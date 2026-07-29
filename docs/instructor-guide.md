# Instructor Guide — CSC 151 Java Programming I

This guide explains the teaching model, the execute gate, coach/player dynamics, and practical facilitation strategies.

---

## The coach/player model

Every lesson in this course uses two roles: **coach** and **player**.

| Role | Primary responsibility |
|------|----------------------|
| **Coach** | States the goal, protects the execute gate, asks questions, requests evidence. |
| **Player** | Restates the task, predicts, writes code, executes, reports evidence, explains. |

These roles are not fixed. Students rotate between coach and player within each lesson. Practicing both roles helps students internalize the thinking behind the work, not only the mechanics.

### Why two roles?

A player who cannot explain the goal has not understood it. A coach who cannot identify a weak prediction has not evaluated it. The rotation makes both forms of thinking visible and practicable.

---

## The execute gate

The **execute gate** is a handshake between the coach and the player. The gate controls when code may be run or submitted. It is not a bureaucratic check; it is a shared moment of alignment that prevents the most common form of wasted effort: running code before understanding what it is supposed to do.

The gate opens only when both parties have confirmed four things:

| Item | Coach provides | Player confirms |
|------|---------------|-----------------|
| **Goal** | What the program must do | "The program must…" |
| **Constraints** | What may and may not change | "I may change… I may not change…" |
| **Prediction** | What should happen before execution | "I expect the output to be…" |
| **Success check** | Tests or observable output | "We know it works when…" |

When all four items are confirmed, the coach says "Agreed" (or the class shorthand: "snap the ball"). The gate opens and the player executes.

### "Snap the ball"

*Snap the ball* is shorthand for completing the execute-gate handshake and beginning execution. In American football, the snap is the moment the center passes the ball to the quarterback, starting the play. Here, the snap means: both sides are ready, the plan is shared, and work begins.

You do not need to know football to use this shorthand. The full literal meaning (complete the handshake, then execute) is always the operative meaning.

The shorthand is optional. Use it if it fits your classroom culture. Always pair it with its literal meaning for students who are unfamiliar with the phrase.

---

## A homily about forward-looking scaffolding

> **"You don't throw where they're standing; you throw where they're going to be."**

In team sports, a player who throws to where a teammate currently stands will miss, because the teammate keeps moving. A skilled player throws to where the teammate *will be*. The same principle applies to instruction.

Design each lesson to open the door to the *next* lesson. If students are learning `if` statements today, introduce the idea that conditions can become complex — a preview of the `while` loop they will encounter next week. Instruction that prepares students for their next achievable step is more effective than instruction that only corrects their current position.

### A small collection of teaching homilies

These brief sayings capture useful instructional ideas. Explain each one literally before using it as shorthand.

1. **"You don't throw where they're standing; you throw where they're going to be."**  
   Plan instruction to prepare students for their next move, not just to fix their current one.

2. **"Snap the ball only when both sides are ready."**  
   Do not begin execution until the goal, constraints, prediction, and success check are confirmed.  
   Literal meaning: complete the handshake before starting work.

3. **"The smallest useful hint."**  
   When a player is stuck, give only the hint needed to take the next step. A full solution ends the learning; a precise question continues it.

4. **"Evidence, not opinion."**  
   A student who says "I think it works" has not finished. Ask for the output, the test result, or the observable behavior.

5. **"Fix the model before fixing the code."**  
   If a player cannot predict what a piece of code does, running and correcting the code will not build understanding. Restore the shared model first.

6. **"One coach, one question."**  
   When a player is confused, a coach asks one diagnostic question at a time. Multiple questions at once create noise, not clarity.

---

## Running a handshake in class

### Example (live or online)

**Coach (instructor):**
> Write a method that accepts an integer array and returns the largest value. Do not sort the array. Test a typical array, a one-element array, and an array containing a negative number.

**Player (student):**
> I will traverse the array once and track the largest value I have seen. I will not sort the array or modify its contents. The method passes when it returns the correct maximum for all three test cases.

**Coach:**
> Agreed. Execute.

The word "Agreed" opens the gate. The player begins writing code.

### What to do when the handshake fails

If the player's restatement is incomplete or incorrect, the coach does not open the gate. Instead, the coach asks one clarifying question:

> "What happens if the array has only one element?"

The player updates the plan and restates. The gate does not open until the shared model is sound.

---

## Role handoffs

After a successful problem, the two roles switch. The previous player becomes the coach. The new coach must:

1. Describe the next task clearly.
2. Define the success check.
3. Review the player's restatement.
4. Approve or reject the handshake.
5. Ask for evidence after execution.

Role handoffs are worth practicing because they make coaching behavior part of the learned skill, not just an administrative convenience.

### Facilitation tip

Announce role switches explicitly. "Switch roles now." This prevents the handoff from being skipped under time pressure.

---

## Minimal hints

When a player is stuck, the coach:

1. Asks what the player currently believes is true.
2. Asks what the player expected versus what they observed.
3. Points to the specific line or concept, not the answer.
4. Waits for the player to attempt before offering more.

A coach who gives the answer has closed the gate retroactively. The player did not predict, execute, and explain — they received. Receiving and understanding are not the same.

---

## Evidence-based feedback

When a player says "it works," the coach asks:

> "What is your evidence?"

Acceptable evidence includes:

- Console output matching the expected value.
- A passing test result with the test's name and outcome visible.
- A comparison of predicted output versus observed output.

Unacceptable evidence includes:

- "I ran it and it seemed fine."
- "I checked and it looks right."

This standard is not punitive. It trains students to verify programs, not merely believe them.

---

## Accessibility in facilitation

- Read handshake steps aloud, not only on screen.
- Allow students to write predictions in any form: text, table, pseudocode, or voice recording.
- Do not require timed handshakes. The gate is about quality of understanding, not speed.
- Allow students using assistive technology to participate as coach or player without modification.
- When using Mermaid diagrams, provide a written description of the diagram for students who cannot see it.

---

## Inclusive language

- Use "player" and "coach" for roles, not gendered terms.
- Do not use "simple," "easy," or "obvious" to describe tasks — these words discourage students who find the task difficult.
- Use "straightforward" or "bounded" instead.
- Avoid slang and idioms that could exclude international students or students from non-sports backgrounds.
- When using homilies like "snap the ball," always pair them with their literal meaning.

---

## Facilitation examples by module

See each module's `README.md` for specific facilitation notes and example handshakes. The two complete sample modules are:

- [Module 01: Variables and Expressions](../modules/01-variables-expressions/README.md)
- [Module 02: Arrays](../modules/02-arrays/README.md)

---

## Evaluation

Use the [Rubric](rubric.md) to evaluate the quality of a lesson or assignment. The minimum passing criteria are:

- Learning goal is observable.
- Execution requires a handshake.
- Prediction happens before execution.
- Success uses evidence.
- The player explains the result.
- A transfer task is included.
