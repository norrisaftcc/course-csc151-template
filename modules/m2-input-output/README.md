# Module 2: Input and Output

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Third module (after Variables and Expressions)  
**Estimated time:** 2–3 class sessions

---

## What this module covers

- Reading user input using `Scanner` for `int`, `double`, and `String`.
- The `import` statement and Java packages.
- `System.out.printf` format specifiers for aligned, decimal-controlled output.
- The input → process → output program pattern.

---

## Learning goal

After this module, students can:

1. Import `java.util.Scanner` and create a `Scanner` object.
2. Read `int`, `double`, and `String` values from the user at run time.
3. Format output using `System.out.printf` with appropriate format specifiers.
4. Write a complete program that reads input, computes a result, and prints formatted output.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | Read how `Scanner` reads a value, and how `printf` format specifiers control output. |
| **Practice** | Run the Play | Trace `TipCalculator` against given input before running it. Repair `Broken.java`, which has two errors. |
| **Apply** | Team Practice | Complete the handshake, then write `AreaCalc` with a coach present. |
| **Assess** | The Big Game | Extend the program to print both area and perimeter, formatted to a stated number of decimal places. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The transfer task adds a second computed value and no new syntax.** Reading input, computing,
and formatting were each rehearsed before it.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with Scanner, printf, input/process/output pattern, handshake, and transfer task |
| [examples/ScannerDemo.java](examples/ScannerDemo.java) | Reads name, score, and bonus; prints a formatted summary |
| [examples/FormattedOutput.java](examples/FormattedOutput.java) | Demonstrates printf column alignment with a receipt table |

---

## Instructor facilitation notes

### Before class

1. Compile and run both Java files to confirm they work on your system.
2. Plan how to demonstrate live input: run `ScannerDemo` in a visible terminal so students see the prompt/input/output cycle.
3. If students use a cloud IDE, confirm it supports standard input. Some online environments require a specific "stdin" panel.

### Common mistakes to watch for

- Forgetting `import java.util.Scanner;` — produces `cannot find symbol: class Scanner`.
- Using `nextLine()` after `nextInt()` or `nextDouble()` without consuming the leftover newline — the next `nextLine()` call returns an empty string. Teach students to add an extra `input.nextLine()` call after numeric reads if a line read follows.
- Using `%f` without a precision — defaults to six decimal places, which is rarely desired. Encourage `%.2f` as the standard choice.
- Using `print` instead of `println` for a prompt — fine for a prompt, but students who use `println` for prompts lose the inline appearance.

### The nextLine-after-nextInt problem

When a student reads an `int` with `nextInt()` and then tries to read a full line with `nextLine()`, the line read returns empty. This is because `nextInt()` consumes the number but not the newline character at the end of the line. The following `nextLine()` immediately consumes that newline.

Fix: add `input.nextLine();` after the `nextInt()` call to consume the leftover newline before the intended `nextLine()` read.

```java
int score = input.nextInt();
input.nextLine();           // consume the leftover newline
String comment = input.nextLine();  // now reads the full next line
```

Introduce this pattern only when students encounter the symptom. Do not front-load it.

### Accessible facilitation

- Show the Scanner interaction in a visible terminal window or shared screen.
- Allow students to predict the output by writing it on paper before they run the program.
- When demonstrating `printf`, run `FormattedOutput.java` and point to the alignment before explaining the specifiers.

---

## How this module connects to the next

Module 3 (Conditionals) will read user input and then branch based on its value. After this module, students know how to get a value from the user; Module 3 teaches them what to do with it depending on what it is.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by showing a one-line `if` that checks the value the user just entered. Students see the connection before they learn the full syntax.
