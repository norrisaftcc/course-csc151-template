// CountdownLoops.java
// Module 4 — Loops
// CSC 151 Java Programming I
//
// Counts down from 3 three times — once with while, once with do-while, once
// with for — then runs each loop again with a condition that is already false
// when the loop starts. Every line stays inside main, because a student writes
// their first method in Module 5.
//
// Expected output:
//   while, counting down from 3:
//   3
//   2
//   1
//   do-while, counting down from 3:
//   3
//   2
//   1
//   for, counting down from 3:
//   3
//   2
//   1
//   The same three loops, started at 0:
//   while body runs: 0
//   do-while body runs: 1
//   for body runs: 0

public class CountdownLoops {
    public static void main(String[] args) {

        // while tests the condition before the body. Forget the i-- and the
        // condition never changes, so the loop prints 3 forever.
        System.out.println("while, counting down from 3:");
        int i = 3;
        while (i > 0) {
            System.out.println(i);
            i--;
        }

        // do-while tests the condition after the body.
        System.out.println("do-while, counting down from 3:");
        int j = 3;
        do {
            System.out.println(j);
            j--;
        } while (j > 0);

        // for gathers the start, the test and the update onto one line. The
        // three parts are the same three jobs the while loop above does in
        // three separate places.
        System.out.println("for, counting down from 3:");
        for (int k = 3; k > 0; k--) {
            System.out.println(k);
        }

        // The three loops above print the same three lines, which makes
        // do-while look like a spelling of while. It is not. Start each loop
        // at 0, where the condition is already false, and the difference is
        // the only reason to ever choose do-while: its body runs once anyway.
        System.out.println("The same three loops, started at 0:");

        int m = 0;
        int whileRuns = 0;
        while (m > 0) {
            whileRuns++;
            m--;
        }
        System.out.println("while body runs: " + whileRuns);

        int n = 0;
        int doWhileRuns = 0;
        do {
            doWhileRuns++;
            n--;
        } while (n > 0);
        System.out.println("do-while body runs: " + doWhileRuns);

        int forRuns = 0;
        for (int p = 0; p > 0; p--) {
            forRuns++;
        }
        System.out.println("for body runs: " + forRuns);
    }
}
