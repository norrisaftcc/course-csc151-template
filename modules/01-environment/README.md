# Module 01: Environment and First Program

**Course:** CSC 151 Java Programming I  
**Position in sequence:** First module (before all coding modules)  
**Estimated time:** 1–2 class sessions

---

## What this module covers

- Setting up or accessing a Java development environment.
- Writing a `public class` with a `main` method.
- Compiling a `.java` file from the command line or an IDE.
- Running a compiled program and reading its output.
- Reading and fixing a compile-time error message.

---

## Learning goal

After this module, students can:

1. Set up or access a Java development environment.
2. Write and run a "Hello, world!" program.
3. Read a compile-time error message and identify the problem.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with compile-run cycle, error reading, handshake, and transfer task |
| [examples/HelloWorld.java](examples/HelloWorld.java) | Minimal runnable Java program — the first program students run |

---

## Instructor facilitation notes

### Before class

1. Verify that students have access to a Java development environment before the session. If students use a cloud IDE (Replit, GitHub Codespaces, etc.), confirm access in advance.
2. Run `examples/HelloWorld.java` yourself to confirm it compiles and prints the expected output.
3. Prepare one example of a broken program to use for the error-reading exercise. The repair task in the lesson can serve this purpose.

### Common environment problems

| Problem | Likely cause | Fix |
|---------|-------------|-----|
| `javac: command not found` | JDK not installed or not on PATH | Install JDK; add `bin` folder to PATH |
| `error: class HelloWorld is public, should be in a file named HelloWorld.java` | File name does not match class name | Rename the file to match the class name exactly |
| `error: reached end of file while parsing` | Missing closing `}` | Count opening and closing braces |
| Program compiles but no output appears | `main` method signature is wrong | Check `public static void main(String[] args)` exactly |

### Running the execute-gate handshake for the first time

This is most students' first encounter with the handshake. Walk through it slowly:

1. State the goal yourself, then ask the player to restate it in their own words.
2. Require a specific prediction — "it will print my name" — not a vague "it will work."
3. Say "Agreed" explicitly and audibly when all four parts are confirmed.
4. After the program runs, ask for evidence before accepting "it worked."

### Accessible facilitation

- Allow students to use a cloud IDE if local installation is not feasible.
- Accept predictions in written or spoken form.
- When reading error messages aloud, spell out the line number and point to the caret (`^`) in the terminal output.

---

## How this module connects to the next

Module 02 (Variables and Expressions) uses the same `System.out.println` statement students learn here. After this module, students enter Module 02 already knowing how to compile, run, and read output — the mechanical skills are no longer new.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by showing students the Module 02 variable declaration. They already know how to print a value; they are about to learn where that value comes from.
