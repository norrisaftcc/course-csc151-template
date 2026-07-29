# Lesson 8.2: The Final Project

**Module:** 8 — Events and Capstone (submodule 8.2)  
**Estimated time:** 1–2 weeks of project work, opening with one 75-minute session  
**Prerequisites:** Lesson 8.1. You can write a handler class, register it with a dispatcher, and run a sentinel loop that ends on `quit`.

---

## Learning goal

After this lesson, you can:

- State the six requirements of the final project, and name the module that taught each one.
- Scope a program you can finish, and say what you decided to leave out.
- Complete the proposal form and the execute-gate handshake with your instructor before you
  write implementation code.
- Build the smallest running version of your program first, and grow it.
- Record evidence for at least two cases you predicted in advance.
- Explain your design decisions in writing or out loud.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Write a class with `private` fields, a constructor using `this`, and `toString`.
- [ ] Hold objects in an `ArrayList` and traverse them with an enhanced `for`.
- [ ] Write a class that `implements` an interface.
- [ ] Register a handler with a dispatcher and dispatch a typed word to it.
- [ ] Run `bash scripts/verify.sh all` on your work surface.

If you cannot do all five, review Modules 6, 7, and Lesson 8.1 before continuing.

---

## Concept explanation

### What the project has to contain

The final project is an original program of your own design. It has to contain six things.

| # | Requirement | Where you already ran it |
|---|-------------|--------------------------|
| 1 | At least one class of your own, beyond the class holding `main` | Module 7 — `Locker`, `Ticket` |
| 2 | At least one array or collection | Module 6 — `ArrayList`; Module 7 — `Shelf`, `TicketOrder` |
| 3 | At least one method beyond `main` | Module 5 — `MyScoreUtils` |
| 4 | At least one registered handler that runs useful code when an event fires | Lesson 8.1 — `Kiosk` |
| 5 | A prediction of the output for at least two test cases | Every module, at every gate |
| 6 | The execute-gate handshake with your instructor before final submission | Module 0 onward |

**Nothing on that list is new.** Every requirement names a skill you have already been taught,
rehearsed alone, and run with a coach beside you. The changed condition in this project is that
nobody hands you the specification. You write it.

### Scope: the part that decides whether you finish

The most common way a final project fails is not a defect. It is a program that was too large
to finish, so nothing in it runs end to end.

Write down the **smallest version that satisfies all six requirements**, and build that first.
One class. One collection. One handler. A loop that ends on `quit`. When that runs, add the
second handler. A running program that does three things is finished work. A half-written
program that would have done ten is not.

Your proposal has a place to record what you left out. Use it. "The program does not sort the
list, because the requirement does not ask for it" is a design decision, and design decisions
are what the reflection asks about.

### The proposal form

Complete [templates/project-proposal-template.md](../../templates/project-proposal-template.md)
before writing implementation code. It carries the program description, the requirements
checklist, the class design, a layout sketch, your test cases, and Section 6 — the four-part
handshake your instructor confirms.

**Two rows of that form name GUI components.** Read them as the requirement they stand for:
**a user action that runs a method you wrote.** A console command word does that, and so does a
Swing button. Both are accepted evidence in full, and the console path is not the lesser one —
see the [Course Map](../../docs/course-map.md#module-8--events-and-capstone). On the console
path, fill "GUI component" with your command word and "ActionListener" with the handler class
registered under it. Sketch your command menu in Section 4 in place of a window.

### What evidence looks like

The standard is the same one you have used since Module 0: three tiers, predicted before
running. The [rubric](../../docs/rubric.md) states what a complete piece of evidence contains.
A screenshot of a working run is not evidence on its own, because it does not say what you
expected.

### Working with an AI teammate on the capstone

The [AI Teammate Policy](../../docs/ai-teammate-policy.md) applies to this project without
change. You remain the coach. You predict before you run. You disclose what the AI produced,
what you changed, and what you kept, in one sentence. You can explain any line you submit.

The design decisions in your reflection have to be yours, because the reflection is where you
say why the program is shaped as it is.

---

## Worked example

Here is a scoped proposal for a program that satisfies all six requirements. It is deliberately
small.

**Program name:** `RoomDesk`

**Description:** The program keeps a list of study rooms. The user types a command word. `list`
prints every room, `seats` prints the total number of seats across all rooms, and `quit` ends
the session. Each room holds a name and a seat count.

**Requirements checklist:**

| Requirement | How this program meets it |
|-------------|--------------------------|
| A class beyond the main class | `Room`, with `name` and `seats` |
| An array or collection | `RoomBoard` holds an `ArrayList<Room>` |
| A method beyond `main` | `RoomBoard.totalSeats()` |
| A registered handler | `ListHandler` and `SeatsHandler`, registered under `list` and `seats` |
| Two predicted test cases | `list` with two rooms; `seats` with two rooms |
| Instructor handshake | Section 6 of the proposal |

**What was deliberately left out:** adding and removing rooms at run time, saving to a file, and
sorting. None of the six requirements asks for them, and each would have doubled the work.

**The skeleton, as first written:**

```java
// RoomDesk.java — the smallest version that satisfies every requirement.
// One public class; every other type is package-private in the same file,
// because the verifier compiles each file on its own.

import java.util.ArrayList;
import java.util.Scanner;

public class RoomDesk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        RoomBoard board = new RoomBoard();
        board.add(new Room("A1", 4));
        board.add(new Room("B2", 8));

        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.register("list", new ListHandler(board));
        dispatcher.register("seats", new SeatsHandler(board));

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String command = input.next();

            if (command.equals("quit")) {
                running = false;
            } else if (!dispatcher.dispatch(command, 0)) {
                System.out.println("Unknown command: " + command);
            }
        }

        System.out.println();
        System.out.println("Desk closed.");
        input.close();
    }
}

class Room {
    private String name;
    private int seats;

    public Room(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public int getSeats() {
        return this.seats;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.seats + " seats)";
    }
}

class RoomBoard {
    private ArrayList<Room> rooms = new ArrayList<>();

    public void add(Room room) {
        this.rooms.add(room);
    }

    public int totalSeats() {
        int total = 0;
        for (Room room : this.rooms) {
            total += room.getSeats();
        }
        return total;
    }

    public void printAll() {
        for (Room room : this.rooms) {
            System.out.println(room);
        }
    }
}

class ListHandler implements CommandHandler {
    private RoomBoard board;

    public ListHandler(RoomBoard board) {
        this.board = board;
    }

    @Override
    public void handle(double value) {
        this.board.printAll();
    }
}

class SeatsHandler implements CommandHandler {
    private RoomBoard board;

    public SeatsHandler(RoomBoard board) {
        this.board = board;
    }

    @Override
    public void handle(double value) {
        System.out.println("Total seats: " + this.board.totalSeats());
    }
}
```

`CommandHandler` and `CommandDispatcher` are the ones from Lesson 8.1, in the same file.

**What to notice:**

- Every part of this program is a Module 6, 7, or 8.1 shape. `RoomBoard` is `Shelf`.
  `totalSeats` is `totalPages`. The loop is the sentinel loop from Module 4.
- Both handlers ignore `value`, and that is allowed. The interface fixes the shape of the
  method, not the use of its parameter.
- The program is small enough to finish, and it satisfies all six requirements. Growth comes
  after it runs.

---

## Trace before running

**Task:** Predict the output of the `RoomDesk` skeleton above for this input:

```
list
seats
rooms
quit
```

**Prediction questions — write your answers before running:**

1. Write the complete output, line by line.
2. How many lines does the `list` command print?
3. What does `rooms` print, and which class decided that?
4. Does `quit` reach the dispatcher?

<details>
<summary>Answers — open only after writing your predicted output</summary>

```
> A1 (4 seats)
B2 (8 seats)
> Total seats: 12
> Unknown command: rooms
> 
Desk closed.
```

1. Six lines, as above.
2. Two — one per room. The first shares its line with the `> ` prompt, because
   `System.out.print` does not end the line. Both come from `println(room)`, which calls
   `Room.toString` for you.
3. `Unknown command: rooms`. `dispatch` walked its list of registered words, found no match,
   returned `false`, and `main` printed the message. No handler ran and nothing changed.
4. No. `main` tests for `quit` before the dispatcher is reached, which is why `quit` is not a
   registered command.

</details>

---

## Repair code

A classmate hands you the version below of the same program. It contains **two errors**. Find
them, fix them, and explain each repair.

Only `main` differs from the worked example. Every other class is unchanged.

```java
public class RoomDesk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        RoomBoard board = new RoomBoard();
        board.add(new Room("A1", 4));
        board.add(new Room("B2", 8));

        CommandDispatcher dispatcher = new CommandDispatcher();

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String command = input.next();

            if (!dispatcher.dispatch(command, 0)) {          // error 2 is here
                System.out.println("Unknown command: " + command);
            }
            if (command.equals("quit")) {
                running = false;
            }
        }

        // error 1: registration happens here
        dispatcher.register("list", new ListHandler(board));
        dispatcher.register("seats", new SeatsHandler(board));

        System.out.println();
        System.out.println("Desk closed.");
        input.close();
    }
}
```

**Errors to find:**

1. Where the two `register` calls sit.
2. Where the `quit` test sits.

**Predict before you repair.** Write down the complete output for the input `list`, `seats`,
`rooms`, `quit`. Both errors are visible in it.

<details>
<summary>Corrections — open only after writing your predicted output</summary>

**The broken version prints:**

```
> Unknown command: list
> Unknown command: seats
> Unknown command: rooms
> Unknown command: quit

Desk closed.
```

1. **Registration happens after the loop, so it never happens in time.** The two `register`
   calls do run — after every command has already been dispatched against an empty list. Every
   command is unknown, including the ones that have handlers written for them. The repair moves
   both lines above the loop.

   This is the register-and-dispatch cycle failing at its first half, and it is worth naming as
   its own failure mode: **code that exists, compiles, and is never reached in time is not the
   same as code that is wrong.** The handlers here are correct.

2. **The `quit` test runs after the dispatch, so `quit` is dispatched first.** The dispatcher
   has no handler under `quit`, so the program prints `Unknown command: quit` and then ends.
   The repair makes the `quit` test the first branch, with the dispatch in its `else`, as the
   worked example has it.

**Fix error 1 alone and the output becomes:**

```
> A1 (4 seats)
B2 (8 seats)
> Total seats: 12
> Unknown command: rooms
> Unknown command: quit

Desk closed.
```

The remaining wrong line is now the only wrong line, which is what "change one thing and run
again" buys you.

</details>

---

## Execute-gate handshake

This handshake is with your **instructor**, and it happens before you write implementation
code. It uses Section 6 of
[templates/project-proposal-template.md](../../templates/project-proposal-template.md).

**Instructor provides this task:**

> Submit your completed proposal. State the four parts of the gate for the program you propose
> to build. Your prediction must name at least two specific test cases with their exact expected
> output, and your success check must be observable — not "it runs," but what it prints.

**Player: complete the handshake using this format:**

```
Goal: My program must ______.
Constraints: I may use ______. I may not use ______. I will finish ______ before adding ______.
Prediction: For the command ______ I expect ______. For the command ______ I expect ______.
Success check: We know it works when ______.
```

**Gate opens when your instructor says: "Agreed."** A proposal that names a program you cannot
scope, or a prediction with no exact output in it, is returned before the gate opens. That is
the gate working rather than the gate failing.

---

## Small coding task

**Build the smallest running version first,** with your coach beside you.

1. One class of your own, with `private` fields, a constructor using `this`, and `toString`.
2. One holder class with an `ArrayList` of that class and one method that reports across it.
3. One handler class that `implements CommandHandler`, registered under one command word.
4. A sentinel loop that ends on `quit`, and an unknown-command message for everything else.

Run it. Confirm one command works end to end, from the typed word to the printed line.

**Only then** add your second handler, your second class, or anything else on your proposal.
Show your coach the first running version before you grow it.

---

## Test evidence

Record all three tiers for your own program. Predict each expected value before you run.

| Tier | Command or input | Expected | Actual | Match? |
|------|-----------------|----------|--------|--------|
| **Normal** | ______ | ______ | | |
| **Boundary** | ______ (an empty collection, or a value at an edge) | ______ | | |
| **Failure** | ______ (an unregistered command) | `Unknown command: ` and the word, with no state changed | | |

Keep this table with your submission. It is the evidence the [rubric](../../docs/rubric.md)
asks for.

---

## Explanation

Answer these questions in writing or out loud to your instructor:

1. Trace one command through your program, naming every method it passes through.
2. Which class holds your program's state, and how does a handler reach it?
3. What evidence shows that an unregistered command changed nothing?
4. Name one line of your program you could not have written in Module 4, and say what changed.

---

## Role rotation

Swap programs with a partner. Read their proposal, then their code. As the coach, ask one
diagnostic question at a time and give the smallest hint that lets them take the next step. Do
not repair their program for them.

Report back to them using ASSAY, from
[Prompting Your AI Teammate](../../docs/prompting-your-ai-teammate.md): report what survives the
floor test in their evidence, and name where the operative sentence sits. **Report only. Do not
rewrite their work.**

---

## Transfer task

**Changed condition:** Nobody hands you the specification. You wrote it, and you build the whole
program from it.

**The task:** Complete your final project as proposed.

It contains:

- At least one class of your own beyond the class holding `main`.
- At least one array or collection.
- At least one method beyond `main`.
- At least one registered handler that runs useful code when an event fires.
- A prediction of the output for at least two test cases, written before the run.
- The execute-gate handshake with your instructor, confirmed before implementation.
- A short written or spoken reflection on your design decisions.

Every one of those seven items is a skill you have already run in an earlier module, under a
coach, on a program that someone else specified. The one thing that changed is who wrote the
specification.

---

## Reflection

Answer all three, in three to five sentences each. This reflection is part of the project.

1. What design decision was hardest to make, and why?
2. What did you predict that turned out to be wrong, and what did you learn from it?
3. What would you change if you had more time?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Name the six project requirements | ☐ | ☐ | ☐ |
| Scope a program you can finish, and record what you left out | ☐ | ☐ | ☐ |
| Complete the proposal form | ☐ | ☐ | ☐ |
| Complete the execute-gate handshake with the instructor | ☐ | ☐ | ☐ |
| Write a class of your own with fields, a constructor, and `toString` | ☐ | ☐ | ☐ |
| Hold objects in a collection and report across them | ☐ | ☐ | ☐ |
| Write and register a handler | ☐ | ☐ | ☐ |
| Build the smallest running version before growing it | ☐ | ☐ | ☐ |
| Record normal, boundary, and failure evidence, predicted in advance | ☐ | ☐ | ☐ |
| Disclose AI teammate use in one sentence | ☐ | ☐ | ☐ |
| Coach role completed on a partner's project | ☐ | ☐ | ☐ |
| Final project completed and submitted | ☐ | ☐ | ☐ |
