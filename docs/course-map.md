# Course Map — CSC 151 Java Programming I

This map shows the topic sequence for a one-semester introductory Java course. The course ships as **nine modules — Module 0 through Module 8 — plus an Appendix.** Some modules contain two submodules. The sequence is adaptable. Adjust the pacing or scope to fit your institution's needs, but keep the module count, because the delivery platform expects it.

---

## Overview

```mermaid
flowchart TD
    M0[Module 0\nGetting on The Bus] --> M1[Module 1\nVariables and Expressions]
    M1 --> M2[Module 2\nInput and Output]
    M2 --> M3[Module 3\nConditionals]
    M3 --> M4[Module 4\nLoops]
    M4 --> M5[Module 5\nMethods and Testing]
    M5 --> M6[Module 6\nArrays and Collections]
    M6 --> M7[Module 7\nClasses and Objects]
    M7 --> M8[Module 8\nEvents and Capstone]
    AP[Appendix\nReference] -.-> M0
    AP -.-> M5
    AP -.-> M8
```

**Plain-text description:** The nine modules run in a single line. Module 0 leads to Module 1, which leads to Module 2, and so on in order through Module 8. The Appendix is not a step in the sequence. It is a reference that students consult from any module; the dotted lines show it being used at the start, in the middle, and at the end of the course.

Each solid arrow represents a dependency. Students should complete earlier modules before later ones.

---

## The spine at a glance

| Module | Title | Submodules | Primary CLOs |
|--------|-------|-----------|--------------|
| 0 | Getting on The Bus | Writing and diagrams · Environment and first program | CLO-1 |
| 1 | Variables and Expressions | — | CLO-2 |
| 2 | Input and Output | — | CLO-2 |
| 3 | Conditionals | — | CLO-1, CLO-2 |
| 4 | Loops | — | CLO-1, CLO-2 |
| 5 | Methods and Testing | Methods · Testing and debugging | CLO-2, CLO-5, CLO-6 |
| 6 | Arrays and Collections | — | CLO-2 |
| 7 | Classes and Objects | — | CLO-3 |
| 8 | Events and Capstone | Event-driven programming · Final project | CLO-3, CLO-4, CLO-5 |
| Appendix | Reference | — | — |

---

## Work surfaces

Students work in **GitHub Codespaces**, in **local VS Code with the Java extension**, or in both. Every graded task in this course runs on either surface.

Graphical (Swing) programs need a display, which a Codespace does not provide. For that reason **every assignment ships a console version as the graded default**, and graphical work is an optional enrichment path for students working locally. Module 8 teaches the event-driven cycle in a form that runs and is verified without a display. See Module 8 below for how CLO-4 is assessed.

Each module README states its work surface. The Appendix carries the full work-surface matrix.

---

## Module descriptions

### Module 0 — Getting on The Bus

**Goal:** Students can use the course's writing and diagram tools, set up a Java development environment, run their first program, and state the four parts of the execute-gate handshake.

Submodule 0.1 — Writing and diagrams:
- Simplified Technical English (STE-100): active voice, one topic per sentence, one term per concept.
- Markdown: headers, bold, code blocks, lists, checklists, tables.
- Mermaid: reading and writing a flowchart with at least one decision.
- The execute-gate handshake, practiced in a non-coding context.

Submodule 0.2 — Environment and first program:
- Accessing a Codespace or setting up local VS Code with the Java extension.
- Writing a `public class` with a `main` method.
- Compiling and running from the command line or the IDE.
- Reading error messages.
- Working with an AI teammate, and what honest use requires.

Suggested time: 2–3 class sessions.

---

### Module 1 — Variables and Expressions

**Goal:** Students can declare variables of primitive types, assign values, and evaluate arithmetic and string expressions.

Topics:
- Primitive types: `int`, `double`, `boolean`, `char`.
- Variable declaration and assignment.
- Arithmetic operators: `+`, `-`, `*`, `/`, `%`.
- Integer division and casting.
- String concatenation.
- `System.out.println` for output.

Sample lesson: [Module 1 in this repository](../modules/m1-variables-expressions/lesson.md).

Suggested time: 2–3 class sessions.

---

### Module 2 — Input and Output

**Goal:** Students can read user input with `Scanner` and format output.

Topics:
- `import java.util.Scanner;`
- `System.in` and `Scanner` methods.
- `System.out.printf` for formatted output.
- Reading `int`, `double`, and `String` values.

Sample lesson: [Module 2 in this repository](../modules/m2-input-output/lesson.md).

Suggested time: 1–2 class sessions.

---

### Module 3 — Conditionals

**Goal:** Students can write `if`, `if-else`, and nested conditional statements to control program flow.

Topics:
- Boolean expressions and relational operators (`<`, `>`, `==`, `!=`, `<=`, `>=`).
- Logical operators: `&&`, `||`, `!`.
- `if`, `if-else`, `else if` chains.
- `switch` statement, introduced as an alternative to long `else if` chains.
- Common mistakes: using `=` instead of `==`.

Suggested time: 2–3 class sessions.

---

### Module 4 — Loops

**Goal:** Students can write `while`, `do-while`, and `for` loops and can choose the appropriate loop for a task.

Topics:
- `while` loop: condition checked before each iteration.
- `do-while` loop: condition checked after each iteration.
- `for` loop: init, condition, update.
- Loop variable tracing.
- `break` and `continue`.
- Nested loops.
- Common mistakes: off-by-one errors, infinite loops.

Suggested time: 3–4 class sessions.

---

### Module 5 — Methods and Testing

**Goal:** Students can write and call methods with parameters and return values, and can test and debug those methods systematically.

A method is the first unit of Java a student can test on its own. Testing is taught here, where it becomes meaningful, rather than at the end of the course where it would arrive too late to practice.

Submodule 5.1 — Methods:
- Defining methods: access modifier, return type, name, parameters.
- Return values and `void`.
- Method calls and argument passing.
- Scope of variables.
- Method overloading.
- Recursive methods, introduced carefully; deep recursion belongs to a later course.

Submodule 5.2 — Testing and debugging:
- Types of errors: compile-time, runtime, logic.
- Reading stack traces.
- Writing unit tests with JUnit 5.
- Normal, boundary, and failure test cases.
- Debugging strategy: reproduce, isolate, fix, verify.
- Running the course verifier: `bash scripts/verify.sh test`.

Suggested time: 4–5 class sessions.

---

### Module 6 — Arrays and Collections

**Goal:** Students can declare, initialize, traverse, and manipulate arrays. Students can use `ArrayList` for a dynamically-sized collection.

Topics:
- Array declaration and initialization.
- Index-based access.
- `for` loop and enhanced `for` loop traversal.
- Common array algorithms: find max, find min, compute sum, count elements.
- Two-dimensional arrays, briefly.
- `java.util.ArrayList`: add, get, size, remove.

Sample lesson: [Module 6 in this repository](../modules/m6-arrays-collections/lesson.md).

Suggested time: 3–4 class sessions.

---

### Module 7 — Classes and Objects

**Goal:** Students can write a class with fields, a constructor, and methods, and can create and use objects.

Topics:
- Fields (instance variables) and access modifiers.
- Constructors.
- Getters and setters.
- The `this` keyword.
- Creating objects with `new`.
- The difference between a class and an object.
- The `toString` method.

Suggested time: 4–5 class sessions.

---

### Module 8 — Events and Capstone

**Goal:** Students can write event-driven code using the register-and-dispatch cycle, and can complete an original program that demonstrates the course skills.

Submodule 8.1 — Event-driven programming:
- The event-dispatch model: user action → event → handler method.
- Implementing a handler interface and registering it with a dispatcher.
- Reading and writing values between the input layer and program logic.
- Separating the interface layer from a logic class.
- Optional enrichment, local surface only: the same handlers wired to Swing `JButton` components with `ActionListener`.

Submodule 8.2 — Final project:
- An original program of the student's own design.
- At least one class, one array or collection, and one method beyond `main`.
- At least one registered handler that runs useful code when an event fires.
- A prediction of the output for at least two test cases.
- The execute-gate handshake with the instructor before final submission.
- A short written or spoken reflection on design decisions.

**How CLO-4 is assessed without a graphical display.** CLO-4 is event-driven programming. The assessed skill is the *register-and-dispatch cycle*, not one graphical toolkit. Students implement a handler interface and register it with a console dispatcher that reads commands from standard input. That cycle has the same shape as `addActionListener`, and it runs and is verified in a Codespace with no display. Students working locally may then wire the same handler classes to Swing buttons, changing no logic — which demonstrates separation of concerns directly. The graphical version is enrichment; the handler cycle is the graded outcome.

Suggested time: 3–4 class sessions for 8.1, then 1–2 weeks for 8.2.

---

### Appendix — Reference

The Appendix is a reference module, not a step in the sequence. Students consult it from any module.

It is **composed from the documents in `docs/`**, which remain the single source of truth. Appendix pages are generated, not written twice, so a definition can never disagree with itself.

Contents:
- Glossary of course terms.
- The ten most common beginner Java errors.
- The assignment rubric.
- The AI teammate policy.
- Prompting your AI teammate.
- The work-surface matrix: what runs in a Codespace, what needs a local machine.
- Command reference for the course verifier.

---

## Adaptation notes

- **Slower pace:** Split each module into two or three shorter meetings. Add more trace-and-predict exercises before the coding task.
- **Faster pace:** Combine Modules 1 and 2, or Modules 3 and 4. Do not skip the execute gate or the transfer task.
- **Online or hybrid delivery:** The coach/player model works in breakout rooms, shared code editors, and asynchronous discussion boards. Adjust the handshake to the medium.
- **Dual enrollment or advanced students:** Expand Module 8.1 to include inheritance, interfaces, or file I/O. Keep Module 8.2 as the integrative capstone.
- **Do not change the module count.** The delivery platform expects Module 0 through Module 8 plus an Appendix. Add depth inside a module rather than adding a tenth module.

---

## Prerequisites

This course assumes students can:

- Use a keyboard and navigate files on a computer.
- Read and follow written instructions.
- Attempt a task and describe what happened.

This course does not assume prior programming experience.
