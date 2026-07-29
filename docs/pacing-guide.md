# Pacing Guide — CSC 151 Java Programming I

This guide provides two calendar templates: a **16-week semester** and an **8-week accelerated term**. Each calendar maps modules to weeks and suggests assessments. Adapt the pacing to your institution's schedule and student population.

The module sequence follows the [Course Map](course-map.md). Module 00 (Writing and Tools) is a prerequisite orientation; it is listed in week 1 of each calendar but is not graded as a Java module.

---

## 16-week semester

### Overview

| Weeks | Module | Key skills | Suggested assessment |
|-------|--------|-----------|---------------------|
| 1 | 00 — Writing and Tools | STE rules, Markdown, Mermaid, handoff | Ungraded orientation activity |
| 1–2 | 01 — Environment | Setup, HelloWorld, compile/run, error reading | Lab 01 (environment check) |
| 2–3 | 02 — Variables and Expressions | Types, arithmetic, integer division | Assignment 01, Lab 02 |
| 3–4 | 03 — Input and Output | Scanner, printf | Lab 03, small in-class exercise |
| 4–6 | 04 — Conditionals | if/else, boolean expressions, switch | Assignment 02, Lab 04 |
| 6–8 | 05 — Loops | while, do-while, for, tracing | Assignment 03, Lab 05 |
| 9–10 | 06 — Methods | Parameters, return values, scope | Assignment 04, Lab 06 |
| 11–12 | 07 — Arrays | Declaration, traversal, algorithms | Assignment 05, Lab 07 |
| 13–14 | 08 — Classes and Objects | Fields, constructor, getters/setters | Assignment 06, Lab 08 |
| 14–15 | 09 — Testing and Debugging | Stack traces, JUnit, reproduce–fix–verify | Lab 09 (debugging exercise) |
| 11–15 | 11 — GUI and Event-Driven | Swing, ActionListener, calculator pattern | Assignment 07 (mini-GUI) |
| 15–16 | 10 — Final Project | Design, implement, test, present | Final project + reflection |

*Module 11 (GUI) can be introduced in parallel with Module 08 or 09, or taught as a block in weeks 11–14, depending on your scheduling preference.*

---

### Week-by-week detail

#### Week 1

- **Session 1:** Module 00. Introduce the course, the handoff model, and the Markdown/Mermaid tools.
- **Session 2:** Module 01. Set up the Java environment. Compile and run `HelloWorld.java`. Practice reading an error message.
- **Assessment:** None graded. Confirm every student can compile and run a Java program before week 2.

#### Week 2

- **Session 3:** Module 01 continued. Fix a broken program. Practice the execute-gate handshake for the first time with code.
- **Session 4:** Module 02 begins. Declare `int` and `double` variables. Predict arithmetic output.
- **Assessment:** Lab 01 due (environment confirmation).

#### Week 3

- **Session 5:** Module 02 continued. Integer division, casting, `String` concatenation.
- **Session 6:** Module 03 begins. `import Scanner`. Read one `int` from the user.
- **Assessment:** Assignment 01 due (variables and arithmetic).

#### Week 4

- **Session 7:** Module 03 continued. `nextLine`, `printf`, the input → process → output pattern.
- **Session 8:** Module 04 begins. Boolean expressions. `if` and `if-else`.
- **Assessment:** Lab 03 due (Scanner exercise).

#### Weeks 5–6

- Module 04 continued: `else if` chains, `switch`, common Boolean mistakes.
- **Assessment:** Assignment 02 due (conditionals).

#### Weeks 6–8

- Module 05: `while`, `do-while`, `for`. Tracing loops by hand. Off-by-one and infinite-loop fixes.
- **Assessment:** Assignment 03 due (loops). Lab 05.

#### Weeks 9–10

- Module 06: static methods, parameters, return values, scope, overloading. Brief introduction to recursion.
- **Assessment:** Assignment 04 due (methods).

#### Weeks 11–12

- Module 07: array declaration, traversal, common algorithms (max, min, sum). `ArrayList`.
- **Assessment:** Assignment 05 due (arrays).

#### Weeks 13–14

- Module 08: class design, fields, constructors, getters/setters, `this`, `toString`.
- Module 11 parallel start: `JFrame`, `JButton`, lambda `ActionListener`.
- **Assessment:** Assignment 06 due (classes).

#### Week 15

- Module 09: error types, stack traces, JUnit basics, reproduce–isolate–fix–verify.
- Module 11 continued: reading `JTextField` values, updating `JLabel`, calculator pattern.
- **Assessment:** Lab 09 (debugging exercise). Assignment 07 (mini-GUI with one button and one calculation) due.

#### Week 16

- Module 10: Final project presentations and demonstrations.
- Execute-gate handshake with instructor required before presentation.
- **Assessment:** Final project and reflection due.

---

## 8-week accelerated term

### Overview

| Week | Modules covered | Key skills | Suggested assessment |
|------|----------------|-----------|---------------------|
| 1 | 00, 01, 02 | Tools, setup, variables | Lab 01, Assignment 01 |
| 2 | 03, 04 | Input/Output, conditionals | Lab 02, Assignment 02 |
| 3 | 04 (finish), 05 | Loops | Assignment 03 |
| 4 | 06 | Methods | Assignment 04 |
| 5 | 07 | Arrays | Assignment 05 |
| 6 | 08 | Classes and Objects | Assignment 06 |
| 7 | 09, 11 | Testing, debugging, GUI intro | Lab 07, Assignment 07 |
| 8 | 10 | Final project | Final project + reflection |

### Notes for accelerated delivery

- **Module 00** should be completed asynchronously before the first class session if possible, or during the first half of week 1.
- **Do not skip the execute-gate handshake.** Shortening the handshake is acceptable; removing it is not. Students who skip the handshake consistently produce code they cannot explain.
- **Combine Modules 01 and 02** if students have prior programming experience. The compile/run cycle can be a brief 20-minute review.
- **Do not combine Modules 04 and 05.** Conditionals and loops are both high-misconception topics. Students need time to trace each one independently before using them together.
- **Module 11 (GUI)** can be reduced to the calculator pattern only (weeks 7–8) in an accelerated term. The core CLO (CLO-4) is satisfied by attaching one `ActionListener` to one button.

---

## Assessment types

| Type | Typical frequency | Purpose |
|------|------------------|---------|
| **Lab** | Once per module | In-class practice with the coach/player model |
| **Assignment** | Once per module | Individual application and transfer |
| **Final project** | Once, week 15–16 / week 8 | Integrative, original program |

### Suggested grading weight

| Category | Suggested weight |
|----------|-----------------|
| Labs (participation and completion) | 20% |
| Assignments | 40% |
| Final project | 30% |
| Reflection and handshake quality | 10% |

Adjust these weights to match your institution's grading policy. The reflection and handshake quality category rewards students who complete the execute-gate handshake carefully, record specific predictions, and explain their results with evidence.

---

## Adaptation notes

- **Slow pace:** Split each module across two additional class sessions. Add one more trace-and-predict exercise before the coding task.
- **Dual enrollment:** Expand Module 11 to include inheritance and interfaces in weeks 13–14. Use the final project to require at least one interface implementation.
- **Online or hybrid:** The coach/player model works in breakout rooms and shared online editors. Assign partner pairs at the start of the course and rotate every two modules.
- **Lab-heavy institutions:** Replace each assignment with a graded lab. Add two extra lab steps (one trace, one transfer variation) to maintain rigor.
