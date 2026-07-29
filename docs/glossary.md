# Glossary — CSC 151 Java Programming I

This glossary defines terms used throughout the course. Terms are listed alphabetically. Find a term quickly using your browser's search (Ctrl+F or Cmd+F).

---

## C

### Coach

The person who states the goal, guards the execute gate, asks questions, and requests evidence. In this course, both instructors and students take turns in the coach role. The coach does not write the solution for the player; the coach helps the player reach it through questions and targeted hints.

See also: **player**, **execute gate**, **role rotation**.

### Compile

To translate Java source code (`.java` files) into bytecode (`.class` files) that the Java Virtual Machine (JVM) can run. Compile-time errors are errors the compiler detects before the program runs. Example: a missing semicolon causes a compile error.

### Condition

An expression that evaluates to either `true` or `false`. Conditions control `if` statements and loops. Example: `x > 0` is a condition.

### Constraint

A rule that limits what the player may change or assume in a task. Constraints are stated during the execute-gate handshake. Example: "You may not sort the array."

---

## D

### Debug

To find and fix errors in a program. Debugging is a systematic process: reproduce the error, isolate its location, fix it, and verify the fix.

---

## E

### Evidence

Observable, specific output that supports a conclusion about whether a program works. Evidence includes console output, test results, and comparisons of expected versus actual values. "It looks right" is not evidence. "The output is `10` and my prediction was `10`" is evidence.

### Execute

To run a compiled Java program. Execution begins after the execute-gate handshake is complete.

### Execute gate

The agreement between the coach and the player that must be completed before the player runs or submits code. The gate has four parts: goal, constraints, prediction, and success check. The gate opens when the coach confirms all four parts. Also called the **handshake**.

See also: **snap the ball**, **prediction**, **success check**.

### Explanation

A statement from the player that describes what happened when the code ran, why it happened, and what evidence supports it. An explanation answers: What changed? Why does it work? What evidence do I have? What would cause failure?

---

## G

### Gate

See **execute gate**.

### Goal (learning goal)

A specific, observable statement of what a student will be able to do after a lesson. A good learning goal describes visible behavior: "The student can trace a `for` loop and report the final value of the loop variable." A weak goal uses vague language: "The student understands loops."

---

## H

### Handoff

The moment when the coach and player switch roles. Handoffs are explicit and practiced. The new coach describes the next task and defines the success check before the new player begins.

**Do not use "handoff" for the agreement before execution.** That agreement is the **handshake**. A handshake opens the gate; a handoff switches the roles. Keeping the two terms separate is an application of the STE rule taught in Module 0: one term for one concept.

### Handshake

The four-part agreement — goal, constraints, prediction, success check — that the coach and player confirm before the player runs or submits code. The coach opens the gate with the word "Agreed." See **execute gate**.

Compare **handoff**, which is the role switch that happens after a task is complete.

---

## M

### Method

A named block of code that performs a task and can be called by name. Methods have a return type, a name, and a parameter list. Example: `public int add(int a, int b)`.

---

## P

### Player

The person who restates the task, predicts the result, writes or modifies code, executes, reports evidence, and explains the result. Students rotate into the player role regularly.

See also: **coach**, **execute gate**, **role rotation**.

### Prediction

The player's statement of expected output, variable values, number of iterations, or method return value *before* any code runs. The prediction must be recorded before the execute gate opens. If the prediction does not match the result, the player explains the difference — this is where learning happens.

---

## R

### Role rotation

The deliberate practice of switching coach and player roles after a successful task. Role rotation ensures that every student practices both performing and evaluating.

---

## S

### Snap the ball

Shorthand for completing the execute-gate handshake and beginning execution. The phrase comes from American football, where the snap starts a play. In this course it means: the handshake is complete and the player may now execute. The shorthand is optional; the handshake is not.

Literal meaning: *complete the four-part execute-gate handshake (goal, constraints, prediction, success check), receive the coach's agreement, and begin running or writing code.*

### Success check

The agreed standard for knowing that the program works. The success check is stated during the execute-gate handshake and must be specific. Example: "The method returns `5` for the array `[1, 5, 3]`, returns `−1` for `[−1]`, and returns `3` for `[3, 1, 2]`."

---

## T

### Transfer

A task that applies the lesson's concept to a new situation: different data, a different structure, or a new edge case. Transfer shows whether the student learned the concept or only copied the example. Transfer is the last step of every lesson.

### Trace

To follow a program's execution step by step on paper or in your head, recording the value of each variable at each step. Tracing before running is a core skill in this course.

---

## V

### Variable

A named storage location for a value in a Java program. Variables have a type (such as `int`, `double`, or `String`) and a name. Example: `int count = 0;`
