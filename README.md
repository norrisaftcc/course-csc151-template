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
- **Nine modules plus an Appendix**, each running the full lesson cycle.
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
│   ├── test-evidence-rubric.md       # How to score a student's test evidence (CLO-5)
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
│   │   ├── lesson-3-work-surfaces-and-ai-teammate.md
│   │   └── examples/
│   │       └── HelloWorld.java
│   ├── m1-variables-expressions/     # Variables and expressions
│   │   ├── README.md
│   │   ├── lesson.md
│   │   ├── assignment-01.md          # Filled assignment example
│   │   ├── lab-01.md                 # Filled lab example
│   │   ├── assignment-metadata.yaml  # Populated metadata example
│   │   └── examples/
│   │       ├── VariablesDemo.java
│   │       └── ExpressionTrace.java
│   ├── m2-input-output/              # Scanner and printf
│   │   ├── README.md
│   │   ├── lesson.md
│   │   └── examples/
│   │       ├── ScannerDemo.java
│   │       ├── ScannerMixedInput.java
│   │       └── FormattedOutput.java
│   ├── m3-conditionals/              # Boolean expressions, if/else, switch
│   │   ├── README.md
│   │   ├── lesson.md
│   │   └── examples/
│   │       ├── TicketPrice.java
│   │       ├── StringMatch.java
│   │       └── MenuSwitch.java
│   ├── m4-loops/                     # while, do-while, for, nested loops
│   │   ├── README.md
│   │   ├── lesson.md
│   │   └── examples/
│   │       ├── CountdownLoops.java
│   │       ├── SumToN.java
│   │       └── SentinelLoop.java
│   ├── m5-methods-and-testing/       # Methods, JUnit, debugging
│   │   ├── README.md
│   │   ├── lesson-1-methods.md
│   │   ├── lesson-2-testing-and-debugging.md
│   │   ├── examples/
│   │   │   ├── MethodBasics.java
│   │   │   └── ScoreUtils.java
│   │   └── tests/
│   │       └── ScoreUtilsTest.java
│   ├── m6-arrays-collections/        # Arrays and collections
│   │   ├── README.md
│   │   ├── lesson.md
│   │   ├── assignment-metadata.yaml  # Populated metadata example
│   │   ├── examples/
│   │   │   ├── ArrayMax.java
│   │   │   ├── ArrayStats.java
│   │   │   └── RosterList.java
│   │   └── tests/
│   │       └── ArrayStatsTest.java
│   ├── m7-classes-objects/           # Fields, constructors, methods, toString
│   │   ├── README.md
│   │   ├── lesson.md
│   │   ├── examples/
│   │   │   ├── Counter.java
│   │   │   └── Book.java
│   │   └── tests/
│   │       └── BookTest.java
│   ├── m8-events-and-capstone/       # Register-and-dispatch, final project
│   │   ├── README.md
│   │   ├── lesson-1-event-driven-programming.md
│   │   ├── lesson-2-final-project.md
│   │   ├── examples/
│   │   │   ├── HandlerIntro.java
│   │   │   └── EventDemo.java
│   │   └── tests/
│   │       └── CommandDispatcherTest.java
│   └── appendix/                     # Reference, composed from docs/
│       └── README.md
├── scripts/
│   ├── verify.sh                     # The course verifier: compile, run, test
│   ├── fetch-junit.sh                # Installs the JUnit runner into .tools/
│   └── check-java.sh                 # Compatibility shim; calls verify.sh compile
├── spikes/                           # Throwaway prototypes; not course content
└── .devcontainer/                    # Codespaces and local dev container setup
    ├── devcontainer.json
    └── post-create.sh
```

Every module in the [Course Map](docs/course-map.md) now exists as a directory: Module 0
through Module 8, plus the Appendix.

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
| Score a student's test evidence | [Test Evidence Rubric](docs/test-evidence-rubric.md) |
| See the workflow diagrams | [Workflow Diagrams](docs/workflow-diagrams.md) |
| Copy a lesson template | [Lesson Template](templates/lesson-template.md) |
| Propose a final project | [Project Proposal Template](templates/project-proposal-template.md) |
| Look something up mid-module | [Appendix: Reference](modules/appendix/README.md) |

### The modules in order

| Module | Directory | Lessons |
|--------|-----------|---------|
| 0 — Getting on The Bus | [m0-getting-on-the-bus](modules/m0-getting-on-the-bus/README.md) | [Writing and diagrams](modules/m0-getting-on-the-bus/lesson-1-writing-and-diagrams.md) · [Environment and first program](modules/m0-getting-on-the-bus/lesson-2-environment-and-first-program.md) · [Work surfaces and AI teammate](modules/m0-getting-on-the-bus/lesson-3-work-surfaces-and-ai-teammate.md) |
| 1 — Variables and Expressions | [m1-variables-expressions](modules/m1-variables-expressions/README.md) | [Lesson](modules/m1-variables-expressions/lesson.md) |
| 2 — Input and Output | [m2-input-output](modules/m2-input-output/README.md) | [Lesson](modules/m2-input-output/lesson.md) |
| 3 — Conditionals | [m3-conditionals](modules/m3-conditionals/README.md) | [Lesson](modules/m3-conditionals/lesson.md) |
| 4 — Loops | [m4-loops](modules/m4-loops/README.md) | [Lesson](modules/m4-loops/lesson.md) |
| 5 — Methods and Testing | [m5-methods-and-testing](modules/m5-methods-and-testing/README.md) | [Methods](modules/m5-methods-and-testing/lesson-1-methods.md) · [Testing and debugging](modules/m5-methods-and-testing/lesson-2-testing-and-debugging.md) |
| 6 — Arrays and Collections | [m6-arrays-collections](modules/m6-arrays-collections/README.md) | [Lesson](modules/m6-arrays-collections/lesson.md) |
| 7 — Classes and Objects | [m7-classes-objects](modules/m7-classes-objects/README.md) | [Lesson](modules/m7-classes-objects/lesson.md) |
| 8 — Events and Capstone | [m8-events-and-capstone](modules/m8-events-and-capstone/README.md) | [Event-driven programming](modules/m8-events-and-capstone/lesson-1-event-driven-programming.md) · [Final project](modules/m8-events-and-capstone/lesson-2-final-project.md) |
| Appendix — Reference | [appendix](modules/appendix/README.md) | — |

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
- All nine modules and the Appendix, each with a README, at least one lesson, and runnable examples
- All templates, including a final project proposal template
- Workflow and diagram documentation
- Rubric, glossary, FAQ, and pacing guide
- GitHub Actions CI workflow for Java compile checking

Instructors should add institution-specific policies and grading systems, which this template deliberately leaves out. See [CHANGELOG.md](CHANGELOG.md) for a version history.
