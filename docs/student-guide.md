# Student Guide — CSC 151 Java Programming I

Welcome. This guide explains how to work through lessons in this course.

---

## How this course works

Every lesson uses two roles: **coach** and **player**.

- The **player** writes and runs code.
- The **coach** checks that the player is ready before the code runs.

You will practice both roles. Playing the coach role is not just supervision — it is part of learning to program.

---

## The execute gate

Before you run or submit code, you and your coach complete a short agreement called the **execute gate** (or "handshake").

The handshake has four parts:

| Part | What it means | Your words |
|------|--------------|------------|
| **Goal** | What the program must do | "The program must…" |
| **Constraints** | What you may and may not change | "I may change… I may not change…" |
| **Prediction** | What you expect to happen | "I expect the output to be…" |
| **Success check** | How you know it worked | "We know it works when…" |

When you have stated all four parts and the coach agrees, the gate opens. You may run your code.

### "Snap the ball"

*Snap the ball* is shorthand for completing the four-part handshake and beginning your work. It comes from American football, where the snap starts the play. You do not need to know football to use this course. The full meaning is: *complete the handshake, then execute*.

Your class may or may not use this phrase. Either way, complete all four parts of the handshake.

---

## What to do before you run code

1. Read the task carefully.
2. State the goal in your own words.
3. List the constraints (what you may change and what you may not).
4. Write your prediction: what do you expect the output to be?
5. State the success check: what output or test result will show the program works?
6. Share your prediction with your coach.
7. Wait for the coach to agree before running anything.

---

## What to do after you run code

1. Record what actually happened (the output or test result).
2. Compare it to your prediction.
   - If they match: explain why the code works.
   - If they do not match: describe what you observed. Then revise your understanding.
3. Run any required tests, including edge cases.
4. State your evidence: "The output is X. The test passed. This matches my prediction because…"

---

## How to explain your result

After your code runs, your coach will ask you to explain it. A good explanation answers these questions:

1. What changed when the code ran?
2. Why does it work?
3. What evidence supports your answer?
4. What mistake would cause it to fail?

"It works" is not an explanation. "The loop runs four times because the condition is `i < 4`, so the final value of `i` is 4 and the sum is 10" is an explanation.

---

## Role rotation

After you successfully complete a task, you and your partner switch roles. If you were the player, you become the coach. If you were the coach, you become the player.

As coach, you must:

1. Describe the next task.
2. State the success check.
3. Listen to the player's restatement and check it.
4. Approve the handshake or ask a clarifying question.
5. Ask for evidence after execution.

Coaching is a skill. It gets easier with practice.

---

## Transfer tasks

At the end of each lesson, there is a **transfer task**. This task changes one important condition from the main lesson: different data, a different structure, or a new edge case.

The transfer task shows whether you understood the idea or only copied the pattern. It is not a punishment. It is the most important part of the lesson.

---

## What to do when you are stuck

1. Re-read the goal and constraints.
2. Check your prediction: did you actually predict before running?
3. Add a `System.out.println` statement to see what the program is doing.
4. Ask your coach one specific question, not "I don't understand anything."

A good question to your coach sounds like: "I expected the loop to run three times, but it ran four. I don't understand why the condition `i <= 3` includes 3."

---

## A note about asking for help

Asking for help is part of programming, not a sign that you cannot program. Professional programmers ask each other questions every day. What matters is that you have tried, you have a specific question, and you can show your work.

Your coach will not give you the answer directly. They will ask a question that helps you find it yourself. This is intentional.

---

## Java basics reference

These terms appear throughout the course. Brief definitions are here; the full glossary is at [docs/glossary.md](glossary.md).

| Term | Brief definition |
|------|-----------------|
| **Variable** | A named storage location for a value. |
| **Expression** | A combination of values and operators that produces a result. |
| **Method** | A named block of code that performs a task and can be called by name. |
| **Array** | An ordered collection of values of the same type. |
| **Condition** | A test that is either true or false. |
| **Loop** | A structure that repeats a block of code while a condition is true. |
| **Class** | A template for creating objects; groups related data and methods. |
| **Object** | A specific instance of a class. |
| **Compile** | Translate source code into instructions the computer can run. |
| **Execute** | Run the compiled program. |
| **Debug** | Find and fix errors in a program. |

---

## Where to start

1. Read this guide.
2. Open [Module 01: Environment and First Program](../modules/01-environment/lesson.md).
3. Follow the lesson step by step.
4. Do not skip the prediction step.
5. Complete the transfer task at the end.

Good luck. Take your time. The handshake is worth doing well.
