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
| CLO-4 | Apply event-driven programming: attach an `ActionListener` to a Swing GUI component (button, menu item) so that clicking it executes useful code. |
| CLO-5 | Test a Java program using normal cases, boundary cases, and failure cases; record and interpret the results. |
| CLO-6 | Debug a Java program by reading error messages, isolating the error, applying a fix, and verifying the result. |

> **Calculator analogy:** On a calculator, pressing `=` is the signal "I have finished entering numbers — now execute." That button press is an event; the calculation that follows is the handler. CLO-4 asks students to build that connection deliberately: a user action (click) triggers a defined method. This maps directly to the course's handoff model — the button click is the user's "Agreed."

---

## Module Learning Outcomes (MLOs) and CLO Mapping

### Module 00 — Technical Writing, Markdown, and Mermaid

*Prerequisite module. No Java code. Introduces course tools and the handoff format.*

| MLO | CLO |
|-----|-----|
| Apply three STE-100 writing rules (active voice, one topic per sentence, consistent terms) to a task description. | — |
| Format a task card in Markdown using headers, lists, code blocks, and a checklist. | — |
| Read and write a Mermaid flowchart with at least one decision node and a plain-text description. | — |

> This module builds the communication skills used in all later modules. It does not map to a CLO directly, but it is a prerequisite for demonstrating any CLO in written form.

---

### Module 01 — Environment and First Program

| MLO | CLO |
|-----|-----|
| Set up or access a Java development environment. | CLO-2 |
| Write a class with a `main` method that prints output. | CLO-2 |
| Compile and run a Java program from the command line or IDE. | CLO-2 |
| Read and interpret a compile-time error message. | CLO-6 |

---

### Module 02 — Variables and Expressions

| MLO | CLO |
|-----|-----|
| Declare a variable of type `int`, `double`, `boolean`, or `String`. | CLO-2 |
| Assign and reassign a value to a variable. | CLO-2 |
| Evaluate an arithmetic expression and predict its result, including integer division. | CLO-1, CLO-2 |
| Identify a type mismatch and describe the fix. | CLO-6 |

---

### Module 03 — Input and Output

| MLO | CLO |
|-----|-----|
| Read user input using `Scanner` for `int`, `double`, and `String` values. | CLO-2 |
| Format output using `System.out.printf`. | CLO-2 |
| Write a program that completes an input → process → output cycle. | CLO-1, CLO-2 |

---

### Module 04 — Conditionals

| MLO | CLO |
|-----|-----|
| Write a correct boolean expression using relational and logical operators. | CLO-2 |
| Write `if`, `if-else`, and `else if` chains to control program flow. | CLO-1, CLO-2 |
| Trace a conditional program and predict which branch executes. | CLO-1 |
| Identify and fix the common error of using `=` instead of `==`. | CLO-6 |

---

### Module 05 — Loops

| MLO | CLO |
|-----|-----|
| Write a `while`, `do-while`, and `for` loop for a given task. | CLO-2 |
| Select the appropriate loop type for a given problem. | CLO-1 |
| Trace a loop iteration-by-iteration and predict the final variable values. | CLO-1 |
| Identify and fix an off-by-one error or an infinite loop. | CLO-6 |

---

### Module 06 — Methods

| MLO | CLO |
|-----|-----|
| Write a static method with parameters and a return value. | CLO-2 |
| Call a method and use its return value. | CLO-2 |
| Explain variable scope and the call stack. | CLO-1 |
| Write an overloaded method. | CLO-2 |

---

### Module 07 — Arrays and Collections

| MLO | CLO |
|-----|-----|
| Declare, initialize, and access elements of an `int` array by index. | CLO-2 |
| Write a `for` loop that traverses an array. | CLO-2 |
| Implement a common array algorithm (find max, find min, sum, count). | CLO-1, CLO-2 |
| Use `ArrayList` to add, access, and remove elements. | CLO-2 |
| Test array methods using normal, one-element, and all-negative input. | CLO-5 |

---

### Module 08 — Classes and Objects

| MLO | CLO |
|-----|-----|
| Write a class with fields, a constructor, and at least two methods. | CLO-3 |
| Create an object using `new` and call its instance methods. | CLO-2, CLO-3 |
| Use access modifiers to control field visibility. | CLO-3 |
| Write a `toString` method and use it in output. | CLO-2, CLO-3 |
| Explain the difference between a class definition and an object instance. | CLO-3 |

---

### Module 09 — Testing and Debugging

| MLO | CLO |
|-----|-----|
| Distinguish between compile-time, runtime, and logic errors. | CLO-6 |
| Read a stack trace and identify the source of a runtime error. | CLO-6 |
| Write a unit test with a normal case, a boundary case, and a failure case. | CLO-5 |
| Apply the reproduce–isolate–fix–verify debugging strategy. | CLO-6 |
| Use the class debugger to step through code and inspect variable values. | CLO-6 |

> The CCL specifically lists "using object-oriented tools such as the class debugger." This module is the primary home for CLO-6 and for debugger use.

---

### Module 10 — Final Project

| MLO | CLO |
|-----|-----|
| Design an original program that uses at least one class, one collection, and one method beyond `main`. | CLO-1, CLO-3 |
| Include at least one GUI component (button or menu item) that triggers useful code via an `ActionListener`. | CLO-4 |
| Code the program to compile and run without unhandled errors. | CLO-2 |
| Complete the execute-gate handoff with the instructor before final submission. | CLO-1 |
| Test the program with at least two cases and record evidence. | CLO-5 |
| Debug at least one error encountered during development, applying the reproduce–isolate–fix–verify strategy. | CLO-6 |
| Explain design decisions in a written or oral reflection. | CLO-1, CLO-3 |

---

### Module 11 — GUI and Event-Driven Programming

*Introduces Swing, the `JFrame`/`JDialog` component model, and the `ActionListener` interface.*

| MLO | CLO |
|-----|-----|
| Create a `JFrame` with at least one `JButton` and display it. | CLO-2, CLO-3 |
| Attach an `ActionListener` to a button so that clicking it calls a defined method. | CLO-4 |
| Read a value from a `JTextField` when a button is clicked and use it in a calculation. | CLO-2, CLO-4 |
| Update a `JLabel` or `JTextField` to display a computed result after an event fires. | CLO-4 |
| Design and implement a calculator-style GUI: number/operator buttons each fire an event; the `=` button triggers the calculation and displays the result. | CLO-1, CLO-3, CLO-4 |
| Debug an event handler: identify why a button click produces no output or the wrong output. | CLO-6 |

---

## Coverage matrix

This matrix shows which modules contribute to each CLO. A filled cell means at least one MLO in that module maps to the CLO.

| Module | CLO-1 | CLO-2 | CLO-3 | CLO-4 | CLO-5 | CLO-6 |
|--------|-------|-------|-------|-------|-------|-------|
| 00 — Writing, Markdown, Mermaid | | | | | | |
| 01 — Environment | | ✓ | | | | ✓ |
| 02 — Variables | ✓ | ✓ | | | | ✓ |
| 03 — Input/Output | ✓ | ✓ | | | | |
| 04 — Conditionals | ✓ | ✓ | | | | ✓ |
| 05 — Loops | ✓ | ✓ | | | | ✓ |
| 06 — Methods | ✓ | ✓ | | | | |
| 07 — Arrays | ✓ | ✓ | | | ✓ | |
| 08 — Classes and Objects | | ✓ | ✓ | | | |
| 09 — Testing and Debugging | | | | | ✓ | ✓ |
| 10 — Final Project | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| 11 — GUI and Event-Driven | ✓ | ✓ | ✓ | ✓ | | ✓ |

> CLO-4 (event-driven/GUI) is introduced in Module 11 and assessed in Module 10's final project. Every other CLO appears in at least two modules.

---

## Open questions for curriculum review

Before this mapping is submitted for formal approval, resolve the following:

1. **CLO-3 depth:** Does "object-oriented principles" require inheritance and polymorphism, or is encapsulation (fields + methods + constructor) sufficient for CSC 151? A "Module 11" placeholder is available in the course map for inheritance/interfaces.
2. **CLO-5 assessment:** Is there a common assessment rubric for test evidence, or does each instructor set their own standard? See [rubric.md](rubric.md).
3. **Module 00 credit:** Does the institution count Module 00 (writing and tools) as a graded module, or is it an ungraded prerequisite activity?

---

## How to use this document

- **Instructors writing new lessons:** Check the MLO column to confirm the new lesson maps to an existing CLO. If it does not, either add a CLO or note that the lesson is a prerequisite activity.
- **Curriculum review:** Use the coverage matrix to verify that every CLO is addressed in at least two modules (introduction and reinforcement).
- **Accreditation mapping:** Each CLO can be mapped to institution-level general education or program outcomes by adding a column to the coverage matrix.
