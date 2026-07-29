# Lesson 5.1: Methods

**Module:** 5 — Methods and Testing (submodule 5.1)  
**Estimated time:** 75–100 minutes  
**Prerequisites:** You can write a `for` loop and an `else if` chain. You can declare `int`, `double`, `boolean`, and `String` variables.

---

## Learning goal

After this lesson, you can:

- Name the four parts of a method declaration: access modifier, return type, name, and
  parameter list.
- Write a method that returns a value, and a method that returns nothing.
- Call a method and use its returned value inside a larger expression.
- State which variables are in scope at a given line.
- Read a sequence of calls as a call stack: who called whom, and where control returns.
- Write two methods that share one name and differ in their parameter lists.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Write an `else if` chain that tests bands from the highest band down.
- [ ] Write a `for` loop with an accumulator declared before the loop.
- [ ] Declare a `boolean` variable and use it in an `if` condition.

If you cannot do all three, complete Modules 3 and 4 before continuing.

---

## Concept explanation

### Why a method exists

Module 3's `TicketPrice.java` writes the same `else if` chain four times, because every line of
that program lives in `main`. Module 4's loops have the same shape as each other. Copying a
decision is not only long: when the decision changes, every copy has to change, and one missed
copy is a defect that no compiler reports.

A **method** is a named block of code that other code can call. Write the decision once, call
it four times.

### The four parts of a declaration

```java
public static int doubled(int value) {
    return value * 2;
}
```

| Part | In this example | What it states |
|------|----------------|----------------|
| **Access modifier** | `public` | Who may call this method |
| **Return type** | `int` | What kind of value the method hands back |
| **Name** | `doubled` | What callers write to reach it |
| **Parameter list** | `(int value)` | What the method must be given, and of what type |

`static` sits between the access modifier and the return type. It means the method belongs to
the class rather than to an object. Every method in this module is `static`. Module 7 removes
the word and explains what changes.

### Return, and `void`

A method with a return type hands one value back to its caller. The `return` statement supplies
it, and `return` ends the method immediately.

```java
public static int doubled(int value) {
    return value * 2;
    // A statement written here never runs. "The last line never happens"
    // is a symptom of a return above it.
}
```

A method with the return type `void` hands nothing back. It is called for what it does.

```java
public static void announce(String label) {
    System.out.println(label);
}
```

`int x = announce("hi");` does not compile, because there is no value to assign.

### A call may appear wherever a value may appear

A call to a value-returning method **is** a value, once the method finishes.

```java
int total = doubled(21) + 8;                  // inside an expression
System.out.println("Letter: " + letterGrade(95));   // inside a println
if (passing(score)) { ... }                   // inside a condition
String letter = letterGrade(clamp(130));      // inside another call
```

In the last line the inner call runs first. `clamp(130)` produces `100`, and `100` is then what
`letterGrade` receives.

### Arguments, parameters, and what gets passed

A **parameter** is the variable named in the declaration. An **argument** is the value supplied
at the call.

```java
public static int doubled(int value) { ... }   // value is the parameter
int total = doubled(score);                    // score's value is the argument
```

For the types in this lesson, the method receives a **copy** of the value. Changing the
parameter inside the method leaves the caller's variable alone.

### Scope

**Scope** is the region of the program where a name is usable. A variable declared inside a
method exists only inside that method.

```java
public static void main(String[] args) {
    int score = 21;          // score exists in main and nowhere else
    announce("Method markers");
}

public static void announce(String label) {
    // score is not in scope here. Naming it is a compile error:
    // cannot find symbol — symbol: variable score
}
```

A value reaches a method only by being passed as an argument. This is a feature rather than an
obstacle: a method that can only see what it was handed is a method you can test on its own,
which is the whole subject of Lesson 5.2.

### The call stack

When `main` calls `printReport`, and `printReport` calls `lastScore`, Java keeps a record of
who called whom. That record is the **call stack**.

```
lastScore     <- running now
printReport   <- waiting for lastScore to finish
main          <- waiting for printReport to finish
```

Control returns down the stack in the reverse of the order it went up. When `lastScore`
returns, `printReport` continues from the line that called it, and when `printReport` returns,
`main` continues. Lesson 5.2 reads this same stack printed on screen after an error.

### Overloading

Two methods may share one name when their **parameter lists differ**.

```java
public static int addUp(int first, int second) { ... }
public static double addUp(double first, double second) { ... }
```

The compiler chooses by the types of the arguments at the call. `addUp(2, 3)` reaches the first
method and `addUp(2.5, 3.5)` reaches the second. A pair that differed only in return type would
not compile, because the call gives the compiler nothing to choose with.

Key terms introduced in this lesson:

- **Method:** a named block of code that other code can call.
- **Parameter:** the variable named in a method's declaration.
- **Argument:** the value supplied at the call.
- **Scope:** the region of the program where a name is usable.
- **Call stack:** the record of which method called which, and where control returns.
- **Overloading:** two methods sharing one name and differing in their parameter lists.

---

## Worked example

`examples/MethodBasics.java` holds one `void` method, one value-returning method used inside a
larger expression, and one overloaded pair. Every method prints a marker as control enters it
and another as control leaves it, so the printed order shows where the program actually is at
each moment.

```java
// MethodBasics.java
// Markers print as control enters and leaves each call.
// See examples/MethodBasics.java for the full runnable version.

public class MethodBasics {

    public static void announce(String label) {
        System.out.println("enter announce");
        System.out.println("  " + label);
        System.out.println("leave announce");
    }

    public static int doubled(int value) {
        System.out.println("enter doubled(" + value + ")");
        int result = value * 2;
        System.out.println("leave doubled, returning " + result);
        return result;
    }

    public static int addUp(int first, int second) {
        System.out.println("enter addUp(int, int)");
        return first + second;
    }

    public static double addUp(double first, double second) {
        System.out.println("enter addUp(double, double)");
        return first + second;
    }

    public static void main(String[] args) {
        System.out.println("main starts");

        int score = 21;

        announce("Method markers");

        int total = doubled(score) + 8;
        System.out.println("total = " + total);

        System.out.println("addUp(2, 3) = " + addUp(2, 3));
        System.out.println("addUp(2.5, 3.5) = " + addUp(2.5, 3.5));

        System.out.println("main ends");
    }
}
```

**Expected output:**
```
main starts
enter announce
  Method markers
leave announce
enter doubled(21)
leave doubled, returning 42
total = 50
enter addUp(int, int)
addUp(2, 3) = 5
enter addUp(double, double)
addUp(2.5, 3.5) = 6.0
main ends
```

**What to notice:**

- `main starts` prints first and `main ends` prints last. Everything between them happens while
  `main` is still waiting on the call stack.
- The two markers from `doubled` print **before** `total = 50`. The call runs to completion
  first, and its returned value then takes its place inside the expression `doubled(score) + 8`.
- `enter addUp(int, int)` prints before the line that contains the call. The call has to finish
  before the `println` has a full string to print.
- `score` is declared in `main`. `announce` and `doubled` cannot read it by name. `doubled`
  receives a copy of its value under the parameter name `value`.
- The two `addUp` methods share a name. `addUp(2, 3)` chooses the `int` version and
  `addUp(2.5, 3.5)` chooses the `double` version, which is why the printed sum is `5` in one
  line and `6.0` in the next.

---

## Trace before running

**Task:** Predict the printed output of `examples/MethodBasics.java` before you run it.

Write the twelve output lines in order. Then answer the questions.

**Prediction questions — write your answers before running:**

1. Which line prints first, `enter announce` or `main starts`?
2. Does `total = 50` print before or after `leave doubled, returning 42`? State why.
3. Which of `score`, `value`, `result`, `label`, and `total` are in scope on the line
   `int result = value * 2;`?
4. Which `addUp` runs for the call `addUp(2, 3)`, and what decides that?
5. When control is inside `doubled`, what does the call stack hold?

<details>
<summary>Answers — open only after writing your predicted output and your answers</summary>

1. `main starts`. `main` is running before it calls anything.
2. After. `doubled(score)` must finish and hand back `42` before the expression
   `doubled(score) + 8` has a value, and the `println` that reports `total` comes after the
   assignment.
3. `value` and `result` only. `score` and `total` are declared in `main`, and `label` is a
   parameter of `announce`. None of those three is usable inside `doubled`.
4. The `int` version. The compiler chooses by the types of the arguments at the call: `2` and
   `3` are `int` literals.
5. Two frames. `doubled` is running, and `main` is waiting under it for `doubled` to finish.

Full expected output:
```
main starts
enter announce
  Method markers
leave announce
enter doubled(21)
leave doubled, returning 42
total = 50
enter addUp(int, int)
addUp(2, 3) = 5
enter addUp(double, double)
addUp(2.5, 3.5) = 6.0
main ends
```

</details>

---

## Repair code

The following program contains **two errors**. Find them, fix them, and explain each repair.
Do not run the code until you have written your explanations.

The program should print `Larger: 9`.

```java
public class RepairMethods {

    // Should return the larger of its two parameters.
    public static void larger(int a, int b) {   // error 1
        if (a > b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        int first = 4;
        int second = 9;
        System.out.println("Larger: " + larger(first, second));
        System.out.println("The value of a was " + a);   // error 2
    }
}
```

**Errors to find:**

1. The declaration of `larger` disagrees with its body.
2. The last line of `main` names something that is not in scope there.

Write your explanation for each fix before running. **Predict how many compiler messages two
defects produce.** Write the number down before you compile.

<details>
<summary>Corrections — open only after writing your explanations</summary>

`javac` reports **four messages for two defects**:

```
RepairMethods.java:5: error: incompatible types: unexpected return value
            return a;
                   ^
RepairMethods.java:7: error: incompatible types: unexpected return value
        return b;
               ^
RepairMethods.java:13: error: 'void' type not allowed here
        System.out.println("Larger: " + larger(first, second));
                                              ^
RepairMethods.java:14: error: cannot find symbol
        System.out.println("The value of a was " + a);
                                                   ^
  symbol:   variable a
  location: class RepairMethods
4 errors
```

The count is the lesson. One defect can produce several messages, so fix the first one and
recompile rather than trying to satisfy all four at once.

1. **The return type is `void` and the body returns a value.** The first three messages all
   come from that single mismatch: two at the `return` statements, and one at the call, where
   a method that hands nothing back is used inside a string. The repair changes `void` to
   `int` in the declaration.

2. **`a` is a parameter of `larger`, so it is not in scope in `main`.** `main` cannot see it,
   and the compiler says so by name. The repair prints `first` instead, or deletes the line.

Corrected code:
```java
public class RepairMethods {

    public static int larger(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        int first = 4;
        int second = 9;
        System.out.println("Larger: " + larger(first, second));
        System.out.println("The value of first was " + first);
    }
}
```

Expected output:
```
Larger: 9
The value of first was 4
```

</details>

---

## Execute-gate handshake

You are now going to write two methods from scratch. Complete the handshake with your coach
before writing any code.

**Coach provides this task:**

> Write `MyScoreUtils.java`. Declare two `static` methods of your own:
>
> - `letterGrade(int score)` returns `"A"` at 90 and above, `"B"` at 80 and above, `"C"` at 70
>   and above, `"D"` at 60 and above, and `"F"` below 60.
> - `clamp(int score)` returns `0` for a score below 0, `100` for a score above 100, and the
>   score itself otherwise.
>
> Call both from `main` and print the results in the format given in the coding task. One of
> your printed lines must pass the result of one method straight into the other.
>
> Constraints: You may look at `examples/ScoreUtils.java` for the shape of a declaration. You
> may not copy its bodies — write both decisions yourself. You may not use any library method
> that does the comparison for you.

**Player: complete the handshake using this format:**

```
Goal: The program must ______.
Constraints: I may ______. I may not ______.
Prediction: For letterGrade(95) I expect ______. For letterGrade(90) I expect ______.
            For letterGrade(89) I expect ______. For clamp(130) I expect ______.
            For letterGrade(clamp(130)) I expect ______.
Success check: We know it works when ______.
```

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

Write a Java program in a file named `MyScoreUtils.java` that:

1. Declares `public static String letterGrade(int score)`.
2. Declares `public static int clamp(int score)`.
3. Calls both from `main` and prints the seven lines below.
4. Builds the last line by calling `clamp` inside the call to `letterGrade`.

**Required output format:**
```
letterGrade(95) = A
letterGrade(90) = A
letterGrade(89) = B
clamp(130) = 100
clamp(-5) = 0
clamp(75) = 75
letterGrade(clamp(130)) = A
```

**Hint on the chain order.** `letterGrade` is the same shape as the `TicketPrice` chain in
Module 3. Check the highest band first, or every passing score returns `"D"`.

---

## Test evidence

Record all three tiers after running.

| Tier | Call | Expected | Actual | Match? |
|------|------|----------|--------|--------|
| **Normal** | `letterGrade(95)` | `A` | | |
| **Boundary** | `letterGrade(90)` and `letterGrade(89)` | `A` then `B` | | |
| **Failure** | `clamp(130)` and `clamp(-5)` | `100` then `0` | | |

The boundary pair is the one worth your attention. A single test at 95 passes whether the
comparison is `>= 90` or `> 90`. Only the pair at 90 and 89 tells the two versions apart, and
that is the difference between a test that checks and a test that agrees with you.

Lesson 5.2 turns this table into a file the machine runs for you.

---

## Explanation

Answer these questions in writing or out loud to your coach:

1. What does `letterGrade` receive, and what does it hand back?
2. Why can `letterGrade` not read a variable declared in `main`?
3. In `letterGrade(clamp(130))`, which method runs first, and what value does the second one
   receive?
4. What evidence shows that your band edges are placed where the specification says?

---

## Role rotation

Switch roles with your partner. The new coach describes the transfer task below. The new player
restates the goal and completes the handshake before writing any code.

---

## Transfer task

**Changed condition:** The method returns a `boolean`, and the caller uses the returned value
**as a condition** rather than printing it.

**Coach provides this task:**

> Write `PassCheck.java` with one method:
>
> `public static boolean passing(int score)` returns `true` when the score is 60 or above, and
> `false` otherwise.
>
> In `main`, call `passing` inside the condition of an `if` for the scores 95, 60, and 59, and
> print `95 is passing` or `59 is not passing` accordingly.
>
> Constraints: `passing` contains no `System.out.println`. It returns a value and prints
> nothing. Every decision about what to print stays in `main`.
>
> Test with 95, 60, and 59.

**Player: complete the full handshake before writing code.**

<details>
<summary>Expected output (check after running)</summary>

```
95 is passing
60 is passing
59 is not passing
```

Two things stayed the same and one changed. The declaration has the same four parts, and the
band edge at 60 is the same edge you checked in `letterGrade`. What changed is where the
returned value goes: `if (passing(score))` uses it directly, because a `boolean` **is** a
condition. A method call is a value, and it may appear wherever a value of that type may
appear.

The 60 case is the boundary. `score >= 60` returns `true` there and `score > 60` returns
`false`, and the test at 95 cannot tell those two apart.

</details>

---

## Reflection

Answer one of the following:

- `TicketPrice.java` in Module 3 writes the same chain four times. Now that you can write a
  method, describe in two sentences what that program would look like.
- Two defects produced four compiler messages in the Repair beat. What will you do differently
  the next time a screen fills with errors?
- What question do you still have about scope, or about what a method can see?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Name the four parts of a method declaration | ☐ | ☐ | ☐ |
| Write a method that returns a value | ☐ | ☐ | ☐ |
| State what `void` means for a caller | ☐ | ☐ | ☐ |
| Use a call inside a larger expression | ☐ | ☐ | ☐ |
| State which variables are in scope at a given line | ☐ | ☐ | ☐ |
| Read a sequence of calls as a call stack | ☐ | ☐ | ☐ |
| Explain how the compiler chooses between overloaded methods | ☐ | ☐ | ☐ |
| Complete the execute-gate handshake | ☐ | ☐ | ☐ |
| Record normal, boundary, and failure evidence | ☐ | ☐ | ☐ |
| Coach role completed | ☐ | ☐ | ☐ |
| Transfer task (`PassCheck`) completed independently | ☐ | ☐ | ☐ |
