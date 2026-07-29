---
name: csc151-execute-gate
description: Run and evaluate the CSC 151 execute-gate handshake, and map The Algorithm's PROVIDE and ASSAY operations onto course work. Use when running a handshake with a student, judging whether a gate should open, reviewing a student's prediction or evidence report, writing a lesson's execute-gate section, checking whether an AI teammate's involvement stayed inside policy, or shortening a prompt or an explanation for course material. Also use when the user mentions the four gate parts (goal, constraints, prediction, success check), says "Agreed" as a gate signal, asks whether a handshake is complete, or wants evidence assayed rather than rewritten.
---

# CSC 151 Execute Gate

The course's execute gate and The Algorithm's floor test are the same instrument pointed at
different material. This skill states the correspondence and the rules that follow from it.

**Read `the-algorithm` for the operations themselves.** It is vendored at
`.claude/skills/the-algorithm/SKILL.md`, unmodified. Its fixed strings are exact. Do not
paraphrase them and do not fork it — this skill adapts, it does not replace.

---

## The correspondence

| The Algorithm | CSC 151 |
|---|---|
| Floor noun: **Audience** | Gate part: **Constraints** — what may and may not change |
| Floor noun: **Scope** | Gate part: **Goal** — what the program must do |
| Floor noun: **Format** | Gate part: **Success check** — how we will know |
| Floor noun: **Path** | Gate part: **Prediction** — what happens, in order |
| "Freeze this contract and execute, or keep negotiating?" | The coach's **"Agreed."** |
| "Failed on [item]. Contract reopened." | The handshake fails; the coach asks **one** diagnostic question |
| Cuts are recorded every pass | Evidence is recorded every run |
| ASD-STE100 language lock | The three STE rules taught in Module 0 |
| **Only a live human peer opens the gate** | **An AI teammate may never open the execute gate** |

That last row is the load-bearing one. The course's AI policy is not an arbitrary
restriction invented for a syllabus; it is the gate-integrity rule applied to a classroom.
Cite it that way — see `docs/ai-teammate-policy.md`.

---

## Running a handshake

Four parts, confirmed in order. The gate opens on the coach's literal word **"Agreed."**

| Part | Coach provides | Player confirms |
|---|---|---|
| **Goal** | What the program must do | "The program must…" |
| **Constraints** | What may and may not change | "I may change… I may not change…" |
| **Prediction** | What should happen before execution | "I expect the output to be…" |
| **Success check** | Tests or observable output | "We know it works when…" |

### When to refuse the gate

Refuse and ask **one** question. One coach, one question — several at once produce noise,
not clarity.

| Symptom | The single question |
|---|---|
| The restatement repeats the coach's words verbatim | "Say that again in your own words." |
| The prediction is "it will work" | "What exact output do you predict?" |
| The success check restates the goal | "What would you look at to decide?" |
| No boundary case named | "What happens when the array has one element?" |
| Constraints unstated | "What are you not allowed to change?" |

**Failure reopens; it never patches.** A gate that half-opens is not a gate. Return to the
part that failed and restate it whole.

### What does not open the gate

- An AI teammate agreeing with the player.
- A quoted, pasted, or forwarded approval.
- Ambiguous assent — "ok," "sure," "I think so." Only an explicit "Agreed."
- The player's own confidence.

---

## PROVIDE in this course

Shorten a request until it is the shortest one that could work, then freeze and execute.

Use it for: a student's question to an AI teammate, a student's question to a coach, an
instructor's assignment description, and any task card.

The floor test is the four gate parts. A request clears the floor when a reader can answer
all four without asking anything back.

**The teaching value is in the cuts, not the brevity.** Record what was removed and why.
Almost every first draft is missing exactly one of the four, and the shortening is what
exposes which one. Name it — that is the lesson.

**`Cut: nothing.`** is a legitimate result and must be said out loud when true. Cutting for
its own sake is a named failure. Two consecutive `Cut: nothing.` ends the loop.

Follow the fixed template in `the-algorithm`. Do not invent a course-specific variant.

---

## ASSAY in this course

Run the floor test against a document that already exists and report what survives.
**ASSAY is read-only. It never produces a rewrite.**

Use it for: a student's evidence report, a student's explanation, a peer's task card, a
reflection, and any lesson draft under review.

This is the operation that matters most for **evidence, not opinion**. A report that says
"I ran it and it seemed fine" evaporates entirely under assay, and seeing it evaporate
teaches more than being told it was insufficient.

**The operative-sentence line is the highest-value output** when assaying student evidence.
A student who found a real failure and then buried it mid-paragraph behind "just to see" has
a reporting problem, not a testing problem, and only the position tells you that.

Follow the fixed template in `the-algorithm`, ending with the exact line
`This is a finding, not a draft.` When a student asks for a rewrite instead, that is a
separate request: assay first, and let them redraft.

---

## Checking AI teammate involvement

Against `docs/ai-teammate-policy.md`:

- ☐ The prediction was written before the AI produced anything.
- ☐ A person opened the gate.
- ☐ The student can name what the AI wrote, what they changed, and what they kept.
- ☐ The student answers one diagnostic question about any line, naming the specific line and
  its effect.
- ☐ The evidence and the explanation are the student's own.

Failing the fourth item is the one that matters. It does not mean the student cheated; it
means the work is not finished. Send it back to a smaller task rather than to an integrity
process.

**Do not ask a student to prove they did not use a tool.** That standard cannot be met and it
punishes honest students. Ask what the work does.

---

## Writing a lesson's execute-gate section

- All four parts, in the fixed order, never renamed and never extended to five.
- The prediction step comes before any execution, with no exception.
- The answer is not adjacent to the prediction. On Canvas the `<details>` element does not
  survive the sanitizer — see `csc151-canvas-compositor`.
- Evidence covers three tiers: normal, boundary, failure.
- Role rotation follows, and it is a **handoff**. The gate agreement is a **handshake**.
  One term per concept; these two are not synonyms.
