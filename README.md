# CSC 151 Java Programming I — Course Template

A reusable, open course framework for community college students learning introductory Java.

> **Status:** Initial template — ready to adapt and extend.  
> **License:** MIT  
> **Attribution:** This design is inspired by general interactive-learning patterns (including the activity shape of Runestone-style courses). All content is original. This is not an official Runestone Academy course.

---

## What this repository is

This repository gives instructors and students a starting framework for a first Java programming course. It includes:

- A **coach/player teaching model** with explicit handshakes.
- An **execute gate** — a shared handshake before running or submitting code.
- **Simplified technical English** so explanations are clear to every reader.
- **Mermaid diagrams** that render on GitHub.
- **Original Java examples** with expected output, checked automatically.
- A **course verifier** that compiles each example, runs it, and compares what it prints against a recorded expectation.
- An **AI teammate policy**: coding assistants are explicitly allowed, with a clear standard for honest use.
- Reusable **templates** for lessons, labs, assignments, and rubrics.
- **Five sample modules** demonstrating the full lesson cycle.
- A **dev container** so a Codespace is ready with no setup.

---

## Who this is for

| Role | How to use this repository |
|------|---------------------------|
| **Instructor** | Copy the repository, adapt the course map, customize modules, and follow the instructor guide. |
| **Student** | Start with the student guide, then follow the module lessons in order. |
| **Contributor** | Read `CONTRIBUTING.md` before adding content. |

---

## The teaching model in one paragraph

Every lesson uses a **coach/player** structure. Before a student (the *player*) runs or submits code, the student and instructor (the *coach*) complete a short handshake called the **execute gate**. The player states the goal, the constraints, a prediction, and the success check. The coach confirms each one. When both agree, the gate opens and work begins. After execution, the player reports evidence, explains the result, and the two roles switch so the player practices coaching as well.

The shorthand for completing the gate is **"snap the ball"** — meaning both sides are ready and play begins. (This phrase comes from American football, where snapping the ball starts a play. You do not need to know football to use this course. The full literal meaning is always provided alongside the shorthand.)

---

## A core homily

> **"You don't throw where they're standing; you throw where they're going to be."**

Instruction should prepare students for their *next* achievable move, not only correct their current position. Plan each lesson to open the door to the one after it.

---

## Repository structure

```
course-csc151-template/
├── README.md                         # This file
├── CONTRIBUTING.md                   # How to add or improve content
├── CHANGELOG.md                      # Version history for instructors who forked this template
├── LICENSE                           # MIT
├── .github/
│   ├── workflows/
│   │   └── check-java.yml            # CI: compiles, runs, and tests Java examples
│   └── PULL_REQUEST_TEMPLATE.md      # Contribution checklist for pull requests
├── docs/
│   ├── instructor-guide.md           # Coach/player dynamics, facilitation
│   ├── student-guide.md              # How to work through a lesson
│   ├── course-map.md                 # Recommended topic sequence
│   ├── clo-mlo-map.md                # Course and module learning outcome mapping
│   ├── glossary.md                   # Key terms defined
│   ├── rubric.md                     # How to evaluate educational content
│   ├── workflow-diagrams.md          # Mermaid diagrams for the full workflow
│   ├── faq.md                        # 10 most common beginner Java errors
│   └── pacing-guide.md               # 16-week and 8-week calendar templates
├── templates/
│   ├── lesson-template.md            # Blank lesson structure
│   ├── assignment-template.md        # Blank assignment structure
│   ├── lab-template.md               # Blank lab structure
│   ├── rubric-template.md            # Blank rubric
│   ├── coach-player-record.md        # Activity record form
│   ├── assignment-metadata.yaml      # YAML schema for assignment metadata
│   └── project-proposal-template.md  # Module 8 final project proposal form
├── modules/                          # Module 0 through Module 8, plus the Appendix
│   ├── m0-getting-on-the-bus/        # Orientation: STE writing, Markdown, Mermaid,
│   │   ├── README.md                 #   environment, first program, AI teammate
│   │   ├── lesson-1-writing-and-diagrams.md
│   │   ├── lesson-2-environment-and-first-program.md
│   │   └── examples/
│   │       └── HelloWorld.java
│   ├── m1-variables-expressions/     # Sample module: variables and expressions
│   │   ├── README.md
│   │   ├── lesson.md
│   │   ├── assignment-01.md          # Filled assignment example
│   │   ├── lab-01.md                 # Filled lab example
│   │   ├── assignment-metadata.yaml  # Populated metadata example
│   │   └── examples/
│   │       ├── VariablesDemo.java
│   │       └── ExpressionTrace.java
│   ├── m2-input-output/              # Sample module: Scanner and printf
│   │   ├── README.md
│   │   ├── lesson.md
│   │   └── examples/
│   │       ├── ScannerDemo.java
│   │       └── FormattedOutput.java
│   ├── m5-methods-and-testing/       # Sample module: methods, JUnit, debugging
│   │   ├── README.md
│   │   ├── examples/
│   │   │   └── ScoreUtils.java
│   │   └── tests/
│   │       └── ScoreUtilsTest.java
│   └── m6-arrays-collections/        # Sample module: arrays and collections
│       ├── README.md
│       ├── lesson.md
│       ├── assignment-metadata.yaml  # Populated metadata example
│       └── examples/
│           ├── ArrayMax.java
│           └── ArrayStats.java
├── scripts/
│   ├── verify.sh                     # The course verifier: compile, run, test
│   ├── fetch-junit.sh                # Installs the JUnit runner into .tools/
│   └── check-java.sh                 # Compatibility shim; calls verify.sh compile
└── .devcontainer/                    # Codespaces and local dev container setup
    ├── devcontainer.json
    └── post-create.sh
```

Modules 3, 4, 7, and 8 and the Appendix are specified in the
[Course Map](docs/course-map.md) and are not yet built as directories.

---

## Navigation

| What you need | Where to go |
|---------------|-------------|
| Start teaching | [Instructor Guide](docs/instructor-guide.md) |
| Start learning | [Student Guide](docs/student-guide.md) |
| See the course sequence | [Course Map](docs/course-map.md) |
| See the pacing calendar | [Pacing Guide](docs/pacing-guide.md) |
| Look up a term | [Glossary](docs/glossary.md) |
| Diagnose a common error | [FAQ](docs/faq.md) |
| Score an assignment | [Rubric](docs/rubric.md) |
| See the workflow diagrams | [Workflow Diagrams](docs/workflow-diagrams.md) |
| Copy a lesson template | [Lesson Template](templates/lesson-template.md) |
| Propose a final project | [Project Proposal Template](templates/project-proposal-template.md) |
| First sample lesson | [Module 0: Getting on The Bus](modules/m0-getting-on-the-bus/lesson-2-environment-and-first-program.md) |
| Second sample lesson | [Module 1: Variables and Expressions](modules/m1-variables-expressions/lesson.md) |
| Third sample lesson | [Module 2: Input and Output](modules/m2-input-output/lesson.md) |
| Fourth sample lesson | [Module 6: Arrays and Collections](modules/m6-arrays-collections/lesson.md) |
| Testing and the verifier | [Module 5: Methods and Testing](modules/m5-methods-and-testing/README.md) |

---

## Quick start for instructors

1. Click **Use this template** (or fork the repository).
2. Read the [Instructor Guide](docs/instructor-guide.md).
3. Review the [Course Map](docs/course-map.md) and adjust the sequence for your institution.
4. Copy a template from `templates/` for each new lesson or assignment.
5. Replace placeholder text with your own content.
6. Run `bash scripts/verify.sh all` to check that every example compiles, runs, and prints what it claims.

### Working surfaces

Students work in **GitHub Codespaces**, in **local VS Code with the Java extension**, or in both. A Codespace needs no setup: the dev container installs the JDK, the Java extension, and the test runner. Every graded task in this course runs on either surface.

| Command | What it does |
|---------|-------------|
| `bash scripts/verify.sh compile` | Compile every `.java` file |
| `bash scripts/verify.sh examples` | Run each example and compare its output against the recorded expectation |
| `bash scripts/verify.sh test` | Run the JUnit tests |
| `bash scripts/verify.sh all` | All of the above |
| `bash scripts/fetch-junit.sh` | Install the JUnit runner (once per machine) |

---

## Reuse and licensing

This repository is released under the [MIT License](LICENSE). You may adapt it freely. If you publish a derived course, a brief acknowledgment is appreciated but not required.

This design is inspired by general principles of interactive learning (including activity shapes found in Runestone-style courses). No proprietary course text or exercises have been copied. All Java examples and instructional text are original.

---

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).

---

## Current status

This is a living template. The following are complete:

- Course structure and navigation
- Instructor and student guides
- Four complete sample modules (environment, variables/expressions, input/output, arrays)
- All templates, including a final project proposal template
- Workflow and diagram documentation
- Rubric, glossary, FAQ, and pacing guide
- GitHub Actions CI workflow for Java compile checking

Instructors should add institution-specific policies, grading systems, and the remaining modules as needed. See [CHANGELOG.md](CHANGELOG.md) for a version history.
