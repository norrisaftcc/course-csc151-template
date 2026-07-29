# Lab 01: Variables and Expressions

**Course:** CSC 151 Java Programming I  
**Module:** 1 — Variables and Expressions  
**Partner:** Work in pairs. Switch coach and player roles at each numbered step.  
**Estimated time:** 50 minutes

---

## Learning goal

Declare and use `int`, `double`, and `String` variables; write arithmetic expressions; and predict the effect of integer division before running code.

---

## Setup

Before starting:

1. Open your Java development environment.
2. Create a new file named `LabVariables.java`.
3. Write the class shell:
   ```java
   public class LabVariables {
       public static void main(String[] args) {
           // your code goes here
       }
   }
   ```
4. Decide who is Player 1 (starts as player) and Player 2 (starts as coach).

---

## Step 1 — Declare and print variables (Player 1 plays, Player 2 coaches)

### Handshake

**Coach (Player 2) states:**

> Declare an `int` variable named `year` with the value `2025`. Declare a `String` variable named `course` with the value `"CSC151"`. Print both variables, one per line. The output must match exactly:
> ```
> 2025
> CSC151
> ```

**Player (Player 1) must confirm before any code is written:**

- Goal: "The program must print `2025` on line one and `CSC151` on line two."
- Constraints: "I may use `int`, `String`, and `System.out.println`. I may not use any other print method."
- Prediction: "I expect the output to be `2025` on the first line and `CSC151` on the second line."
- Success check: "We know it works when the program compiles and prints those two lines in that order."

Gate opens when the coach says: "Agreed."

### Task

Declare `year` and `course` inside `main`. Print each one with `System.out.println`.

### Evidence

After running, record:
- Actual output: ______
- Expected output: `2025` / `CSC151`
- Match? Yes / No

### Explanation (Player 1 explains to Player 2)

1. What did the code print?
2. Why does `System.out.println(year)` print a number even though there are no quotes?
3. What evidence shows it is correct?

---

## Step 2 — Integer division (Player 2 plays, Player 1 coaches)

**Roles switch.** Player 2 is now the player. Player 1 is now the coach.

### Handshake

**Coach (Player 1) states:**

> Declare an `int` variable named `score` with the value `91`. Declare an `int` variable named `half` equal to `score / 2`. Print `half`. Before you write the code, predict the output.

**Player (Player 2) must confirm:**

- Goal: "The program must compute `score / 2` and print the result."
- Constraints: "I may only use `int` variables and integer arithmetic. I may not cast or use `double`."
- Prediction: "`91 / 2` using integer division will print ______." (fill in your prediction)
- Success check: "We know it works when the printed value matches my prediction."

Gate opens when the coach says: "Agreed."

### Task

Add to `main`: declare `score = 91`, compute `half = score / 2`, and print `half`.

### Evidence

After running, record:
- Predicted value: ______
- Actual output: ______
- Match? Yes / No
- If no: explain why the actual value differs from your prediction.

### Explanation (Player 2 explains to Player 1)

1. What did `score / 2` print?
2. Why does Java discard the remainder in integer division?
3. What would you change to get `45.5` instead of `45`?

---

## Step 3 — String concatenation (Player 1 plays, Player 2 coaches)

**Roles switch.** Player 1 is now the player again.

### Handshake

**Coach (Player 2) states:**

> Using the `score` variable already declared, print one line in this format: `Score: 91`. Use string concatenation — do not type the number directly in the string.

**Player (Player 1) must confirm:**

- Goal: "The program must print `Score: ` followed by the value of `score` on one line."
- Constraints: "I must use string concatenation with `score`. I may not write `\"Score: 91\"` as a literal."
- Prediction: "I expect the output to be `Score: 91`."
- Success check: "We know it works when changing `score` to any other value automatically changes the printed line."

Gate opens when the coach says: "Agreed."

### Task

Add one `System.out.println` line that uses string concatenation to print `Score: ` followed by `score`.

### Evidence

After running, record:
- Actual output: ______
- Expected output: `Score: 91`
- Match? Yes / No

### Explanation (Player 1 explains to Player 2)

1. What does the `+` operator do when one side is a `String`?
2. What would change in the output if you set `score = 100`?

---

## Step 4 — Transfer (both players, roles your choice)

**Changed condition:** Use `double` arithmetic instead of `int`.

Complete the full handshake before writing or running any code. Both players should agree on the goal and prediction before the gate opens.

**Task:** Add code to compute and print:
- A `double` variable `average` equal to `(score + 80) / 2.0`
- A label line in the format: `Average: 85.5`

**Prediction:** Write your expected value for `average` before running.

---

## Lab completion record

| Step | Player | Coach | Handshake complete | Evidence recorded | Explanation given |
|------|--------|-------|--------------------|-------------------|-------------------|
| 1 — Declare and print | Player 1 | Player 2 | Yes / No | Yes / No | Yes / No |
| 2 — Integer division | Player 2 | Player 1 | Yes / No | Yes / No | Yes / No |
| 3 — Concatenation | Player 1 | Player 2 | Yes / No | Yes / No | Yes / No |
| Transfer | | | Yes / No | Yes / No | Yes / No |

---

## Instructor sign-off

Instructor initials: ______ Date: ______

Notes: ______
