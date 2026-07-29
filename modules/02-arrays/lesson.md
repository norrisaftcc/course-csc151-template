# Lesson 02: Arrays

**Module:** 02 — Arrays  
**Estimated time:** 75–100 minutes  
**Prerequisites:** You can write a `for` loop. You can write and call a static method with a return value.

---

## Learning goal

After this lesson, you can:

- Declare and initialize an `int` array.
- Access elements by index.
- Write a single-pass `for` loop to find the maximum value in an `int` array.
- Identify and test at least two edge cases: a one-element array and an all-negative array.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Write a `for` loop that counts from `0` to `n - 1`.
- [ ] Write a static method that accepts an `int` and returns an `int`.
- [ ] Compile and run a program with a method called from `main`.

If you cannot do one of the above, review the Methods module before continuing.

---

## Concept explanation

### What is an array?

An **array** is an ordered collection of values of the same type. Each value has an **index** — a number that identifies its position. Indexes start at `0`.

```
Index:   0    1    2    3    4
Value:  10   30   20   50   40
```

The array above has 5 elements. The first element (index 0) is `10`. The last element (index 4) is `40`.

### Declaring and initializing an array

```java
// Declare and initialize with literal values
int[] numbers = {10, 30, 20, 50, 40};

// Declare with a size (all values start at 0)
int[] scores = new int[5];
scores[0] = 95;
scores[1] = 82;
```

The **length** of an array is available with `.length`:

```java
System.out.println(numbers.length);  // prints 5
```

### Accessing elements

```java
int first = numbers[0];   // 10
int last  = numbers[4];   // 40
```

If you use an index that is out of range — less than `0` or greater than or equal to the array's length — Java throws an `ArrayIndexOutOfBoundsException` at runtime.

### Traversing with a for loop

The standard pattern for visiting every element:

```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

The loop variable `i` starts at `0` and stops when `i` equals `numbers.length`. The last valid index is `numbers.length - 1`.

---

## Worked example

The following program finds the maximum value in an array by checking every element.

```java
// ArrayMax.java
// Finds the largest value in an int array.
// See examples/ArrayMax.java for the full runnable version.

public class ArrayMax {

    // Returns the largest value in numbers.
    // Assumes the array has at least one element.
    public static int findMax(int[] numbers) {
        int max = numbers[0];   // start with the first element
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {10, 30, 20, 50, 40};
        System.out.println("Max: " + findMax(data));   // Max: 50
    }
}
```

**Expected output:**
```
Max: 50
```

**What to notice:**

- `max` is initialized to `numbers[0]`, not to `0`. Starting with `0` would fail for an array of all negative values: `{-5, -2, -8}` would return `0` instead of `-2`.
- The loop starts at index `1` because `max` already holds `numbers[0]`. Starting at `1` avoids comparing the first element to itself.
- The method returns `max` only after the loop completes — after every element has been checked.

**One common mistake:**

```java
int max = 0;   // WRONG for negative arrays
```

If every value in the array is negative, this initialization causes the method to return `0` instead of the actual maximum. Always initialize `max` to `numbers[0]`.

---

## Trace before running

**Task:** Trace the `findMax` method for the array `{-3, -5, -1, -8}`.

Use the table below. Fill in one row per iteration. Do not run the code yet.

| Iteration | `i` | `numbers[i]` | `max` (after the `if`) |
|-----------|-----|--------------|------------------------|
| Start | — | — | `numbers[0]` = \_\_\_ |
| 1 | 1 | \_\_\_ | \_\_\_ |
| 2 | 2 | \_\_\_ | \_\_\_ |
| 3 | 3 | \_\_\_ | \_\_\_ |

**Prediction questions — write answers before running:**

1. What is the value of `max` after the loop completes?
2. What does the method return?
3. How many times does the loop body run?

<details>
<summary>Answers — open only after filling in the table and writing your predictions</summary>

| Iteration | `i` | `numbers[i]` | `max` (after the `if`) |
|-----------|-----|--------------|------------------------|
| Start | — | — | -3 |
| 1 | 1 | -5 | -3 (−5 is not > −3) |
| 2 | 2 | -1 | -1 (−1 > −3) |
| 3 | 3 | -8 | -1 (−8 is not > −1) |

1. `max = -1`
2. The method returns `-1`.
3. The loop body runs 3 times (for `i = 1, 2, 3`).

</details>

---

## Repair code

The following code contains two errors. Find them, fix them, and explain each repair. Do not run the code until you have written your explanations.

```java
public class RepairMax {
    public static int findMax(int[] numbers) {
        int max = 0;   // error 1
        for (int i = 0; i <= numbers.length; i++) {   // error 2
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {-3, -5, -1};
        System.out.println(findMax(data));
    }
}
```

**Errors to find:**

1. Line 3: the initialization of `max`.
2. Line 4: the loop condition.

Write your explanation for each fix before running.

<details>
<summary>Corrections — open only after writing your explanations</summary>

1. `int max = 0;` → `int max = numbers[0];`  
   Reason: initializing to `0` gives the wrong answer for all-negative arrays.

2. `i <= numbers.length` → `i < numbers.length`  
   Reason: valid indexes are `0` through `numbers.length - 1`. When `i == numbers.length`, `numbers[i]` throws `ArrayIndexOutOfBoundsException`.

Corrected code:
```java
public class RepairMax {
    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {-3, -5, -1};
        System.out.println(findMax(data));   // -1
    }
}
```

</details>

---

## Execute-gate handshake

You are now going to write your own `findMax` method from scratch. Complete the handshake with your coach before writing any code.

**Coach provides this task:**

> Write a static method named `findMax` that accepts an `int` array and returns the largest value in that array. Do not sort the array. Do not use any library methods.
>
> Test your method with these three arrays:
> - `{5, 2, 8, 1, 9}` — a typical array
> - `{42}` — an array with one element
> - `{-7, -3, -10}` — an array with all negative values
>
> Constraint: You may not sort the array. You may not use `Math.max` or any other library method. You must initialize `max` to `numbers[0]`.

**Player: complete the handshake using this format:**

```
Goal: The program must ______.
Constraints: I may ______. I may not ______.
Prediction: For {5, 2, 8, 1, 9} I expect ______. For {42} I expect ______.
            For {-7, -3, -10} I expect ______.
Success check: We know it works when ______.
```

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

Write a Java program in a file named `MyArrayMax.java` that:

1. Declares the static method `findMax(int[] numbers)`.
2. Tests it with all three arrays listed in the handshake.
3. Prints one line per test showing the array description and the result.

**Required output format:**
```
Typical array max: 9
One element max: 42
All negative max: -3
```

---

## Test evidence

After running, fill in this table:

| Test | Expected | Actual | Match? |
|------|----------|--------|--------|
| `{5, 2, 8, 1, 9}` | `9` | | |
| `{42}` | `42` | | |
| `{-7, -3, -10}` | `-3` | | |

---

## Explanation

Answer these questions in writing or out loud to your coach:

1. What did the method do on each iteration of the loop?
2. Why must `max` be initialized to `numbers[0]` instead of `0`?
3. What evidence shows the method is correct for all three test cases?
4. What would happen if you used `<=` instead of `<` in the loop condition?

---

## Role rotation

Switch roles with your partner. The new coach describes the transfer task below. The new player restates the goal and completes the handshake before writing any code.

---

## Transfer task

**Changed condition:** Instead of finding the maximum, find the **minimum** value.

**Coach provides this task:**

> Write a static method named `findMin` that accepts an `int` array and returns the smallest value. Apply the same rules: no sorting, no library methods, initialize to `numbers[0]`.
>
> Test with:
> - `{5, 2, 8, 1, 9}` — expected: `1`
> - `{42}` — expected: `42`
> - `{-7, -3, -10}` — expected: `-10`

**Player: complete the full handshake before writing code.**

<details>
<summary>Expected output (check after running)</summary>

```
Typical array min: 1
One element min: 42
All negative min: -10
```

The only change from `findMax` is the comparison: `<` instead of `>`.

</details>

---

## Reflection

Answer one of the following:

- Why is the one-element array an important test case? What would happen if you skipped it?
- What is the difference between a logic error and a runtime error? Give an example of each from this lesson.
- What question do you still have about arrays?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Declare and initialize an `int` array | | | |
| Access elements by index | | | |
| Trace a loop using a table | | | |
| Write a single-pass `findMax` method | | | |
| Initialize `max` to `numbers[0]` (not `0`) | | | |
| Test a normal case, edge case, and failure case | | | |
| Complete the execute-gate handshake | | | |
| Explain the result with evidence | | | |
| Coach role completed | | | |
| Transfer task (`findMin`) completed independently | | | |
