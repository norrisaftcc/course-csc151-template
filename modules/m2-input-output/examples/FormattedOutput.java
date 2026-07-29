// FormattedOutput.java
// Module 2 — Input and Output
// CSC 151 Java Programming I
//
// Demonstrates System.out.printf format specifiers for aligned output.
// No user input — run this to see how printf formats different types.
//
// Expected output (also recorded in FormattedOutput.expected, which
// scripts/verify.sh checks against the real output):
//   Item                Price    Qty    Total
//   -----------------------------------------
//   Pencil               0.50      3     1.50
//   Notebook             4.99      2     9.98
//   Backpack            24.95      1    24.95
//   -----------------------------------------
//   Grand total:                        36.43
//
// Every line is 41 characters wide: %-16s + space + %8s + space + %6s
// + space + %8s. The rule and the grand total use the same width, so the
// last digit of every number in the Total column lines up.

public class FormattedOutput {
    public static void main(String[] args) {
        // Column header
        System.out.printf("%-16s %8s %6s %8s%n", "Item", "Price", "Qty", "Total");
        System.out.println("-----------------------------------------");

        // Each row: name, unit price, quantity, line total
        printRow("Pencil",   0.50, 3);
        printRow("Notebook", 4.99, 2);
        printRow("Backpack", 24.95, 1);

        System.out.println("-----------------------------------------");

        double grandTotal = (0.50 * 3) + (4.99 * 2) + (24.95 * 1);
        System.out.printf("%-16s %24.2f%n", "Grand total:", grandTotal);
    }

    // Prints one row of the table.
    // name: item description
    // price: unit price
    // qty: quantity ordered
    static void printRow(String name, double price, int qty) {
        double lineTotal = price * qty;
        System.out.printf("%-16s %8.2f %6d %8.2f%n", name, price, qty, lineTotal);
    }
}
