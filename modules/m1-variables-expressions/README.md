# Module 1: Variables and Expressions

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Second module (after environment setup)  
**Estimated time:** 2–3 class sessions

---

## What this module covers

- Declaring variables of types `int`, `double`, `boolean`, and `String`.
- Assigning and reassigning values.
- Writing arithmetic expressions.
- Understanding integer division and casting.
- Using `System.out.println` to display output.

---

## Learning goal

After this module, students can:

1. Declare a variable of a given primitive type and assign it a value.
2. Write and evaluate an arithmetic expression involving two or more variables.
3. Predict the output of a short program involving variable assignment and printing.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Plays | Read how `int`, `double`, `boolean`, and `String` are declared and assigned, and how an expression is evaluated. |
| **Practice** | Run the Play | Trace `ExpressionTrace.java` on paper, including the integer division. Repair `RepairMe.java`, which has two errors. |
| **Apply** | Team Practice | Complete the handshake, then write `PayCalculator.java` with a coach present. |
| **Assess** | The Big Game | Write the same calculation for three different values and a changed output format. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The transfer task changes the data and the format, not the skill.** Every operation it needs
was declared in the Learn beat, traced in the Practice beat, and written once in the Apply
beat.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with handshake, trace, task, and transfer |
| [examples/VariablesDemo.java](examples/VariablesDemo.java) | Runnable demo of variable declaration and arithmetic |
| [examples/ExpressionTrace.java](examples/ExpressionTrace.java) | Practice trace program |

---

## Instructor facilitation notes

### Before class

1. Compile and run both Java files to confirm they work on your system.
2. Review the execute-gate handshake in the lesson. Adapt the coach prompts to your style.
3. Prepare a blank prediction worksheet if your students prefer paper.

### Suggested handshake prompt for the main coding task

> Declare an `int` variable named `score` with value 85, a `double` variable named `bonus` with value 1.5, and compute the result of `score * bonus`. Print the result. Predict the output before running.

Students often predict `127` (expecting integer multiplication) rather than `127.5`. This is the core misconception this module addresses.

### Common mistakes to watch for

- Declaring a variable twice: `int x = 1; int x = 2;` — Java does not allow this.
- Integer division: `7 / 2` evaluates to `3`, not `3.5`.
- Type mismatch: assigning a `double` value to an `int` variable without a cast.

### Accessible facilitation

- When tracing on a whiteboard, say the variable name and value aloud as you write.
- Allow students to record predictions in text, table, or spoken form.
- The `ExpressionTrace.java` file contains only output statements — students who have difficulty writing code can focus on tracing and predicting first.

---

## How this module connects to the next

This module ends with expressions and arithmetic. Module 2 (if following the course map) covers input with `Scanner`. After Module 2, students can build programs that take input, compute a result, and display it — a complete input/process/output cycle. Design the transfer task so students see that the variable they computed here will soon come from a user rather than a literal value.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by pointing toward user input, which students will learn next.
