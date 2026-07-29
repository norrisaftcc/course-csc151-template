# Pacing Guide — CSC 151 Java Programming I

This guide provides two calendar templates: a **16-week semester** and an **8-week accelerated term**. Each calendar maps modules to weeks and suggests assessments. Adapt the pacing to your institution's schedule and student population.

The module sequence follows the [Course Map](course-map.md). Submodule 0.1 (writing and tools) is a prerequisite orientation; it is listed in week 1 of each calendar but is not graded as a Java module.

---

## 16-week semester

### Overview

| Weeks | Module | Key skills | Suggested assessment |
|-------|--------|-----------|---------------------|
| 1 | 0.1 — Writing and Diagrams | STE rules, Markdown, Mermaid, handshake | Ungraded orientation activity |
| 1–2 | 0.2 — Environment and First Program | Setup, HelloWorld, compile/run, error reading, AI teammate policy | Lab 01 (environment check) |
| 2–3 | 1 — Variables and Expressions | Types, arithmetic, integer division | Assignment 01, Lab 02 |
| 3–4 | 2 — Input and Output | Scanner, printf | Lab 03, small in-class exercise |
| 4–6 | 3 — Conditionals | if/else, boolean expressions, switch | Assignment 02, Lab 04 |
| 6–8 | 4 — Loops | while, do-while, for, tracing | Assignment 03, Lab 05 |
| 9–11 | 5 — Methods and Testing | Parameters, return values, scope; stack traces, JUnit, reproduce–isolate–fix–verify | Assignment 04, Lab 06 (debugging exercise) |
| 12 | 6 — Arrays and Collections | Declaration, traversal, algorithms, `ArrayList` | Assignment 05, Lab 07 |
| 13–14 | 7 — Classes and Objects | Fields, constructor, getters/setters | Assignment 06, Lab 08 |
| 15 | 8.1 — Event-Driven Programming | Handler interface, register-and-dispatch, calculator command set | Assignment 07 (event handler) |
| 15–16 | 8.2 — Final Project | Design, implement, test, present | Final project + reflection |

*Testing sits with methods in Module 5 because a method is the first unit a student can test on its own. Moving it later leaves too little time to practice the skill before the capstone depends on it.*

---

### Week-by-week detail

#### Week 1

- **Session 1:** Submodule 0.1. Introduce the course, the handshake model, and the Markdown/Mermaid tools.
- **Session 2:** Submodule 0.2. Set up the Java environment. Compile and run `HelloWorld.java`. Practice reading an error message.
- **Assessment:** None graded. Confirm every student can compile and run a Java program before week 2.

#### Week 2

- **Session 3:** Submodule 0.2 continued. Fix a broken program. Practice the execute-gate handshake for the first time with code.
- **Session 4:** Module 1 begins. Declare `int` and `double` variables. Predict arithmetic output.
- **Assessment:** Lab 01 due (environment confirmation).

#### Week 3

- **Session 5:** Module 1 continued. Integer division, casting, `String` concatenation.
- **Session 6:** Module 2 begins. `import Scanner`. Read one `int` from the user.
- **Assessment:** Assignment 01 due (variables and arithmetic).

#### Week 4

- **Session 7:** Module 2 continued. `nextLine`, `printf`, the input → process → output pattern.
- **Session 8:** Module 3 begins. Boolean expressions. `if` and `if-else`.
- **Assessment:** Lab 03 due (Scanner exercise).

#### Weeks 5–6

- Module 3 continued: `else if` chains, `switch`, common Boolean mistakes.
- **Assessment:** Assignment 02 due (conditionals).

#### Weeks 6–8

- Module 4: `while`, `do-while`, `for`. Tracing loops by hand. Off-by-one and infinite-loop fixes.
- **Assessment:** Assignment 03 due (loops). Lab 05.

#### Weeks 9–10

- Submodule 5.1: static methods, parameters, return values, scope, overloading. Brief introduction to recursion.
- **Assessment:** Assignment 04 due (methods).

#### Week 11

- Submodule 5.2: error types, stack traces, JUnit basics, reproduce–isolate–fix–verify. Run `bash scripts/verify.sh test` against the methods written in weeks 9–10.
- **Assessment:** Lab 06 due (debugging exercise).

#### Week 12

- Module 6: array declaration, traversal, common algorithms (max, min, sum). `ArrayList`.
- **Assessment:** Assignment 05 due (arrays).

#### Weeks 13–14

- Module 7: class design, fields, constructors, getters/setters, `this`, `toString`.
- **Assessment:** Assignment 06 due (classes).

#### Week 15

- Submodule 8.1: the handler interface, registering a handler with the dispatcher, the calculator command set, separating the handler layer from the logic class.
- Optional for students working locally: wire the same handlers to Swing buttons.
- **Assessment:** Assignment 07 due (one registered handler and one calculation). Final project proposal due; project work begins.

#### Week 16

- Submodule 8.2: final project presentations and demonstrations.
- Execute-gate handshake with instructor required before presentation.
- **Assessment:** Final project and reflection due.

---

## 8-week accelerated term

### Overview

| Week | Modules covered | Key skills | Suggested assessment |
|------|----------------|-----------|---------------------|
| 1 | 0, 1 | Tools, setup, variables | Lab 01, Assignment 01 |
| 2 | 2, 3 | Input/Output, conditionals | Lab 02, Assignment 02 |
| 3 | 3 (finish), 4 | Loops | Assignment 03 |
| 4 | 5 | Methods, testing, debugging | Assignment 04, Lab 04 |
| 5 | 6 | Arrays and collections | Assignment 05 |
| 6 | 7 | Classes and objects | Assignment 06 |
| 7 | 8.1 | Event-driven programming | Assignment 07 |
| 8 | 8.2 | Final project | Final project + reflection |

### Notes for accelerated delivery

- **Submodule 0.1** should be completed asynchronously before the first class session if possible, or during the first half of week 1.
- **Do not skip the execute-gate handshake.** Shortening the handshake is acceptable; removing it is not. Students who skip the handshake consistently produce code they cannot explain.
- **Combine submodule 0.2 and Module 1** if students have prior programming experience. The compile/run cycle can be a brief 20-minute review.
- **Do not combine Modules 3 and 4.** Conditionals and loops are both high-misconception topics. Students need time to trace each one independently before using them together.
- **Do not drop submodule 5.2.** In an accelerated term the temptation is to cut testing. CLO-5 and CLO-6 both depend on it, and the capstone assumes students can already read a stack trace. Reduce the JUnit content instead: one normal case, one boundary case, one failure case is enough.
- **Submodule 8.1** can be reduced to the calculator command set only. CLO-4 is satisfied by registering one handler that runs one calculation. The Swing version stays optional.

---

## Assessment types

| Type | Typical frequency | Purpose |
|------|------------------|---------|
| **Lab** | Once per module | In-class practice with the coach/player model |
| **Assignment** | Once per module | Individual application and transfer |
| **Final project** | Once, week 15–16 or week 8 | Integrative, original program |

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
- **Dual enrollment:** Expand submodule 8.1 to include inheritance and interfaces. Use the final project to require at least one interface implementation.
- **Online or hybrid:** The coach/player model works in breakout rooms and shared online editors. Assign partner pairs at the start of the course and rotate every two modules.
- **Lab-heavy institutions:** Replace each assignment with a graded lab. Add two extra lab steps (one trace, one transfer variation) to maintain rigor.
