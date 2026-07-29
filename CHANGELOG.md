# Changelog

All notable changes to the CSC 151 course template are listed here.

The format follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).  
Instructors who forked an earlier version of this template can use this log to identify what has changed since their fork.

---

## [Unreleased]

*Changes that are complete but not yet tagged as a release.*

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
