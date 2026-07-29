// ExpressionTrace.java
// Module 02 — Variables and Expressions
// CSC 151 Java Programming I
//
// Trace this program on paper BEFORE running it.
// Predict the value of result1, result2, and result3.
// Then run and compare your predictions to the actual output.
//
// Expected output:
//   3
//   5.0
//   1

public class ExpressionTrace {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        double c = 2.0;

        // Two int operands: integer division, remainder discarded.
        int result1 = a / b;

        // One double operand: decimal division.
        double result2 = a / c;

        // Modulo: the remainder after integer division.
        // 10 divided by 3 is 3 remainder 1.
        int result3 = a % b;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
