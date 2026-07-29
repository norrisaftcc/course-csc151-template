// SentinelLoop.java
// Module 4 — Loops
// CSC 151 Java Programming I
//
// Reads doubles until the sentinel value 0 arrives, then reports how many
// values arrived and what they add up to. The number of readings is not known
// before the program runs, which is the reason a counted loop does not fit.
// Module 8 reuses this loop shape to read commands until the user types quit.
// Every line stays inside main.
//
// The recorded output in SentinelLoop.expected comes from SentinelLoop.stdin
// rather than from a keyboard, so the numbers you would have typed are not
// echoed, and the repeated prompts run together on one line because
// System.out.print does not end the line.
//
// Expected output:
//   Enter a number (0 to stop): Enter a number (0 to stop): Enter a number (0 to stop): Enter a number (0 to stop):
//   Values entered: 3
//   Total: 10.0

import java.util.Scanner;

public class SentinelLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;
        int count = 0;

        // The first reading happens before the loop, so the condition has a
        // value to test on its first look. This is called the priming read.
        System.out.print("Enter a number (0 to stop): ");
        double value = input.nextDouble();

        while (value != 0) {
            // The sentinel is the stop signal, not data. Adding or counting it
            // inside the loop would be harmless for the total, because 0 adds
            // nothing, and wrong for the count, which would come out one too
            // high. Reading it after the body, as the last line here does,
            // keeps it out of both.
            total += value;
            count++;

            System.out.print("Enter a number (0 to stop): ");
            value = input.nextDouble();
        }

        System.out.println();
        System.out.println("Values entered: " + count);
        System.out.println("Total: " + total);

        input.close();
    }
}
