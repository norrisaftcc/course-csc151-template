# Lesson 5.2: Testing and Debugging

**Module:** 5 — Methods and Testing (submodule 5.2)  
**Estimated time:** 100–120 minutes  
**Prerequisites:** Lesson 5.1. You can write a `static` method with parameters and a return value, and call it from `main`.

---

## Learning goal

After this lesson, you can:

- Tell a compile-time error, a runtime error, and a logic error apart by what each one does.
- Read a stack trace from the bottom up and name the file and line that caused it.
- Name the three evidence tiers: normal, boundary, and failure.
- Read a JUnit test method and name its two imports, its `@Test` annotation, its assertion, and
  what its name claims.
- Write a test method for a method you wrote, in the form
  `method_expectedResult_forCondition`.
- Run `bash scripts/verify.sh test` and read its PASS and FAIL lines.
- Apply reproduce, isolate, fix, verify to a defect you did not write.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Write a `static` method with a parameter list and a return value.
- [ ] Call a method and use its returned value.
- [ ] State which variables are in scope inside a method.
- [ ] Run `bash scripts/verify.sh all` on your work surface.

If you cannot do all four, complete Lesson 5.1 before continuing.

---

## Concept explanation

### Three kinds of error, told apart by what they do

| Kind | When it appears | What you see | Example from this course |
|------|----------------|--------------|--------------------------|
| **Compile-time** | Before the program runs | `javac` prints a file, a line, a caret, and a message | `cannot find symbol`, a missing semicolon |
| **Runtime** | While the program runs | The program stops and prints a stack trace | `ArrayIndexOutOfBoundsException` |
| **Logic** | Never | The program runs, ends normally, and prints a wrong answer | Integer division inside `average` |

The third row is the one that costs the most. A compile-time error tells you where it is. A
runtime error tells you where it stopped. A logic error tells you nothing at all, and the only
thing that finds it is a test whose expected value you decided **before** you ran the code.

### Reading a stack trace

A **stack trace** is the call stack from Lesson 5.1, printed at the moment the program stopped.

Here is a program that fails. It is printed here and is not shipped as a runnable file, because
a program that throws exits with a nonzero status and the course verifier reports that as a
failure.

```java
 1  public class ScoreReport {
 2
 3      public static int lastScore(int[] scores) {
 4          return scores[scores.length];
 5      }
 6
 7      public static void printReport(int[] scores) {
 8          System.out.println("Report for " + scores.length + " scores");
 9          System.out.println("Last score: " + lastScore(scores));
10      }
11
12      public static void main(String[] args) {
13          int[] scores = {80, 90, 100};
14          printReport(scores);
15      }
16  }
```

A real run prints this:

```
Report for 3 scores
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at ScoreReport.lastScore(ScoreReport.java:4)
	at ScoreReport.printReport(ScoreReport.java:9)
	at ScoreReport.main(ScoreReport.java:14)
```

**Read it from the bottom up.** The bottom line is where the program started, and each line
above it is a call the line below made:

- `main` at line 14 called `printReport`.
- `printReport` at line 9 called `lastScore`.
- `lastScore` at line 4 is where the program stopped.

**Name the file and the line before you read the message.** `ScoreReport.java:4` is the line to
open. Only then does the message earn its attention: `Index 3 out of bounds for length 3` says
the array holds 3 elements, whose valid indexes are 0, 1, and 2, and that the code asked for
index 3. Line 4 asks for `scores[scores.length]`, and `scores.length` is 3. The repair is
`scores[scores.length - 1]`.

The first printed line, `Report for 3 scores`, is also evidence. It proves the program reached
line 8 and stopped after it.

### The three evidence tiers

Every test set in this course reports three tiers.

| Tier | What it covers | Example for `clamp` |
|------|---------------|---------------------|
| **Normal** | The ordinary case the method was written for | `clamp(75)` returns `75` |
| **Boundary** | The value at the edge of a range, where off-by-one errors live | `letterGrade(90)` and `letterGrade(89)` |
| **Failure** | Input the method must reject or correct | `clamp(130)` returns `100` |

**A passing test tells you one case works.** It is not proof of correctness. The boundary and
failure tiers exist because the normal tier agrees with you too readily.

### A JUnit test, part by part

`tests/ScoreUtilsTest.java` is the test file for `examples/ScoreUtils.java`. Here is one method
from it, with every part named.

```java
import org.junit.jupiter.api.DisplayName;              // 1
import org.junit.jupiter.api.Test;                     // 1

import static org.junit.jupiter.api.Assertions.assertEquals;   // 2

class ScoreUtilsTest {                                 // 3

    @Test                                              // 4
    @DisplayName("letterGrade returns A at exactly 90")   // 5
    void letterGrade_returnsA_atExactly90() {          // 6
        assertEquals("A", ScoreUtils.letterGrade(90)); // 7
    }
}
```

1. **The two imports that name the annotations.** `Test` marks a method as a test.
   `DisplayName` gives it a sentence to print.
2. **The static import of the assertion.** This is what lets you write `assertEquals` instead
   of `Assertions.assertEquals`.
3. **The test class.** Its name is the class under test plus `Test`. It carries no `public`,
   and it needs none.
4. **`@Test`.** Without it, the runner never calls the method, and a test that never runs
   never fails.
5. **`@DisplayName`.** The sentence printed when the test is reported.
6. **The method name, in three parts: `method_expectedResult_forCondition`.** A test name is
   read at the moment it fails, so it must state the claim.
   `letterGrade_returnsA_atExactly90` tells you what broke. `test3` does not.
7. **The assertion. The expected value comes first.** `assertEquals(expected, actual)`. Written
   the other way round it still passes and still fails, and every failure message then reads
   backwards.

### Reproduce, isolate, fix, verify

| Step | What you do | What it prevents |
|------|-------------|------------------|
| **Reproduce** | Find an input that fails every time | Chasing a defect you cannot make happen |
| **Isolate** | Cut away everything that is not needed to make it fail | Fixing the wrong line and believing you fixed it |
| **Fix** | Change one thing | Two changes, one of which was wrong |
| **Verify** | Run the failing case again, then run the rest | A repair that broke something else |

**Write the failing case down as a test before you fix it.** A test written at that moment is
a test you know can fail, because you just watched it fail.

### Running the tests

Once per machine or Codespace:

```
bash scripts/fetch-junit.sh
```

Then, as often as you like:

```
bash scripts/verify.sh test
```

The verifier compiles the module's `examples/` folder and its `tests/` folder together, then
runs every test it finds. It prints `PASS` or `FAIL` for each test directory, and a count of
tests that succeeded and failed.

Key terms introduced in this lesson:

- **Stack trace:** the call stack printed at the moment a program stopped.
- **Assertion:** a statement in a test that names an expected value and an actual value.
- **Evidence tier:** one of normal, boundary, and failure.
- **Reproduce, isolate, fix, verify:** the four steps of a debugging pass.

---

## Worked example

`tests/ScoreUtilsTest.java` holds all three tiers against the three methods in
`examples/ScoreUtils.java`. Read the file in full, then read the three groups below.

**Normal — the ordinary case:**

```java
@Test
@DisplayName("letterGrade returns A for a score well inside the A band")
void letterGrade_returnsA_forNinetyFive() {
    assertEquals("A", ScoreUtils.letterGrade(95));
}
```

**Boundary — the edge, tested in pairs:**

```java
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
```

**Failure — input the method exists to correct:**

```java
@Test
@DisplayName("clamp lowers a score above the maximum to 100")
void clamp_returns100_forScoreAboveMaximum() {
    assertEquals(100, ScoreUtils.clamp(130));
}
```

**What to notice:**

- Each band edge is tested **twice**: at the edge, and one below it. That pair is what catches
  a `>` written where a `>=` belongs. A single test at 90 passes under both versions.
- The names carry the claim. Read the four names above without reading a single assertion, and
  you have read the specification.
- `average_keepsFraction_forOneAndTwo` asserts `1.5` for `{1, 2}`. That one test is the whole
  reason the `(double)` cast is in `average`, and the Repair beat below removes it.
- Nothing in this file tests `average` with an empty array. That case is the transfer task, and
  a shipped test would answer it for you.

---

## Trace before running

### Part 1 — the stack trace

**Task:** Read the `ScoreReport` program and its stack trace in the Concept explanation. Do not
change anything yet.

**Prediction questions — write your answers before reading the answers:**

1. Which line of the trace do you read first, and why?
2. Which file and line number caused the error?
3. How many method calls were on the stack when the program stopped?
4. `Report for 3 scores` printed before the trace. What does that tell you?
5. What is the repair to line 4?

<details>
<summary>Answers — open only after writing your predictions</summary>

1. The bottom line, `at ScoreReport.main(ScoreReport.java:14)`. It names where the program
   started. Reading upward then follows the calls in the order they were made. The first line
   of a trace is the deepest call, which is often library code you did not write.
2. `ScoreReport.java`, line 4: `return scores[scores.length];`.
3. Three: `main`, `printReport`, and `lastScore`.
4. It proves the program reached line 8 and stopped somewhere after it. Printed output is
   evidence about how far execution got, which is why a print statement is a legitimate
   debugging tool.
5. `return scores[scores.length - 1];`. An array of length 3 has valid indexes 0, 1, and 2.

</details>

### Part 2 — a broken method and the tests that watch it

**Task:** Suppose `average` in `examples/ScoreUtils.java` loses its `(double)` cast, so the
last line reads `return sum / scores.length;`. Three shipped tests call `average`:

| Test | Input | Asserts |
|------|-------|---------|
| `average_returnsMean_forThreeScores` | `{80, 90, 100}` | `90.0` |
| `average_returnsTheValue_forOneElement` | `{42}` | `42.0` |
| `average_keepsFraction_forOneAndTwo` | `{1, 2}` | `1.5` |

**Predict which of the three fail, and write the reason, before you read on.**

<details>
<summary>Answer — open only after writing your prediction</summary>

**One of the three fails.**

| Test | Result without the cast | Why |
|------|------------------------|-----|
| `average_returnsMean_forThreeScores` | Passes | `270 / 3` is `90` in integer division, and `90` widens to `90.0` on return |
| `average_returnsTheValue_forOneElement` | Passes | `42 / 1` is `42` |
| `average_keepsFraction_forOneAndTwo` | **Fails** | `3 / 2` is `1` in integer division, so the method returns `1.0` where `1.5` is expected |

Two of the three tests pass against a broken method. That is the point of the boundary tier:
the normal case agreed with a defect, and only the input with a fraction in the answer told the
truth. A student who wrote three normal-case tests would have shipped this.

</details>

---

## Repair code

This beat holds **two defects**, in two different files. Neither is shipped in the repository;
both are printed here. Find each one, decide what the repair is, and explain each in one
sentence before you change anything.

### Defect 1 — a method that compiles, runs, and lies

```java
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
    return sum / scores.length;     // defect 1
}
```

It returns `90.0` for `{80, 90, 100}` and `1.0` for `{1, 2}`.

**Your task:** name the defect, name the tier of test that catches it, and state the repair.

### Defect 2 — a test that disagrees with itself

```java
@Test
@DisplayName("letterGrade returns A at exactly 90")
void letterGrade_returnsA_atExactly90() {
    assertEquals("B", ScoreUtils.letterGrade(90));   // defect 2
}
```

This test **fails** against the correct `ScoreUtils`.

**Your task:** exactly one of the two — the name or the assertion — states what the course
specification says. Decide which one is wrong, and say how you decided.

<details>
<summary>Corrections — open only after writing your explanations</summary>

**Defect 1: integer division.** `sum` is an `int` and `scores.length` is an `int`, so `/`
discards the remainder before the result is widened to a `double`. The repair restores the
cast: `return (double) sum / scores.length;`. The tier that catches it is the **boundary**
tier — specifically an input whose true answer carries a fraction, such as `{1, 2}`. Two
normal-case inputs pass against the broken version, which is why the tier matters more than
the count of tests.

**Defect 2: the assertion is wrong, not the name.** The specification in
`examples/ScoreUtils.java` states that `letterGrade` returns `"A"` at 90 and above, so 90 is an
A. The repair is `assertEquals("A", ScoreUtils.letterGrade(90));`.

How you decide is the part worth writing down: **you go to the specification, not to the
code.** Reading `ScoreUtils.letterGrade` and copying whatever it does would make every test
agree with every defect. Renaming the test to `letterGrade_returnsB_atExactly90` would also
turn the run green, and it would delete the only test of the A edge in the file. A test that
was changed to match the code has stopped being evidence.

**A test can be wrong.** That is the second thing this beat is for. When a test fails, one of
two things is wrong, and finding out which is your judgment rather than the runner's.

</details>

---

## Execute-gate handshake

You are now going to write tests for the methods you wrote in Lesson 5.1. Complete the
handshake with your coach before writing any code.

**Coach provides this task:**

> Put your `MyScoreUtils.java` from Lesson 5.1 in `modules/m5-methods-and-testing/examples/`.
> Then write `MyScoreUtilsTest.java` in `modules/m5-methods-and-testing/tests/`, holding
> exactly three test methods:
>
> - one **normal** test of `letterGrade`,
> - one **boundary** test of `letterGrade` at a band edge,
> - one **failure** test of `clamp` with a score outside 0 to 100.
>
> Name every test `method_expectedResult_forCondition`. Run `bash scripts/fetch-junit.sh` once,
> then `bash scripts/verify.sh test`.
>
> Constraints: You may copy the two imports and the static import from `tests/ScoreUtilsTest.java`.
> You may not copy an assertion from it. Write the expected value in each assertion from the
> specification, before you run anything.

**Player: complete the handshake using this format:**

```
Goal: The program must ______.
Constraints: I may ______. I may not ______.
Prediction: I expect ______ of my 3 tests to pass on the first run.
            If one fails, I expect the failing one to be ______, because ______.
Success check: We know it works when ______.
```

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

Write `MyScoreUtilsTest.java` in `modules/m5-methods-and-testing/tests/`.

Requirements:

1. Import `org.junit.jupiter.api.Test` and statically import
   `org.junit.jupiter.api.Assertions.assertEquals`.
2. Declare `class MyScoreUtilsTest {`.
3. Write three test methods, each marked `@Test`, one per tier.
4. Name each one in the form `method_expectedResult_forCondition`.
5. Run the tests and read the PASS and FAIL lines aloud to your coach.

Both files go in the module folders named above. `bash scripts/verify.sh test` compiles a
module's `examples/` and `tests/` folders together, which is why the method under test and the
test that calls it both live inside `modules/m5-methods-and-testing/`.

**Then break your own method on purpose.** Change one band edge in `letterGrade` from `>=` to
`>`, run the tests again, and read which test fails. Change it back. A test you have never
seen fail is a test you have not finished checking.

---

## Test evidence

Record all three tiers after running.

| Tier | Test name you wrote | Expected | Actual | Match? |
|------|--------------------|----------|--------|--------|
| **Normal** | ______ | ______ | | |
| **Boundary** | ______ | ______ | | |
| **Failure** | ______ | ______ | | |

Then record the deliberate break:

| What you changed | Which test failed | What the failure message said |
|------------------|-------------------|-------------------------------|
| `>= 90` to `> 90` in `letterGrade` | ______ | ______ |

---

## Explanation

Answer these questions in writing or out loud to your coach:

1. What does each of your three tests claim, stated without reading its assertion?
2. Why does a single test at 95 fail to check the A edge?
3. When you broke `letterGrade` on purpose, which test failed and which stayed green? What
   does the green one tell you about the value of a passing test?
4. A test fails. Name the two things that could be wrong, and say how you would decide which.

---

## Role rotation

Switch roles with your partner. The new coach describes the transfer task below. The new player
restates the goal and completes the handshake before writing any code.

---

## Transfer task

**Changed condition:** The method under test is **not one you wrote**, and one of its inputs
falls outside the contract its documentation states.

**Coach provides this task:**

> Write a three-tier evidence set for `ScoreUtils.average` in
> `examples/ScoreUtils.java` — a method you did not write. Read its Javadoc before you read its
> body.
>
> - **Normal:** one test of a typical several-element array.
> - **Boundary:** one test of an input whose true average carries a fraction.
> - **Failure:** `average(new int[0])`. Run it and record what it returns. **Do not write an
>   assertion for this case yet.**
>
> Then write **one sentence** deciding whether the method or its documented contract is at
> fault, and say what you would change.
>
> Constraints: Write the two tests in your own test file. Do not edit `ScoreUtils.java` and do
> not edit `ScoreUtilsTest.java`. Observe the empty-array result by calling
> `ScoreUtils.average(new int[0])` from a `main` and printing it, which is a Lesson 5.1 skill.

**Player: complete the full handshake before writing code.**

<details>
<summary>What a real run shows, and what the sentence has to decide</summary>

`ScoreUtils.average(new int[0])` prints:

```
NaN
```

It throws nothing. The loop over an empty array runs zero passes, so `sum` stays `0`, and
`(double) 0 / 0` in `double` arithmetic produces `NaN` — "not a number" — rather than an error.
The program continues, and any later arithmetic on that value produces `NaN` too.

**Why no assertion is written for it yet.** A test asserts what the contract says. The Javadoc
on `average` reads *"@param scores an int array with at least one element."* The empty array is
outside the stated contract, so there is no agreed right answer to assert. Writing
`assertEquals(0.0, ...)` would invent a contract; writing an assertion that matches `NaN` would
freeze current behaviour as if it had been decided on purpose. Decide first, then assert.

**Either sentence below is a complete answer, and they lead to different repairs:**

- *"The contract is at fault: the method behaves reasonably for the inputs it promises to
  accept, so the empty case should be stated in the Javadoc and given a defined answer."*
- *"The method is at fault: it returns a value that looks like a number and is not, so it
  should reject an empty array instead of computing with it."*

What is **not** acceptable is a sentence that says the empty array "works" because nothing
crashed. `NaN` is a wrong answer that travels quietly, which is the definition of a logic
error from the first table in this lesson.

Nothing in this task is new. You wrote `@Test` methods in the Apply beat, you read a Javadoc
contract in the Concept explanation, and you decided between a wrong method and a wrong test in
the Repair beat. The one changed condition is that the method belongs to someone else.

</details>

---

## Reflection

Answer one of the following:

- Two of the three `average` tests passed against a broken method. What does that change about
  how you will read a green test run?
- Which of the four debugging steps — reproduce, isolate, fix, verify — do you skip when you
  are in a hurry, and what has that cost you?
- What question do you still have about JUnit, or about deciding whether a test or a method is
  wrong?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Tell a compile-time, runtime, and logic error apart | ☐ | ☐ | ☐ |
| Read a stack trace from the bottom up | ☐ | ☐ | ☐ |
| Name the file and line that caused a runtime error | ☐ | ☐ | ☐ |
| Name the three evidence tiers | ☐ | ☐ | ☐ |
| Name the parts of a JUnit test method | ☐ | ☐ | ☐ |
| Name a test `method_expectedResult_forCondition` | ☐ | ☐ | ☐ |
| Write the expected value from the specification, not from the code | ☐ | ☐ | ☐ |
| Run `bash scripts/verify.sh test` and read its output | ☐ | ☐ | ☐ |
| Decide whether a failing test or the method is wrong | ☐ | ☐ | ☐ |
| Apply reproduce, isolate, fix, verify | ☐ | ☐ | ☐ |
| Complete the execute-gate handshake | ☐ | ☐ | ☐ |
| Coach role completed | ☐ | ☐ | ☐ |
| Transfer task (`average` evidence set) completed independently | ☐ | ☐ | ☐ |
