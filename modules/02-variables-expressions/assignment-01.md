# Assignment 01: Variables and Arithmetic

**Course:** CSC 151 Java Programming I  
**Module:** 02 — Variables and Expressions  
**Type:** Individual  
**Due:** End of Module 02 (confirm timing with your instructor)

---

## Learning goal

Declare variables of types `int`, `double`, and `String`; write arithmetic expressions; and predict the output of a program that uses integer division and casting.

---

## Background

Variables are the basic storage unit in a Java program. Every value your program uses — a score, a price, a name — must be stored somewhere before it can be used. Understanding how types affect arithmetic (especially integer division) prevents one of the most common bugs in introductory Java: a division that silently drops the decimal.

---

## Requirements

Your submission must:

1. Declare at least three variables: one `int`, one `double`, and one `String`.
2. Compute at least two arithmetic expressions and store each result in a variable.
3. Print all variables and results using `System.out.println`.
4. Include at least one example of integer division and one example that avoids it using a cast or a `double` literal.
5. Compile without errors.
6. Pass all required test cases.

### Constraints

- You **may** use: `int`, `double`, `String`, `System.out.println`, arithmetic operators (`+`, `-`, `*`, `/`, `%`), and casting.
- You **may not** use: `Scanner`, arrays, loops, or methods other than `main`.

---

## Execute-gate handshake

Before submitting or running your final code, complete the handshake with your instructor.

Submit your handshake responses with your assignment. Use this format:

```
Goal: The program must declare three variables, compute two expressions, 
      and print results including one integer division and one decimal division.
Constraints: I may use int, double, String, println, and arithmetic operators.
             I may not use Scanner, arrays, loops, or extra methods.
Prediction: I expect the integer division of 85 / 2 to print 42.
            I expect the decimal division (double) 85 / 2 to print 42.5.
Success check: We know it works when the program compiles, prints the correct 
               values, and the integer-division line prints 42 (not 42.5).
```

---

## Tasks

### Task 1 — Student score report

Declare the following variables and assign the values shown:

| Variable | Type | Value |
|----------|------|-------|
| `studentName` | `String` | your own name |
| `rawScore` | `int` | `85` |
| `bonus` | `double` | `1.5` |

Compute:
- `adjusted`: `rawScore` multiplied by `bonus` (store as `double`)
- `halfScore`: `rawScore` divided by `2` (store as `int` — integer division)

Print all five values, one per line, with a label. Example:

```
Name: Alex
Raw score: 85
Bonus: 1.5
Adjusted score: 127.5
Half score: 42
```

### Task 2 — Predict before you run

Before running your program, fill in the prediction table:

| Expression | Predicted value | Actual value |
|-----------|----------------|-------------|
| `85 * 1.5` | | |
| `85 / 2` (int division) | | |
| `(double) 85 / 2` | | |
| `"Score: " + 85` | | |

Run your program and record the actual values. Explain any difference between your prediction and the actual result.

### Task 3 (Transfer) — Price with tax

**Changed condition:** Instead of a student score, compute a price with tax.

Declare:
- `itemName` (`String`) — name of any item
- `price` (`double`) — a price between 1.00 and 100.00
- `taxRate` (`double`) — `0.08` (8% tax)

Compute and print:
- The tax amount: `price * taxRate`
- The total price: `price + tax amount`

Round to two decimal places if you know how; if not, print the full decimal value.

---

## Test cases

Your submission must pass all of the following:

| Test | Input | Expected output |
|------|-------|----------------|
| Integer division | `rawScore = 85`, divisor `2` | `42` (not `42.5`) |
| Decimal division | `(double) rawScore / 2` | `42.5` |
| String concatenation | `"Score: " + rawScore` | `Score: 85` |
| Adjusted score | `85 * 1.5` | `127.5` |

---

## Evidence requirements

Submit a file named `evidence.txt` (or add inline comments to your `.java` file) that shows:

1. Your predicted output for the integer-division case and the decimal-division case.
2. Your actual output for all four test cases in the table above.
3. One sentence: "The integer division prints 42 because…"
4. One mistake that would make `halfScore` print `42.5` instead of `42`.

---

## Explanation question

Answer this question in 2–4 sentences:

> Why does Java produce different results for `85 / 2` and `(double) 85 / 2`? What does the cast `(double)` do, and when do you need it?

---

## Submission checklist

- [ ] Code compiles without errors.
- [ ] All required test cases pass.
- [ ] Execute-gate handshake is complete (written).
- [ ] Evidence file is included.
- [ ] Explanation question is answered.
- [ ] Transfer task (price with tax) is completed.

---

## Grading

| Criterion | Points |
|-----------|--------|
| Code compiles | 10 |
| Required test cases pass | 30 |
| Handshake is complete and specific | 20 |
| Evidence is specific (actual output recorded) | 20 |
| Explanation question answered clearly | 10 |
| Transfer task completed | 10 |
| **Total** | **100** |
