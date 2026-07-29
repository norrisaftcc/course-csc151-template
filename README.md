# CSC 151 Java Programming I — Course Template

A reusable, open course framework for community college students learning introductory Java.

> **Status:** Initial template — ready to adapt and extend.  
> **License:** MIT  
> **Attribution:** This design is inspired by general interactive-learning patterns (including the activity shape of Runestone-style courses). All content is original. This is not an official Runestone Academy course.

---

## What this repository is

This repository gives instructors and students a starting framework for a first Java programming course. It includes:

- A **coach/player teaching model** with explicit handoffs.
- An **execute gate** — a shared handshake before running or submitting code.
- **Simplified technical English** so explanations are clear to every reader.
- **Mermaid diagrams** that render on GitHub.
- **Original Java examples** with expected output.
- Reusable **templates** for lessons, labs, assignments, and rubrics.
- Two **complete sample modules** demonstrating the full lesson cycle.

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
├── LICENSE                           # MIT
├── docs/
│   ├── instructor-guide.md           # Coach/player dynamics, facilitation
│   ├── student-guide.md              # How to work through a lesson
│   ├── course-map.md                 # Recommended topic sequence
│   ├── glossary.md                   # Key terms defined
│   ├── rubric.md                     # How to evaluate educational content
│   └── workflow-diagrams.md          # Mermaid diagrams for the full workflow
├── templates/
│   ├── lesson-template.md            # Blank lesson structure
│   ├── assignment-template.md        # Blank assignment structure
│   ├── lab-template.md               # Blank lab structure
│   ├── rubric-template.md            # Blank rubric
│   ├── coach-player-record.md        # Activity record form
│   └── assignment-metadata.yaml      # YAML schema for assignment metadata
├── modules/
│   ├── 01-variables-expressions/     # Sample module: variables and expressions
│   │   ├── README.md
│   │   ├── lesson.md
│   │   └── examples/
│   │       ├── VariablesDemo.java
│   │       └── ExpressionTrace.java
│   └── 02-arrays/                    # Sample module: arrays
│       ├── README.md
│       ├── lesson.md
│       └── examples/
│           ├── ArrayMax.java
│           └── ArrayStats.java
└── scripts/
    └── check-java.sh                 # Lightweight Java compile check
```

---

## Navigation

| What you need | Where to go |
|---------------|-------------|
| Start teaching | [Instructor Guide](docs/instructor-guide.md) |
| Start learning | [Student Guide](docs/student-guide.md) |
| See the course sequence | [Course Map](docs/course-map.md) |
| Look up a term | [Glossary](docs/glossary.md) |
| Score an assignment | [Rubric](docs/rubric.md) |
| See the workflow diagrams | [Workflow Diagrams](docs/workflow-diagrams.md) |
| Copy a lesson template | [Lesson Template](templates/lesson-template.md) |
| First sample lesson | [Module 01: Variables and Expressions](modules/01-variables-expressions/lesson.md) |
| Second sample lesson | [Module 02: Arrays](modules/02-arrays/lesson.md) |

---

## Quick start for instructors

1. Click **Use this template** (or fork the repository).
2. Read the [Instructor Guide](docs/instructor-guide.md).
3. Review the [Course Map](docs/course-map.md) and adjust the sequence for your institution.
4. Copy a template from `templates/` for each new lesson or assignment.
5. Replace placeholder text with your own content.
6. Run `scripts/check-java.sh` to verify that all Java examples compile.

---

## Reuse and licensing

This repository is released under the [MIT License](LICENSE). You may adapt it freely. If you publish a derived course, a brief acknowledgment is appreciated but not required.

This design is inspired by general principles of interactive learning (including activity shapes found in Runestone-style courses). No proprietary course text or exercises have been copied. All Java examples and instructional text are original.

---

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).

---

## Current status

This is an initial template. The following are complete:

- Course structure and navigation
- Instructor and student guides
- Two complete sample modules (variables/expressions, arrays)
- All templates
- Workflow and diagram documentation
- Rubric and glossary

Instructors should add institution-specific policies, grading systems, and additional modules as needed.
