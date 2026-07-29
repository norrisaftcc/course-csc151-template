// EventDemo.java
// Module 8 — Events and Capstone
// CSC 151 Java Programming I
//
// A runnable console dispatcher. A command word typed by the user is the
// event, and the handler registered under that word is the method that runs.
// Pressing = on a calculator works the same way: the key press is the event
// and the calculation is the handler.
//
// Every type this program needs lives in this one file. The course verifier
// copies each .java file into an empty directory and compiles it alone, so a
// file that names a class defined elsewhere does not compile. One public
// class is allowed per file; the rest are package-private top-level classes.
//
// The tests for this file are in ../tests/CommandDispatcherTest.java.
// Run them with:  bash scripts/verify.sh test
//
// The recorded output in EventDemo.expected comes from EventDemo.stdin rather
// than from a keyboard, so the commands you would have typed are not echoed
// after the "> " prompt.
//
// Expected output:
//   Registered commands: 4
//   Type add <value>, subtract <value>, equals, clear, or quit.
//   > Added 5.0
//   > Added 7.5
//   > Total: 12.5
//   > Subtracted 2.5
//   > Total: 10.0
//   > Cleared.
//   > Total: 0.0
//   > Unknown command: multiply
//   >
//   Session ended.

import java.util.ArrayList;
import java.util.Scanner;

public class EventDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();

        // Registration happens once, before any event arrives. Nothing runs
        // here: each line only records which handler answers to which word.
        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("subtract", new SubtractHandler(engine));
        dispatcher.register("equals", new EqualsHandler(engine));
        dispatcher.register("clear", new ClearHandler(engine));

        System.out.println("Registered commands: " + dispatcher.registeredCount());
        System.out.println("Type add <value>, subtract <value>, equals, clear, or quit.");

        // A sentinel loop, the shape Module 4 taught. The number of commands
        // is unknown before the program runs, and the word quit ends it.
        boolean running = true;
        while (running) {
            System.out.print("> ");
            String command = input.next();

            if (command.equals("quit")) {
                running = false;
            } else {
                // Only add and subtract carry a value, so only those two read
                // one. Every other command is dispatched with 0, and its
                // handler ignores what it was given.
                double value = 0;
                if (command.equals("add") || command.equals("subtract")) {
                    value = input.nextDouble();
                }

                boolean handled = dispatcher.dispatch(command, value);
                if (!handled) {
                    System.out.println("Unknown command: " + command);
                }
            }
        }

        System.out.println();
        System.out.println("Session ended.");
        input.close();
    }
}

/**
 * Names the one method every handler must supply.
 *
 * The interface fixes the shape of a handler and says nothing about what a
 * handler does with the value it is given. A handler is free to ignore it.
 */
interface CommandHandler {

    /**
     * Runs this handler's action.
     *
     * @param value the number that came with the command, or 0 when the
     *              command carries no number
     */
    void handle(double value);
}

/**
 * Records which handler answers to which command word, and runs the matching
 * handler when a command arrives.
 *
 * The two lists run in parallel: the handler for commands.get(i) is
 * handlers.get(i). A map would be shorter and is not taught in this course.
 */
class CommandDispatcher {

    private ArrayList<String> commands = new ArrayList<>();
    private ArrayList<CommandHandler> handlers = new ArrayList<>();

    /**
     * Registers a handler under a command word.
     *
     * Registering the same word twice replaces the handler and does not add a
     * second entry, so the count stays where it was.
     *
     * @param command the word a user types
     * @param handler the handler that answers to that word
     */
    public void register(String command, CommandHandler handler) {
        for (int i = 0; i < this.commands.size(); i++) {
            if (this.commands.get(i).equals(command)) {
                this.handlers.set(i, handler);
                return;
            }
        }
        this.commands.add(command);
        this.handlers.add(handler);
    }

    /**
     * Runs the handler registered under the given command word.
     *
     * @param command the word a user typed
     * @param value   the number that came with it, or 0
     * @return true when a handler ran, false when no handler is registered
     */
    public boolean dispatch(String command, double value) {
        for (int i = 0; i < this.commands.size(); i++) {
            // .equals compares the characters. Written as ==, this asks
            // whether the typed word and the registered word are the same
            // object, which they never are, so every handler would look dead:
            // nothing runs, nothing prints, and no error appears anywhere.
            if (this.commands.get(i).equals(command)) {
                this.handlers.get(i).handle(value);
                return true;
            }
        }
        return false;
    }

    /**
     * Reports whether a word has a handler.
     *
     * The comparison is exact, so "Add" is a different word from "add". A
     * handler registered under one spelling and dispatched under the other
     * never runs.
     *
     * @param command the word to look for
     * @return true when a handler is registered under that exact word
     */
    public boolean isRegistered(String command) {
        for (int i = 0; i < this.commands.size(); i++) {
            if (this.commands.get(i).equals(command)) {
                return true;
            }
        }
        return false;
    }

    /** Returns how many command words have a handler. */
    public int registeredCount() {
        return this.commands.size();
    }
}

/**
 * Holds the running total.
 *
 * This class is never told what triggered a call. A console command word and
 * a Swing button press reach it the same way, which is why the same handler
 * classes serve both surfaces.
 */
class CalculatorEngine {

    private double total = 0.0;

    /**
     * Adds a value to the running total.
     *
     * @param value the number to add
     */
    public void add(double value) {
        this.total = this.total + value;
    }

    /**
     * Takes a value off the running total.
     *
     * @param value the number to take off
     */
    public void subtract(double value) {
        this.total = this.total - value;
    }

    /** Returns the running total. */
    public double total() {
        return this.total;
    }

    /** Sets the running total back to 0. */
    public void clear() {
        this.total = 0.0;
    }
}

/** Adds the value it is given to the engine's total. */
class AddHandler implements CommandHandler {

    private CalculatorEngine engine;

    /**
     * Builds a handler that works on one engine.
     *
     * @param engine the engine this handler changes
     */
    public AddHandler(CalculatorEngine engine) {
        this.engine = engine;
    }

    @Override
    public void handle(double value) {
        this.engine.add(value);
        System.out.println("Added " + value);
    }
}

/** Takes the value it is given off the engine's total. */
class SubtractHandler implements CommandHandler {

    private CalculatorEngine engine;

    /**
     * Builds a handler that works on one engine.
     *
     * @param engine the engine this handler changes
     */
    public SubtractHandler(CalculatorEngine engine) {
        this.engine = engine;
    }

    @Override
    public void handle(double value) {
        this.engine.subtract(value);
        System.out.println("Subtracted " + value);
    }
}

/** Reports the engine's total. */
class EqualsHandler implements CommandHandler {

    private CalculatorEngine engine;

    /**
     * Builds a handler that works on one engine.
     *
     * @param engine the engine this handler reports on
     */
    public EqualsHandler(CalculatorEngine engine) {
        this.engine = engine;
    }

    @Override
    public void handle(double value) {
        // This handler ignores value on purpose. The interface fixes the
        // shape of the method, not what the method does with its parameter.
        System.out.println("Total: " + this.engine.total());
    }
}

/** Sets the engine's total back to 0. */
class ClearHandler implements CommandHandler {

    private CalculatorEngine engine;

    /**
     * Builds a handler that works on one engine.
     *
     * @param engine the engine this handler clears
     */
    public ClearHandler(CalculatorEngine engine) {
        this.engine = engine;
    }

    @Override
    public void handle(double value) {
        this.engine.clear();
        System.out.println("Cleared.");
    }
}
