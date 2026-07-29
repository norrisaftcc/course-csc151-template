// HandlerIntro.java
// Module 8 — Events and Capstone
// CSC 151 Java Programming I
//
// The smallest interface this course needs: one interface that names a single
// method, two classes that supply that method, and a main that calls each of
// them through a variable whose declared type is the interface.
//
// The interface here is named Greeter rather than CommandHandler on purpose.
// The verifier compiles every file in this folder together when it runs the
// tests, and two files declaring the same type would collide.
//
// Expected output:
//   Good morning, Avery.
//   Good evening, Avery.
//   Good morning, Brooks.
//   Good evening, Brooks.

public class HandlerIntro {
    public static void main(String[] args) {

        // The declared type is Greeter and the object is a MorningGreeter.
        // That is allowed because MorningGreeter implements Greeter, and it is
        // the whole reason the interface exists: code below can call greet
        // without knowing which class answers.
        Greeter morning = new MorningGreeter();
        Greeter evening = new EveningGreeter();

        System.out.println(morning.greet("Avery"));
        System.out.println(evening.greet("Avery"));

        System.out.println(morning.greet("Brooks"));
        System.out.println(evening.greet("Brooks"));
    }
}

/**
 * Names one method and supplies no body for it.
 *
 * An interface holds no code. It states the shape of a method — the return
 * type, the name and the parameter list — and every class that implements it
 * must supply a method of exactly that shape.
 */
interface Greeter {

    /**
     * Returns a greeting for the given name.
     *
     * @param name the person to greet
     * @return the greeting text
     */
    String greet(String name);
}

/** Supplies the morning wording for Greeter.greet. */
class MorningGreeter implements Greeter {

    // implements obliges this class to supply greet. Delete this method, or
    // misspell it as Greet, and the class does not compile: the compiler
    // reports that MorningGreeter is not abstract and does not override greet.
    @Override
    public String greet(String name) {
        return "Good morning, " + name + ".";
    }
}

/** Supplies the evening wording for Greeter.greet. */
class EveningGreeter implements Greeter {

    @Override
    public String greet(String name) {
        return "Good evening, " + name + ".";
    }
}
