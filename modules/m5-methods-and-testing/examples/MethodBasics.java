// MethodBasics.java
// Module 5 — Methods and Testing
// CSC 151 Java Programming I
//
// One void method, one value-returning method used inside a larger
// expression, and one overloaded pair. Every method prints a marker as
// control enters it and another as control leaves it, so the printed order
// shows where the program actually is at each moment.
//
// Expected output:
//   main starts
//   enter announce
//     Method markers
//   leave announce
//   enter doubled(21)
//   leave doubled, returning 42
//   total = 50
//   enter addUp(int, int)
//   addUp(2, 3) = 5
//   enter addUp(double, double)
//   addUp(2.5, 3.5) = 6.0
//   main ends

public class MethodBasics {

    /**
     * Prints a label between two markers.
     *
     * @param label the text to print
     */
    public static void announce(String label) {
        System.out.println("enter announce");
        System.out.println("  " + label);
        System.out.println("leave announce");
        // The return type is void, so this method hands nothing back.
        // int x = announce("hi"); does not compile: there is no value to
        // assign. A void method is called for what it does, not for what it
        // gives you.
    }

    /**
     * Returns twice the given value.
     *
     * @param value any int
     * @return value multiplied by 2
     */
    public static int doubled(int value) {
        System.out.println("enter doubled(" + value + ")");
        int result = value * 2;
        System.out.println("leave doubled, returning " + result);
        return result;
        // A statement written below this return would never run. return ends
        // the method immediately and hands control back to the caller, so
        // "the last line never happens" is a symptom of a return above it.
    }

    /**
     * Adds two whole numbers.
     *
     * @param first  the first value
     * @param second the second value
     * @return the sum as an int
     */
    public static int addUp(int first, int second) {
        System.out.println("enter addUp(int, int)");
        return first + second;
    }

    /**
     * Adds two values that may carry a fraction.
     *
     * @param first  the first value
     * @param second the second value
     * @return the sum as a double
     */
    public static double addUp(double first, double second) {
        // Two methods may share one name when their parameter lists differ.
        // The compiler chooses by the types of the arguments at the call, not
        // by the return type, so a pair that differed only in return type
        // would not compile.
        System.out.println("enter addUp(double, double)");
        return first + second;
    }

    public static void main(String[] args) {
        System.out.println("main starts");

        // score is declared in main, so it exists only in main. announce and
        // doubled cannot read it by name. A value reaches a method only by
        // being passed as an argument.
        int score = 21;

        announce("Method markers");

        // doubled(score) runs to completion first, and its returned value
        // then takes its place inside the expression. That is why the two
        // markers from doubled print before the total line.
        int total = doubled(score) + 8;
        System.out.println("total = " + total);

        System.out.println("addUp(2, 3) = " + addUp(2, 3));
        System.out.println("addUp(2.5, 3.5) = " + addUp(2.5, 3.5));

        System.out.println("main ends");
    }
}
