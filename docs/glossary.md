# Glossary — CSC 151 Java Programming I

This glossary defines terms used throughout the course. Terms are listed alphabetically. Find a term quickly using your browser's search (Ctrl+F or Cmd+F).

---

## A

### Apply (Team Practice)

The third beat of the [LPAA cycle](course-map.md#the-lpaa-cycle). The player completes the execute-gate handshake and writes code with a coach present. Apply is not graded. Its lesson sections are the handshake, the small coding task, the test evidence, and the explanation.

**Team practice** is the course's name for this beat. Literal meaning: do the whole thing with your coach beside you, still not for a score.

See also: **LPAA cycle**, **execute gate**.

### Assess (The Big Game)

The fourth beat of the [LPAA cycle](course-map.md#the-lpaa-cycle). The player transfers the skill to a task they have not seen before, and it counts toward the grade. Its lesson sections are role rotation, the transfer task, the reflection, and the mastery record.

**The Big Game** is the course's name for this beat. Literal meaning: the work that counts toward your grade. The phrase comes from American team sports; you do not need to know anything about sports to take this course.

Nothing appears in an Assess beat that has not already appeared in a Learn, a Practice, and an Apply beat. See **no-new-plays rule**.

See also: **LPAA cycle**, **transfer**.

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

## L

### Learn (Study the Play)

The first beat of the [LPAA cycle](course-map.md#the-lpaa-cycle). The player reads the concept and walks through a worked example. Nothing is at stake. Its lesson sections are the learning goal, the prior knowledge check, the concept explanation, and the worked example.

**Study the play** is the course's name for this beat. Literal meaning: read and understand the one play you are about to run, before you run it. A play is a single planned movement, written down so a team can read it before rehearsing it. The play you study in this beat is the play you rehearse in the next one.

See also: **LPAA cycle**.

### LPAA cycle

The four beats every module runs, in order: **Learn**, **Practice**, **Apply**, **Assess**. Each beat has a second name used with students: Study the Play, Run the Play, Team Practice, and The Big Game. Both names are correct, and neither replaces the other.

Only the fourth beat is graded. The first three exist so that the fourth is never the first time a student meets a skill. See **no-new-plays rule**.

The full cycle, including the mapping from beats to lesson sections, is in the [Course Map](course-map.md#the-lpaa-cycle).

---

## M

### Method

A named block of code that performs a task and can be called by name. Methods have a return type, a name, and a parameter list. Example: `public int add(int a, int b)`.

---

## N

### No-new-plays rule

The design constraint the [LPAA cycle](course-map.md#the-lpaa-cycle) exists to keep:

> "We would never make you use a play in The Big Game that you haven't run during practice until you understood it."

**Literal meaning:** nothing is graded that has not first been taught, rehearsed alone, and then practiced with a coach.

The rule is checkable. For every skill assessed in an Assess beat, an earlier Learn beat taught it, a Practice beat rehearsed it, and an Apply beat ran it with a coach — in the same module or an earlier one. A skill that first appears in an Assess beat is a defect in the course, and the repair is the author's work: add the missing beats, or move the assessment later.

A student who meets an unfamiliar skill in a graded task has found a bug and should report it.

See also: **LPAA cycle**, **transfer**.

---

## P

### Player

The person who restates the task, predicts the result, writes or modifies code, executes, reports evidence, and explains the result. Students rotate into the player role regularly.

See also: **coach**, **execute gate**, **role rotation**.

### Practice (Run the Play)

The second beat of the [LPAA cycle](course-map.md#the-lpaa-cycle). The player rehearses one movement alone: tracing a program on paper, or repairing a broken one. Answers are available, and a wrong prediction costs nothing. Its lesson sections are "trace before running" and "repair or modify code".

**Run the play** is the course's name for this beat. Literal meaning: rehearse that same play by itself, slowly, with nothing at stake.

Practice is where the prediction is cheap to get wrong, which is why the prediction habit is built here rather than at the gate.

See also: **LPAA cycle**, **prediction**, **trace**.

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
