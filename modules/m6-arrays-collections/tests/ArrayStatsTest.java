// ArrayStatsTest.java
// Module 6 — Arrays and Collections
// CSC 151 Java Programming I
//
// Unit tests for ../examples/ArrayStats.java.
//
// Run them with:  bash scripts/verify.sh test
//
// This file shows the three test tiers this course requires as evidence:
//
//   Normal   — the ordinary array a traversal is written for.
//   Boundary — the smallest array that must still work: one element, then none.
//   Failure  — the array that exposes a wrong starting value.
//
// Every method below is named for what it claims, because the name is the
// first thing you read when a test fails. "findMax_returnsMinusOne_forAllNegativeArray"
// tells you what broke. "test3" does not.
//
// Each test builds its own array. Nothing is shared between tests, so a
// failure names one input and one claim.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayStatsTest {

    // ---- Normal: a typical six-element array ---------------------------

    @Test
    @DisplayName("findMin returns the smallest value in a typical array")
    void findMin_returnsOne_forTypicalArray() {
        int[] numbers = {4, 7, 2, 9, 1, 5};
        assertEquals(1, ArrayStats.findMin(numbers));
    }

    @Test
    @DisplayName("findMax returns the largest value in a typical array")
    void findMax_returnsNine_forTypicalArray() {
        int[] numbers = {4, 7, 2, 9, 1, 5};
        assertEquals(9, ArrayStats.findMax(numbers));
    }

    @Test
    @DisplayName("sum adds every value in a typical array")
    void sum_returnsTwentyEight_forTypicalArray() {
        int[] numbers = {4, 7, 2, 9, 1, 5};
        assertEquals(28, ArrayStats.sum(numbers));
    }

    @Test
    @DisplayName("arrayToString lists every value in order, separated by commas")
    void arrayToString_returnsBracketedList_forTypicalArray() {
        int[] numbers = {4, 7, 2, 9, 1, 5};
        assertEquals("[4, 7, 2, 9, 1, 5]", ArrayStats.arrayToString(numbers));
    }

    // ---- Boundary: one element, then none ------------------------------
    //
    // A one-element array is where an off-by-one traversal shows itself. The
    // loop body never runs, so the answer has to come from the starting value.

    @Test
    @DisplayName("findMin of a one-element array is that element")
    void findMin_returnsTheElement_forOneElementArray() {
        int[] numbers = {42};
        assertEquals(42, ArrayStats.findMin(numbers));
    }

    @Test
    @DisplayName("findMax of a one-element array is that element")
    void findMax_returnsTheElement_forOneElementArray() {
        int[] numbers = {42};
        assertEquals(42, ArrayStats.findMax(numbers));
    }

    @Test
    @DisplayName("sum of a one-element array is that element")
    void sum_returnsTheElement_forOneElementArray() {
        int[] numbers = {42};
        assertEquals(42, ArrayStats.sum(numbers));
    }

    @Test
    @DisplayName("arrayToString of a one-element array holds no comma")
    void arrayToString_returnsSingleValue_forOneElementArray() {
        // The separator goes between elements, never after the last one.
        int[] numbers = {42};
        assertEquals("[42]", ArrayStats.arrayToString(numbers));
    }

    @Test
    @DisplayName("sum of an empty array is 0")
    void sum_returnsZero_forEmptyArray() {
        // An accumulator starts at 0, so a traversal that never runs still
        // has an answer to return.
        int[] numbers = new int[0];
        assertEquals(0, ArrayStats.sum(numbers));
    }

    @Test
    @DisplayName("arrayToString of an empty array is a pair of brackets")
    void arrayToString_returnsEmptyBrackets_forEmptyArray() {
        int[] numbers = new int[0];
        assertEquals("[]", ArrayStats.arrayToString(numbers));
    }

    // ---- Failure: the array a wrong starting value reports wrongly -------
    //
    // These tests are the reason findMax starts at numbers[0] rather than at
    // 0. A findMax that starts at 0 returns 0 for this array — a value the
    // array never held. Every test above still passes in that case, so this
    // tier is the one that catches it. findMin repeats the check because the
    // same mistake reversed starts a running minimum at 0.

    @Test
    @DisplayName("findMax returns -1 for an all-negative array, not 0")
    void findMax_returnsMinusOne_forAllNegativeArray() {
        int[] numbers = {-3, -5, -1, -8};
        assertEquals(-1, ArrayStats.findMax(numbers));
    }

    @Test
    @DisplayName("findMin returns -8 for an all-negative array")
    void findMin_returnsMinusEight_forAllNegativeArray() {
        int[] numbers = {-3, -5, -1, -8};
        assertEquals(-8, ArrayStats.findMin(numbers));
    }

    @Test
    @DisplayName("sum of an all-negative array stays negative")
    void sum_returnsMinusSeventeen_forAllNegativeArray() {
        int[] numbers = {-3, -5, -1, -8};
        assertEquals(-17, ArrayStats.sum(numbers));
    }
}
