# Module 6: Arrays and Collections

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Seventh module (after Methods)  
**Estimated time:** 3–4 class sessions

---

## What this module covers

- Declaring and initializing an `int` array.
- Accessing elements by index.
- Traversing an array with a `for` loop.
- Common array algorithms: find maximum, find minimum, compute sum.
- An introduction to edge cases: one-element arrays, arrays with negative values.

---

## Learning goal

After this module, students can:

1. Declare and initialize an `int` array and access elements by index.
2. Write a single-pass traversal to find the maximum value in an `int` array.
3. Identify at least two edge cases for any array algorithm and test them.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Plays | Read how an array is declared, indexed, and traversed, and how `ArrayList` differs. |
| **Practice** | Run the Play | Trace `findMax` against `{-3, -5, -1, -8}` one iteration at a time — the all-negative case, where initializing to 0 gives the wrong answer. Repair `RepairMax.java`. |
| **Apply** | Team Practice | Complete the handshake, then write `MyArrayMax.java` and test it against all three arrays named in the handshake. |
| **Assess** | The Big Game | Write `findMin` and apply the same three test cases to it. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The transfer task reverses the comparison and changes nothing else.** The one-element array
and the all-negative array were both traced in the Practice beat, which is where the
initialization mistake is meant to be made.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with handshake, trace, task, and transfer |
| [examples/ArrayMax.java](examples/ArrayMax.java) | Runnable program: find maximum value in an array |
| [examples/ArrayStats.java](examples/ArrayStats.java) | Runnable program: min, max, and sum of an array |

---

## Instructor facilitation notes

### Before class

1. Compile and run both Java files to confirm they work on your system.
2. Review the execute-gate handshake in the lesson. The main coding task requires students to write the `findMax` method independently before seeing the solution.
3. Prepare at least three test arrays on the board: a typical array, a one-element array, and an array with all negative values. Students should predict the result for each before running.

### Suggested handshake prompt for the main coding task

> Write a static method named `findMax` that accepts an `int` array and returns the largest value. Do not sort the array. Test an array with five elements, an array with one element, and an array where all values are negative.

The most common mistake is initializing the "running max" to `0`. This fails for an all-negative array. Prompt students to predict what happens with `[-3, -5, -1]` before they run it.

### Common mistakes to watch for

- Initializing `max = 0` instead of `max = numbers[0]`.
- Using `<=` instead of `<` in the loop: this causes an `ArrayIndexOutOfBoundsException`.
- Returning `0` when the array is empty instead of throwing an exception or handling the case explicitly.

### Accessible facilitation

- When tracing the loop, use a table on the board with columns: `i`, `numbers[i]`, `max`. Update the table at each iteration.
- Allow students to trace on paper before typing.
- The `ArrayStats.java` file includes the same loop pattern three times (for min, max, and sum), which reinforces the pattern through repetition.

---

## How this module connects to the next

This module uses static methods. The next module (Classes and Objects) will move data and methods inside a class. Point out that the `findMax` method they write here could become a method on an array-processing class — the logic does not change, only its location.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: this module's static methods are the same logic students will put inside classes next.
