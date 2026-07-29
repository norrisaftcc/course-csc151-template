# Changelog

All notable changes to the CSC 151 course template are listed here.

The format follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).  
Instructors who forked an earlier version of this template can use this log to identify what has changed since their fork.

---

## [Unreleased]

*Changes that are complete but not yet tagged as a release.*

### Changed

- **Reconciled the curriculum content with the instructor's answers to the open-questions list.** CLO-3, Module 0 credit, and CLO-4 are now marked Resolved with strikethrough, matching the document's own stated convention for closed items. CLO-5's rubric question is partially resolved: the point total is set (a lightweight rubric, four categories summing to 20), but the four categories themselves are not yet named, so no new rubric file was authored — inventing the category split would have been guessing at institution policy, which `CLAUDE.md` rules out. `rubric.md` is unaffected; it scores lesson and assignment design, a different artifact from a student test-evidence rubric.
- **JUnit 1.11.4 is the accepted version for this course.** The pin in `scripts/fetch-junit.sh` and its recorded SHA-256 describe that exact jar, so changing the version means re-recording the checksum. The script says so where the version is set.
- **The no-new-plays audit ran for the first time and found seven real violations, all repaired.** The rule has been stated since the LPAA theming landed; nobody had run it against the built modules until now. Each finding was a skill an Assess beat required with no earlier Learn, Practice, and Apply beat teaching it:
  - **M1's transfer task required `System.out.printf` before Module 2 teaches it.** `74.85000000000001` is what `74.85` actually prints from binary arithmetic, and the graded task's answer key patched this with an explanation of `%.2f` inside the assessment — exactly what the rule forbids. Repaired by changing the task's values so the graded computation lands on an exact double (`12 * 4.25 = 51.0`); the messy case moves to an optional, explicitly ungraded note in the Reflection beat that points forward to Module 2 rather than teaching printf early.
  - **M0's Apply and Assess beats both required naming a file to match its public class, with no Practice beat rehearsing it.** Repaired: the Repair beat now walks the exact compiler message before the graded task can produce it.
  - **M5 required writing a JUnit test from scratch with no beat that ever showed a test method's parts.** Repaired: lesson 5.2's Learn beat now dissects a real test method — its two imports, `@Test`, and the assertion — line by line before the Assess beat asks for one.
  - **M6 required `ArrayList` for the capstone with no module ever teaching it** — the only mention was a single sentence in a README's Learn row. Repaired: `RosterList.java` and its lesson content teach `add`, `get`, `size`, and the enhanced `for` before Module 8 needs them.
  - **M3, M4, and M7 did not exist,** so three more skills the capstone depends on — comparing `String` values with `.equals` rather than `==`, a sentinel-controlled loop, and writing a class that `implements` an interface — had no beat anywhere. Building the three modules closed all three; each carries an explicit note naming which later module depends on it and why.

### Added

- **The spine is now built end to end.** Every module the course map specifies exists as a directory: Module 0 through Module 8, plus the Appendix. The module count is unchanged — nine modules and an Appendix — and no module was renumbered.
- `modules/m3-conditionals/` — README, lesson, and three examples: `TicketPrice.java` (an `else if` chain read from the highest band down), `StringMatch.java` (`.equals` against `==` on `String` values), and `MenuSwitch.java` (`switch` with `break`). The `==`-on-`String` defect is taught, traced, and repaired here because Module 8 grades a dispatcher that fails in exactly that way.
- `modules/m4-loops/` — README, lesson, and three examples: `CountdownLoops.java` (`while` against `do-while` at zero iterations), `SumToN.java` (`for` with an accumulator), and `SentinelLoop.java` (a loop that ends on a sentinel value, with a `.stdin` fixture).
- `modules/m5-methods-and-testing/lesson-1-methods.md` and `lesson-2-testing-and-debugging.md` — the two submodules written out, plus `MethodBasics.java`. Lesson 5.2 takes `ScoreUtilsTest.java` apart one method at a time and names the three evidence tiers where they are first taught.
- `modules/m7-classes-objects/` — README, lesson, `Counter.java`, `Book.java` (with a `Shelf` class holding an `ArrayList<Book>`), and `tests/BookTest.java`.
- `modules/m8-events-and-capstone/` — README, both submodule lessons, `HandlerIntro.java` (an interface with two implementations), `EventDemo.java` (the register-and-dispatch cycle on a console calculator, with a `.stdin` fixture), and `tests/CommandDispatcherTest.java`. The console path is the graded path, so the whole module runs in a Codespace with no display.
- `modules/appendix/` — the reference module's README, composed from the documents in `docs/`, which stay the single source of truth.
- `modules/m2-input-output/examples/ScannerMixedInput.java` and `modules/m6-arrays-collections/examples/RosterList.java` and `tests/ArrayStatsTest.java` — the `nextLine`-after-`nextInt` symptom and its fix as a runnable program, an `ArrayList` example beside the array examples, and unit tests for the array algorithms.
- `.expected` fixtures for every new example, and `.stdin` fixtures for the three that read input. Each one was generated from a real run.

- `spikes/` — throwaway prototypes that answer one question each. Nothing in this directory is course content, and nothing is linked from a module.
- `spikes/execute-gate-teaser.html` — a single-file interactive teaser for the execute gate. It states the four-part handshake as behavior rather than prose: the page will not run the code until all four parts are on the board. It then takes a prediction, shows the recorded output, and names the gap — the three most common wrong predictions each get their own response, including `3.0`, which is the right value with the wrong type. No frameworks, fonts, scripts, or images are loaded from anywhere. Editing the handshake after running retracts the result, because revising a prediction with the answer on screen is the habit the page argues against. The page honours `prefers-reduced-motion`.
- The teaser uses **The Huddle** and **The Snap** as working names for the two sides of the execute gate, each with its literal meaning. They are pitch vocabulary rather than a proposal, and dropping them changes nothing in the course. They never rename **handshake**, which stays the name of the four-part agreement — that boundary is stated because this repository has already had one bug caused by drift between *handshake* and *handoff*. If they are worth keeping, it is as a worked example of the idiom rule rather than as course terminology.

### Changed — breaking

- **Reflowed the course to a nine-module spine: Module 0 through Module 8, plus an Appendix.** The delivery platform requires exactly eight numbered modules plus a Module Zero and an Appendix. The previous twelve-unit sequence (00–11) no longer matches it. Instructors who forked an earlier version must renumber. The mapping is:

  | Old | New |
  |-----|-----|
  | 00 Writing/Markdown/Mermaid + 01 Environment | Module 0 — Getting on The Bus (submodules 0.1, 0.2) |
  | 02 Variables and Expressions | Module 1 |
  | 03 Input and Output | Module 2 |
  | 04 Conditionals | Module 3 |
  | 05 Loops | Module 4 |
  | 06 Methods + 09 Testing and Debugging | Module 5 — Methods and Testing (submodules 5.1, 5.2) |
  | 07 Arrays and Collections | Module 6 |
  | 08 Classes and Objects | Module 7 |
  | 11 GUI/Event-Driven + 10 Final Project | Module 8 — Events and Capstone (submodules 8.1, 8.2) |

- Module directories renamed to match the spine: `modules/m0-getting-on-the-bus/`, `modules/m1-variables-expressions/`, `modules/m2-input-output/`, `modules/m6-arrays-collections/`.
- **Testing and debugging moved from the end of the course to Module 5, alongside methods.** A method is the first unit a student can test on its own, so JUnit now arrives when it becomes usable rather than in the same module as the capstone.
- **CLO-4 is no longer defined in terms of Swing.** It now reads "process a user event as a function call," which a console menu selection satisfies as fully as a Swing button press. This lets students working in a GitHub Codespace, which has no display, complete every graded task. See the Changed entry below for how curriculum review settled it.
- `docs/course-map.md`, `docs/clo-mlo-map.md`, and `docs/pacing-guide.md` rewritten for the new sequence, including the dependency diagram and both calendars.

### Added

- `scripts/verify.sh` — the course verifier, replacing compile-only checking. Subcommands: `compile`, `run`, `examples`, `test`, `all`. It compiles each file, runs examples, and compares real standard output against a recorded `.expected` file, with an optional `.stdin` fixture for programs that read input.
- `scripts/fetch-junit.sh` — installs the JUnit console runner into a gitignored `.tools/` directory. The jar is not committed, so forks stay small. `JUNIT_SHA256` is pinned to the SHA-256 of JUnit 1.11.4, recorded from a download that was verified against the checksum Maven Central publishes beside the jar. A download that does not match is deleted rather than installed.
- `.devcontainer/` — Codespaces and local dev container setup: JDK 21, the VS Code Java extension pack, and a post-create script that installs the test runner and runs a smoke check.
- `modules/m5-methods-and-testing/` — `ScoreUtils.java` and `ScoreUtilsTest.java`, demonstrating the `tests/` convention and the three required test tiers (normal, boundary, failure).
- `.expected` fixtures for every existing example, and a `.stdin` fixture for `ScannerDemo`.
- `modules/m0-getting-on-the-bus/lesson-3-work-surfaces-and-ai-teammate.md` — the two work surfaces, the verifier as the arbiter of what a program printed, the five AI teammate rules, and the floor test applied to a request. The transfer task is an assay: students report what survives in a classmate's request and hand back the finding, not a repaired version.
- `.claude/skills/csc151-canvas-compositor/` — composes Markdown into sanitizer-safe, inline-styled Canvas HTML. Ported from `csc134-canvas-compositor`: retargeted to Java escaping, remapped onto the course's fourteen-section lesson shape, and given two new voices — *Your AI Teammate* (monospace, because a machine emitted it) and *What The Coach Might Say* (sans and italic, because a machine did not). Coach sayings are synthesized and never attributed to a real person; the skill's self-check refuses to emit without the mandatory literal-meaning gloss.
- `.claude/skills/the-algorithm/` — vendored unmodified so the repository is self-contained. Its fixed strings are exact; it is not forked.
- `.claude/skills/csc151-execute-gate/` — maps The Algorithm's PROVIDE and ASSAY onto course work, and states the correspondence between its floor nouns and the four gate parts. The AI policy's central rule descends from its gate-integrity rule: only a live human opens the gate.
- `CLAUDE.md` — house style for coding agents working in this repository.
- `docs/ai-teammate-policy.md` — AI coding assistance is explicitly allowed. States the five rules, the disclosure standard, and the explain-any-line bar.
- `docs/prompting-your-ai-teammate.md` — the PROVIDE and ASSAY operations taught as student skills, with the four floor items mapped to the four parts of the execute gate.
- AI teammate disclosure section and a "Coaching an AI teammate" mastery row in `templates/coach-player-record.md`.
- Work-surface statement in the course map and in module READMEs: every graded task runs on a Codespace or a local machine.

### Changed

- **The LPAA cycle is themed, and both name sets are kept.** Learn / Practice / Apply / Assess gain the course names Study the Play / Run the Play / Team Practice / The Big Game. Neither set replaces the other: the LPAA names are the stable tokens used by design documents, outcome mapping, and the compositor dial; the course names are what students hear. The four course names are American football idioms and carry their literal meanings wherever they appear, per the repository's idiom rule.
- **The no-new-plays rule is now a stated design constraint.** *"We would never make you use a play in The Big Game that you haven't run during practice until you understood it."* It is written as something checkable rather than as a slogan: for every skill assessed in an Assess beat, an earlier Learn beat taught it, a Practice beat rehearsed it, and an Apply beat ran it with a coach. A skill that first appears in an Assess beat is a defect in the course, and the repair belongs to the author — add the missing beats, or move the requirement. Patching it with an explanation inside the assessment is the rule being broken quietly. `docs/instructor-guide.md` carries the audit procedure, and the compositor refuses to compose around a violation.
- Each module README gains a **"The LPAA cycle in this module"** table naming that module's real trace, real repair, and real transfer task, rather than restating the general cycle.
- `templates/lesson-template.md` marks where each beat begins, so new lessons inherit the mapping.

- **CLO-4 is resolved and no longer carries a caveat.** Curriculum review settled it: CLO-4 is fulfilled by **processing a user event as a function call**, and a console menu selection and a Swing button press are both accepted evidence. The console path is not the lesser one — no part of the grade is reserved for the graphical version. Swing is therefore an alternative path for students working locally, not optional enrichment, and submodule 8.2 carries no local-machine requirement. Open question 4 in `docs/clo-mlo-map.md` is struck through with the decision recorded, so a fork can see what was decided rather than only what remains open.

### Fixed

- **Lesson 0.1 used its own section names.** It carried "Trace before reading," "Repair the diagram," and "Small writing task," and it had no "Concept explanation" heading at all — its three parts sat directly under the lesson title. The fourteen sections are the four LPAA beats, so a renamed section is a beat that tooling and instructors cannot find. The canonical headings are restored, each with one line saying what the section holds in a lesson whose material is prose and diagrams rather than Java.
- **Five lessons reported evidence without the three tiers.** Lessons 0.1, 0.2, 1, 2, and 6 listed test rows with no tier named, so a student could report three normal cases and believe the section was finished. Each table now names **normal**, **boundary**, and **failure**, and each carries the one-paragraph note saying which tier is the informative one. The Module 2 failure tier is recorded rather than handled, and it says so — nothing in that module asks a program to survive bad input.
- **One diagram had no plain-text description.** The corrected Mermaid flowchart inside the Lesson 0.1 repair answers rendered without one. Every diagram carries one now.
- **The README described a repository that no longer exists.** Its structure block stopped at Module 6, it stated that Modules 3, 4, 7, 8 and the Appendix "are not yet built as directories," and it counted five sample modules. The block now lists every module directory, and the navigation table gains a module-by-module index.
- **`docs/course-map.md` gave Module 0 two to three class sessions.** Module 0 has three lessons since lesson 0.3 was added, and the 16-week calendar already gave it four sessions. The course map now says three to four, matching the module README and the pacing guide. Module 2's estimate matches its README for the same reason.
- **`docs/pacing-guide.md` still called the Swing path optional**, which contradicts the resolved CLO-4 recorded below. Swing is an alternative trigger for the same handler classes, and the console path carries full credit. Wording fixed in both calendars.
- **`docs/instructor-guide.md` listed three modules as the ones with facilitation notes.** Every module README carries them now, so the list names all ten.
- **Two banned words.** `docs/ai-teammate-policy.md` said a student "answers easily," and `templates/project-proposal-template.md` asked for a "simple text diagram." Module 0 teaches that these words discourage students who find the task hard, so the course's own files may not use them.

- **`verify.sh` could abort part-way through a run instead of reporting a failure.** `show_diagnostics` piped through `grep -v`, and `grep` exits 1 when it selects no lines — which is the normal case when a failing program wrote nothing to standard error, or wrote nothing but JVM `Picked up …` notices. Under `set -euo pipefail` that status ended the run: the file was marked FAIL, then the verifier exited before checking the remaining files and before printing the summary. A student would have seen a truncated list and no totals. Diagnostics printing can no longer change control flow, and a genuine `grep` error is reported rather than swallowed. Found in review.
- **Week 2 of the 16-week calendar listed two different sessions both numbered 4.** Module 0 needs four sessions once lesson 0.3 is included, so Modules 1 and 2 each now occupy a full week and Module 3 starts in the weeks 5–6 block, which already held most of its content. Sessions 1 through 8 are unique again. Found in review.
- **`docs/course-map.md` still described Swing as enrichment**, contradicting the resolved CLO-4 and the CHANGELOG entry below it. The paragraph was missed when open question 4 was closed. Both paths are now stated as equally accepted wherever CLO-4 is described. Found in review.

- **`FormattedOutput.java` printed a misaligned table.** The new verifier caught it on its first run: the separator rule was 38 characters while the data rows were 41, and the grand-total line was 40, so its number did not line up under the Total column. In an example whose purpose is teaching aligned output, that was a defect. The rule and the total now match the row width, and the documented output matches what the program actually prints.
- **`scripts/check-java.sh` is now a shim** that calls `verify.sh compile`, so older instructions and older forks keep working.
- **Resolved the handshake/handoff synonym drift.** `modules/00-ste-markdown-mermaid/README.md` had declared "handoff" the preferred term for the execute-gate agreement while every other document said "handshake," and called the two synonymous — in a course whose first lesson bans synonym drift. The two words now name different things: a **handshake** opens the gate, a **handoff** switches the roles. `docs/glossary.md` states the distinction.

---

## [1.1.0] — 2026-07-29

### Added

- `modules/01-environment/` — full lesson, README, and `HelloWorld.java` example for the Environment and First Program module.
- `modules/03-input-output/` — full lesson, README, `ScannerDemo.java`, and `FormattedOutput.java` for the Input and Output module.
- `modules/02-variables-expressions/assignment-01.md` — filled-in assignment example for Module 02.
- `modules/02-variables-expressions/lab-01.md` — filled-in lab example for Module 02.
- `modules/02-variables-expressions/assignment-metadata.yaml` — populated metadata for Module 02.
- `modules/07-arrays/assignment-metadata.yaml` — populated metadata for Module 07.
- `.github/workflows/check-java.yml` — GitHub Actions CI workflow that runs `scripts/check-java.sh` on every push or pull request that touches Java files.
- `docs/faq.md` — the 10 most common beginner Java errors with STE-formatted diagnosis and fix.
- `docs/pacing-guide.md` — 16-week and 8-week calendar templates mapping modules to weeks.
- `templates/project-proposal-template.md` — execute-gate proposal form for Module 10 final project.
- `CHANGELOG.md` — this file.
- `.github/PULL_REQUEST_TEMPLATE.md` — contribution checklist for pull requests.

### Changed

- Renamed `modules/01-variables-expressions/` → `modules/02-variables-expressions/` to match the Module 02 position in the course map.
- Renamed `modules/02-arrays/` → `modules/07-arrays/` to match the Module 07 position in the course map.
- Updated all cross-references in `README.md`, `docs/course-map.md`, `docs/instructor-guide.md`, `docs/student-guide.md`, and module-internal files to reflect the new directory names.
- Removed duplicate handoff flowchart from `modules/00-ste-markdown-mermaid/lesson.md`; replaced with a reference to `docs/workflow-diagrams.md`.

---

## [1.0.0] — 2025-01-01

### Added

- Initial template release.
- `README.md` with course overview, teaching model description, and navigation table.
- `CONTRIBUTING.md` with content standards.
- `docs/instructor-guide.md`, `docs/student-guide.md`, `docs/course-map.md`, `docs/glossary.md`, `docs/rubric.md`, `docs/workflow-diagrams.md`, `docs/clo-mlo-map.md`.
- `templates/lesson-template.md`, `templates/assignment-template.md`, `templates/lab-template.md`, `templates/rubric-template.md`, `templates/coach-player-record.md`, `templates/assignment-metadata.yaml`.
- `modules/00-ste-markdown-mermaid/` — orientation module for STE writing, Markdown, and Mermaid.
- `modules/01-variables-expressions/` (now `02-variables-expressions/`) — sample module for variables and expressions.
- `modules/02-arrays/` (now `07-arrays/`) — sample module for arrays.
- `scripts/check-java.sh` — lightweight Java compile check script.
