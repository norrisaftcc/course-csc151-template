---
name: csc151-canvas-compositor
description: Compose CSC 151 Canvas pages and assignment descriptions from Markdown source into sanitizer-safe, inline-styled HTML in the CSC 151 house style, and decide whether an artifact ships as a Canvas page, a PDF, or a standalone HTML file. Use whenever preparing CSC 151 Java content for Canvas — writing or restyling a page or assignment description, converting a lesson or module README into something to paste into the Canvas HTML editor, adding callouts, checklists, code blocks, handshake panels, or flowcharts to course material, composing an Appendix page from a docs/ file, or working out how to get a Mermaid diagram into Canvas. Also use when the user mentions "the RCE," module pages, "Your AI Teammate" or "What The Coach Might Say" blocks, or says a Canvas page looks generic or boxy.
---

# CSC 151 Canvas Compositor

Forked from `csc134-canvas-compositor`. Same sanitizer knowledge, same emitter discipline,
different course and different language. Four substantive changes:

1. **The language is Java.** The escaping rule targets generics and lambdas, not
   `#include <iostream>`. See *Code and machine output*.
2. **The machine narrator is back, and it is not a character.** CSC 134 removed the parent
   skill's AI voice. CSC 151 has one — *Your AI Teammate* — because this course explicitly
   permits coding-assistant use and must show what advisory machine output looks like. See
   *Voice*.
3. **There is a coach voice, and it carries a hard safety rule.** See *What The Coach Might
   Say* — the rule is not stylistic.
4. **The beat model is the course's own 14-section lesson shape,** mapped onto LPAA. See
   *The dial*.

Mental model: **Markdown → Canvas page as document → InDesign.** The source supplies content
and structure. This skill supplies typographic decisions. No inventing a new visual device
per page.

---

## The dial

Every source document opens with one comment naming where in the course it sits and which
beat it is:

```
<!-- compositor: M5 · apply -->
```

That is the whole dial. Two facts the author already knows; everything else is derived.

The module numbers match the repository directories exactly — `modules/m5-methods-and-testing/`
is `M5`. The Appendix uses `AP`.

**Derived from the module number — which notation is in play:**

| Modules | Notation available | Diagram routing |
|---|---|---|
| **M0–M2** | Flowcharts, linear processes, the handshake exchange | Character diagram; native `<ol>`; sequence gutters |
| **M3–M5** | The above, plus trace tables, execution order, call stacks | Character diagram; ASCII trace table |
| **M6–M8** | The above, plus indexing, array layout, objects, event dispatch | Character diagram (chains only); SVG figure for anything with a hub |

Do not use notation from a later row. An M3 page that draws an object diagram is teaching M7
content in the wrong module. Refuse it and ask.

**Derived from the beat.** CSC 151 lessons have a fixed fourteen-section order. Those
sections group into the four LPAA beats, and the beat sets how much scaffolding the devices
carry:

| Beat | Course name | Lesson sections it covers | Register | Device consequences |
|---|---|---|---|---|
| **Learn** | Study the Plays | Learning goal · Prior knowledge check · Concept explanation · Worked example | Exposition | Prose-heavy. Code blocks are read, not typed. Longest of the four. |
| **Practice** | Run the Play | Trace before running · Repair code | Check | Very short. Usually no breakouts at all. Predictions stay hidden — see *Predictions*. |
| **Apply** | Team Practice | Execute-gate handshake · Small coding task · Test evidence · Explanation | Instructor-led walkthrough | Numbered `<ol>` steps carry the page. The handshake panel is mandatory and comes before any code. |
| **Assess** | The Big Game | Role rotation · Transfer task · Reflection · Mastery record | Contract | Terse. Task statement first. Numbered requirements. Pre-flight checklist mandatory. |

**The dial takes the LPAA name, not the course name.** `<!-- compositor: M5 · apply -->`, never
`· team-practice`. The instructional names are the stable tokens; the course names are prose.

**Emit the course name in the page kicker, and the LPAA name nowhere in the body.** A student
reads "Module 5 · Team Practice". The word *Apply* is a design term and does not appear on
student-facing pages. Both names live in `docs/course-map.md`, which is where an instructor
reads the mapping.

**Every course name needs its gloss on first use per page** — they are all American football
idioms, and the repository's idiom rule is not suspended for a recurring one. The kicker does
not count as a use, because a kicker is a label rather than a sentence. If the body copy says
"in The Big Game," the literal meaning follows it.

**The no-new-plays rule constrains what an Assess page may contain.** Nothing graded may be
the first appearance of a skill. If composing an Assess beat surfaces a requirement that no
earlier beat taught, that is a defect in the source — stop and report it rather than writing
around it with an explanatory aside. An aside that teaches a skill inside The Big Game is the
rule being broken quietly.

**The Make gradient** lives in the Apply row and nowhere else: code blocks are complete and
typed verbatim (M0–M2), 80% complete with a marked gap (M3–M6), or absent (M7–M8).

---

## Step 1: pick the delivery tier

| Tier | What it is | Sanitizer applies |
|---|---|---|
| **One** | Canvas page or assignment description, pasted into the RCE | Yes — all eight rules |
| **One (quiz)** | Canvas quiz question field | Yes, per question, and **no wrapper** — every `<pre>` carries its full inline style |
| **Two** | PDF handout | No. Print design. |
| **Three** | Standalone HTML in Course Files | No — the content domain is sandboxed, so **Mermaid renders there** |

Tier three is the escape hatch for anything genuinely interactive or diagram-heavy. Decide it
in advance, not after a tier-one page fails.

---

## Canvas page and assignment rules

Canvas sanitizes on save. Violations are silently destroyed:

1. **Inline `style` attributes only.** No `<style>`, no `<link>`, no `@media`. This is the
   email-HTML problem.
2. **No `<script>`.** No client-rendered anything.
3. **System fonts only.** Font stacks must degrade.
4. **No inline `<svg>`.** Diagrams ship as `<img>`.
5. **Sections start at `<h2>`.** Canvas renders the title as the `<h1>` outside the content
   area, and nothing in the body repeats it.
6. **No fixed pixel widths.** The Canvas Student app renders in a ~375px webview. Use
   `max-width` and percentages; wrap tables in `<div style="overflow-x:auto">`.
7. **Never set `background-color` without also setting `color`,** or vice versa. Students on
   Canvas's high-contrast setting get half the declaration.
8. **No `<details>`/`<summary>`.** It does not survive the sanitizer in this instance.
   Grounded, not assumed.

Rule 8 has a specific consequence in this course. See *Predictions*.

### Compose only what Canvas doesn't already render

**Never in the HTML:** due dates, points possible, availability windows, submission type,
next/previous navigation, the page or assignment title.

**Always in the HTML:** the task, the constraints, the worked reasoning, what is explicitly
out of scope, the named common mistake, and — on any page with an Apply beat — the
execute-gate handshake.

---

## Predictions

The repository hides prediction answers behind `<details><summary>` so a student records an
answer before seeing one. **That element does not survive the Canvas sanitizer.** A page that
relies on it silently reveals every answer.

Three workable routes, in order of preference:

1. **Move the answer off the page.** The prediction stays; the answer lives in the following
   Canvas page, or in the instructor's copy only. Best for Practice beats.
2. **Make it a quiz question.** Canvas quizzes hide the answer natively and record the
   student's response, which is what the prediction step is actually for.
3. **Ship it as tier three** if a page genuinely needs inline disclosure.

Never emit a prediction and its answer adjacent in tier-one HTML, and never emit an
instruction telling a student not to scroll. Design the reveal, do not request restraint.

---

## Placeholders

Canvas relinks only references inserted through the RCE. A hand-written `src` or internal
`href` survives a course copy still pointing at last term's course. So emit loud placeholders
and wire them in the RCE.

| Target | Placeholder | Insert with |
|---|---|---|
| Image | `src="UPLOAD-PENDING-figure-01.svg"` | RCE image tool |
| Course file (handout, rubric) | `href="#LINK-PENDING-slug"` | RCE **Course Documents** |
| Another Canvas page or assignment | `href="#LINK-PENDING-slug"` | RCE **Course Links** |
| External URL (docs.oracle.com, GitHub) | the real URL | type it |

Every placeholder link carries a visible marker:

```html
<a href="#LINK-PENDING-ai-teammate-policy" style="color:#0374B5;">AI Teammate Policy</a> <span style="font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;color:#9A6700;">[LINK PENDING]</span>
```

Delete the marker when the link is wired. Adjacent placeholder links may share one marker
stating the count: `[2 LINKS PENDING]`. The invariant: marker counts sum to the number of
placeholder links on the page. Every emitted fragment ships with `PLACEHOLDERS.md`.

---

## Design tokens

| Role | Value | Use |
|---|---|---|
| ink | `#16191D` | headings, code text |
| body | `#3C4149` | body text (set on wrapper) |
| muted | `#6B7280` | labels, captions, checkbox borders |
| rule | `#DFE3E8` | hairlines, table rows, default gutters |
| wash | `#F4F6F7` | code, diagram, and panel backgrounds |
| accent | `#1F6F5C` | kickers, sequence gutters, source-document gutters, AI teammate |
| caution | `#9A6700` | caution gutters and labels, placeholder markers |
| link | `#0374B5` | links only — Canvas blue, and it stays that way |

Mono stack: `ui-monospace,SFMono-Regular,Menlo,Consolas,monospace`

**Accent no more than three times per page,** counting distinct *roles*, not occurrences.

### Reskinning the accent

The course may adopt a crimson team palette. The accent is the only token that should move,
and moving it has two constraints that are not negotiable:

- **Crimson must not be the caution color, and must not sit next to it.** A red accent beside
  `#9A6700` reads as two severities of warning. If the accent goes crimson, the caution token
  moves to a color that cannot be mistaken for it, and both are retested together.
- **Contrast is checked, not assumed.** Accent text appears at `.7rem` in uppercase labels.
  A crimson that passes at body size can fail there. Verify against the wash `#F4F6F7` and
  against white before committing the change.

Do not reskin token-by-token in individual pages. Change the table, then recompose.

---

## The wrapper trick

Put every inheritable property on one wrapper `<div>` and let it cascade. Children carry only
non-inheritable properties: background, border, padding, margin, display.

```html
<div style="max-width:52rem;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Lato,Helvetica,Arial,sans-serif;color:#3C4149;font-size:1rem;line-height:1.65;">
  ...content...
</div>
```

---

## Voice

Voice arrives settled in the source. The compositor's only job is to make voice shifts
visible. CSC 151 has five voices.

| Voice | Device | Why |
|---|---|---|
| **Instructor teaching** (default) | Plain body copy, no device | It's the page's register. A box would imply it's optional. |
| **Instructor out of character** — support, policy, the human talking | Hairline gutter, muted mono label, **plain sans prose** | The frame drops and the design drops with it. Never decorated. |
| **Machine output** — compiler, program, verifier | Left-rule `<pre>`, wash | Authoritative. This is what the computer actually said. |
| **Your AI Teammate** — advisory assistant output | Accent gutter, mono label, **mono body**, no wash | Monospace means *a machine emitted this text*. |
| **What The Coach Might Say** — synthesized coaching aphorism | Hairline gutter, muted mono label, **plain sans prose, italic** | Not machine output. A human register, so it must not be monospace. |

**The monospace rule is load-bearing.** In this course monospace means a machine emitted the
text. That is why the coach voice is sans and the AI voice is mono, and it is why neither can
borrow the other's device.

**The two-machines rule.** A gray-rule `<pre>` is authoritative compiler or program output. A
green-gutter mono block is the AI teammate, and it is advisory. A student must be able to
tell at a glance which one is a fact. Never put AI output in a `<pre>`.

### Instructor out of character

```html
<div style="border-left:2px solid #DFE3E8;padding-left:1rem;margin:0 0 1.4rem;">
  <p style="margin:0 0 .25rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;letter-spacing:.1em;text-transform:uppercase;color:#6B7280;">Instructor &middot; out of character</p>
  <p style="margin:0;">Plain prose. Real support. Real policy.</p>
</div>
```

### Your AI Teammate

```html
<div style="border-left:2px solid #1F6F5C;padding-left:1rem;margin:0 0 1.4rem;">
  <p style="margin:0 0 .3rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;letter-spacing:.1em;text-transform:uppercase;color:#1F6F5C;">Your AI teammate &middot; suggestion</p>
  <p style="margin:0 0 .3rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.9rem;line-height:1.55;">One observation about the code. Then one flat imperative check the student performs themselves.</p>
  <p style="margin:0;font-size:.8rem;color:#6B7280;">You confirm this. It does not open the gate.</p>
</div>
```

Reading flow, not a breakout — no wash, no enclosure, so it doesn't spend the breakout budget.
It does spend an accent role.

**Rules, all of them enforced by the self-check:**

- **The closing line is mandatory and fixed in meaning:** the student verifies, and the AI
  does not open the execute gate. This is course policy, not decoration — see
  `docs/ai-teammate-policy.md`. Reword it to fit the sentence, never drop it.
- **Never in an Assess beat.** Assessment is the student's own work.
- **At most one per Apply stage, two per page elsewhere.**
- **Nothing load-bearing goes in this block.** If a student who skipped it cannot finish the
  task, it belongs in body copy or a caution. The AI voice is always skippable.
- The register is understated and concrete. It observes and checks. It does not encourage,
  congratulate, or apologize.

### What The Coach Might Say

```html
<div style="border-left:2px solid #DFE3E8;padding-left:1rem;margin:0 0 1.4rem;">
  <p style="margin:0 0 .25rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;letter-spacing:.1em;text-transform:uppercase;color:#6B7280;">What the coach might say</p>
  <p style="margin:0 0 .3rem;font-style:italic;">&ldquo;The short saying goes here.&rdquo;</p>
  <p style="margin:0;font-size:.85rem;">Literal meaning: the same idea stated plainly, in one sentence, with no figurative language.</p>
</div>
```

**This block carries a safety rule that overrides style.**

1. **The quote is synthesized. It is never attributed to a real person.** The label is
   literally *What the coach might say* — conditional, unattributed, and it stays that way.
   Never emit a name, never emit "as Coach X said," never emit a date or a source. Composing
   a sentence a real living person did not say and presenting it as theirs is fabrication,
   and the fact that a course is the venue does not change that.
2. **The literal-meaning line is mandatory.** `CONTRIBUTING.md` requires every idiom to be
   paired with its plain meaning, and `docs/instructor-guide.md` bans slang that excludes
   students from non-sports backgrounds. A coach block without its gloss violates both.
   Emit the gloss or drop the block.
3. **Nothing load-bearing.** The saying is a mnemonic for something the body copy already
   said. A student who skips every coach block must still be able to complete the page.
4. **At most one per page.** Two make it a motif; the register stops being a note and starts
   being the voice of the course.
5. **The gloss is plain, not another idiom.** "Play the next down" is not a gloss for "next
   play, next play." State the instruction.

Sayings already glossed in the repository — reuse these rather than inventing new ones:
the throw-ahead homily, "snap the ball only when both sides are ready," "the smallest useful
hint," "evidence, not opinion," "fix the model before fixing the code," "one coach, one
question," and "you are either on the bus or off the bus." Their glosses are in
`docs/instructor-guide.md` and `docs/ai-teammate-policy.md`.

---

## Reading flow or breakout

Every block is one or the other, and that's always the design question.

**Reading flow.** The reader passes through without stopping: body copy, headings, lists,
steps, tables, asides, cautions, sequence gutters, the instructor device, the AI teammate,
the coach. These get **a left rule plus a monospace label** — never an enclosing box. The
label always carries information. If you can't write a truthful label, drop the device and
use a plain paragraph.

**Breakout.** The reader stops, treats it as an object, and returns: code, diagrams,
checklists, worked examples, the handshake panel. These get an enclosure.

- **Three to five breakouts per page.**
- **In an Apply walkthrough the unit is the stage, not the block.** One breakout group per
  stage — the code to type, the output it should produce, and at most one AI check-in —
  counts as one. Ceiling is five stages.
- **Every breakout must be skippable,** except the handshake panel, which is the one
  deliberate exception: the Apply beat does not proceed without it.
- **Never two breakouts in a row** without body copy between them.
- **The enclosure style is the type signal.** Three styles, three meanings. Don't mix them.

### The three breakout styles

| Style | Means | Spec |
|---|---|---|
| Left rule, no radius, wash | **Code or machine output** — part of the argument | `border-left:2px solid #DFE3E8` |
| Full border, radius 6, wash | **Diagram** — an object you look at | `border:1px solid #DFE3E8;border-radius:6px` |
| Full border, radius 4, wash | **Panel** — checklist, summary, worked example, handshake | `border:1px solid #DFE3E8;border-radius:4px` |

---

## Component vocabulary

### Page header — kicker, lede, hairline

Pages only. **No `<h2>` title** — Canvas already renders the title as the `<h1>`.

```html
<p style="margin:0 0 .5rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.72rem;letter-spacing:.14em;text-transform:uppercase;color:#1F6F5C;">Module 5 &middot; Team Practice</p>
<p style="margin:0 0 1.4rem;font-size:1.1rem;">One or two sentences on why this page exists and what the student will be able to do after it.</p>
<hr style="border:0;border-top:1px solid #DFE3E8;margin:0 0 1.6rem;">
```

### The execute-gate handshake panel

The one component unique to this course. **Mandatory on every page with an Apply beat, and it
comes before any code the student runs.**

```html
<div style="background-color:#F4F6F7;color:#3C4149;border:1px solid #DFE3E8;border-radius:4px;padding:1rem 1.1rem;margin:0 0 1.4rem;">
  <p style="margin:0 0 .6rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;letter-spacing:.1em;text-transform:uppercase;color:#6B7280;">Execute-gate handshake</p>
  <p style="margin:0 0 .6rem;font-size:.9rem;">State all four to your coach. The gate opens when your coach says &ldquo;Agreed.&rdquo;</p>
  <div style="overflow-x:auto;">
    <table style="width:100%;border-collapse:collapse;font-size:.92rem;">
      <thead>
        <tr><th style="text-align:left;padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;color:#16191D;">Part</th><th style="text-align:left;padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;color:#16191D;">You say</th></tr>
      </thead>
      <tbody>
        <tr><td style="padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;">Goal</td><td style="padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;">&ldquo;The program must&hellip;&rdquo;</td></tr>
        <tr><td style="padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;">Constraints</td><td style="padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;">&ldquo;I may change&hellip; I may not change&hellip;&rdquo;</td></tr>
        <tr><td style="padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;">Prediction</td><td style="padding:.4rem .5rem;border-bottom:1px solid #DFE3E8;">&ldquo;I expect the output to be&hellip;&rdquo;</td></tr>
        <tr><td style="padding:.4rem .5rem;">Success check</td><td style="padding:.4rem .5rem;">&ldquo;We know it works when&hellip;&rdquo;</td></tr>
      </tbody>
    </table>
  </div>
</div>
```

The four rows are fixed. Do not reorder them, do not rename them, and do not add a fifth.

### Aside — the default reading-flow device

```html
<div style="border-left:2px solid #DFE3E8;padding-left:1rem;margin:0 0 1.4rem;">
  <p style="margin:0 0 .25rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;letter-spacing:.1em;text-transform:uppercase;color:#6B7280;">Note</p>
  <p style="margin:0;">Body of the aside.</p>
</div>
```

### Caution — same shape, `#9A6700` on rule and label

Never signal by color alone; the word *Caution* does the work. **Label the common mistake as
common.** One caution per page.

### Code and machine output

```html
<pre style="margin:0 0 1.4rem;padding:.85rem 1rem;background-color:#F4F6F7;color:#16191D;border-left:2px solid #DFE3E8;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.85rem;line-height:1.5;overflow-x:auto;">code here</pre>
```

**Escape `<` and `>` as `&lt;` `&gt;`.** In Java the cases are generics (`ArrayList<String>`,
`Map<String, Integer>`), lambda arrows (`->`), and every relational operator in a loop
condition (`i < numbers.length`). That last one appears in nearly every M4 and M6 example.
Check it programmatically; do not eyeball it.

**Show the error before they hit it.** Error text gets the code device, and the sentence
after it says what the compiler is actually complaining about. The ten errors in
`docs/faq.md` are the canonical set.

### Verifier output

Verifier output is machine output — the `<pre>` device, gray rule. It is never the AI
teammate device, because `verify.sh` is authoritative.

```html
<pre style="margin:0 0 1.4rem;padding:.85rem 1rem;background-color:#F4F6F7;color:#16191D;border-left:2px solid #DFE3E8;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.85rem;line-height:1.5;overflow-x:auto;">$ bash scripts/verify.sh examples

PASS  modules/m5-methods-and-testing/examples/ScoreUtils.java

Results: 1 passed, 0 failed</pre>
```

### Steps

A real `<ol>`, restyled for spacing. Inline CSS can't reach `::marker`; don't fake numbered
badges. **Number requirements so feedback can cite them.**

### Checklists

No `<input>`, no Unicode `☐` — draw the box, sized in `em` so it scales with the text.

```html
<li style="margin:0 0 .45rem;list-style:none;"><span style="display:inline-block;width:.85em;height:.85em;border:1px solid #6B7280;border-radius:2px;margin-right:.5em;vertical-align:-.05em;"></span>The thing to confirm.</li>
```

Bullets describe; checkboxes commit. Use checkboxes only where the student is meant to act.

### Panel

```html
<div style="background-color:#F4F6F7;color:#3C4149;border:1px solid #DFE3E8;border-radius:4px;padding:1rem 1.1rem;margin:0 0 1.4rem;">
  <p style="margin:0 0 .5rem;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;letter-spacing:.1em;text-transform:uppercase;color:#6B7280;">Before you submit</p>
  ...
</div>
```

Every Assess beat ends with one of these.

### Mastery record

The mastery table closes an Assess beat. A plain hairline table, wrapped for narrow screens,
with drawn checkboxes in the cells. Never a nested list.

---

## Diagrams

Mermaid is JavaScript and does not render on tier one. There it is a *source* format, not an
output format. It renders natively on tier three.

**Authorship decides the device.** If the student only reads the diagram, ship a character
diagram or an SVG figure. If the student writes the notation — which they do in M0, where
Mermaid is taught — ship the Mermaid source in a code block. If both, ship the character
diagram and the source, with prose between them.

**Character diagrams:** 24–28 columns comfortable, 40 hard ceiling. All box rows exactly
equal width. **Always accompanied by a three- or four-sentence prose statement of the
logic** — this is an accessibility cost paid deliberately, and the prose is what pays it.
The repository requires a "Plain-text description:" paragraph on every Mermaid diagram for
the same reason; carry that requirement into the composed page.

**Never character-diagrammed:** wireframes, screenshots, state machines, parallel-track
architecture, and anything with a hub. Those go to SVG.

---

## Composing an Appendix page from `docs/`

The Appendix module is **composed from `docs/`, never authored separately.** Those files are
the single source of truth, so a definition cannot disagree with itself.

1. Read the source file. Do not edit it.
2. Compose it at tier one with the beat set to `learn` and the module set to `AP`.
3. **Record provenance** at the foot of the composed page:

```html
<p style="margin:1.6rem 0 0;font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.7rem;color:#6B7280;">Composed from docs/glossary.md &middot; commit abc1234</p>
```

4. Note the source path and commit in `PLACEHOLDERS.md` alongside the link list.

**Staleness check before recomposing:** `git log -1 --format=%h -- docs/<file>.md`. If the
short hash differs from the one on the page, the page is stale. If it matches, do not
recompose — an unchanged source that produces a different page means the compositor drifted,
and that is a bug to investigate, not to paper over.

Never copy Appendix prose back into a module page. Link to it.

---

## Workflow

1. Read the dial comment. Derive notation row and beat.
2. Pick the delivery tier.
3. Identify voices present in the source. Do not invent voice shifts the source doesn't have.
4. Map the source's sections onto the beat's device budget.
5. Decide reading flow or breakout for every block. Count the breakouts.
6. Emit the wrapper, then the content.
7. Run the self-check below.
8. Emit `PLACEHOLDERS.md` alongside the fragment.

---

## Self-check before emitting

**Sanitizer**

- No `<style>`, `<link>`, `@media`, `<script>`, inline `<svg>`, `<details>`, or `<summary>`.
- No fixed pixel widths. Tables wrapped in `overflow-x:auto`.
- Every `background-color` paired with a `color`, and the reverse.
- Sections start at `<h2>`. No `<h1>` anywhere.
- Every `<` and `>` inside `<pre>` escaped — checked programmatically, including every loop
  condition.

**Voice**

- Nothing in monospace that a machine did not emit.
- The coach block is sans and italic, never mono.
- AI teammate output is not in a `<pre>`.
- Every AI teammate block carries its closing verification line.
- No AI teammate block in an Assess beat.
- **Every coach block has its literal-meaning gloss.**
- **No coach quote is attributed to any named person.** No name, no source, no date.
- Neither the coach nor the AI block carries anything load-bearing.

**Budget**

- Three to five breakouts, or five stages in an Apply walkthrough.
- No two breakouts adjacent.
- Accent used in at most three distinct roles.
- At most one caution. At most one coach block.

**Content**

- No due dates, points, availability, submission type, navigation, or title in the body.
- Apply beat has the handshake panel, and it precedes any runnable code.
- Assess beat ends with a pre-flight panel.
- The kicker carries the course beat name; the word *Learn*, *Practice*, *Apply*, or *Assess*
  appears nowhere in the body.
- Every course beat name used in a sentence carries its literal-meaning gloss on first use.
- No Assess page introduces a skill for the first time.
- Every diagram has its plain-text description.
- Predictions and their answers are never adjacent on a tier-one page.
- Placeholder marker counts sum to the number of placeholder links.
- `PLACEHOLDERS.md` is present.

**STE**

Run the three Module 0 rules over all body copy — they are course content, so the course's
own pages must obey them:

- Active voice.
- One topic per sentence.
- One term per concept: **handshake** for the gate agreement, **handoff** for the role
  switch. These are not synonyms.
- No "simple," "easy," or "obvious." Use "straightforward" or "bounded."

---

## Deferred

Unresolved, recorded rather than guessed:

1. **The crimson palette.** The accent may move to a team color. The caution-color collision
   and the small-size contrast check are specified above, but no palette has been chosen, so
   nothing has been retested.
2. **Where the Swing enrichment track lives.** GUI work is optional and local-only. Whether
   the optional path is a separate Canvas page or an aside inside the M8 page is not settled.
