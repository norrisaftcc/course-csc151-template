# Module 7: Classes and Objects

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Eighth module (after Arrays and Collections)  
**Estimated time:** 4–5 class sessions  
**Work surface:** Codespace or local VS Code — both work for every task in this module.

---

## What this module covers

- The difference between a class and an object.
- `private` fields, and what `private` prevents.
- A constructor whose parameters fill the fields, and `this` as the way to tell a field from a
  parameter of the same name.
- `new`, and the fact that two objects of one class hold separate values.
- Getters, and one setter that refuses an invalid value.
- `toString`, and who calls it for you.
- Holding objects in an `ArrayList` and reporting a total across them.

Interfaces are deliberately not here. They are taught, traced, and coached inside Module 8
before anything graded needs them.

---

## Learning goal

After this module, students can:

1. State the difference between a class and an object, with an example of each.
2. Declare `private` fields and reach them from outside the class through methods.
3. Write a constructor that uses `this` to fill fields from parameters of the same name.
4. Write getters, and a setter that refuses an invalid value and leaves the field alone.
5. Write `toString` and explain why `println` prints a hash code without it.
6. Hold objects in an `ArrayList` and compute a total across them.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | Read what a class defines and what an object is, why fields are `private`, how `this.title = title` tells the field from the parameter, what `new` does, and why `println` prints `Book@659e0bfd` without a `toString`. Worked examples: `Book.java`, which pairs `Book` with a `Shelf` holding an `ArrayList<Book>`, and `Counter.java`. |
| **Practice** | Run the Play | Trace `Counter.java`: two objects, interleaved `increment()` calls, predicting what each object holds after every line. Then predict what `Book.java` reports after `setPages(0)` is refused and `setPages(350)` is accepted. Repair `RepairBook`, whose two defects are `title = title` in the constructor and a method spelled `ToString`. Neither produces a compiler message. |
| **Apply** | Team Practice | Complete the handshake, then write `Locker.java`: private fields, a constructor using `this` that corrects a locker number below 1, getters, a `release()` setter, and `toString`. Hold three lockers in an `ArrayList<Locker>`, print each with an enhanced `for`, and report how many are in use. |
| **Assess** | The Big Game | Write `Ticket.java` and a `TicketOrder` that reports a total across an `ArrayList<Ticket>`, where a **validating** setter changes a ticket's price after construction and the reported total has to follow — including when the setter refuses. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The transfer task changes one condition: the total now depends on a setter that can say no.**
Everything else has a rehearsal behind it. `Shelf` is the model for `TicketOrder` and is read in
the Learn beat. The refused setter is traced in the Practice beat, against `Book.expected`,
where the shelf total stays at 953 after `setPages(0)` and moves to 891 after `setPages(350)`.
The accumulator over a collection is written with a coach in the Apply beat, as the count of
lockers in use.

**On class names.** No example in this course names a class `Player` or `Student`. Those two
words are the course's role term and its audience, and the one-term-one-concept rule applies to
example code as much as to prose. This module uses `Book`, `Shelf`, `Counter`, `Locker`, and
`Ticket`.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with fields, constructors, `this`, getters, the validating setter, `toString`, handshake, and transfer task |
| [examples/Book.java](examples/Book.java) | Runnable program: `Book` with a validating `setPages`, plus a `Shelf` holding an `ArrayList<Book>` and reporting a total |
| [examples/Counter.java](examples/Counter.java) | Runnable program: two objects of one class, stepped in an interleaved order |
| [tests/BookTest.java](tests/BookTest.java) | JUnit tests for `Book` and `Shelf`, in all three evidence tiers |

**Why `Shelf` lives inside `Book.java`.** The verifier copies each `.java` file into an empty
directory and compiles it alone, so a file that names a class defined elsewhere does not
compile. A file carries one `public` class at most, so `Shelf` is a package-private top-level
class in the same file. Students writing `Ticket.java` follow the same rule, and the lesson
says so where it matters.

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

## Instructor facilitation notes

### Before class

1. Run `bash scripts/verify.sh all` and confirm it passes.
2. Run `examples/Counter.java` in a visible terminal. Two objects built from one class, stepped
   unevenly, is the whole idea of this module in six printed lines.
3. Prepare the `toString` demonstration: comment out `toString` in a copy of `Book.java`, run
   it, and show the class name and hash code. Students who have seen `Book@659e0bfd` once stop
   reading it as an error message.

### Common mistakes

| Mistake | What it looks like | The single diagnostic question |
|---------|-------------------|-------------------------------|
| `title = title` in a constructor | The object prints `null`, with no error | "Which of those two names is the field?" |
| `ToString` or `tostring` | `println` prints `Book@659e0bfd` | "What exactly does `println` look for?" |
| A setter with no guard | An object holds a value that should be impossible | "Where is the one place this value can be refused?" |
| Public fields | The guard exists and nothing has to use it | "Can code outside the class still write that field directly?" |
| Expecting a shared field | One object's change is expected to appear in another | "How many times did `new` run?" |

The first two produce **no compiler message at all**, which is what makes this module a good
place to reuse the reproduce–isolate–fix–verify habit from Module 5.2. The Practice beat is
built so that repairing the second defect exposes the first.

### Accessible facilitation

- Draw two labelled boxes on the board for two objects and update each one as calls are made.
  Do not rely on colour to tell the boxes apart — label them `left` and `right` in words.
- Allow students to write a class on paper as four lists: fields, constructor, getters, other
  methods.
- Read `this.pages = pages;` aloud as "the field `pages` of this object takes the value of the
  parameter `pages`." The sentence is longer than the line and it removes the ambiguity.
- Give students who find the constructor hard a one-field class first. `Counter` exists for
  that purpose.

---

## How this module connects to the next

Module 8 (Events and Capstone) builds handler classes: small objects, each holding a reference
to one engine object, each supplying one method. That is this module's toolkit with one addition
— an interface, which names a method and supplies no body. The dispatcher in Module 8 holds its
handlers in an `ArrayList`, exactly as `Shelf` holds books.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by asking what would happen if `Shelf` had to hold two
> different kinds of thing that both answer the same question. Students already build objects
> and call their methods. They are about to learn what names that shared question.
