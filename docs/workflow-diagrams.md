# Workflow Diagrams — CSC 151 Java Programming I

This page contains the primary Mermaid diagrams for the course workflow. Each diagram is followed by a plain-text description for screen readers and other assistive contexts.

---

## 1. Overall learning workflow

The diagram below shows the complete path from selecting a task to recording mastery.

```mermaid
flowchart TD
    A[Select a Java task] --> B[State the learning goal]
    B --> C[Check prior knowledge]
    C --> D[Classify each activity type]

    D --> D1[Learn a concept]
    D --> D2[Trace an example]
    D --> D3[Repair or modify code]
    D --> D4[Write new code]
    D --> D5[Explain the result]

    D1 --> E[Prepare coach instructions]
    D2 --> E
    D3 --> E
    D4 --> E
    D5 --> E

    E --> F[Coach presents goal, constraints, and success check]
    F --> G[Player restates the plan]

    G --> H{Handshake complete?}
    H -- No --> I[Coach asks one clarifying question]
    I --> G

    H -- Yes --> J[Execute gate opens]
    J --> K[Player records prediction]
    K --> L[Player writes or changes code]
    L --> M[Player runs agreed tests]
    M --> N[Player reports evidence]

    N --> O{Evidence meets success check?}
    O -- No --> P[Coach asks a diagnostic question]
    P --> K

    O -- Yes --> Q[Player explains why the code works]
    Q --> R[Switch coach and player roles]
    R --> S[Complete a transfer task]
    S --> T{Independent success?}

    T -- No --> U[Return to a smaller practice task]
    U --> F

    T -- Yes --> V[Record mastery]
```

**Plain-text description:**  
A task is selected and its learning goal is stated. Prior knowledge is checked. Each activity in the lesson is classified as learn, trace, repair, build, or explain. The coach prepares instructions and presents the goal, constraints, and success check to the player. The player restates the plan. If the handshake is incomplete, the coach asks one clarifying question and the player tries again. When the handshake is complete, the execute gate opens. The player records a prediction, writes or changes code, runs tests, and reports evidence. If the evidence does not meet the success check, the coach asks a diagnostic question and the player tries again. When the evidence meets the check, the player explains why the code works. The roles switch. The player (now acting as player with the former player as coach) completes a transfer task. If the transfer succeeds, mastery is recorded. If not, the pair returns to a smaller practice task.

---

## 2. Execute-gate handshake

The diagram below shows the four-part handshake that opens the execute gate.

```mermaid
flowchart LR
    A[Task is assigned] --> B[Coach states goal]
    B --> C[Coach states constraints]
    C --> D[Coach requests prediction]
    D --> E[Player states prediction]
    E --> F[Coach states success check]
    F --> G[Player confirms success check]
    G --> H{All four parts confirmed?}
    H -- No --> I[Coach clarifies the missing part]
    I --> H
    H -- Yes --> J[Coach says 'Agreed']
    J --> K[Execute gate opens]
    K --> L[Player executes]
```

**Plain-text description:**  
The task is assigned. The coach states the goal, then the constraints, then asks for a prediction. The player states their prediction. The coach states the success check, and the player confirms it. If all four parts (goal, constraints, prediction, success check) are confirmed, the coach says "Agreed" and the gate opens. If any part is missing, the coach clarifies and the check repeats. Once the gate opens, the player executes.

---

## 3. Lesson progression

The diagram below shows how a single lesson moves from concept to transfer.

```mermaid
flowchart LR
    A[State learning goal] --> B[Check prior knowledge]
    B --> C[Explain concept]
    C --> D[Worked example]
    D --> E[Trace before running]
    E --> F[Repair or arrange code]
    F --> G[Small coding task]
    G --> H[Run tests and record evidence]
    H --> I[Explain the result]
    I --> J[Switch roles]
    J --> K[Transfer task]
    K --> L[Reflect and record mastery]
```

**Plain-text description:**  
A lesson begins by stating the learning goal and checking what the student already knows. The concept is explained, followed by a worked example. The student traces the example before running it. The student then repairs or arranges provided code. Next, the student completes a small coding task, runs tests, and records evidence. The student explains the result. Roles switch (coach and player trade places). The student completes a transfer task with a changed condition. The lesson closes with reflection and a mastery record.

---

## 4. Assignment-shape summary

This diagram summarizes the activity types in a well-formed assignment.

```mermaid
flowchart LR
    A[Concept] --> B[Worked example]
    B --> C[Trace before running]
    C --> D[Repair or arrange code]
    D --> E[Write a small program]
    E --> F[Explain the result]
    F --> G[Apply in a new case — transfer]
```

**Plain-text description:**  
An assignment moves in order through: introducing a concept, showing a worked example, tracing before running, repairing or arranging provided code, writing a small program, explaining the result, and applying the concept in a new case (the transfer task).

---

## Notes on Mermaid diagrams

These diagrams use GitHub-flavored Mermaid. They render automatically in GitHub's Markdown preview. If you are viewing this file in a plain text editor or a system that does not render Mermaid, refer to the plain-text descriptions above each diagram.

All Mermaid blocks in this repository use the `flowchart` directive (not `graph`), which is the current recommended syntax for GitHub rendering.
