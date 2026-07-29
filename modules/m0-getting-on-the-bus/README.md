# Module 0: Getting on The Bus

**Course:** CSC 151 Java Programming I  
**Position in sequence:** First module (before all coding modules)  
**Estimated time:** 2–3 class sessions  
**Work surface:** Codespace or local VS Code — both work for every task in this module.

---

## What "getting on the bus" means

*Getting on the bus* means committing to the course process: predict before you run, complete the handshake, execute, report evidence, explain the result. The phrase comes from American team sports, where the team bus leaves on schedule and everyone who is travelling is aboard.

You do not need to know anything about sports to take this course. The literal meaning — follow the process every time — is always the operative meaning.

The bus is the process, not the tooling. You may use an AI coding assistant and still be on the bus. You are off the bus when you skip the prediction or cannot explain the result.

---

## What this module covers

- Simplified Technical English (STE-100): active voice, one topic per sentence, consistent terms.
- Markdown: headers, bold, code blocks, lists, checklists, and tables.
- Mermaid: how to read and write a flowchart that diagrams a process.
- Setting up or accessing a Java development environment.
- Writing a `public class` with a `main` method.
- Compiling a `.java` file and running the compiled program.
- Reading and fixing a compile-time error message.
- Your work surfaces: GitHub Codespaces and local VS Code.
- Working with an AI teammate, and what honest use looks like.

---

## Learning goal

After this module, students can:

1. Apply three STE-100 rules to improve a written task description.
2. Format a task card using Markdown.
3. Read and write a Mermaid flowchart that diagrams a multi-step process with at least one decision.
4. Set up or access a Java development environment.
5. Write and run a "Hello, world!" program.
6. Read a compile-time error message and identify the problem.
7. State the four parts of the execute-gate handshake without prompting.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson-1-writing-and-diagrams.md](lesson-1-writing-and-diagrams.md) | STE-100, Markdown, Mermaid, the handshake, and a transfer task |
| [lesson-2-environment-and-first-program.md](lesson-2-environment-and-first-program.md) | Compile-run cycle, error reading, handshake, and a transfer task |
| [examples/HelloWorld.java](examples/HelloWorld.java) | Minimal runnable Java program — the first program students run |

Related course documents:

| Document | Why you need it |
|----------|-----------------|
| [AI Teammate Policy](../../docs/ai-teammate-policy.md) | What assistance is allowed, and what you must disclose |
| [Prompting Your AI Teammate](../../docs/prompting-your-ai-teammate.md) | How to ask for the shortest thing that could work |
| [Student Guide](../../docs/student-guide.md) | How to work through any lesson in this course |

---

## Why this module comes first

Every module in this course uses Markdown files, Mermaid diagrams, and precise written language. Students who understand these tools can read task cards, predict outcomes, and document their work without friction. Students who do not can spend a full session confused by the format rather than the content.

This module also introduces the **handshake** — the structured four-part agreement (goal, constraints, prediction, success check) that opens the execute gate before every coding task. Introducing the handshake in a non-coding context lets students practice the form without the added load of writing Java. Lesson 2 then applies the same handshake to real code.

---

## Instructor facilitation notes

### Before class

1. Open the lesson files on GitHub and confirm the Mermaid diagrams render.
2. Confirm every student has a work surface. Students using GitHub Codespaces need repository access confirmed in advance. Students working locally need the JDK and the VS Code Java extension installed.
3. Run `examples/HelloWorld.java` yourself to confirm it compiles and prints the expected output.
4. Prepare one poorly written task description for the STE warm-up, and one broken program for the error-reading exercise. The worked examples in the lessons can serve both purposes.
5. Review the handshake format. The first time students see it, walk through each of the four parts aloud before asking them to complete one independently.

### Running the handshake for the first time

Students often treat the handshake as a form to fill in rather than a shared confirmation. Watch for:

- A player who copies the coach's wording verbatim. The restatement is not yet in the player's own words.
- A player who gives a vague prediction: "I think it will work." Ask: "What specific output do you predict?"
- A coach who opens the gate before all four parts are confirmed.

Announce explicitly: "The gate opens when I say 'Agreed.' Not before."

### Common STE mistakes

- Passive voice: "the diagram is drawn by the player" → "the player draws the diagram."
- Compound sentences: "write the step and label the decision" → "write the step. Label the decision."
- Synonym drift: using "handshake," "agreement," and "handoff" interchangeably. This course uses **handshake** every time.

### Common environment problems

| Problem | Likely cause | Fix |
|---------|-------------|-----|
| `javac: command not found` | JDK not installed or not on PATH | Install a JDK; add its `bin` folder to PATH |
| `error: class HelloWorld is public, should be in a file named HelloWorld.java` | File name does not match class name | Rename the file to match the class name exactly |
| `error: reached end of file while parsing` | Missing closing `}` | Count opening and closing braces |
| Program compiles but no output appears | `main` method signature is wrong | Check `public static void main(String[] args)` exactly |

### Mermaid facilitation

- Show a broken diagram first (the repair exercise in Lesson 1). Students who see a syntax error and fix it remember the syntax better than students who only see correct examples.
- After students complete their diagrams, ask each pair to swap files and verify that the other pair's diagram renders and matches the plain-text description.

### Accessible facilitation

- Read Mermaid diagrams aloud using the plain-text descriptions. Every diagram in this module has one.
- Allow students to draw a diagram by hand before translating it into Mermaid syntax.
- Accept predictions in any written or spoken form: prose, table, numbered list, or voice recording.
- Allow students to use a Codespace if local installation is not workable.
- When reading error messages aloud, spell out the line number and point to the caret (`^`) in the terminal output.

---

## How this module connects to the next

Module 1 (Variables and Expressions) uses the same handshake format, the same Markdown task cards, and the same `System.out.println` statement students run here. After this module, students enter Module 1 already knowing how to compile, run, and read output. The mechanical skills are no longer new, so the attention in Module 1 can go entirely to Java.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by showing students the Module 1 variable declaration. They already know how to print a value. They are about to learn where that value comes from.
