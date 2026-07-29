// MenuSwitch.java
// Module 3 — Conditionals
// CSC 151 Java Programming I
//
// Reads one command word and selects an action twice: once with a switch,
// once with the else-if chain that makes the same decision. The two lines
// always agree, which is what "an alternative to a long chain" means.
// Module 8 reuses this shape to send a command word to a handler.
// Every line stays inside main.
//
// The recorded output in MenuSwitch.expected comes from MenuSwitch.stdin
// rather than from a keyboard, so the word you would have typed is not echoed
// after the prompt.
//
// Expected output:
//   Enter a command (list, add, remove, quit):
//   switch says:  Adding an entry.
//   else-if says: Adding an entry.

import java.util.Scanner;

public class MenuSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a command (list, add, remove, quit): ");
        String command = input.next();
        System.out.println();

        String fromSwitch;
        switch (command) {
            case "list":
                fromSwitch = "Listing every entry.";
                // break ends the switch here. A case does not fall out on its
                // own: remove this break and control runs straight into the
                // "add" body below, overwriting the answer.
                break;
            case "add":
                fromSwitch = "Adding an entry.";
                break;
            case "remove":
                fromSwitch = "Removing an entry.";
                break;
            case "quit":
                // No statement and no break here, so "quit" runs on into the
                // "exit" body. Two labels above one body is the one place
                // where running on is deliberate rather than a defect.
            case "exit":
                fromSwitch = "Stopping.";
                break;
            default:
                fromSwitch = "Unknown command: " + command;
        }

        // The same decision as an else-if chain. Each case label becomes one
        // .equals test, and default becomes the final else. Note that switch
        // on a String still compares characters, so the chain must use
        // .equals rather than == to ask the same question.
        String fromChain;
        if (command.equals("list")) {
            fromChain = "Listing every entry.";
        } else if (command.equals("add")) {
            fromChain = "Adding an entry.";
        } else if (command.equals("remove")) {
            fromChain = "Removing an entry.";
        } else if (command.equals("quit") || command.equals("exit")) {
            fromChain = "Stopping.";
        } else {
            fromChain = "Unknown command: " + command;
        }

        System.out.println("switch says:  " + fromSwitch);
        System.out.println("else-if says: " + fromChain);

        input.close();
    }
}
