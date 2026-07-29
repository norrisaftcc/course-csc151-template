# Lesson 0.2: Environment and First Program

**Module:** 0 — Getting on The Bus (submodule 0.2)  
**Estimated time:** 50–75 minutes  
**Prerequisites:** None. This is the first lesson.

---

## Learning goal

After this lesson, you can:

- Set up or access a Java development environment.
- Write a class with a `main` method that prints output.
- Compile and run a Java program from the command line or an IDE.
- Read and describe a compile-time error message.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Open a terminal (command prompt) on your computer, or open a cloud-based coding environment.
- [ ] Navigate to a folder using `cd` commands or a file manager.

If you cannot do both of these, ask your coach before continuing.

---

## Concept explanation

### What is Java?

**Java** is a programming language. You write instructions in Java, and the computer follows them.

A Java program is stored in a plain-text file with the extension `.java`. Before the computer can run the program, the file must be **compiled** — translated into a form the computer understands.

### The Java development environment

To write and run Java, you need:

1. A **Java Development Kit (JDK)** — includes the compiler (`javac`) and the runtime (`java`).
2. A **text editor or IDE** — where you write your code. Common choices:
   - **IntelliJ IDEA** (recommended for this course)
   - **VS Code** with the Java extension
   - **BlueJ** (beginner-friendly)
   - Any plain-text editor (Notepad++, gedit) combined with a terminal

### The compile-run cycle

Every Java program goes through two steps before you see output:

```
Source file (.java)  →  javac  →  Bytecode (.class)  →  java  →  Output
```

**Step 1 — Compile:** The compiler reads your `.java` file and checks for errors. If the code is correct, it produces a `.class` file.

**Step 2 — Run:** The Java runtime executes the `.class` file and you see the output.

If there is a compile error, you must fix it before you can run the program.

### The minimum Java program

Every Java program needs at least one **class** and one **main method**. The `main` method is where execution starts.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

Key terms:

- **`public class HelloWorld`** — declares a class named `HelloWorld`. The file must be named `HelloWorld.java`.
- **`public static void main(String[] args)`** — the entry point. The JVM calls this method first.
- **`System.out.println(...)`** — prints one line of text to the console.

### Reading a compile-time error

When the compiler finds a problem, it prints an error message. Example:

```
HelloWorld.java:3: error: ';' expected
        System.out.println("Hello, world!")
                                           ^
1 error
```

The message tells you:
- **File name:** `HelloWorld.java`
- **Line number:** `3`
- **Problem:** a semicolon is missing
- **Location:** the `^` points to the character after the problem

Read the first error first. Fix it. Recompile. Repeat until there are no errors.

---

## Worked example

The following program prints two lines of output.

```java
// HelloWorld.java
// Prints a greeting and confirms the environment is ready.

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("The environment is ready.");
    }
}
```

**Expected output:**
```
Hello, world!
The environment is ready.
```

**What to notice:**
- The class name (`HelloWorld`) matches the file name (`HelloWorld.java`). They must match exactly, including uppercase letters.
- Each `System.out.println` statement ends with a semicolon.
- Each `System.out.println` prints one line and moves to the next line automatically.

---

## Trace before running

**Task:** Read the following code. Do not run it yet. Answer the questions, then check your answers.

```java
public class Greeting {
    public static void main(String[] args) {
        System.out.println("Step 1");
        System.out.println("Step 2");
        System.out.println("Step 3");
    }
}
```

**Prediction questions:**

1. How many lines of output does this program print?
2. What is the second line of output?
3. What would happen if the semicolon after `"Step 2"` were removed?

Write your answers before continuing.

<details>
<summary>Answers (open after recording your predictions)</summary>

1. Three lines.
2. `Step 2`
3. The program would not compile. The compiler would report a syntax error on that line. You would not see any output until you fix the error.

</details>

---

## Repair code

The following code contains one syntax error.

```java
public class Broken {
    public static void main(String[] args) {
        System.out.println("Line one")
        System.out.println("Line two");
    }
}
```

**Task:** Find the error. Fix it. Explain your repair in one sentence.

Do not run the code until you have written your explanation.

<details>
<summary>Answer (open after writing your explanation)</summary>

The semicolon is missing at the end of the first `println` statement. Add `;` after `"Line one")` to fix it.

</details>

---

## Execute-gate handshake

Before writing your own code, complete the handshake with your coach.

**Coach provides:**

> Write a Java program named `MyName` that prints your first name on the first line and your last name on the second line. The program must compile and produce exactly two lines of output.

**Player must confirm:**

- Goal: "The program must print my first name on line one and my last name on line two."
- Constraints: "I may use `System.out.println`. I may not print both names on one line."
- Prediction: "I expect the output to be my first name on line one and my last name on line two."
- Success check: "We know it works when the program compiles, runs, and prints exactly two lines matching my name."

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

**Task:** Write a Java program named `MyName` that:

1. Prints your first name on the first line.
2. Prints your last name on the second line.

Requirements:
- The class name must be `MyName`.
- The file must be named `MyName.java`.
- The program must compile without errors.
- The program must print exactly two lines.

Test cases to pass:
- (Substitute your actual name)
- First line → your first name
- Second line → your last name

---

## Test evidence

After running your code, record the following:

| Test | Expected output | Actual output | Pass? |
|------|----------------|---------------|-------|
| First line | your first name | | |
| Second line | your last name | | |
| Compiles | no errors | | |

---

## Explanation

Answer the following in writing or out loud to your coach:

1. What did the program print when it ran?
2. Why does the class name have to match the file name?
3. What evidence shows the program is correct?
4. What mistake would cause a compile error in this program?

---

## Role rotation

Switch roles with your partner. The new coach describes the next task. The new player restates the plan and completes the handshake.

---

## Transfer task

**Changed condition:** Instead of printing your name, print three lines: your city, your state or province, and your country.

**Task:** Write a program named `MyLocation` that prints three lines describing where you are from. Complete the full handshake with your coach before writing any code.

---

## Reflection

Answer one of the following:

- What is the difference between a compile error and a runtime error? What does each one mean for the person reading it?
- Why does Java require the class name to match the file name?
- What was the most confusing part of setting up the environment? What did you do to resolve it?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Set up or access a Java development environment | | | |
| Write a `public class` with a `main` method | | | |
| Compile a `.java` file without errors | | | |
| Run a compiled program and read the output | | | |
| Read a compile-time error message and identify the problem | | | |
| Fix a syntax error and recompile | | | |
| Complete the execute-gate handshake | | | |
| Coach role completed | | | |
| Transfer task completed independently | | | |
