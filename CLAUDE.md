# CLAUDE.md — CSC 151 Java Programming I Template

Guidance for coding agents working in this repository. This is a **course template**, so
almost every file is instructional content read by students and instructors. Prose here is
the product, not documentation of the product.

---

## Before you change anything

Run the verifier and keep it green:

```
bash scripts/verify.sh all
```

Subcommands: `compile`, `run <file>`, `examples`, `test`, `all`. Install the JUnit runner
once with `bash scripts/fetch-junit.sh`. `scripts/check-java.sh` is a compatibility shim.

---

## The spine — do not renumber it

The course is **Module 0 through Module 8, plus an Appendix.** Nine modules exactly. The
delivery platform requires that count, so adding a tenth module is a breaking change, not a
convenience. Add depth inside a module instead.

Directories match the numbering: `modules/m0-getting-on-the-bus/`, `modules/m5-methods-and-testing/`,
`modules/appendix/`. Submodules are **files inside a module**, named `lesson-1-<slug>.md`,
`lesson-2-<slug>.md` — never extra directory levels.

`docs/course-map.md` is the authority on sequence. If you change the spine, that file, plus
`docs/clo-mlo-map.md` and `docs/pacing-guide.md`, change in the same commit.

---

## Writing rules (STE-100)

These are course content — Module 0 teaches them — so the course's own files must obey them.

1. **Active voice.** "The coach opens the gate," not "the gate is opened by the coach."
2. **One topic per sentence.** Split on "and" when the halves stand alone.
3. **One term for one concept.** No synonym drift.

Terminology that has already caused a bug here, so get it right:

| Term | Means | Not |
|------|-------|-----|
| **handshake** | The four-part agreement that opens the execute gate | "handoff," "agreement" |
| **handoff** | The role switch after a task completes | "handshake" |
| **coach** / **player** | The two roles | gendered or seniority terms |

**Banned words:** "simple," "easy," "obvious." Use "straightforward" or "bounded." They
discourage students who find the task hard.

**Idioms need a gloss.** Every sports phrase is paired with its literal meaning at the point
of use — this is a hard rule in `CONTRIBUTING.md` and `docs/instructor-guide.md`, and it
exists so the course does not exclude students from non-sports backgrounds. Never introduce a
new idiom without one.

**Never fabricate an attributed quotation.** Synthesized coaching sayings are labeled as
conditional and unattributed ("What the coach might say"). Do not attach a real person's
name to a sentence they did not say.

---

## The LPAA cycle

Every module runs four beats: **Learn**, **Practice**, **Apply**, **Assess**. Each has a second
name used with students, and **both names stay** — neither replaces the other:

| Beat | Course name | Lesson sections |
|------|------------|-----------------|
| Learn | Study the Play | Learning goal · Prior knowledge check · Concept explanation · Worked example |
| Practice | Run the Play | Trace before running · Repair or modify code |
| Apply | Team Practice | Execute-gate handshake · Small coding task · Test evidence · Explanation |
| Assess | The Big Game | Role rotation · Transfer task · Reflection · Mastery record |

Design documents use the LPAA names. Student-facing prose uses the course names, each with its
literal gloss on first use — they are football idioms and the idiom rule is not suspended for a
recurring one. `docs/course-map.md` is the authority.

**The no-new-plays rule:** *"We would never make you use a play in The Big Game that you
haven't run during practice until you understood it."* Nothing graded is the first appearance
of a skill. Before adding a requirement to an Assess beat, find the earlier Learn, Practice,
and Apply beats that cover it. If they do not exist, add them or move the requirement — never
patch it with an explanation inside the assessment.

---

## Structure that must not drift

**Every lesson uses this section order, complete and unreordered:**

Learning goal → Prior knowledge check → Concept explanation → Worked example → Trace before
running → Repair code → Execute-gate handshake → Small coding task → Test evidence →
Explanation → Role rotation → Transfer task → Reflection → Mastery record

**Every module README:** What this module covers → Learning goal → **The LPAA cycle in this
module** → Files table → Instructor facilitation notes (Before class / Common mistakes /
Accessible facilitation) → How this module connects to the next → closing homily with its
literal gloss.

The LPAA table names what the module's own four beats actually contain — the real trace, the
real repair, the real transfer task. A generic restatement of the cycle is not useful there;
`docs/course-map.md` already holds the general version.

**The execute gate is four parts** — goal, constraints, prediction, success check — in that
order. Never renamed, never a fifth. The gate opens on the coach's literal word "Agreed."

**Prediction always precedes execution.** Answers hide behind `<details><summary>` in the
repository. That element does not survive the Canvas sanitizer, so composed pages solve it
differently — see the compositor skill.

**Evidence has three tiers:** normal, boundary, failure.

---

## Java examples

Every example carries a header comment with the filename, module, course, and purpose,
followed by an `// Expected output:` block. Javadoc goes on non-trivial methods.

**Comments explain the misconception being prevented,** not the syntax. Write "Start with the
first element, not 0. Initializing to 0 gives the wrong answer for all-negative arrays,"
not "loop through the array."

**Every example needs a `.expected` file** holding its exact standard output, next to the
`.java` file. Examples that read input also need a `.stdin` fixture. Generate `.expected`
from a real run — never hand-write it, and never edit it to make a test pass. If output and
expectation disagree, one of them is a bug; find out which.

Unit tests live in `modules/<module>/tests/`. They are excluded from `verify.sh compile`
because they need JUnit on the classpath.

---

## Accessibility

- Mermaid uses `flowchart`, not `graph`.
- **Every diagram has a "Plain-text description:" paragraph.** No exceptions.
- Tables have headers. Code fences carry `java`.
- Information is never conveyed by color alone.
- Placeholders are `[SQUARE BRACKETS]`; fill-in blanks are `______`; forms use `☐`,
  checklists use `- [ ]`.

---

## Skills in this repository

| Skill | Use it for |
|-------|-----------|
| `csc151-canvas-compositor` | Turning Markdown into sanitizer-safe Canvas HTML |
| `csc151-execute-gate` | Running or judging a handshake; PROVIDE and ASSAY on course work |
| `the-algorithm` | The PROVIDE and ASSAY operations themselves — **vendored unmodified, do not edit** |

---

## When you finish

- `bash scripts/verify.sh all` passes.
- Relative Markdown links resolve.
- `CHANGELOG.md` has an `[Unreleased]` entry.
- Cross-references updated in `README.md`, `docs/course-map.md`, and the instructor guide if
  structure moved.
- The `.github/PULL_REQUEST_TEMPLATE.md` checklist is satisfied.

**Do not invent institution-specific policy.** Grading weights, integrity procedures, and
academic calendars belong to a fork, not to this template. Where a real decision is needed,
add it to the open-questions list in `docs/clo-mlo-map.md` rather than guessing.
