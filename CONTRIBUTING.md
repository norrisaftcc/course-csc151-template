# Contributing to CSC 151 Java Programming I Template

Thank you for helping improve this course template. This document explains how to contribute content, check quality, and coordinate with other contributors.

---

## Who can contribute

Anyone may contribute. You do not need to be a computer science educator. Useful contributions include:

- Fixing errors in Java examples.
- Improving the clarity of instructions.
- Adding new lesson modules.
- Improving accessibility of diagrams.
- Translating content.

---

## Before you start

1. Read the [Instructor Guide](docs/instructor-guide.md) to understand the coach/player model.
2. Read the [Rubric](docs/rubric.md) to understand what makes good educational content.
3. Check the [Course Map](docs/course-map.md) to understand where new content fits.

---

## How to contribute

1. Fork or branch the repository.
2. Make your changes.
3. Run the Java compile check: `bash scripts/check-java.sh`
4. Open a pull request. Describe what you changed and why.

---

## Content quality checks

Before submitting a pull request, verify each item below.

### Java code

- [ ] All `.java` files compile without errors (`bash scripts/check-java.sh`).
- [ ] Code uses straightforward Java appropriate for an introductory course.
- [ ] Expected output is included in comments or a companion file.
- [ ] No dependencies on paid services or institution-specific infrastructure.

### Lesson content

- [ ] The learning goal is observable (a student can do something, not just "understand" something).
- [ ] The execute gate is present: goal, constraints, prediction, and success check.
- [ ] A prediction step appears before any code execution.
- [ ] Evidence (output or test results) supports the conclusion.
- [ ] The player explains the result after execution.
- [ ] A transfer task appears at the end of the lesson.
- [ ] Role rotation (coach and player switch) is included.

### Diagrams

- [ ] Mermaid blocks use valid syntax that renders on GitHub.
- [ ] Every diagram has a text explanation so information is not only visual.

### Writing

- [ ] Sentences are short. Verbs are concrete. Headings are descriptive.
- [ ] Specialized terms are defined at first use or linked to the glossary.
- [ ] No slang that could exclude learners.
- [ ] "Snap the ball" is always paired with its literal meaning.
- [ ] Language is respectful and adult. No condescension.

### Accessibility

- [ ] Tables have headers.
- [ ] Code blocks use fenced markdown with the language identifier (` ```java `).
- [ ] Images have alt text where used.
- [ ] Information is not conveyed only by color.

---

## What not to include

- Proprietary text, exercises, or images from textbooks or other courses.
- Institution-specific grading policies (those belong in a fork, not the shared template).
- Paid tools, proprietary IDEs, or platform-specific instructions as requirements.
- Content that stereotypes or excludes learners.

---

## Attribution

If your contribution is based on or inspired by an existing source, note it in the pull request. All contributed content must be original or clearly in the public domain.

---

## Questions

Open an issue or start a discussion on GitHub. Keep questions specific so they can be answered clearly.
