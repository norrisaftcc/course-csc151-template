// ArrayStats.java
// Module 02 — Arrays
// CSC 151 Java Programming I
//
// Computes the minimum, maximum, and sum of an int array
// using three separate single-pass traversals.
//
// Expected output:
//   Array: [4, 7, 2, 9, 1, 5]
//   Min: 1
//   Max: 9
//   Sum: 28

public class ArrayStats {

    /** Returns the smallest value in numbers. */
    public static int findMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /** Returns the largest value in numbers. */
    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /** Returns the sum of all values in numbers. */
    public static int sum(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    /** Returns a string representation of the array, e.g. "[4, 7, 2]". */
    public static String arrayToString(int[] numbers) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            if (i < numbers.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] data = {4, 7, 2, 9, 1, 5};

        System.out.println("Array: " + arrayToString(data));
        System.out.println("Min: "   + findMin(data));
        System.out.println("Max: "   + findMax(data));
        System.out.println("Sum: "   + sum(data));
    }
}
