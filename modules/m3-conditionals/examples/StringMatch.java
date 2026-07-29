// StringMatch.java
// Module 3 — Conditionals
// CSC 151 Java Programming I
//
// Reads one word with next(), then compares it to the literal "yes" twice:
// once with == and once with .equals. The two answers disagree, and the
// disagreement is the point of the file. Every line stays inside main.
//
// The recorded output in StringMatch.expected comes from StringMatch.stdin
// rather than from a keyboard, so the word you would have typed is not echoed
// after the prompt.
//
// Expected output:
//   Enter a word:
//   You typed: yes
//   literal == "yes" is true
//   typed == "yes" is false
//   typed.equals("yes") is true

import java.util.Scanner;

public class StringMatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String typed = input.next();
        System.out.println();

        // A String written directly in the source is stored once and shared,
        // so two copies of the same literal are the same object and == is
        // true. That true answer is what hides the bug: the operator looks
        // like it compares letters, and here it agrees by accident.
        String literal = "yes";

        System.out.println("You typed: " + typed);
        System.out.println("literal == \"yes\" is " + (literal == "yes"));

        // Scanner builds a new String object from the characters it read.
        // == asks whether two references point at the same object, so a word
        // the user typed is never == to a literal, even when it reads the
        // same on screen.
        System.out.println("typed == \"yes\" is " + (typed == "yes"));

        // .equals asks whether the two Strings hold the same characters,
        // which is the question the program actually means to ask.
        System.out.println("typed.equals(\"yes\") is " + typed.equals("yes"));

        input.close();
    }
}
