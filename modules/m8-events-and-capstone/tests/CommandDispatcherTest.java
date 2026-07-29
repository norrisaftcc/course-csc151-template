// CommandDispatcherTest.java
// Module 8 — Events and Capstone
// CSC 151 Java Programming I
//
// Unit tests for the dispatcher, the engine, and the handlers declared in
// ../examples/EventDemo.java.
//
// Run them with:  bash scripts/verify.sh test
//
// EventDemo.java holds one public class and several package-private ones:
// the CommandHandler interface, CommandDispatcher, CalculatorEngine, and the
// four handlers. They share one file because the verifier compiles each
// example on its own. This test file sits in the same default package, so it
// reaches every one of them by name.
//
// The tests below drive the dispatcher directly instead of typing at the
// keyboard. They can do that because the engine is never told what produced
// the call. A typed command word, a pressed button, and a test method all
// reach the same handler, which is why docs/clo-mlo-map.md accepts a console
// menu and a Swing button as equal evidence for CLO-4.
//
// Also — every value used here (0.0, 2.5, 5.0, 7.5) is exact in binary, so
// assertEquals compares these doubles without a tolerance argument.
//
// This file shows the three test tiers this course requires as evidence:
//
//   Normal   — a registered command runs its handler and the total changes.
//   Boundary — a fresh engine, a value of 0.0, and a command registered twice.
//   Failure  — a command nobody registered, and a command whose spelling
//              differs only in case.
//
// Every method below is named for what it claims, because the name is the
// first thing you read when a test fails.
// "dispatch_returnsFalse_forUnregisteredCommand" tells you what broke.
// "test3" does not.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandDispatcherTest {

    // ---- Normal: registered commands run --------------------------------

    @Test
    @DisplayName("a registered add command runs its handler and raises the total")
    void dispatch_addsToTheTotal_forRegisteredAddCommand() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));

        assertTrue(dispatcher.dispatch("add", 5.0));
        assertEquals(5.0, engine.total());
    }

    @Test
    @DisplayName("a registered subtract command lowers the total")
    void dispatch_subtractsFromTheTotal_forRegisteredSubtractCommand() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("subtract", new SubtractHandler(engine));

        dispatcher.dispatch("add", 5.0);
        assertTrue(dispatcher.dispatch("subtract", 2.5));
        assertEquals(2.5, engine.total());
    }

    @Test
    @DisplayName("a registered clear command returns the total to 0.0")
    void dispatch_returnsTotalToZero_forRegisteredClearCommand() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("clear", new ClearHandler(engine));

        dispatcher.dispatch("add", 7.5);
        assertTrue(dispatcher.dispatch("clear", 0.0));
        assertEquals(0.0, engine.total());
    }

    @Test
    @DisplayName("the equals command reports the total without changing it")
    void dispatch_leavesTheTotalAlone_forRegisteredEqualsCommand() {
        // A handler may ignore the value the dispatcher passes it. The
        // interface fixes the shape of the call, not the use.
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("equals", new EqualsHandler(engine));

        dispatcher.dispatch("add", 7.5);
        assertTrue(dispatcher.dispatch("equals", 0.0));
        assertEquals(7.5, engine.total());
    }

    @Test
    @DisplayName("the dispatcher counts each command registered under a new name")
    void registeredCount_returnsFour_forFourDistinctCommands() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();

        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("subtract", new SubtractHandler(engine));
        dispatcher.register("equals", new EqualsHandler(engine));
        dispatcher.register("clear", new ClearHandler(engine));

        assertEquals(4, dispatcher.registeredCount());
    }

    // ---- Boundary: a fresh engine, a zero value, a repeated name ---------

    @Test
    @DisplayName("a fresh engine starts at 0.0")
    void total_returnsZero_forNewEngine() {
        CalculatorEngine engine = new CalculatorEngine();
        assertEquals(0.0, engine.total());
    }

    @Test
    @DisplayName("adding 0.0 runs the handler and leaves the total at 0.0")
    void dispatch_returnsTrue_forAddOfZero() {
        // The return value says the handler ran. It does not say the state
        // changed, and here nothing changes. Reading an unchanged total as
        // "nothing ran" is the mistake this test names.
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));

        assertTrue(dispatcher.dispatch("add", 0.0));
        assertEquals(0.0, engine.total());
    }

    @Test
    @DisplayName("registering one command twice leaves one entry")
    void registeredCount_returnsOne_forOneCommandRegisteredTwice() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();

        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("add", new SubtractHandler(engine));

        assertEquals(1, dispatcher.registeredCount());
    }

    @Test
    @DisplayName("the handler registered second is the one that runs")
    void dispatch_runsTheSecondHandler_forOneCommandRegisteredTwice() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();

        dispatcher.register("add", new AddHandler(engine));
        dispatcher.register("add", new SubtractHandler(engine));

        dispatcher.dispatch("add", 2.5);

        // The second registration replaced the first, so the total falls
        // rather than rises.
        assertEquals(-2.5, engine.total());
    }

    // ---- Failure: commands the dispatcher must refuse --------------------

    @Test
    @DisplayName("the dispatcher refuses an unregistered command")
    void dispatch_returnsFalse_forUnregisteredCommand() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));

        assertFalse(dispatcher.dispatch("nope", 1.0));
    }

    @Test
    @DisplayName("an unregistered command changes no state")
    void total_isUnchanged_afterUnregisteredCommand() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));

        dispatcher.dispatch("nope", 1.0);

        assertEquals(0.0, engine.total());
    }

    @Test
    @DisplayName("isRegistered finds a command the dispatcher stored")
    void isRegistered_returnsTrue_forRegisteredCommand() {
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));

        assertTrue(dispatcher.isRegistered("add"));
    }

    @Test
    @DisplayName("isRegistered does not find a command whose case differs")
    void isRegistered_returnsFalse_forDifferentCase() {
        // "Add" and "add" are two different command names. This mismatch is
        // what makes a live handler look dead: the registration succeeded,
        // the dispatch found nothing, and nothing printed.
        CalculatorEngine engine = new CalculatorEngine();
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("add", new AddHandler(engine));

        assertFalse(dispatcher.isRegistered("Add"));
    }

    // ---- The handler, called without the dispatcher ----------------------
    //
    // A handler is an ordinary object with an ordinary method. The dispatcher
    // decides when to call that method. The dispatcher does not decide what
    // the method does, so a test may call handle itself and then read the
    // engine.

    @Test
    @DisplayName("AddHandler.handle raises the total on its own")
    void handle_addsToTheTotal_forAddHandler() {
        CalculatorEngine engine = new CalculatorEngine();
        AddHandler handler = new AddHandler(engine);

        handler.handle(7.5);

        assertEquals(7.5, engine.total());
    }

    @Test
    @DisplayName("SubtractHandler.handle lowers the total on its own")
    void handle_lowersTheTotal_forSubtractHandler() {
        CalculatorEngine engine = new CalculatorEngine();
        engine.add(7.5);

        new SubtractHandler(engine).handle(2.5);

        assertEquals(5.0, engine.total());
    }
}
