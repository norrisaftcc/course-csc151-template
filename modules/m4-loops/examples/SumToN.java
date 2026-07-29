// SumToN.java
// Module 4 — Loops
// CSC 151 Java Programming I
//
// Accumulates 1 through n with a for loop and prints the running total after
// every pass, so a trace table written on paper has a printed line to check
// itself against. Every line stays inside main.
//
// Expected output:
//   i = 1, total after this pass = 1
//   i = 2, total after this pass = 3
//   i = 3, total after this pass = 6
//   i = 4, total after this pass = 10
//   i = 5, total after this pass = 15
//   Sum of 1 through 5 is 15
//   The loop body ran 5 times.

public class SumToN {
    public static void main(String[] args) {
        int n = 5;

        // The accumulator is declared before the loop and survives every pass.
        // Declared inside the body instead, it would be created and set to 0
        // again on every pass, and the final total would be only the last
        // value added — 5 here rather than 15.
        int total = 0;
        int passes = 0;

        // i <= n, not i < n. The task counts 1 through 5 inclusive, so the
        // last value must still enter the body.
        for (int i = 1; i <= n; i++) {
            total += i;
            passes++;
            System.out.println("i = " + i + ", total after this pass = " + total);
        }

        System.out.println("Sum of 1 through " + n + " is " + total);
        System.out.println("The loop body ran " + passes + " times.");
    }
}
