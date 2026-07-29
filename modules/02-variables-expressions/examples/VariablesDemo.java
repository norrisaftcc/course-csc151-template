// VariablesDemo.java
// Module 02 — Variables and Expressions
// CSC 151 Java Programming I
//
// Demonstrates variable declaration, assignment, and arithmetic expressions.
// Run this program after tracing it on paper.
//
// Expected output:
//   Student: Jordan
//   Score: 85
//   Doubled: 170
//   Adjusted: 127.5
//   Half (integer division): 42

public class VariablesDemo {
    public static void main(String[] args) {
        int score = 85;
        double bonus = 1.5;
        String name = "Jordan";

        int doubled = score * 2;
        double adjusted = score * bonus;

        System.out.println("Student: " + name);
        System.out.println("Score: " + score);
        System.out.println("Doubled: " + doubled);
        System.out.println("Adjusted: " + adjusted);

        // Integer division: the remainder is discarded.
        // 85 / 2 = 42 remainder 1. Java keeps only 42.
        int half = score / 2;
        System.out.println("Half (integer division): " + half);
    }
}
