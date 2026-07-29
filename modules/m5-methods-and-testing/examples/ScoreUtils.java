// ScoreUtils.java
// Module 5 — Methods and Testing
// CSC 151 Java Programming I
//
// A small set of static methods with parameters and return values.
// Module 5 uses these methods twice: first to practice writing and calling
// methods (submodule 5.1), then as the code under test (submodule 5.2).
//
// The tests for this file are in ../tests/ScoreUtilsTest.java.
// Run them with:  bash scripts/verify.sh test
//
// Expected output:
//   Letter for 95: A
//   Letter for 60: D
//   Average of {80, 90, 100}: 90.0
//   Clamped 130 -> 100

public class ScoreUtils {

    /**
     * Returns the letter grade for a numeric score.
     *
     * @param score a score from 0 to 100
     * @return "A", "B", "C", "D", or "F"
     */
    public static String letterGrade(int score) {
        // Check the highest band first. Checking upward instead would return
        // "D" for every passing score, because 95 is also greater than 60.
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Returns the average of the given scores.
     *
     * @param scores an int array with at least one element
     * @return the mean of the values in scores
     */
    public static double average(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        // Cast before dividing. Without the cast this is integer division,
        // so the average of 80, 90, and 100 would come out as 90 instead of
        // 90.0, and the average of 1 and 2 would come out as 1 instead of 1.5.
        return (double) sum / scores.length;
    }

    /**
     * Returns the score limited to the range 0 to 100.
     *
     * @param score any int
     * @return 0 if score is below 0, 100 if score is above 100, otherwise score
     */
    public static int clamp(int score) {
        if (score < 0) {
            return 0;
        }
        if (score > 100) {
            return 100;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println("Letter for 95: " + letterGrade(95));
        System.out.println("Letter for 60: " + letterGrade(60));
        System.out.println("Average of {80, 90, 100}: " + average(new int[] {80, 90, 100}));
        System.out.println("Clamped 130 -> " + clamp(130));
    }
}
