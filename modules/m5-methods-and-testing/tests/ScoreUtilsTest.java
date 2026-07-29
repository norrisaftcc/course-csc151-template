// ScoreUtilsTest.java
// Module 5 — Methods and Testing
// CSC 151 Java Programming I
//
// Unit tests for ../examples/ScoreUtils.java.
//
// Run them with:  bash scripts/verify.sh test
//
// This file shows the three test tiers this course requires as evidence:
//
//   Normal   — the ordinary case a method is written for.
//   Boundary — the value at the edge of a range, where off-by-one errors live.
//   Failure  — input the method must reject or correct.
//
// Every method below is named for what it claims. When a test fails, the
// name is the first thing you read, so it must state the claim and not the
// mechanics. "letterGrade_returnsA_atExactly90" tells you what broke.
// "test3" does not.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreUtilsTest {

    // ---- letterGrade: normal cases -------------------------------------

    @Test
    @DisplayName("letterGrade returns A for a score well inside the A band")
    void letterGrade_returnsA_forNinetyFive() {
        assertEquals("A", ScoreUtils.letterGrade(95));
    }

    @Test
    @DisplayName("letterGrade returns F for a failing score")
    void letterGrade_returnsF_forThirty() {
        assertEquals("F", ScoreUtils.letterGrade(30));
    }

    // ---- letterGrade: boundary cases -----------------------------------
    //
    // Each band edge is tested twice: at the edge, and one below it. This is
    // the pair that catches a > written where a >= belongs.

    @Test
    @DisplayName("letterGrade returns A at exactly 90")
    void letterGrade_returnsA_atExactly90() {
        assertEquals("A", ScoreUtils.letterGrade(90));
    }

    @Test
    @DisplayName("letterGrade returns B at 89, one below the A band")
    void letterGrade_returnsB_atEightyNine() {
        assertEquals("B", ScoreUtils.letterGrade(89));
    }

    @Test
    @DisplayName("letterGrade returns D at exactly 60, the lowest passing score")
    void letterGrade_returnsD_atExactly60() {
        assertEquals("D", ScoreUtils.letterGrade(60));
    }

    @Test
    @DisplayName("letterGrade returns F at 59, one below passing")
    void letterGrade_returnsF_atFiftyNine() {
        assertEquals("F", ScoreUtils.letterGrade(59));
    }

    // ---- average: normal and boundary ----------------------------------

    @Test
    @DisplayName("average returns the mean of several scores")
    void average_returnsMean_forThreeScores() {
        assertEquals(90.0, ScoreUtils.average(new int[] {80, 90, 100}));
    }

    @Test
    @DisplayName("average of a one-element array is that element")
    void average_returnsTheValue_forOneElement() {
        assertEquals(42.0, ScoreUtils.average(new int[] {42}));
    }

    @Test
    @DisplayName("average keeps the fraction instead of truncating it")
    void average_keepsFraction_forOneAndTwo() {
        // This is the test that catches integer division. Without the cast in
        // average, this returns 1.0 rather than 1.5.
        assertEquals(1.5, ScoreUtils.average(new int[] {1, 2}));
    }

    // ---- clamp: failure cases ------------------------------------------
    //
    // These are the inputs the method exists to correct.

    @Test
    @DisplayName("clamp lowers a score above the maximum to 100")
    void clamp_returns100_forScoreAboveMaximum() {
        assertEquals(100, ScoreUtils.clamp(130));
    }

    @Test
    @DisplayName("clamp raises a negative score to 0")
    void clamp_returns0_forNegativeScore() {
        assertEquals(0, ScoreUtils.clamp(-5));
    }

    @Test
    @DisplayName("clamp leaves a score inside the range unchanged")
    void clamp_returnsInput_forScoreInRange() {
        assertEquals(75, ScoreUtils.clamp(75));
    }
}
