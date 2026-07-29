# Lesson 4: Loops

**Module:** 4 — Loops  
**Estimated time:** 100–120 minutes  
**Prerequisites:** You can write an `if` statement and a boolean condition. You can read a value with `Scanner` and print a formatted line with `printf`.

---

## Learning goal

After this lesson, you can:

- Write a `while` loop, a `do-while` loop, and a `for` loop, and state which one fits a task.
- Name the three parts of a `for` loop header: init, condition, update.
- Write the accumulator pattern: declare a running total before the loop and add to it inside.
- Trace a loop with a table, one row per pass.
- Write a sentinel-controlled loop that reads values until a stop value arrives.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Write a condition using `<`, `<=`, `>=`, or `!=`.
- [ ] Write an `if` statement that runs one block when a condition is `true`.
- [ ] Read a `double` from the user with `Scanner`.

If you cannot do all three, complete Module 3 (Conditionals) before continuing.

---

## Concept explanation

### A loop repeats a block while a condition stays true

A **loop** runs the same block of code more than once. The block is the **body**. One run of
the body is one **pass**, also called an iteration. A condition decides whether another pass
happens.

### `while` — test before the body

```java
int i = 3;
while (i > 0) {
    System.out.println(i);
    i--;
}
```

Java tests `i > 0` **before** each pass. When the condition is already `false` at the start,
the body never runs at all.

**Something in the body must change the condition.** Delete the `i--` above and `i` stays at
`3` forever, so the condition never becomes `false` and the program prints `3` until you stop
it. That is an **infinite loop**, and it is entry 9 in the [FAQ](../../docs/faq.md). Stop a
runaway program in the terminal with `Ctrl+C`.

### `do-while` — test after the body

```java
int j = 3;
do {
    System.out.println(j);
    j--;
} while (j > 0);
```

Java runs the body first and tests the condition afterward, so **the body always runs at least
once**. Start the two loops above at `0` instead of `3` and the difference appears: the
`while` body runs zero times and the `do-while` body runs once. That difference is the only
reason to choose `do-while`.

### `for` — the three jobs on one line

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

A `for` header holds three parts, separated by semicolons:

| Part | This example | When it runs |
|------|-------------|--------------|
| **Init** | `int i = 1` | Once, before the first test |
| **Condition** | `i <= 5` | Before every pass |
| **Update** | `i++` | After every pass, before the next test |

These are the same three jobs the `while` loop does in three separate places. A `for` loop
collects them where a reader can check all three at once, which is why a counted repetition is
usually written as a `for`.

### The accumulator pattern

An **accumulator** is a variable that collects a result across passes.

```java
int total = 0;                      // declared BEFORE the loop
for (int i = 1; i <= 5; i++) {
    total += i;                     // added to INSIDE the loop
}
System.out.println(total);          // 15
```

`total += i` means `total = total + i`.

**Declare the accumulator before the loop.** Declared inside the body, it is created and set
to `0` again on every pass, and the final value is only the last thing added — `5` here
instead of `15`.

### `break` and `continue`

`break` ends the loop immediately. `continue` skips the rest of the current pass and goes to
the next test.

```java
for (int i = 1; i <= 10; i++) {
    if (i == 4) {
        continue;          // skip 4, keep looping
    }
    if (i == 7) {
        break;             // stop the loop at 7
    }
    System.out.print(i + " ");
}
// prints: 1 2 3 5 6
```

Both statements are useful and both hide the exit from the loop header, so a reader has to
search the body to learn when the loop ends. Prefer a clear condition where one will do.

### Nested loops

A loop inside another loop runs the inner loop completely on every pass of the outer loop.

```java
for (int row = 1; row <= 3; row++) {
    for (int col = 1; col <= 3; col++) {
        System.out.printf("%4d", row * col);
    }
    System.out.println();          // ends the row
}
```

The outer loop counts rows, the inner loop counts columns, and the `println` after the inner
loop ends the line. The outer loop runs three passes. Each of those passes runs the inner loop
three times, so the inner body runs nine times in total.

### The sentinel-controlled loop

Sometimes the number of readings is not known before the program runs. A **sentinel** is a
stop value that ends the loop — a value the data itself would never carry.

```java
System.out.print("Enter a number (0 to stop): ");
double value = input.nextDouble();     // the priming read

while (value != 0) {
    total += value;
    count++;

    System.out.print("Enter a number (0 to stop): ");
    value = input.nextDouble();        // read again at the end of the body
}
```

Two details carry this shape:

1. **The priming read.** The first value arrives before the loop, so the condition has
   something to test on its first look.
2. **The sentinel is not data.** The reading that ends the loop happens at the end of the
   body, so the stop value is never added and never counted. Count it and the total is right
   while the count is one too high.

`examples/SentinelLoop.java` is this loop, runnable. Module 8 reuses the same shape to read
commands until the user types `quit`.

Key terms introduced in this lesson:

- **Body:** the block a loop repeats.
- **Pass (iteration):** one run of the body.
- **Accumulator:** a variable declared before the loop that collects a result across passes.
- **Infinite loop:** a loop whose condition never becomes `false`.
- **Sentinel:** a stop value that ends a loop when the number of readings is unknown.

---

## Worked example

`examples/SumToN.java` adds `1` through `n` with the accumulator pattern and prints the
running total after every pass, so a trace written on paper has a printed line to check itself
against.

```java
// SumToN.java
// Adds 1 through n and prints the running total after each pass.
// See examples/SumToN.java for the full runnable version.

public class SumToN {
    public static void main(String[] args) {
        int n = 5;

        int total = 0;      // the accumulator, declared before the loop
        int passes = 0;

        // i <= n, not i < n. The task counts 1 through 5 inclusive, so the
        // last value must still enter the body.
        for (int i = 1; i <= n; i++) {
            total += i;
            passes++;
            System.out.println("i = " + i + ", total after this pass = " + total);
        }

        System.out.println("Sum of 1 through " + n + " is " + total);
        System.out.println("The loop body ran " + passes + " times.");
    }
}
```

**Expected output:**
```
i = 1, total after this pass = 1
i = 2, total after this pass = 3
i = 3, total after this pass = 6
i = 4, total after this pass = 10
i = 5, total after this pass = 15
Sum of 1 through 5 is 15
The loop body ran 5 times.
```

**What to notice:**

- `total` is declared before the loop and survives every pass. `i` is declared in the header
  and exists only inside the loop.
- The condition is `i <= n` because the task counts 1 through 5 **inclusive**. A loop that
  starts at `0` and visits `n` items uses `i < n` instead. The right comparison depends on
  where the counting starts, and this is where off-by-one errors live.
- The body runs 5 times. Count the printed `i =` lines: that count is evidence, not an
  opinion.

`examples/CountdownLoops.java` is the second worked example. It counts down from 3 three times
— once with each loop — and then runs each loop again with a condition that is already `false`
at the start. Run it and read the last three lines: the `while` body runs 0 times, the
`do-while` body runs 1 time, and the `for` body runs 0 times.

---

## Trace before running

### Part 1 — `SumToN` with a table

**Task:** Trace `examples/SumToN.java` for `n = 5`. Do not run it yet.

Fill in one row per pass.

| Pass | `i` | `total` after the body | Condition `i <= n` before the next pass |
|------|-----|------------------------|------------------------------------------|
| 1 | 1 | ______ | ______ |
| 2 | 2 | ______ | ______ |
| 3 | 3 | ______ | ______ |
| 4 | 4 | ______ | ______ |
| 5 | 5 | ______ | ______ |

**Prediction questions — write your answers before running:**

1. What is the value of `total` after the loop ends?
2. How many times does the loop body run?
3. What value does `i` hold when the condition is `false` for the first time?
4. What would the final total be if `total` were declared inside the loop body?

<details>
<summary>Answers — open only after filling in the table and writing your predictions</summary>

| Pass | `i` | `total` after the body | Condition before the next pass |
|------|-----|------------------------|--------------------------------|
| 1 | 1 | 1 | `2 <= 5` is `true` |
| 2 | 2 | 3 | `3 <= 5` is `true` |
| 3 | 3 | 6 | `4 <= 5` is `true` |
| 4 | 4 | 10 | `5 <= 5` is `true` |
| 5 | 5 | 15 | `6 <= 5` is `false` — the loop ends |

1. `total = 15`.
2. The body runs 5 times.
3. `i` holds `6`. The update runs after the fifth pass, and the test that follows it fails.
4. The final total would be `5`. A `total` declared inside the body is created and set to `0`
   again on every pass, so the printed value is only the last number added.

</details>

### Part 2 — `SentinelLoop` with a short prediction

**Task:** Read `examples/SentinelLoop.java`, and read its input fixture
`examples/SentinelLoop.stdin`, which holds these four lines:

```
4.5
2.5
3.0
0
```

**Prediction questions — write your answers before running:**

1. How many times does the loop body run?
2. What does the program print for `Values entered:`?
3. What does the program print for `Total:`?
4. The fixture ends with `0`. Is that `0` added to the total? Is it counted?

<details>
<summary>Answers — open only after writing your predictions</summary>

1. The body runs 3 times, once for each of `4.5`, `2.5`, and `3.0`.
2. `Values entered: 3`.
3. `Total: 10.0`.
4. The `0` is neither added nor counted. It arrives in the read at the **end** of the body,
   the condition `value != 0` then fails, and the loop ends before the body runs again. Adding
   `0` would leave the total correct and the count one too high, which is the failure that
   makes this ordering worth writing down.

</details>

---

## Repair code

The following program contains **two errors**. Find them, fix them, and explain each repair.
Do not run the code until you have written your explanations.

The program should print the numbers 1 through 5, then print one star for each of those five
numbers.

```java
public class RepairCounter {
    public static void main(String[] args) {
        int n = 5;

        // Part 1: print 1 through n.
        int i = 1;
        while (i <= n) {
            System.out.println(i);
            // error 1
        }

        // Part 2: print one star per number printed above.
        for (int k = 0; k <= n; k++) {   // error 2
            System.out.print("*");
        }
        System.out.println();
    }
}
```

**Errors to find:**

1. The `while` loop. Something the loop needs is missing from its body.
2. The `for` loop condition. Count the stars it prints.

**Predict before you repair.** Write down what this program does when you run it as written.
One of the two errors makes the program never stop, so predicting it is safer than running it.
If you do run it, stop it with `Ctrl+C`.

<details>
<summary>Corrections — open only after writing your explanations</summary>

1. **The `while` body never updates `i`.** The condition `i <= n` tests a variable that no
   statement changes, so it stays `true` and the loop prints `1` until the program is stopped.
   The repair adds `i++;` as the last statement of the body. This is entry 9 in the
   [FAQ](../../docs/faq.md), and the diagnostic question is always the same: which statement
   in this body changes the variable in the condition?

2. **`k <= n` runs one pass too many.** `k` starts at `0`, so the passes are `k = 0, 1, 2, 3,
   4, 5` — six passes and six stars for five numbers. The repair is `k < n`, which gives
   `k = 0, 1, 2, 3, 4`. This is entry 10 in the FAQ, the off-by-one error.

**Both comparisons are correct somewhere.** `SumToN` uses `i <= n` and is right to, because it
starts at `1` and must include `n`. `RepairCounter` starts at `0` and must stop before `n`.
The rule is not "always use `<`" — the rule is that the starting value decides the comparison,
so trace the first pass and the last pass every time.

Corrected code:
```java
public class RepairCounter {
    public static void main(String[] args) {
        int n = 5;

        int i = 1;
        while (i <= n) {
            System.out.println(i);
            i++;
        }

        for (int k = 0; k < n; k++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
```

Expected output:
```
1
2
3
4
5
*****
```

</details>

---

## Execute-gate handshake

You are now going to write two loops of your own. Complete the handshake with your coach
before writing any code.

**Coach provides this task:**

> Part 1: Write `TimesTable.java`. Print a 5 by 5 multiplication grid with nested `for` loops.
> Print each number with `System.out.printf("%4d", value)` so the columns line up, and end each
> row with `System.out.println()`. Read the grid size from an `int` variable named `size`, so
> the same program prints a grid of any size when that one value changes.
>
> Part 2: In the same file, after the grid, write a sentinel-controlled loop. Read `double`
> values until the user enters `0`, then print how many values arrived and what they add up to.
> Use the priming-read shape from `SentinelLoop.java`.
>
> Constraints: You may use `while`, `do-while`, `for`, `break`, and `continue`. You may not use
> any library method that does the counting for you. Every line stays inside `main`, as it does
> in every Module 4 example.

**Player: complete the handshake using this format:**

```
Goal: The program must ______.
Constraints: I may ______. I may not ______.
Prediction: For size = 5 I expect ______ rows and ______ numbers in each row.
            For size = 1 I expect ______. For size = 0 I expect ______.
            For the values 4.5, 2.5, 3.0, 0 I expect a count of ______ and a total of ______.
Success check: We know it works when ______.
```

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

Write a Java program in a file named `TimesTable.java`.

**Part 1 — the grid:**

1. Declare `int size = 5;`.
2. Print `size` rows. Each row holds `size` numbers.
3. The number in row `r`, column `c` is `r * c`.
4. Print every number with `System.out.printf("%4d", value);` and end every row with
   `System.out.println();`.

**Required output for `size = 5`:**
```
   1   2   3   4   5
   2   4   6   8  10
   3   6   9  12  15
   4   8  12  16  20
   5  10  15  20  25
```

**Part 2 — the sentinel loop:**

5. After the grid, prompt for and read `double` values until the user enters `0`.
6. Print the count of values entered and their total.

**Required output for the values 4.5, 2.5, 3.0, 0:**
```
Values entered: 3
Total: 10.0
```

---

## Test evidence

Record all three tiers after running. All three change one value: `size`.

| Tier | What to run | Expected | Actual | Match? |
|------|-------------|----------|--------|--------|
| **Normal** | `size = 5` | 5 rows, 5 numbers per row, last number `25` | | |
| **Boundary** | `size = 1` | One row holding one number, `   1` | | |
| **Failure** | `size = 0` | No rows at all, and the program still reaches the sentinel loop and ends normally | | |

The failure tier is the one worth your attention. A `size` of `0` makes the outer condition
`false` on entry, so the body never runs. The program prints nothing for the grid and does not
report an error, because a loop that runs zero times is not a broken loop. Compare that with
the `do-while` in `CountdownLoops.java`, whose body would print one row even at `size = 0`.

---

## Explanation

Answer these questions in writing or out loud to your coach:

1. How many times does the inner loop body run in total when `size = 5`? Show the arithmetic.
2. Why is the accumulator in Part 2 declared before the loop instead of inside it?
3. What evidence shows that the sentinel `0` was not counted?
4. Which loop would you rewrite as a `while`, and which as a `for`? State the reason for each.

---

## Role rotation

Switch roles with your partner. The new coach describes the transfer task below. The new
player restates the goal and completes the handshake before writing any code.

---

## Transfer task

**Changed condition:** The same sentinel loop must now report an **average** instead of a
total. Dividing by the count turns an empty run into a case the program has to answer rather
than compute.

**Coach provides this task:**

> Write `AverageUntilZero.java`. Read `double` values until the user enters `0`. Then print how
> many values arrived and their average.
>
> When the user enters `0` first and enters nothing else, print `No values entered` and print
> no average.
>
> Constraints: Use the priming-read sentinel shape. Guard the division with an `if`, which you
> wrote in Module 3. Every line stays inside `main`.
>
> Test with `4.5 2.5 3.0 0`, with `7.0 0`, and with `0` on its own.

**Player: complete the full handshake before writing code.**

<details>
<summary>Expected output (check after running)</summary>

For `4.5 2.5 3.0 0`:
```
Values entered: 3
Average: 3.3333333333333335
```

For `7.0 0`:
```
Values entered: 1
Average: 7.0
```

For `0` on its own:
```
No values entered
```

Two notes on the first result. The long tail of digits is what a `double` division prints, and
it is correct — Module 2 showed how `printf("%.2f%n", average)` shortens it when a report needs
two decimals. Either output is acceptable evidence here as long as your prediction matches
what you printed.

The third case is the one being assessed. Without the `if`, the program divides a total of
`0.0` by a count of `0`, and `double` division by zero produces `NaN` rather than an error
message. The program prints `Average: NaN` and exits normally, so nothing tells you it failed.
The guard is the reason the case is in the test plan.

Everything else here is the loop you already wrote with your coach. The sentinel shape, the
count, and the accumulator do not change.

</details>

---

## Reflection

Answer one of the following:

- Which loop did you reach for first in Part 1, and what made a `for` fit the grid better than
  a `while`?
- The infinite loop in `RepairCounter` produces no error message at all. What would you tell a
  classmate to check first when a program never returns to the prompt?
- What question do you still have about the sentinel loop or the priming read?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Write a `while` loop with a condition that changes | ☐ | ☐ | ☐ |
| State the difference between `while` and `do-while` | ☐ | ☐ | ☐ |
| Name the init, condition, and update parts of a `for` header | ☐ | ☐ | ☐ |
| Write the accumulator pattern with the total declared before the loop | ☐ | ☐ | ☐ |
| Trace a loop with a table, one row per pass | ☐ | ☐ | ☐ |
| Choose `<` or `<=` from the starting value | ☐ | ☐ | ☐ |
| Write nested loops that print a grid | ☐ | ☐ | ☐ |
| Write a sentinel-controlled loop with a priming read | ☐ | ☐ | ☐ |
| Keep the sentinel out of the count and the total | ☐ | ☐ | ☐ |
| Complete the execute-gate handshake | ☐ | ☐ | ☐ |
| Record normal, boundary, and failure evidence | ☐ | ☐ | ☐ |
| Coach role completed | ☐ | ☐ | ☐ |
| Transfer task (`AverageUntilZero`) completed independently | ☐ | ☐ | ☐ |
