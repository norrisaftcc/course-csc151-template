# Module 5: Methods and Testing

**Course:** CSC 151 Java Programming I  
**Position in sequence:** After Module 4 (Loops), before Module 6 (Arrays and Collections)  
**Estimated time:** 4–5 class sessions  
**Work surface:** Codespace or local VS Code — both work for every task in this module.

---

## What this module covers

**Submodule 5.1 — Methods**

- Defining methods: access modifier, return type, name, parameters.
- Return values and `void`.
- Method calls and argument passing.
- Scope of variables.
- Method overloading.
- Recursive methods, introduced briefly.

**Submodule 5.2 — Testing and Debugging**

- Types of errors: compile-time, runtime, logic.
- Reading stack traces.
- Writing unit tests with JUnit 5.
- Normal, boundary, and failure test cases.
- The reproduce–isolate–fix–verify debugging strategy.
- Running the course verifier.

---

## Why testing sits here

A method is the first unit of Java a student can test on its own. Before methods, there is
nothing to call except `main`, and a test of `main` is not a unit test.

Testing taught at the end of a course arrives too late to practice. Testing taught here gets
used in every module that follows, and the capstone in Module 8 can assume students already
read a stack trace without help.

---

## Learning goal

After this module, students can:

1. Write a static method with parameters and a return value.
2. Call a method and use its return value.
3. Explain variable scope and the call stack.
4. Write a unit test with a normal case, a boundary case, and a failure case.
5. Read a stack trace and name the line that caused the error.
6. Apply reproduce–isolate–fix–verify to a defect they did not write.
7. Run the course verifier and interpret its PASS and FAIL output.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | **5.1:** read the four parts of a method declaration, `return` against `void`, scope, the call stack, and overloading, with `MethodBasics.java` as the worked example. **5.2:** read what tells a compile-time, runtime, and logic error apart, how a stack trace is read from the bottom up, the three evidence tiers, and every part of a JUnit test method as `ScoreUtilsTest.java` is taken apart one method at a time. |
| **Practice** | Run the Play | **5.1:** predict the printed order of `MethodBasics.java` as control enters and leaves each call, and name which variables are in scope at each line. Repair `RepairMethods`, whose two defects produce four compiler messages. **5.2:** read a real stack trace and name the file and line that caused it, then predict which of the three shipped `average` tests fail once the `(double)` cast is removed. Repair two defects: `average` without its cast, and a test whose name claims `letterGrade_returnsA_atExactly90` while its assertion expects `"B"`. |
| **Apply** | Team Practice | **5.1:** complete the handshake, then write `MyScoreUtils.java` with `letterGrade` and `clamp` written from scratch. **5.2:** complete the handshake, then write one test per tier against those methods with a coach present, run `bash scripts/fetch-junit.sh` once and `bash scripts/verify.sh test`, and read the PASS and FAIL lines aloud. |
| **Assess** | The Big Game | **5.1:** write `PassCheck.java`, whose method returns a `boolean` the caller uses as a condition. **5.2:** write a three-tier evidence set for `ScoreUtils.average`, a method the student did not write, including `average(new int[0])`, and decide in one sentence whether the method or its documented contract is at fault. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The Assess beat here needs a skill that is worth naming explicitly:** reading a failing test's
output and deciding whether the test or the method is wrong. That judgment is rehearsed in the
Practice beat of Lesson 5.2, on the deliberately broken `average` method and on the test whose
name and assertion disagree, before it is graded.

**Writing a JUnit test method from scratch is met four times.** It is taught in the Learn beat
of Lesson 5.2, half-written in that lesson's Practice repair, coached in its Apply beat, and
only then graded. The transfer task changes one condition: the method under test belongs to
someone else, and one of its inputs falls outside the contract its Javadoc states.

**The empty-array case is recorded rather than asserted.** `average(new int[0])` returns `NaN`
today, and the method's Javadoc promises nothing about an empty array. Students observe the
result, then decide whether the method or the contract is at fault. Writing an assertion before
that decision would freeze current behaviour as if someone had chosen it.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson-1-methods.md](lesson-1-methods.md) | Submodule 5.1: declarations, `return` and `void`, scope, the call stack, overloading, handshake, and transfer task |
| [lesson-2-testing-and-debugging.md](lesson-2-testing-and-debugging.md) | Submodule 5.2: the three error kinds, reading a stack trace, the evidence tiers, JUnit part by part, handshake, and transfer task |
| [examples/MethodBasics.java](examples/MethodBasics.java) | Runnable program: a `void` method, a value-returning method used inside an expression, and an overloaded pair, with markers printed as control enters and leaves each call |
| [examples/ScoreUtils.java](examples/ScoreUtils.java) | Three static methods used first as method practice, then as the code under test |
| [examples/ScoreUtils.expected](examples/ScoreUtils.expected) | The exact output `ScoreUtils` prints, checked by the verifier |
| [tests/ScoreUtilsTest.java](tests/ScoreUtilsTest.java) | JUnit tests showing all three evidence tiers |

---

## Running the tests

Once per machine or Codespace:

```
bash scripts/fetch-junit.sh
```

Then, as often as you like:

```
bash scripts/verify.sh test
```

A Codespace installs the runner automatically when it is created.

---

## Instructor facilitation notes

### Before class

1. Run `bash scripts/verify.sh all` and confirm it passes.
2. Confirm every student can run `bash scripts/verify.sh test` before the 5.2 session. A
   student debugging their test runner instead of their code learns nothing about testing.
3. Prepare one defect for the debugging exercise. Breaking `ScoreUtils.average` by removing
   the `(double)` cast is a good choice: the method still compiles, still runs, and returns a
   confidently wrong answer. That is what a logic error feels like.

### Common mistakes

| Mistake | What it looks like | The single diagnostic question |
|---------|-------------------|-------------------------------|
| Integer division inside a method | `average` returns `1.0` for 1 and 2 | "What type is `sum`, and what type is `scores.length`?" |
| Checking bands upward | Every passing score returns "D" | "Which `if` runs first for a score of 95?" |
| Testing only the happy path | Three tests, all with typical values | "What is the smallest input that should still work?" |
| Off-by-one at a boundary | 90 returns "B" instead of "A" | "Is 90 an A? Which comparison decides that?" |
| Treating a passing test as proof | "The test passed, so it works" | "What input would make it fail?" |

The last one is the important one. A passing test tells you one case works. Students
routinely read it as proof of correctness, and the whole point of the boundary and failure
tiers is to show that it is not.

### Naming tests

A test name is read at the moment it fails, so it must state the claim. Require the pattern
`method_expectedResult_forCondition`. `letterGrade_returnsA_atExactly90` tells you what broke.
`test3` does not. This is the same rule as the STE lesson in Module 0: name the thing, once,
clearly.

### Accessible facilitation

- Read stack traces aloud from the bottom up, naming the file and line number before the
  message. The most useful line is rarely the first one.
- Allow students to describe a defect in prose before writing a test for it.
- Do not time the debugging exercise. Reproduce–isolate–fix–verify is a habit, and rushing it
  teaches guessing instead.

---

## How this module connects to the next

Module 6 (Arrays and Collections) introduces array algorithms whose failure modes are exactly
the boundary cases students just practiced: the one-element array, the all-negative array, the
empty array. Students arrive already able to write a test for each.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by asking what a `findMax` method should do with a
> one-element array. Students already know how to test that question. They are about to learn
> how to answer it.
