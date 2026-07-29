# Module 4: Loops

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Fifth module (after Conditionals)  
**Estimated time:** 3–4 class sessions  
**Work surface:** Codespace or local VS Code — both work for every task in this module.

---

## What this module covers

- The `while` loop: the condition is tested before the body.
- The `do-while` loop: the condition is tested after the body, so the body always runs once.
- The `for` loop: init, condition, and update written as three parts of one header.
- The accumulator pattern: a running total declared before the loop.
- `break` and `continue`.
- Nested loops, and the grid they print.
- The sentinel-controlled loop, where the number of readings is unknown before the program runs.
- Two failure modes with no error message: the infinite loop and the off-by-one count.

Every example in this module keeps all code inside `main`. Students write their first method
in Module 5.

---

## Learning goal

After this module, students can:

1. Write a `while`, a `do-while`, and a `for` loop, and state which one fits a task.
2. Name the three parts of a `for` header and say when each one runs.
3. Write the accumulator pattern with the total declared before the loop.
4. Trace a loop with a table, one row per pass, and predict the number of passes.
5. Write a sentinel-controlled loop with a priming read, keeping the stop value out of the
   count and the total.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | Read how each of the three loops tests its condition, why an accumulator is declared before the loop, what `break` and `continue` move, and how a sentinel ends a loop whose length is unknown. Worked examples: `CountdownLoops.java` and `SumToN.java`. |
| **Practice** | Run the Play | Trace `SumToN.java` for `n = 5` with an iteration table, predicting the total of 15 and the five body runs. Then predict the count and total `SentinelLoop.java` prints from its four-line fixture. Repair `RepairCounter`, which has two defects: a `while` body that never updates `i`, and a `for` condition that counts one pass too many. |
| **Apply** | Team Practice | Complete the handshake, then write `TimesTable.java`: a nested-loop grid printed with `printf("%4d")`, followed by a sentinel loop that reads values until `0` and reports the count and total. |
| **Assess** | The Big Game | Write `AverageUntilZero.java`, which reports an average from the same sentinel loop and answers an empty run with `No values entered`. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The transfer task keeps the loop and changes what it reports.** The sentinel shape is taught
in the Concept explanation, traced against `SentinelLoop.java` in the Practice beat, and
written with a coach in the second half of the Apply task. The one changed condition is the
division: an average needs a count in the denominator, so an immediate `0` becomes a case the
program must answer instead of compute. The `if` that guards it comes from Module 3.

**This module carries a skill Module 8 depends on.** The capstone dispatcher reads commands
until the user types `quit`. That is the sentinel loop from this module with a word in place of
a number, and it is rehearsed here rather than met for the first time under a grade.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with the three loops, the trace table, the handshake, and the transfer task |
| [examples/CountdownLoops.java](examples/CountdownLoops.java) | Runnable program: the same countdown written three ways, then each loop run again with a condition that is false on entry |
| [examples/SumToN.java](examples/SumToN.java) | Runnable program: the accumulator pattern, printing the running total after every pass |
| [examples/SentinelLoop.java](examples/SentinelLoop.java) | Runnable program: reads values until the sentinel `0`, then reports the count and total |

`SentinelLoop` reads input. It ships a `.stdin` fixture beside it, so
`bash scripts/verify.sh examples` runs it with no keyboard.

---

## Instructor facilitation notes

### Before class

1. Run `bash scripts/verify.sh all` and confirm it passes.
2. Run `examples/CountdownLoops.java` in a visible terminal and stop at its last three lines.
   Those three lines are the whole argument for `do-while`, and the first nine lines are the
   reason students think the three loops are interchangeable.
3. Decide how you will handle the infinite loop in the Practice beat. Show `Ctrl+C` in a
   terminal **before** the exercise starts. A student whose terminal is scrolling and who does
   not know how to stop it learns panic instead of loops.

### Common mistakes

| Mistake | What it looks like | The single diagnostic question |
|---------|-------------------|-------------------------------|
| Missing update in a `while` body | The program never returns to the prompt | "Which statement in the body changes the variable in the condition?" |
| Accumulator declared inside the loop | The total equals the last value added | "How many times is that `int total = 0;` line executed?" |
| Off-by-one in a `for` condition | One item too many or too few | "What is the first value of the counter, and the last one that enters the body?" |
| Counting the sentinel | The count is one too high, the total is right | "Where in the body is the next value read?" |
| No priming read | The first value is skipped, or the condition tests an unset variable | "What does the condition compare on its first look?" |

The third row is worth slowing down on. Students often learn "always use `<`," which is wrong
half the time. `SumToN` uses `<=` correctly because it starts at `1`. The rule is that the
starting value decides the comparison.

### Accessible facilitation

- Trace loops on the board with a table: one column per variable, one row per pass. Update the
  table in front of the class rather than describing the update in words.
- Allow students to trace on paper before typing.
- Do not use colour alone to mark which pass is current. Number the rows and point to the
  number.
- Read a `for` header aloud as three sentences: "Start `i` at 1. Keep going while `i` is at
  most 5. Add one to `i` after each pass."
- Give students who find the grid hard a `size` of 2 before a `size` of 5. Four printed
  numbers are traceable by hand; twenty-five are not.

---

## How this module connects to the next

Module 5 (Methods and Testing) gives the repetition in this module a second home. Students have
now written the same loop shape several times inside `main`, and `TicketPrice.java` in Module 3
writes the same chain out four times. A method is the tool that ends that repetition, and it is
also the first unit of Java a student can test on its own.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by asking how a student would run the sentinel loop twice
> in one program without copying it. They already feel the cost of the copy. They are about to
> learn the name of the answer.
