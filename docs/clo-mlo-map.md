# CLO / MLO Map — CSC 151 Java Programming I

This document maps the **Course Learning Outcomes (CLOs)** to the **Module Learning Outcomes (MLOs)** for CSC 151.

The CLOs are derived directly from the Combined Course Library (CCL) entry for CSC 151:

> *This course introduces computer programming using the JAVA programming language with object-oriented programming principles. Emphasis is placed on event-driven programming methods, including creating and manipulating objects, classes, and using object-oriented tools such as the class debugger. Upon completion students should be able to design, code, test, debug JAVA language programs.*

**Status:** In flux — review and revise as the course develops. Items marked ⚠️ require an instructor decision before the course is finalized.

---

## Course Learning Outcomes (CLOs)

These outcomes are extracted and refined from the CCL description. Each CLO uses active, observable language.

| ID | CLO |
|----|-----|
| CLO-1 | Design a Java program that meets a stated requirement: select appropriate data types, control structures, and class structure. |
| CLO-2 | Code a Java program using primitive types, expressions, control flow, methods, and at least one class. |
| CLO-3 | Apply object-oriented principles: define a class with fields and methods, create objects, and call instance methods. |
| CLO-4 | Apply event-driven programming: **process a user event as a function call.** Register a handler so that a user action executes a defined method, and explain the register-and-dispatch cycle. A console menu selection and a Swing button press are both accepted evidence. |
| CLO-5 | Test a Java program using normal cases, boundary cases, and failure cases; record and interpret the results. |
| CLO-6 | Debug a Java program by reading error messages, isolating the error, applying a fix, and verifying the result. |

> **Calculator analogy:** On a calculator, pressing `=` is the signal "I have finished entering numbers — now execute." That press is an event; the calculation that follows is the handler. CLO-4 asks students to build that connection deliberately: a user action triggers a defined method. This maps directly to the course's handshake model — the `=` press is the user's "Agreed."

---

## Module Learning Outcomes (MLOs) and CLO Mapping

### Module 0 — Getting on The Bus

#### Submodule 0.1 — Writing and Diagrams

*No Java code. Introduces course tools and the handshake format.*

| MLO | CLO |
|-----|-----|
| Apply three STE-100 writing rules (active voice, one topic per sentence, consistent terms) to a task description. | — |
| Format a task card in Markdown using headers, lists, code blocks, and a checklist. | — |
| Read and write a Mermaid flowchart with at least one decision node and a plain-text description. | — |

> This submodule builds the communication skills used in all later modules. It does not map to a CLO directly, but it is a prerequisite for demonstrating any CLO in written form.

#### Submodule 0.2 — Environment and First Program

| MLO | CLO |
|-----|-----|
| Set up or access a Java development environment on a Codespace or a local machine. | CLO-2 |
| Write a class with a `main` method that prints output. | CLO-2 |
| Compile and run a Java program from the command line or IDE. | CLO-2 |
| Read and interpret a compile-time error message. | CLO-6 |
| State the four parts of the execute-gate handshake without prompting. | CLO-1 |
| Describe what honest use of an AI teammate requires. | — |

---

### Module 1 — Variables and Expressions

| MLO | CLO |
|-----|-----|
| Declare a variable of type `int`, `double`, `boolean`, or `String`. | CLO-2 |
| Assign and reassign a value to a variable. | CLO-2 |
| Evaluate an arithmetic expression and predict its result, including integer division. | CLO-1, CLO-2 |
| Identify a type mismatch and describe the fix. | CLO-6 |

---

### Module 2 — Input and Output

| MLO | CLO |
|-----|-----|
| Read user input using `Scanner` for `int`, `double`, and `String` values. | CLO-2 |
| Format output using `System.out.printf`. | CLO-2 |
| Write a program that completes an input → process → output cycle. | CLO-1, CLO-2 |

---

### Module 3 — Conditionals

| MLO | CLO |
|-----|-----|
| Write a correct boolean expression using relational and logical operators. | CLO-2 |
| Write `if`, `if-else`, and `else if` chains to control program flow. | CLO-1, CLO-2 |
| Trace a conditional program and predict which branch executes. | CLO-1 |
| Identify and fix the common error of using `=` instead of `==`. | CLO-6 |

---

### Module 4 — Loops

| MLO | CLO |
|-----|-----|
| Write a `while`, `do-while`, and `for` loop for a given task. | CLO-2 |
| Select the appropriate loop type for a given problem. | CLO-1 |
| Trace a loop iteration-by-iteration and predict the final variable values. | CLO-1 |
| Identify and fix an off-by-one error or an infinite loop. | CLO-6 |

---

### Module 5 — Methods and Testing

*A method is the first unit of Java a student can test on its own. Testing is taught here, where it becomes meaningful, rather than at the end of the course where it would arrive too late to practice.*

#### Submodule 5.1 — Methods

| MLO | CLO |
|-----|-----|
| Write a static method with parameters and a return value. | CLO-2 |
| Call a method and use its return value. | CLO-2 |
| Explain variable scope and the call stack. | CLO-1 |
| Write an overloaded method. | CLO-2 |

#### Submodule 5.2 — Testing and Debugging

| MLO | CLO |
|-----|-----|
| Distinguish between compile-time, runtime, and logic errors. | CLO-6 |
| Read a stack trace and identify the source of a runtime error. | CLO-6 |
| Write a unit test with a normal case, a boundary case, and a failure case. | CLO-5 |
| Run the course verifier and interpret its PASS and FAIL output. | CLO-5 |
| Apply the reproduce–isolate–fix–verify debugging strategy. | CLO-6 |
| Use the class debugger to step through code and inspect variable values. | CLO-6 |

> The CCL specifically lists "using object-oriented tools such as the class debugger." This submodule is the primary home for CLO-6 and for debugger use.

---

### Module 6 — Arrays and Collections

| MLO | CLO |
|-----|-----|
| Declare, initialize, and access elements of an `int` array by index. | CLO-2 |
| Write a `for` loop that traverses an array. | CLO-2 |
| Implement a common array algorithm (find max, find min, sum, count). | CLO-1, CLO-2 |
| Use `ArrayList` to add, access, and remove elements. | CLO-2 |
| Test array methods using normal, one-element, and all-negative input. | CLO-5 |

---

### Module 7 — Classes and Objects

| MLO | CLO |
|-----|-----|
| Write a class with fields, a constructor, and at least two methods. | CLO-3 |
| Create an object using `new` and call its instance methods. | CLO-2, CLO-3 |
| Use access modifiers to control field visibility. | CLO-3 |
| Write a `toString` method and use it in output. | CLO-2, CLO-3 |
| Explain the difference between a class definition and an object instance. | CLO-3 |

---

### Module 8 — Events and Capstone

#### Submodule 8.1 — Event-Driven Programming

*Teaches the register-and-dispatch cycle: a user action produces an event, and the event runs a handler method.*

**How CLO-4 is assessed.** *Resolved in curriculum review — see open question 4.* CLO-4 is satisfied by **processing a user event as a function call.** The assessed skill is the register-and-dispatch cycle, not one graphical toolkit, and **two paths are equally acceptable:**

| Path | The user action | Work surface |
|------|----------------|--------------|
| **Console menu** | The student selects an option from a menu | Codespace or local — both |
| **Swing** | The student presses a `JButton` | Local machine only |

Neither path is the lesser one. A student who completes only the console path has met CLO-4 in full, and no part of the grade is reserved for the graphical version. Students on a local machine may choose Swing, and students in a Codespace are not disadvantaged by choosing the menu.

The handler classes are identical across both paths, because the logic layer does not know what produced the event. That is the point of the outcome, and it is what students explain: `dispatcher.register("add", new AddHandler())` and `button.addActionListener(new AddHandler())` are the same cycle with different triggers.

| MLO | CLO |
|-----|-----|
| Process a user event as a function call: implement a handler interface so that a selected menu option or a pressed button runs a defined method. | CLO-3, CLO-4 |
| Register a handler with a dispatcher, and explain the register-and-dispatch cycle. | CLO-1, CLO-4 |
| Read a value supplied with an event and use it in a calculation. | CLO-2, CLO-4 |
| Display a computed result after an event fires. | CLO-4 |
| Design a calculator-style command set: each operator command updates state; the `=` command triggers the calculation and displays the result. | CLO-1, CLO-3, CLO-4 |
| Separate the event-handling layer from a logic class, and explain why the separation makes the logic testable. | CLO-3, CLO-5 |
| Debug an event handler: identify why a command produces no output or the wrong output. | CLO-6 |
| *Alternative path, local surface only:* wire the same handler classes to Swing `JButton` components using `ActionListener`, changing no logic. | CLO-4 |

#### Submodule 8.2 — Final Project

| MLO | CLO |
|-----|-----|
| Design an original program that uses at least one class, one collection, and one method beyond `main`. | CLO-1, CLO-3 |
| Include at least one registered handler that runs useful code when an event fires. | CLO-4 |
| Code the program to compile and run without unhandled errors. | CLO-2 |
| Complete the execute-gate handshake with the instructor before final submission. | CLO-1 |
| Test the program with at least two cases and record evidence. | CLO-5 |
| Debug at least one error encountered during development, applying the reproduce–isolate–fix–verify strategy. | CLO-6 |
| Explain design decisions in a written or spoken reflection. | CLO-1, CLO-3 |

---

## Coverage matrix

This matrix shows which modules contribute to each CLO. A filled cell means at least one MLO in that module maps to the CLO.

| Module | CLO-1 | CLO-2 | CLO-3 | CLO-4 | CLO-5 | CLO-6 |
|--------|-------|-------|-------|-------|-------|-------|
| 0 — Getting on The Bus | ✓ | ✓ | | | | ✓ |
| 1 — Variables and Expressions | ✓ | ✓ | | | | ✓ |
| 2 — Input and Output | ✓ | ✓ | | | | |
| 3 — Conditionals | ✓ | ✓ | | | | ✓ |
| 4 — Loops | ✓ | ✓ | | | | ✓ |
| 5 — Methods and Testing | ✓ | ✓ | | | ✓ | ✓ |
| 6 — Arrays and Collections | ✓ | ✓ | | | ✓ | |
| 7 — Classes and Objects | | ✓ | ✓ | | | |
| 8 — Events and Capstone | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |

> CLO-4 (event-driven programming) is introduced in submodule 8.1 and assessed again in submodule 8.2's final project. Every other CLO appears in at least two modules.
>
> **Note on CLO-4 coverage.** CLO-4 appears in only one module, which is the thinnest coverage in this matrix. It is deliberate: the register-and-dispatch cycle depends on Module 7's classes, so it cannot move earlier without also moving object-oriented content. Instructors who want a second CLO-4 touchpoint can add a small handler exercise to Module 5.2, where the callback shape is already visible in test fixtures.

---

## Open questions for curriculum review

Before this mapping is submitted for formal approval, resolve the following. Resolved items are kept, struck through, with the decision recorded — a fork needs to see what was decided, not only what is left.

1. **CLO-3 depth:** Does "object-oriented principles" require inheritance and polymorphism, or is encapsulation (fields + methods + constructor) sufficient for CSC 151? Submodule 8.1 can absorb inheritance and interfaces for sections that need the depth.
2. **CLO-5 assessment:** Is there a common assessment rubric for test evidence, or does each instructor set their own standard? See [rubric.md](rubric.md).
3. **Module 0 credit:** Does the institution count submodule 0.1 (writing and tools) as graded work, or as an ungraded prerequisite activity?
4. ~~**CLO-4 without a graphical display.**~~ **Resolved.** CLO-4 is fulfilled by processing a user event as a function call. A console menu selection and a Swing button press are both accepted evidence, and the console path is not the lesser one. Submodule 8.2 therefore carries no local-machine requirement, and every graded task runs in a Codespace.
5. **AI teammate disclosure:** Confirm that the disclosure standard in the [AI Teammate Policy](ai-teammate-policy.md) matches the institution's academic integrity policy.

---

## How to use this document

- **Instructors writing new lessons:** Check the MLO column to confirm the new lesson maps to an existing CLO. If it does not, either add a CLO or note that the lesson is a prerequisite activity.
- **Curriculum review:** Use the coverage matrix to verify that every CLO is addressed in at least two modules (introduction and reinforcement).
- **Accreditation mapping:** Each CLO can be mapped to institution-level general education or program outcomes by adding a column to the coverage matrix.
