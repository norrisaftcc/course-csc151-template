# Test Evidence Rubric — CSC 151 Java Programming I

This rubric scores one artifact: a student's **test evidence**. Test evidence is the
completed "Test evidence" table, or authored JUnit tests, plus the "Explanation" that
follows. It is the work a lesson's **Team Practice** or **The Big Game** asks for.
**Team Practice** is the course's name for the Apply beat. Literal meaning: do the whole
thing with your coach beside you, still not for a score. **The Big Game** is the course's
name for the Assess beat. Literal meaning: the work that counts toward your grade.

This rubric is a different artifact from the one [rubric.md](rubric.md) scores. `rubric.md`
evaluates *lesson and assignment design* — whether a lesson an instructor writes has an
observable goal, a complete handshake, and the rest. This document evaluates *what a student
turned in* after running that lesson: the recorded evidence and the written explanation. Use
`rubric.md` when reviewing course material. Use this rubric when grading a submission.

This rubric implements the decision recorded in open question 2 of
[clo-mlo-map.md](clo-mlo-map.md): four categories, five points each, twenty points total.

---

## How evidence is submitted

Test evidence reaches a grader in one of two forms, and this rubric scores both the same way.

- **Table form.** Most modules grade evidence the student records by hand: the student runs a
  plain `main`-driven program and fills in a Test evidence table (Tier | ... | Expected |
  Actual | Match?) in the lesson, as shown in every module's Test evidence section. This is
  the form Modules 0 through 4, 6, 7, and 8 grade.
- **JUnit form.** Module 5 Lesson 5.2's assignment is the exception: the student authors and
  submits a JUnit test class, one test method per tier, named with the course's
  `method_expectedResult_forCondition` convention.

Grade whichever form the lesson assigned. Do not require a JUnit test where the lesson
assigns a table, and do not accept a table row where the lesson assigns JUnit. A tier counts
as evidenced when either of these is true:

- A named JUnit test method exists for that tier, asserts the correct expected value, and
  runs.
- A row for that tier in the Test evidence table names a real run, and its Expected, Actual,
  and Match? columns are filled in and consistent with that run.

---

## The four categories

The categories match the three-tier evidence model fixed in `CLAUDE.md` and used in every
lesson's Test evidence table, or, in Module 5 Lesson 5.2, in submitted JUnit test methods,
plus the Explanation beat that follows.

1. **Normal case (5 pts)** — correct evidence for the case the method or program was written
   for.
2. **Boundary case (5 pts)** — correct evidence for the smallest or edge input.
3. **Failure case (5 pts)** — correct evidence for the input that exposes a wrong assumption.
4. **Explanation (5 pts)** — the player states what the evidence shows and why it matters.
   ("Player" is the course's term for the student holding the keyboard during Team Practice
   or The Big Game; the **coach**, the other role, is the one guiding rather than typing.)

---

## Scoring guide

Each of the four categories scores on the same 0-to-5 scale, grouped into four bands. The top
band splits into two points: one for work that is complete, and one more for work that leaves
no gap for a reader to fill in.

The normal-case, boundary-case, and failure-case categories are each evidenced in one of the
two submission forms — JUnit or table — described below. The explanation category has no
submission form of its own; its band criteria are prose, not a test method or a table row, and
appear in its own entry under "Category detail and worked anchors."

### 0 — Missing
For an evidence category, no evidence is present in either form: there is no test method, and
there is no completed row. For the explanation category, no explanation is written.

### 1–2 — Partial
For an evidence category, evidence exists but has a gap:

- **JUnit form:** the test name does not describe what it claims (`test3` instead of
  `findMax_returnsMinusOne_forAllNegativeArray`), or the test targets the wrong tier (a
  second normal-case test submitted as the boundary test).
- **Table form:** the Expected or Actual column is blank, the row describes a run that was
  not actually performed, or the row's input is not really this tier (a second normal case
  submitted as the boundary row).

For the explanation category, see its own band criteria below.

### 3–4 — Complete

- **JUnit form:** the test targets the correct tier, the name follows the course's
  `method_expectedResult_forCondition` pattern, and it asserts a correct expected value.
- **Table form:** the row's input is a genuine example of this tier, and the Expected,
  Actual, and Match? columns are filled in and consistent with each other.

For the explanation category, see its own band criteria below.

### 5 — Complete and load-bearing
For an evidence category, the work meets every criterion in the Complete band, in whichever
form it takes. It also would expose the misconception it targets if that misconception were
still present. A boundary test or row of `{42}` that would also pass, or show a Match, against
a broken traversal scores a 4, not a 5. The result has to depend on the fix, not merely follow
it. For the explanation category, see its own band criteria below.

---

## Category detail and worked anchors

Each category below shows both submission forms. The JUnit anchors illustrate the naming
convention Module 5 Lesson 5.2's assignment requires, drawn from
`modules/m6-arrays-collections/tests/ArrayStatsTest.java` and
`modules/m7-classes-objects/tests/BookTest.java` — two instructor-authored contract files
students read and run against, not files students submit. The table anchors illustrate the
form nearly every other module actually grades, drawn from those same modules' lesson Test
evidence sections.

### Normal case (5 pts)

The evidence uses the ordinary input the method or program was written to handle — a typical
array, a book with an unremarkable page count.

**JUnit form:**

```java
@Test
@DisplayName("findMax returns the largest value in a typical array")
void findMax_returnsNine_forTypicalArray() {
    int[] numbers = {4, 7, 2, 9, 1, 5};
    assertEquals(9, ArrayStats.findMax(numbers));
}
```

**Table form:**

| Tier | Array | Expected | Actual | Match? |
|------|-------|----------|--------|--------|
| **Normal** | `{5, 2, 8, 1, 9}` | `9` | `9` | Yes |

| Score | What the submission shows |
|-------|---------------------------|
| 0 | No normal-case evidence is present in either form. |
| 1–2 | Evidence exists, but the JUnit name does not state the claim, or the table's Expected/Actual columns are blank. |
| 3–4 | The evidence targets a typical input; the JUnit name states its claim, or the table row is filled in and consistent. |
| 5 | Meets the 3–4 criteria. The evidence also catches a plausible normal-case defect, such as a wrong loop bound or a swapped operand. |

### Boundary case (5 pts)

The evidence uses the smallest or edge input the method or program must still handle
correctly — one element, zero elements, the lowest accepted value.

**JUnit form:**

```java
@Test
@DisplayName("a shelf with no books reports a size of 0")
void size_returnsZero_forEmptyShelf() {
    Shelf shelf = new Shelf();
    assertEquals(0, shelf.size());
}
```

**Table form:**

| Tier | Array | Expected | Actual | Match? |
|------|-------|----------|--------|--------|
| **Boundary** | `{42}` | `42` — one element, and the loop body never runs | `42` | Yes |

| Score | What the submission shows |
|-------|---------------------------|
| 0 | No boundary-case evidence is present in either form. |
| 1–2 | Evidence exists, but its input is not actually the smallest or edge case for this method, or the table is incomplete. |
| 3–4 | The evidence uses a genuine edge input (one element, an empty collection, the lowest valid value), and the JUnit name states its claim, or the table row is filled in and consistent. |
| 5 | Meets the 3–4 criteria. The evidence also fails, or shows a mismatch, against an off-by-one traversal or a guard that wrongly excludes the edge value. |

### Failure case (5 pts)

The evidence uses the input that exposes a wrong assumption the code could plausibly make —
an all-negative array against a `findMax` that starts at `0`, a negative page count against a
setter that does not validate.

**JUnit form:**

```java
@Test
@DisplayName("findMax returns -1 for an all-negative array, not 0")
void findMax_returnsMinusOne_forAllNegativeArray() {
    int[] numbers = {-3, -5, -1, -8};
    assertEquals(-1, ArrayStats.findMax(numbers));
}
```

**Table form:**

| Tier | Array | Expected | Actual | Match? |
|------|-------|----------|--------|--------|
| **Failure** | `{-7, -3, -10}` | `-3` | `-3` | Yes |

| Score | What the submission shows |
|-------|---------------------------|
| 0 | No failure-case evidence is present in either form. |
| 1–2 | Evidence exists, but it repeats the normal case with different numbers instead of targeting a specific wrong assumption, or the table is incomplete. |
| 3–4 | The evidence targets a named, plausible wrong assumption; the JUnit name states its claim, or the table row is filled in and consistent. |
| 5 | Meets the 3–4 criteria. Every other tier's evidence would still pass, or show a Match, if the targeted misconception were present, so this is the one tier that catches it. |

### Explanation (5 pts)

The player states, in the lesson's Explanation section, what the evidence shows and why it
matters — not a restatement of the code. This category scores the same way regardless of
which submission form produced the evidence being explained.

| Score | What the submission shows |
|-------|---------------------------|
| 0 | No explanation is written. |
| 1–2 | The explanation describes the code's structure ("this method loops through the array") rather than what the test evidence demonstrated. |
| 3–4 | The explanation names which piece of evidence caught which mistake, and connects a Match? result (or an assertion result) to a specific claim about the code's behavior. |
| 5 | Meets the 3–4 criteria. The explanation also names the general misconception the failure case guards against, in language another student could apply to a different method. |

---

## Rubric table

| Category | 0 | 1–2 | 3–4 | 5 |
|----------|---|-----|-----|---|
| **Normal case** | No evidence present | Present, but incomplete in the assigned form | Genuine typical input, complete and consistent | Also catches a plausible normal-case defect |
| **Boundary case** | No evidence present | Present, but not a genuine edge case, or incomplete | Genuine edge input, complete and consistent | Also catches an off-by-one or wrong-guard defect |
| **Failure case** | No evidence present | Present, but repeats the normal case, or incomplete | Targets a named wrong assumption, complete and consistent | Is the one tier that would catch the targeted misconception |
| **Explanation** | Not written | Describes code structure only | Names which evidence caught which mistake | Names the general misconception in transferable language |

**Maximum score: 20**

---

## Score interpretation

| Range | Interpretation |
|-------|---------------|
| 18–20 | Complete evidence. All three tiers are load-bearing and the explanation transfers. |
| 14–17 | Complete evidence, with one tier or the explanation short of load-bearing. |
| 10–13 | At least two tiers are present but incomplete, or the explanation restates the code. |
| 5–9 | Only one or two tiers are present. |
| 0–4 | Little or no evidence submitted. |

---

## Minimum acceptance criteria

A submission must meet **all** of the following to pass minimum review, regardless of total
score:

```
Each of the three tiers — normal, boundary, and failure — is evidenced, in whichever form
  the lesson assigned: a named JUnit test method, or a completed Test evidence table row.
A JUnit test name follows method_expectedResult_forCondition, when the lesson assigns
  JUnit tests.
A Test evidence table row's Expected, Actual, and Match? columns are filled in and
  consistent with a real run, when the lesson assigns a table.
An explanation is written, addressing at least one specific result from the evidence.
```

If any item is missing, the submission does not meet the minimum standard.

---

## Checklist for graders

- [ ] Confirm which form this lesson assigned: JUnit tests, or a manually recorded table.
- [ ] A normal-case tier is evidenced in that form.
- [ ] A boundary-case tier is evidenced in that form, using a genuine edge input, not a
      second normal case.
- [ ] A failure-case tier is evidenced in that form, targeting a named, plausible wrong
      assumption.
- [ ] Where JUnit is the assigned form, every test name follows
      `method_expectedResult_forCondition`.
- [ ] Where a table is the assigned form, the Expected, Actual, and Match? columns are
      filled in for every row, with no blank cell, and match an actual run.
- [ ] The explanation states what the evidence shows, not only what the code does.
- [ ] The explanation, at the top band, names the misconception in language that would
      transfer to a different method.
