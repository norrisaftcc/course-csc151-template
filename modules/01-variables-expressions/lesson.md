# Lesson 01: Variables and Expressions

**Module:** 01 — Variables and Expressions  
**Estimated time:** 50–75 minutes  
**Prerequisites:** You can compile and run a Java program with a `main` method.

---

## Learning goal

After this lesson, you can:

- Declare a variable of type `int`, `double`, or `String` and assign it a value.
- Write an arithmetic expression using two variables.
- Predict the printed output of a short program involving variable assignment.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Compile a `.java` file from the command line or your IDE.
- [ ] Run a compiled Java program and see output in the console.

If you cannot do both of these, complete Module 00 (Environment Setup) first.

---

## Concept explanation

### What is a variable?

A **variable** is a named storage location for a value. Think of it as a labeled box. You choose the label (the name), and you put a value in the box.

In Java, every variable has a **type** — a declaration of what kind of value the box can hold.

```java
int count = 0;
```

This line:
1. Declares a variable named `count`.
2. States that `count` holds an `int` (a whole number).
3. Assigns the value `0` to `count`.

### Primitive types used in this lesson

| Type | What it holds | Example value |
|------|--------------|---------------|
| `int` | A whole number (no decimal) | `42`, `-7`, `0` |
| `double` | A number with a decimal | `3.14`, `-0.5`, `100.0` |
| `boolean` | True or false | `true`, `false` |
| `String` | Text | `"Hello"`, `"CSC151"` |

`String` is not a primitive type — it is a class — but it behaves like one for the purposes of this lesson.

### What is an expression?

An **expression** is a combination of values and operators that produces a result. Examples:

```java
3 + 4        // result: 7
count * 2    // result: depends on the value of count
"Hello " + "world"  // result: "Hello world"
```

### Integer division

When both operands are `int`, Java divides as a whole number and discards the remainder:

```java
7 / 2   // result: 3, not 3.5
```

This is a common source of bugs. If you need the decimal result, at least one operand must be a `double`:

```java
7.0 / 2   // result: 3.5
(double) 7 / 2   // result: 3.5 — the cast converts 7 to 7.0 before dividing
```

---

## Worked example

The following program declares several variables and prints their values and computed results.

```java
// VariablesDemo.java
// Demonstrates variable declaration, assignment, and arithmetic expressions.

public class VariablesDemo {
    public static void main(String[] args) {
        int score = 85;
        double bonus = 1.5;
        String name = "Jordan";

        int doubled = score * 2;
        double adjusted = score * bonus;

        System.out.println("Student: " + name);
        System.out.println("Score: " + score);
        System.out.println("Doubled: " + doubled);
        System.out.println("Adjusted: " + adjusted);

        // Integer division example
        int half = score / 2;
        System.out.println("Half (integer division): " + half);
    }
}
```

**Expected output:**
```
Student: Jordan
Score: 85
Doubled: 170
Adjusted: 127.5
Half (integer division): 42
```

**What to notice:**

- `score * bonus` produces `127.5` (not `127`) because `bonus` is a `double`. When you multiply an `int` by a `double`, Java uses the `double` result.
- `score / 2` produces `42`, not `42.5`, because both `score` and `2` are `int`. The remainder is discarded.
- Variables declared inside `main` are only available within `main`. This is called **scope** — you will learn more about scope in the Methods module.

**One common mistake:**

Declaring a variable twice in the same scope causes a compile error:

```java
int score = 85;
int score = 90;  // ERROR: variable score is already defined
```

Reassign the variable instead:

```java
int score = 85;
score = 90;      // correct: reassigns, does not redeclare
```

---

## Trace before running

**Task:** Read the following code. Do not run it yet. Answer all questions, then run and check.

```java
// ExpressionTrace.java
public class ExpressionTrace {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        double c = 2.0;

        int result1 = a / b;
        double result2 = a / c;
        int result3 = a % b;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
```

**Prediction questions — write your answers before running:**

1. What is the value of `result1`?
2. What is the value of `result2`?
3. What is the value of `result3`?  
   (Hint: `%` is the **modulo** operator — it returns the remainder after division.)
4. What are the three lines of output?

<details>
<summary>Answers — open only after you have written your predictions</summary>

1. `result1 = 3` — because `10 / 3` with two `int` operands discards the remainder.
2. `result2 = 5.0` — because `10 / 2.0` uses a `double` operand, giving a decimal result.
3. `result3 = 1` — because `10 % 3` is the remainder of `10 ÷ 3` (3 goes into 10 three times with 1 left over).
4. Output:
   ```
   3
   5.0
   1
   ```

</details>

---

## Repair code

The following code contains two errors. Find them, fix them, and explain each repair.

```java
public class RepairMe {
    public static void main(String[] args) {
        int price = 20;
        int quantity = 3;
        int price = 25;   // reassign the price
        double total = price * quantity;
        System.out.println("Total: " + total)
    }
}
```

**Errors to find:**

1. There is a declaration error on line 5.
2. There is a syntax error on line 7.

Write your explanation for each fix before running the corrected code.

<details>
<summary>Corrections — open only after writing your explanation</summary>

1. `int price = 25;` should be `price = 25;` — you cannot declare the same variable twice in the same scope.
2. `System.out.println("Total: " + total)` is missing a semicolon. It should be `System.out.println("Total: " + total);`.

Corrected code:
```java
public class RepairMe {
    public static void main(String[] args) {
        int price = 20;
        int quantity = 3;
        price = 25;
        double total = price * quantity;
        System.out.println("Total: " + total);
    }
}
```

Expected output: `Total: 75.0`

</details>

---

## Execute-gate handshake

You are now going to write your own code. Complete the handshake with your coach before writing any code.

**Coach provides this task:**

> Declare three variables: an `int` named `hours` with value `8`, a `double` named `rate` with value `12.50`, and a `String` named `employee` with value `"Alex"`. Compute the total pay as `hours * rate`. Print a message in the format: `"Alex earned: 100.0"` (with the actual computed value). Include a prediction before running.
>
> Constraints: You may only use the three variables named above. You may not use additional variables for intermediate results.

**Player: complete the handshake using this format:**

```
Goal: The program must ______.
Constraints: I may ______. I may not ______.
Prediction: I expect the output to be ______.
Success check: We know it works when ______.
```

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

Write a Java program named `PayCalculator.java` that:

1. Declares `int hours = 8`, `double rate = 12.50`, and `String employee = "Alex"`.
2. Computes `double totalPay = hours * rate`.
3. Prints: `Alex earned: 100.0`

**Test cases:**

| Test | Input (change the literal values) | Expected output |
|------|----------------------------------|----------------|
| Normal | `hours = 8`, `rate = 12.50` | `Alex earned: 100.0` |
| Edge case | `hours = 0`, `rate = 12.50` | `Alex earned: 0.0` |
| Large values | `hours = 40`, `rate = 25.0` | `Alex earned: 1000.0` |

---

## Test evidence

After running your code, fill in this table:

| Test | Expected output | Actual output | Match? |
|------|----------------|---------------|--------|
| `hours = 8, rate = 12.50` | `Alex earned: 100.0` | | |
| `hours = 0, rate = 12.50` | `Alex earned: 0.0` | | |
| `hours = 40, rate = 25.0` | `Alex earned: 1000.0` | | |

---

## Explanation

Answer these questions in writing or out loud to your coach:

1. What did the program do when it ran?
2. Why does `hours * rate` produce a `double` result even though `hours` is `int`?
3. What evidence do you have that the program is correct?
4. What change to the code would cause the output to be wrong?

---

## Role rotation

Switch roles with your partner. The new coach describes the transfer task below. The new player restates the goal and completes the handshake before writing any code.

---

## Transfer task

**Changed condition:** You will now use three different data values, and the output format changes.

**Coach provides this task:**

> Declare `int units = 15`, `double price = 4.99`, and `String product = "Notebooks"`. Compute the subtotal as `units * price`. Print two lines:
>
> ```
> Product: Notebooks
> Subtotal: 74.85
> ```
>
> Constraint: You may not hard-code `74.85` — it must be the computed result. Your prediction must match the exact format above.

**Player: complete the full handshake before writing code.**

<details>
<summary>Expected output (check after running)</summary>

```
Product: Notebooks
Subtotal: 74.85
```

If your output shows `74.85000...` instead, use `System.out.printf("Subtotal: %.2f%n", subtotal);` to format it. (The `%n` is a newline. The `%.2f` means: print the `double` with two decimal places.)

</details>

---

## Reflection

Answer one of the following:

- What surprised you about integer division? How would you explain it to a classmate?
- Why does the execute gate require a prediction before running? What is the value of writing the prediction even when you are confident?
- What is one question you still have about variables or expressions?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Declare and assign a primitive variable | | | |
| Predict the result of integer division | | | |
| Write an arithmetic expression with mixed types | | | |
| Complete the execute-gate handshake | | | |
| Record test evidence | | | |
| Explain the result to a coach | | | |
| Coach role completed | | | |
| Transfer task completed independently | | | |
