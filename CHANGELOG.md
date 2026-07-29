# Changelog

All notable changes to the CSC 151 course template are listed here.

The format follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).  
Instructors who forked an earlier version of this template can use this log to identify what has changed since their fork.

---

## [Unreleased]

*Changes that are complete but not yet tagged as a release.*

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
- **CLO-4 is no longer defined in terms of Swing.** It now reads "register a handler so that a user action executes a defined method, and explain the register-and-dispatch cycle." Swing's `ActionListener` is the graphical form of that cycle and is an optional enrichment path. This lets students working in a GitHub Codespace, which has no display, complete every graded task. See open question 4 in `docs/clo-mlo-map.md`.
- `docs/course-map.md`, `docs/clo-mlo-map.md`, and `docs/pacing-guide.md` rewritten for the new sequence, including the dependency diagram and both calendars.

### Added

- `scripts/verify.sh` — the course verifier, replacing compile-only checking. Subcommands: `compile`, `run`, `examples`, `test`, `all`. It compiles each file, runs examples, and compares real standard output against a recorded `.expected` file, with an optional `.stdin` fixture for programs that read input.
- `scripts/fetch-junit.sh` — installs the JUnit console runner into a gitignored `.tools/` directory. The jar is not committed, so forks stay small and the download is checksum-verified.
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
