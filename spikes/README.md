# Spikes

A **spike** is a throwaway prototype built to answer one question. Spikes are not course
content. Nothing here is assigned to students, graded, or linked from a module.

Keep them here so a reviewer can see the idea working without it leaking into the course.

---

## What is in this directory

| Spike | Question it answers | Status |
|-------|--------------------|--------|
| [execute-gate-teaser.html](execute-gate-teaser.html) | What does the execute gate feel like as an interactive page rather than as prose? | For review |

---

## execute-gate-teaser.html

Open it in any browser, from disk or from a server. It loads nothing from anywhere: no
frameworks, no fonts, no scripts, no images. One file.

**What it demonstrates**

- The four-part handshake as a real constraint. The page will not let you run the code until
  all four parts are on the board, which is the rule stated as behavior rather than as prose.
- The prediction habit. You predict, then the recorded output appears, and the page names the
  gap between them. The three most common wrong predictions each get their own response.
- The house voice: STE-plain instruction, a labelled caution naming the common mistake, and a
  "What the coach might say" block that is conditional and unattributed.
- The design tokens from the Canvas compositor skill, so the tone matches composed pages.

**The diagram.** The course teaches Mermaid, and this diagram is a Mermaid `flowchart LR` —
but Mermaid is a JavaScript library, and the no-dependency rule rules it out. The SVG is the
same graph drawn by hand, and the page shows the Mermaid source next to it so the two can be
compared. A Canvas **tier three** artifact could render Mermaid natively; see the
`csc151-canvas-compositor` skill for what the tiers mean.

**Two working terms, not a proposal**

| Term | Working meaning | Literal meaning |
|------|----------------|-----------------|
| **The Huddle** | Everything before the gate: the four parts, stated and confirmed. Nothing runs. | In American football, players gather before a play to agree on what each of them will do. |
| **The Snap** | Everything after the gate opens: execute, report evidence, explain. | The snap is the moment the ball moves and the play starts. |

These are pitch vocabulary. **Drop them and nothing in the course changes** — they name the
two *sides* of the execute gate, and they never rename the **handshake**, which stays the name
of the four-part agreement itself. That boundary is stated because this repository has already
had one bug caused by synonym drift between *handshake* and *handoff*, and a third term
arriving without a stated boundary is how that happens again.

If they are worth keeping, it is as a **worked example of the idiom rule**: two sports phrases,
each paired with its literal meaning at the point of use, in a page a student would actually
read. That is the rule demonstrated rather than described, and it would belong in Module 0
rather than in the glossary.

Keeping them for that purpose means a `docs/glossary.md` entry stating the relationship to
*handshake*. Nothing here assumes that decision.

**What it does not do**

- It does not run Java. The output it shows is recorded, the same way every `.expected` file
  in this repository is recorded. The page says so.
- It is not sanitizer-safe, and pasting it into the Canvas rich content editor will destroy
  most of it. Composed pages are a different job — that is what the compositor skill is for.
- It is not accessible-audited beyond the basics. It carries a plain-text description, a
  `<title>` and `<desc>` on the diagram, labelled form fields, and no meaning carried by color
  alone. It has not been tested with a screen reader.

**How it was checked**

- Driven end to end in Chromium: the gate stays latched at two of four parts, opens at four,
  and the reset returns it to the latched state.
- Zero network requests recorded while loading and using the page.
- No horizontal scrolling at 390px wide.
- Every numeric claim on the page was produced by running Java, not from memory:
  `7 / 2` is `3`, `7 / 2.0` is `3.5`, `1 / 2` is `0`, `9 / 2` is `4`, and `7 / 0` throws
  `ArithmeticException`.
