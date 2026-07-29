// TicketPrice.java
// Module 3 — Conditionals
// CSC 151 Java Programming I
//
// Prints the ticket price for four fixed cases. Each case runs the same
// else-if chain over an age band, and one band also tests a membership flag
// with &&. Every line stays inside main, because a student writes their first
// method in Module 5.
//
// Expected output:
//   Age 12, member no: $5.00
//   Age 70, member yes: $8.00
//   Age 30, member yes: $9.00
//   Age 30, member no: $12.00

public class TicketPrice {
    public static void main(String[] args) {

        // Case 1: a child who is not a member.
        int age = 12;
        String member = "no";
        double price;

        // The chain runs from the highest band down, and that order is the
        // whole design. Written lowest band first — age >= 0, then age >= 13,
        // then age >= 18 — every case matches the first test, and every later
        // branch is dead code that never runs.
        if (age >= 65) {
            price = 8.00;
        } else if (age >= 18 && member.equals("yes")) {
            // && stops at the first false part. For age 12 the left part is
            // already false, so member.equals("yes") is never evaluated. A
            // trace that reports "Java checked the membership here" is wrong.
            price = 9.00;
        } else if (age >= 18) {
            price = 12.00;
        } else if (age >= 13) {
            price = 7.00;
        } else {
            price = 5.00;
        }
        System.out.printf("Age %d, member %s: $%.2f%n", age, member, price);

        // Case 2: a senior who is a member. The first branch is true, so the
        // chain stops there. Membership never enters the decision, and the
        // senior price is not reduced a second time.
        age = 70;
        member = "yes";
        if (age >= 65) {
            price = 8.00;
        } else if (age >= 18 && member.equals("yes")) {
            price = 9.00;
        } else if (age >= 18) {
            price = 12.00;
        } else if (age >= 13) {
            price = 7.00;
        } else {
            price = 5.00;
        }
        System.out.printf("Age %d, member %s: $%.2f%n", age, member, price);

        // Case 3: an adult member. Both parts of the && are true.
        age = 30;
        member = "yes";
        if (age >= 65) {
            price = 8.00;
        } else if (age >= 18 && member.equals("yes")) {
            price = 9.00;
        } else if (age >= 18) {
            price = 12.00;
        } else if (age >= 13) {
            price = 7.00;
        } else {
            price = 5.00;
        }
        System.out.printf("Age %d, member %s: $%.2f%n", age, member, price);

        // Case 4: an adult who is not a member. The && branch fails on its
        // right part, so control reaches the plain adult band below it.
        age = 30;
        member = "no";
        if (age >= 65) {
            price = 8.00;
        } else if (age >= 18 && member.equals("yes")) {
            price = 9.00;
        } else if (age >= 18) {
            price = 12.00;
        } else if (age >= 13) {
            price = 7.00;
        } else {
            price = 5.00;
        }
        System.out.printf("Age %d, member %s: $%.2f%n", age, member, price);

        // The chain appears four times because everything here lives in main.
        // Module 5 shows how to write the decision once and call it four
        // times. The repetition is the honest cost of the current toolkit.
    }
}
