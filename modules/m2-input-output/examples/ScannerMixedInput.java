// ScannerMixedInput.java
// Module 2 — Input and Output
// CSC 151 Java Programming I
//
// Reads an int with nextInt(), consumes the leftover newline, then reads a
// whole line with nextLine(). This file is a facilitation reference for the
// Module 2 README. The lesson does not teach it. Reach for it when a student
// reports that their program skipped a prompt and read an empty name.
//
// The recorded output in ScannerMixedInput.expected comes from
// ScannerMixedInput.stdin rather than from a keyboard, so nothing you would
// have typed appears, and the two prompts run together on one line because
// System.out.print does not end the line.
//
// Expected output:
//   Enter your locker number: Enter your full name:
//   Number: 7
//   Name: Jordan Lee

import java.util.Scanner;

public class ScannerMixedInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your locker number: ");
        int number = input.nextInt();

        // nextInt() reads the digits and stops in front of the newline the
        // user typed. It does not consume that newline. Without the throwaway
        // nextLine() below, the next nextLine() returns the empty remainder of
        // the number's line, name comes back as "", and the program looks like
        // it printed the second prompt and refused to wait for an answer.
        input.nextLine();

        System.out.print("Enter your full name: ");
        String name = input.nextLine();

        System.out.println();
        System.out.println("Number: " + number);
        System.out.println("Name: " + name);

        input.close();
    }
}
