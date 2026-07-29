// ScannerDemo.java
// Module 2 — Input and Output
// CSC 151 Java Programming I
//
// Demonstrates reading int, double, and String values from the user
// using Scanner, then printing a formatted summary.
//
// To compile: javac ScannerDemo.java
// To run:     java ScannerDemo
//
// Sample interaction when you type the input yourself
// (what you type is shown after the colon):
//   Enter your name: Jordan
//   Enter your score (int): 85
//   Enter your bonus multiplier (double): 1.5
//   -------------------------
//   Name:     Jordan
//   Score:    85
//   Bonus:    1.5
//   Adjusted: 127.5
//
// The recorded output in ScannerDemo.expected looks different, and the
// difference is worth understanding. That file records what the program
// prints when the input comes from ScannerDemo.stdin instead of from your
// keyboard. Two things change:
//
//   1. Your typing is never echoed, because you did not type anything.
//   2. The three prompts run together on one line, because System.out.print
//      does not end the line and nothing was inserted between the prompts.
//
// The program is identical either way. Only the source of the input changed.

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read a String (the full line, to handle names with spaces)
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        // Read an int
        System.out.print("Enter your score (int): ");
        int score = input.nextInt();

        // Read a double
        System.out.print("Enter your bonus multiplier (double): ");
        double bonus = input.nextDouble();

        // Compute the adjusted score
        double adjusted = score * bonus;

        // Print the summary
        System.out.println("-------------------------");
        System.out.printf("Name:     %s%n", name);
        System.out.printf("Score:    %d%n", score);
        System.out.printf("Bonus:    %.1f%n", bonus);
        System.out.printf("Adjusted: %.1f%n", adjusted);

        input.close();
    }
}
