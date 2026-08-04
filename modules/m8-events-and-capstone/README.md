# Module 8: Events and Capstone

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Ninth and last module (after Classes and Objects)  
**Estimated time:** 3–4 class sessions for 8.1, then 1–2 weeks for 8.2  
**Work surface:** Codespace or local VS Code — both work for every task in this module, including every graded one.

---

## What this module covers

**Submodule 8.1 — Event-driven programming**

- An event: a user action that runs a method written in advance.
- The register-and-dispatch cycle, and why its two halves happen at different times.
- `interface` and `implements`: an interface names a method and supplies no body.
- A dispatcher built from two parallel `ArrayList` values, looked up with `.equals`.
- Separating the handler layer from a logic class that never learns what triggered it.
- The Swing path, local surface only: the same handler classes reached by a button press.

**Addendum 8a — Swing track**

- Optional local practice that adapts a `JButton` press to the existing handler interface.
- Black structure, gold emphasis, and grayscale surfaces for local examples.
- No new graded requirement. Students without a local display use the console path.

**Submodule 8.2 — Final project**

- The six project requirements, and the module that taught each one.
- Scoping a program you can finish.
- The proposal form and the instructor handshake.
- Building the smallest running version first.
- Evidence in three tiers, predicted in advance.
- A reflection on design decisions.

---

## Learning goal

After this module, students can:

1. State what an event is and name the two halves of the register-and-dispatch cycle.
2. Write a class that `implements` an interface and supplies the method it names.
3. Register a handler under a command word and dispatch a typed word to it.
4. Explain why the logic class needs no change when the trigger changes.
5. Design, propose, build, test, and explain an original program that meets six stated
   requirements.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | **8.1:** read what an event is, the register-and-dispatch cycle with the calculator analogy, and what `interface` and `implements` supply. Worked examples: `HandlerIntro.java`, then `EventDemo.java` walked through part by part, with a flowchart of the dispatch path and its plain-text description. The Swing wiring appears as a fenced block marked local surface only. **8.2:** read the six requirements, the scoping rule, and the proposal form, with a worked `RoomDesk` proposal and skeleton. |
| **Practice** | Run the Play | **8.1:** trace `EventDemo.java` against its nine-line fixture — `add 5`, `add 7.5`, `equals`, `subtract 2.5`, `equals`, `clear`, `equals`, `multiply`, `quit` — predicting each printed line and the engine total after each command. Repair `RepairDispatcher`, whose two defects are a handler registered under `"Add"` and dispatched as `"add"`, and a lookup written with `==` instead of `.equals`. **8.2:** predict the output of the `RoomDesk` skeleton, then repair a classmate's version where registration sits after the loop and the `quit` test sits after the dispatch. |
| **Apply** | Team Practice | **8.1:** complete the handshake, then write `Kiosk.java`: a `CommandHandler` interface, a dispatcher, a balance engine, and two handlers of your own, driven by a sentinel loop that ends on `quit`. Run `bash scripts/verify.sh test` and read `CommandDispatcherTest` against your own dispatcher. **8.2:** complete the handshake with your instructor from the proposal form, then build the smallest running version of your project with a coach beside you. |
| **Assess** | The Big Game | **8.1:** register a `multiply` command with a handler class the lesson never wrote, and show that the dispatcher and every existing handler stay untouched. **8.2:** the capstone — an original program with at least one class, one collection, one method beyond `main`, one registered handler, a prediction for at least two cases, the instructor handshake, and a reflection on design decisions. |

The **8a addendum** is optional local practice. It follows the same four beats inside
[its lesson](lesson-3-swing-track-addendum.md), but it does not create a new graded path.

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The 8.1 transfer task changes one condition: the dispatcher meets a word it has never seen.**
Writing a handler class, registering it, and reading the value an event carries are all taught
in the Learn beat, traced against `EventDemo` in the Practice beat, and written with a coach in
the Apply beat. What the assessment adds is the claim about what did **not** change, which is
checkable by reading four types that the student did not touch.

**The 8.2 capstone requires nothing that is new here.** Each of its six requirements names a
skill from an earlier module, listed with its source in a table inside the lesson. The one
changed condition is that the student writes the specification.

**Where the earlier modules carry this one:**

| This module needs | Taught, traced, and coached in |
|-------------------|-------------------------------|
| Comparing command words with `.equals` | Module 3 |
| A sentinel loop that ends on `quit` | Module 4 |
| `ArrayList` — `add`, `get`, `size`, and the enhanced `for` | Module 6 |
| Classes, `private` fields, constructors with `this`, `toString` | Module 7 |
| Reading a stack trace, and evidence in three tiers | Module 5.2 |

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson-1-event-driven-programming.md](lesson-1-event-driven-programming.md) | Submodule 8.1: events, register and dispatch, interfaces, the Swing block, handshake, and transfer task |
| [lesson-2-final-project.md](lesson-2-final-project.md) | Submodule 8.2: the six requirements, scoping, the proposal, the worked `RoomDesk` skeleton, handshake, and the capstone |
| [lesson-3-swing-track-addendum.md](lesson-3-swing-track-addendum.md) | Module 8a addendum: local Swing wiring for the existing handlers |
| [examples/HandlerIntro.java](examples/HandlerIntro.java) | Runnable program: one interface, two classes implementing it, called through a variable typed as the interface |
| [examples/EventDemo.java](examples/EventDemo.java) | Runnable program: the console dispatcher — interface, dispatcher, engine, four handlers, and a sentinel command loop, all in one file |
| [tests/CommandDispatcherTest.java](tests/CommandDispatcherTest.java) | JUnit tests for `CommandDispatcher`, `CalculatorEngine`, and the four handlers, in all three evidence tiers |
| [../../templates/project-proposal-template.md](../../templates/project-proposal-template.md) | The proposal form students complete before the capstone gate opens |

**Why everything lives in one file.** The verifier copies each `.java` file into an empty
directory and compiles it alone, so a file that names a class defined elsewhere does not
compile. `EventDemo.java` therefore declares its interface, its dispatcher, its engine, and all
four handlers itself. One `public` class is allowed per file; the rest are package-private
top-level classes in the default package, which is also how `tests/CommandDispatcherTest.java`
reaches them.

`HandlerIntro.java` names its interface `Greeter` rather than `CommandHandler` on purpose. The
verifier compiles the whole `examples/` folder together when it runs the tests, and two files
declaring the same type would collide.

`EventDemo` reads input, and its `.stdin` fixture ends with `quit`. Without that last line
`next()` reads past the end of the input, throws, and exits with a nonzero status, which the
verifier reports as a failure.

---

## Running the tests

Once per machine or Codespace:

```
bash scripts/fetch-junit.sh
```

Then:

```
bash scripts/verify.sh test
```

---

## How CLO-4 is assessed

CLO-4 is satisfied by **processing a user event as a function call.** The assessed skill is the
register-and-dispatch cycle, not one graphical toolkit.

| Path | The user action | Work surface |
|------|----------------|--------------|
| **Console menu** | The student types a command word | Codespace or local — both |
| **Swing** | The student presses a `JButton` | Local machine only |

**Neither path is the lesser one.** A student who completes only the console path has met CLO-4
in full, and no part of the grade is reserved for the graphical version. The handler classes are
identical across both paths, because the logic layer does not know what produced the event —
which is the outcome being demonstrated. See
[docs/clo-mlo-map.md](../../docs/clo-mlo-map.md) for the resolved decision.

No Swing file ships in `examples/`. A Codespace has no display, so a window program cannot
produce recorded output for the verifier. The Swing wiring appears in Lesson 8.1 as a fenced
block marked local surface only.

---

## Instructor facilitation notes

### Before class

1. Run `bash scripts/verify.sh all` and confirm it passes, then `bash scripts/verify.sh test`.
2. Run `examples/EventDemo.java` from a keyboard, not from its fixture, so students see the
   prompt, the typed word, and the printed result as three separate moments. The fixture output
   is correct and reads oddly, because the prompts share lines with the results.
3. Register a handler under `"Add"` and dispatch `"add"` in front of the class before you
   explain anything. The program prints `Unknown command: add` with no error, and that silence
   is the lesson.
4. Decide when to open the capstone proposal window. Students who begin 8.2 before 8.1's
   transfer task is done tend to propose a program that needs a dispatcher they have not
   finished.

### Common mistakes

| Mistake | What it looks like | The single diagnostic question |
|---------|-------------------|-------------------------------|
| Case mismatch in registration | The handler never runs, and nothing reports an error | "What does `isRegistered` say about that exact word?" |
| `==` in the lookup | Every handler looks dead | "Where did the word you are comparing come from?" |
| Registration after the loop | Every command is unknown, including correct ones | "When does that `register` line actually run?" |
| `quit` tested after dispatch | `Unknown command: quit`, then the program ends | "Which branch does `quit` reach first?" |
| Fixture with no `quit` | `NoSuchElementException`, nonzero exit, failed verifier | "What does `next()` read after the last line of input?" |
| A capstone scoped too large | Nothing runs end to end at the deadline | "Which one command works today, from typing to printing?" |

The last row is the one that decides most capstones. Ask for a running program with one command
before you accept a plan for five.

### Accessible facilitation

- Read the dispatch flowchart aloud from its plain-text description. Every diagram in this
  module has one.
- Draw registration as a two-column table on the board — words on the left, handler names on the
  right — and dispatch as a finger walking the left column. Do not use colour alone to pair the
  columns; pair them by row number.
- Allow a student to describe their capstone in prose before filling in the proposal form.
- Accept the reflection as a written document or a spoken recording.
- Do not require Swing from anyone. Do not present it as the more advanced path.
- Offer the [8a Swing addendum](lesson-3-swing-track-addendum.md) only to students with a local display.

---

## How this module connects to the next

There is no next module. This is the ninth of nine, and the Appendix is a reference students
consult rather than a step in the sequence.

What follows the course is the next course, and the shape a student carries into it is the one
this module ends on: a program that waits for an event, runs a method someone wrote in advance,
and keeps its logic in a class that never learns what triggered the call.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by asking what would change if the same handlers were wired
> to a web form instead of a console or a button. Students have now seen two triggers reach one
> handler. The answer they give is the reason the separation was worth the trouble.
