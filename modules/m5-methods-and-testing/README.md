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

## Files in this module

| File | Description |
|------|-------------|
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
