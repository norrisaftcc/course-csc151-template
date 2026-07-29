// ArrayMax.java
// Module 07 — Arrays
// CSC 151 Java Programming I
//
// Demonstrates finding the maximum value in an int array
// using a single-pass traversal without sorting.
//
// Expected output:
//   Typical array max: 50
//   One element max: 42
//   All negative max: -1

public class ArrayMax {

    /**
     * Returns the largest value in the given array.
     *
     * @param numbers an int array with at least one element
     * @return the largest value in numbers
     */
    public static int findMax(int[] numbers) {
        // Start with the first element, not 0.
        // Initializing to 0 would give the wrong answer for all-negative arrays.
        int max = numbers[0];

        // Compare every remaining element to the current max.
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Test case 1: typical array
        int[] typical = {10, 30, 20, 50, 40};
        System.out.println("Typical array max: " + findMax(typical));

        // Test case 2: one-element array
        int[] oneElement = {42};
        System.out.println("One element max: " + findMax(oneElement));

        // Test case 3: all negative values
        int[] allNegative = {-3, -5, -1, -8};
        System.out.println("All negative max: " + findMax(allNegative));
    }
}
