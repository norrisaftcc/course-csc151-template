# Lesson 7: Classes and Objects

**Module:** 7 — Classes and Objects  
**Estimated time:** 100–120 minutes  
**Prerequisites:** You can write a `static` method with parameters and a return value. You can declare an `ArrayList`, add to it, and traverse it with an enhanced `for`.

---

## Learning goal

After this lesson, you can:

- State the difference between a class and an object.
- Declare `private` fields and explain what `private` prevents.
- Write a constructor whose parameters fill those fields, using `this` to tell the two apart.
- Build objects with `new` and state that two objects of one class hold separate values.
- Write getters, and one setter that refuses an invalid value.
- Write `toString`, and state who calls it for you.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Write a method with an access modifier, a return type, a name, and a parameter list.
- [ ] Declare an `ArrayList<String>`, add items to it, and read `size()`.
- [ ] Traverse a collection with an enhanced `for` loop.

If you cannot do all three, complete Modules 5 and 6 before continuing.

---

## Concept explanation

### A class is the definition. An object is one thing built from it.

Every program so far has held one class and put every line inside `main`. A **class** can also
describe a kind of thing: what values it holds, and what it can do.

An **object** is one thing built from that class. One `Book` class describes what any book
holds. `new Book("Dune", "Frank Herbert", 412)` builds one book. A second `new` builds another,
and the two hold separate values.

### Fields, and why they are `private`

A **field** is a variable that belongs to an object rather than to a method.

```java
public class Book {
    private String title;
    private String author;
    private int pages;
}
```

`private` means that code outside this class cannot read or write these fields directly. It
reaches them only through the methods the class supplies. That is the point: the class decides
what a `Book` may become. A page count of `0` can be refused in one place instead of in every
program that ever builds a book.

### The constructor, and `this`

A **constructor** runs once when an object is built. It has the class's name and no return
type, and its job is to fill the fields.

```java
public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
}
```

`this` names the object the call was made on, so `this.title` is the **field** and `title` is
the **parameter**. Both names are in scope inside the constructor, and without `this` the
parameter wins.

```java
title = title;      // assigns the parameter to itself
```

That line compiles. The field keeps its starting value of `null`, the object then prints `null`
where the title should be, and nothing anywhere reports an error.

### `new`

```java
Book dune = new Book("Dune", "Frank Herbert", 412);
Book odyssey = new Book("The Odyssey", "Homer", 541);
```

`new` builds one object and runs the constructor once. Two calls to `new` build two objects.
`dune` and `odyssey` each carry their own copy of every field, so changing one leaves the other
where it was.

### Getters, and one setter that refuses

A **getter** returns a field's value. A **setter** changes it.

```java
public int getPages() {
    return this.pages;
}

public void setPages(int pages) {
    if (pages > 0) {
        this.pages = pages;
    }
}
```

A setter that stores whatever it is handed is a field with extra typing. The guard is the
reason the field is `private`: a book with zero pages can never exist, whatever a caller asks
for. `setPages(0)` changes nothing, and `getPages()` still returns the value from before.

A getter for a `boolean` field is usually named `isSomething` rather than `getSomething`:
`isInUse()` reads as the question it asks.

### `toString`

```java
@Override
public String toString() {
    return this.title + " by " + this.author + " (" + this.pages + " pages)";
}
```

`System.out.println(dune)` and `"Book: " + dune` both call `toString` for you. Without it, they
print the class name and a hash code — text like `Book@659e0bfd`, where the hexadecimal digits
change from run to run and tell a reader nothing.

`@Override` tells the compiler you meant to replace an inherited method. It is not required, and
it earns its place by catching a misspelling: write `ToString` with a capital `T` and the
compiler reports it instead of silently accepting a new, unrelated method.

### Holding many objects

An `ArrayList` holds objects the same way it held the `String` values in Module 6.

```java
private ArrayList<Book> books = new ArrayList<>();

public int totalPages() {
    int total = 0;
    for (Book book : this.books) {
        total += book.getPages();
    }
    return total;
}
```

The list holds the **same** objects, not copies of them. Change a book's page count after it is
on the shelf, and the shelf's total changes with it, without the shelf being told anything.

Key terms introduced in this lesson:

- **Class:** the definition of a kind of thing.
- **Object:** one thing built from a class.
- **Field:** a variable that belongs to an object.
- **Constructor:** the method that runs once when an object is built.
- **`this`:** the object the call was made on.
- **Getter / setter:** a method that returns a field's value, or changes it.

---

## Worked example

`examples/Book.java` holds one class definition, several objects built from it, and a second
class that keeps those objects in an `ArrayList`. `Shelf` lives in the same file on purpose:
the course verifier copies each `.java` file into an empty directory and compiles it alone, so
a file that names a class defined elsewhere does not compile. One `public` class is allowed per
file, so `Shelf` carries no access modifier.

```java
// Book.java
// One class, several objects, and a second class that holds them.
// See examples/Book.java for the full runnable version with its Javadoc.

import java.util.ArrayList;

public class Book {

    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle()  { return this.title; }
    public String getAuthor() { return this.author; }
    public int getPages()     { return this.pages; }

    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        }
    }

    @Override
    public String toString() {
        return this.title + " by " + this.author + " (" + this.pages + " pages)";
    }

    public static void main(String[] args) {
        Book dune = new Book("Dune", "Frank Herbert", 412);
        Book odyssey = new Book("The Odyssey", "Homer", 541);

        System.out.println(dune);
        System.out.println(odyssey);

        Shelf shelf = new Shelf();
        shelf.add(dune);
        shelf.add(odyssey);

        System.out.println("Books on the shelf: " + shelf.size());
        System.out.println("Total pages: " + shelf.totalPages());

        dune.setPages(0);
        System.out.println("setPages(0) refused, pages still " + dune.getPages());

        dune.setPages(350);
        System.out.println("setPages(350) accepted, pages now " + dune.getPages());

        System.out.println("Total pages: " + shelf.totalPages());
    }
}

class Shelf {

    private ArrayList<Book> books = new ArrayList<>();

    public void add(Book book) {
        this.books.add(book);
    }

    public int size() {
        return this.books.size();
    }

    public int totalPages() {
        int total = 0;
        for (Book book : this.books) {
            total += book.getPages();
        }
        return total;
    }
}
```

**Expected output:**
```
Dune by Frank Herbert (412 pages)
The Odyssey by Homer (541 pages)
Books on the shelf: 2
Total pages: 953
setPages(0) refused, pages still 412
setPages(350) accepted, pages now 350
Total pages: 891
```

**What to notice:**

- `System.out.println(dune)` prints a sentence rather than `Book@659e0bfd`, because `toString`
  is defined.
- `dune` and `odyssey` hold separate values. Changing `dune` leaves `odyssey` at 541 pages.
- `setPages(0)` prints no error and changes nothing. The guard refuses the value, and the
  caller finds out by asking `getPages()`.
- The last line changes without anyone telling the shelf. The shelf holds the same `Book`
  object that `setPages(350)` changed, so `totalPages()` reads the new value: 541 + 350 = 891.
- `Shelf.totalPages` is the accumulator pattern from Module 4, walking a collection with the
  enhanced `for` from Module 6. Nothing about the loop is new. What is new is that the values
  it adds come from objects.

`examples/Counter.java` is the second worked example. It holds one field, one method that
changes it, one method that reports it, and two objects stepped in an interleaved order.

---

## Trace before running

### Part 1 — two objects, one class

**Task:** Trace `examples/Counter.java`. Do not run it yet.

`main` builds two counters, then makes these calls in this order:

```java
Counter left = new Counter();
Counter right = new Counter();
left.increment();
left.increment();
right.increment();
left.increment();
right.increment();
```

Fill in one row per line.

| After this line | `left.count()` | `right.count()` |
|-----------------|---------------|-----------------|
| both built | ______ | ______ |
| `left.increment();` | ______ | ______ |
| `left.increment();` | ______ | ______ |
| `right.increment();` | ______ | ______ |
| `left.increment();` | ______ | ______ |
| `right.increment();` | ______ | ______ |

**Prediction questions — write your answers before running:**

1. What does each counter hold at the end?
2. `increment()` contains the line `this.count = this.count + 1;`. Which object does `this`
   name when the call is `right.increment()`?
3. What would each counter hold if the two objects shared one `count` field?

<details>
<summary>Answers — open only after filling in the table and writing your predictions</summary>

| After this line | `left.count()` | `right.count()` |
|-----------------|---------------|-----------------|
| both built | 0 | 0 |
| `left.increment();` | 1 | 0 |
| `left.increment();` | 2 | 0 |
| `right.increment();` | 2 | 1 |
| `left.increment();` | 3 | 1 |
| `right.increment();` | 3 | 2 |

1. `left` holds 3 and `right` holds 2.
2. `this` names `right` — the object the call was made on. The same line of source changes a
   different object depending on who was called.
3. Both would report 5, the total of all five calls. They do not, and that is the observable
   difference between a class and an object: the class is written once, and each object carries
   its own copy of every field.

</details>

### Part 2 — state that changes after construction

**Task:** Look at the last four lines of the expected output of `examples/Book.java`.

**Prediction questions — write your answers before running:**

1. `dune.setPages(0)` runs. What does `dune.getPages()` return afterward, and what error, if
   any, does the program print?
2. `dune.setPages(350)` runs next. What does `shelf.totalPages()` return afterward?
3. Nobody calls a method on `shelf` between those two lines. Why does its total change?

<details>
<summary>Answers — open only after writing your predictions</summary>

1. `412`, unchanged. No error is printed at all. The guard `if (pages > 0)` is `false`, so the
   assignment never runs and the method returns normally. A caller who wants to know whether
   the value was accepted has to ask `getPages()`.
2. `891`. The odyssey still holds 541 pages, and `dune` now holds 350.
3. The shelf holds the same `Book` object that `setPages(350)` changed, rather than a copy of
   it. `totalPages()` reads each book's page count at the moment it is called, so the new value
   arrives on its own.

</details>

---

## Repair code

The following program contains **two errors**. Find them, fix them, and explain each repair.
Do not run the code until you have written your explanations.

The program should print `Dune (412 pages)`.

```java
public class RepairBook {

    private String title;
    private int pages;

    public RepairBook(String title, int pages) {
        title = title;          // error 1
        this.pages = pages;
    }

    public String ToString() {  // error 2
        return this.title + " (" + this.pages + " pages)";
    }

    public static void main(String[] args) {
        RepairBook book = new RepairBook("Dune", 412);
        System.out.println(book);
    }
}
```

**Errors to find:**

1. The constructor's first assignment.
2. The name of the method that builds the description.

**Predict before you repair.** Write down what this program prints as written, then what it
prints once you have fixed only error 2. Neither error stops the program, and neither produces
a compiler message.

<details>
<summary>Corrections — open only after writing your explanations</summary>

**As written, a real run prints:**

```
RepairBook@659e0bfd
```

The hexadecimal digits differ from run to run and from machine to machine. They are not a
value you can use, and they hide error 1 completely.

1. **`title = title;` assigns the parameter to itself.** Both names are in scope inside the
   constructor, and the parameter wins, so the field is never touched and keeps its starting
   value of `null`. The repair is `this.title = title;`.

2. **`ToString` is not `toString`.** Java is case-sensitive, so this declares a new method that
   nothing ever calls. `println` looks for `toString`, does not find one, and falls back to the
   class name and hash code. The repair is `public String toString()`, and adding `@Override`
   above it makes the compiler catch this exact misspelling next time.

**Fix only error 2 and the program prints:**

```
null (412 pages)
```

That is the more useful state to reach on purpose. The second error was hiding the first one,
and repairing in one step would have left you believing that one change fixed both. This is why
the debugging strategy in Module 5.2 says to change one thing and run again.

Corrected code:
```java
public class RepairBook {

    private String title;
    private int pages;

    public RepairBook(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.pages + " pages)";
    }

    public static void main(String[] args) {
        RepairBook book = new RepairBook("Dune", 412);
        System.out.println(book);
    }
}
```

Expected output: `Dune (412 pages)`

</details>

---

## Execute-gate handshake

You are now going to write a class of your own. Complete the handshake with your coach before
writing any code.

**Coach provides this task:**

> Write `Locker.java`: a class with the private fields `number`, `ownerName`, and `inUse`; a
> constructor that fills them using `this`; a getter for each field; a `release()` method that
> marks the locker free; and a `toString`.
>
> The constructor refuses a locker number below 1 and stores `1` instead.
>
> In `main`, build three lockers, hold them in an `ArrayList<Locker>`, print each one with an
> enhanced `for`, and report how many lockers are in use. Then release one locker and report the
> count again.
>
> Constraints: Every field is `private`. Every field is read from outside the class through a
> getter. `Locker` and its `main` stay in one file, as `Book` and `Shelf` do.

**Player: complete the handshake using this format:**

```
Goal: The program must ______.
Constraints: I may ______. I may not ______.
Prediction: For three lockers I expect ______. After release() I expect the count to be ______.
            For an empty list I expect ______. For new Locker(0, "Sam") I expect ______.
Success check: We know it works when ______.
```

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

Write a Java program in a file named `Locker.java` that:

1. Declares `private int number;`, `private String ownerName;`, and `private boolean inUse;`.
2. Declares `public Locker(int number, String ownerName)`, which sets `inUse` to `true` and
   stores `1` when the number given is below 1.
3. Declares `getNumber()`, `getOwnerName()`, and `isInUse()`.
4. Declares `public void release()`, which sets `inUse` to `false` and `ownerName` to `"none"`.
5. Declares `toString()` returning `Locker 12: Jordan (in use)` or `Locker 7: none (free)`.
6. In `main`, builds three lockers, adds them to an `ArrayList<Locker>`, prints each with an
   enhanced `for`, and prints how many are in use.
7. Releases one locker, then prints the count of lockers in use again.

**Required output format:**
```
Locker 12: Jordan (in use)
Locker 7: Avery (in use)
Locker 1: Brooks (in use)
Lockers in use: 3
Locker 7 released.
Lockers in use: 2
```

Count the lockers in use with an accumulator and an enhanced `for`, the way `Shelf.totalPages`
adds page counts.

---

## Test evidence

Record all three tiers after running.

| Tier | What to run | Expected | Actual | Match? |
|------|-------------|----------|--------|--------|
| **Normal** | Three lockers, then release one | Three lines, `Lockers in use: 3`, then `Lockers in use: 2` | | |
| **Boundary** | Build the `ArrayList` and add nothing | No locker lines at all, `Lockers in use: 0`, and the program still ends normally | | |
| **Failure** | `new Locker(0, "Sam")` | `Locker 1: Sam (in use)` — the constructor corrected the number | | |

The boundary tier is worth your attention for the same reason it was in Module 4: an enhanced
`for` over an empty collection runs zero passes and reports nothing. Zero passes is not a
failure, and a program that prints nothing here is behaving correctly.

---

## Explanation

Answer these questions in writing or out loud to your coach:

1. What does `private` prevent, and what does the class gain by preventing it?
2. In your constructor, what does `this.number` name, and what does `number` name?
3. What evidence shows that a locker number of `0` was corrected rather than stored?
4. Your list holds the same objects, not copies. What evidence in your output shows that?

---

## Role rotation

Switch roles with your partner. The new coach describes the transfer task below. The new player
restates the goal and completes the handshake before writing any code.

---

## Transfer task

**Changed condition:** The object's state changes after construction through a **validating
setter**, and the total the collection reports must follow that change — including when the
setter refuses.

**Coach provides this task:**

> Write `Ticket.java` with the same shape you just used:
>
> - `Ticket`: private fields `eventName`, `holderName`, and `price`; a constructor using `this`;
>   a getter for each field; `setPrice(double price)`, which refuses `0` and any negative value
>   and keeps the previous price; and a `toString` returning `Concert for Avery: $45.00`.
> - `TicketOrder`: a second class in the same file, holding an `ArrayList<Ticket>`, with
>   `add(Ticket ticket)`, `size()`, and `totalPrice()`.
>
> In `main`, build three tickets at `45.00`, `30.00`, and `25.00`, add all three to one order,
> and print the total. Then call `setPrice(-5.00)` on the first ticket and print the total
> again. Then call `setPrice(20.00)` on the same ticket and print the total again.
>
> Constraints: `TicketOrder` carries no access modifier and lives in `Ticket.java`, as `Shelf`
> lives in `Book.java`. Print money with `System.out.printf("%.2f%n", value)`.

**Player: complete the full handshake before writing code.**

<details>
<summary>Expected output (check after running)</summary>

```
Concert for Avery: $45.00
Concert for Brooks: $30.00
Concert for Jordan: $25.00
Tickets in the order: 3
Order total: $100.00
setPrice(-5.00) refused, price still $45.00
Order total: $100.00
setPrice(20.00) accepted, price now $20.00
Order total: $75.00
```

Two lines carry the assessment.

The **refused** line proves the guard ran: the price stayed at `45.00`, no error appeared, and
the order total did not move. A setter with no guard would have stored `-5.00` and the total
would have read `$50.00`.

The **accepted** line proves the order holds the ticket rather than a copy of its price. Nobody
calls a method on the order between the two totals, and the total changes anyway — exactly as
`Shelf.totalPages` changed after `dune.setPages(350)`.

Everything here has a rehearsal behind it. `Shelf` is the model for `TicketOrder`. `setPages`
is the model for `setPrice`. The accumulator inside `totalPrice()` is the loop you wrote for
`Lockers in use`. The one changed condition is that the value your collection reports now
depends on a setter that can say no.

</details>

---

## Reflection

Answer one of the following:

- `setPages(0)` and `setPrice(-5.00)` both refuse silently. Is silence the right behaviour? Say
  what you would do instead, and what it would cost.
- The `ToString` misspelling produced no compiler message. What habit would have caught it, and
  what does that suggest about `@Override`?
- What question do you still have about `this`, or about what `private` protects?

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| State the difference between a class and an object | ☐ | ☐ | ☐ |
| Declare `private` fields and say what `private` prevents | ☐ | ☐ | ☐ |
| Write a constructor that fills fields using `this` | ☐ | ☐ | ☐ |
| Build objects with `new` | ☐ | ☐ | ☐ |
| Show that two objects hold separate values | ☐ | ☐ | ☐ |
| Write a getter for each field | ☐ | ☐ | ☐ |
| Write a setter that refuses an invalid value | ☐ | ☐ | ☐ |
| Write `toString`, and say who calls it | ☐ | ☐ | ☐ |
| Hold objects in an `ArrayList` and traverse them | ☐ | ☐ | ☐ |
| Report a total across a collection of objects | ☐ | ☐ | ☐ |
| Complete the execute-gate handshake | ☐ | ☐ | ☐ |
| Record normal, boundary, and failure evidence | ☐ | ☐ | ☐ |
| Coach role completed | ☐ | ☐ | ☐ |
| Transfer task (`Ticket`) completed independently | ☐ | ☐ | ☐ |
