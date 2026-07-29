// RosterList.java
// Module 6 — Arrays and Collections
// CSC 151 Java Programming I
//
// Builds an ArrayList of Strings, adds four entries, reports its size, reads
// one entry by index, removes one by index, then prints every remaining entry
// with an enhanced for. Module 8's dispatcher holds its commands and handlers
// in two ArrayLists built exactly this way.
//
// Expected output:
//   Size after four adds: 4
//   First entry: Avery
//   Index 1 before the remove: Brooks
//   Size after removing index 1: 3
//   Index 1 after the remove: Casey
//   Every entry:
//     Avery
//     Casey
//     Devon

import java.util.ArrayList;

public class RosterList {
    public static void main(String[] args) {

        // An array fixes its length at creation: new String[4] holds four
        // slots forever. An ArrayList starts empty and grows on every add,
        // so no length is stated here.
        ArrayList<String> roster = new ArrayList<>();

        roster.add("Avery");
        roster.add("Brooks");
        roster.add("Casey");
        roster.add("Devon");

        // An ArrayList reports size(), with parentheses, because size is a
        // method. An array reports .length, with no parentheses, because
        // length is a field. Asking either container for the other one's
        // spelling does not compile.
        System.out.println("Size after four adds: " + roster.size());

        // get(0) reads the first entry. Indexes start at 0 for an ArrayList
        // exactly as they do for an array.
        System.out.println("First entry: " + roster.get(0));
        System.out.println("Index 1 before the remove: " + roster.get(1));

        // remove(1) takes the entry out and slides every later entry down one
        // index. Nothing is left blank at index 1, and the entry that was at
        // index 2 now answers to index 1. A loop that counts indexes upward
        // while removing therefore skips the entry after each removal.
        roster.remove(1);

        System.out.println("Size after removing index 1: " + roster.size());
        System.out.println("Index 1 after the remove: " + roster.get(1));

        // The enhanced for hands over each entry in turn and never mentions an
        // index, so there is no index to get wrong at either end.
        System.out.println("Every entry:");
        for (String name : roster) {
            System.out.println("  " + name);
        }
    }
}
