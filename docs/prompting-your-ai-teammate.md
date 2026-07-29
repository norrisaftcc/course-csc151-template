# Prompting Your AI Teammate — CSC 151 Java Programming I

This document teaches two operations: **PROVIDE** and **ASSAY**.

- **PROVIDE** makes a request shorter until it is the shortest request that could work.
- **ASSAY** makes a report shorter until it is the shortest report that makes the same point.

Both operations use the same test. Both are useful without an AI. You will use them on assignment descriptions, on your own explanations, and on messages to your coach.

> Read the [AI Teammate Policy](ai-teammate-policy.md) first. It states what assistance is allowed.

---

## Why shorter

A long request hides what you actually want. A long report hides what you actually found.

When you cut a request to its floor, you discover which parts you had not decided yet. That discovery is the point. The shortening is how you find the gap.

---

## The floor test

A request clears the floor when a reader can answer all four questions without asking you anything.

| Floor item | The question it answers | Gate item it matches |
|-----------|------------------------|---------------------|
| **Audience** | Who is this for? | Constraints |
| **Scope** | What is included, and what is not? | Goal |
| **Format** | What shape should the answer take? | Success check |
| **Path** | What should happen first, and next? | Prediction |

These four match the four parts of the execute-gate handshake. That is not a coincidence. A handshake is a floor test between two people. A prompt is a floor test between you and a tool.

---

## PROVIDE — shorten a request

### The steps

1. Write the request as it first comes to you. Do not edit while writing.
2. Remove every sentence that does not serve Audience, Scope, Format, or Path.
3. Check the four floor items. If one is missing, add one short sentence for it.
4. Record what you cut and why.
5. Read the result. If it still clears the floor, it is done.

### The rule that makes it work

**Record every cut.** Write one line naming what you removed. If you cannot say why a sentence went, put it back.

Cutting for the sake of cutting is a failure, not a success. If a pass removes nothing, say so — "Cut: nothing" — and stop. Two such passes in a row means the request is already at its floor.

### A worked example

**First draft:**

> Hi, I am working on the Module 6 arrays assignment and I am kind of stuck. I have been trying for a while to write a method that goes through an array and finds the biggest number in it, but I keep getting the wrong answer when the numbers are all negative, which I think might have something to do with how I set up my starting value but I am not sure. Could you please help me figure out what is wrong? Thanks so much!

**After PROVIDE:**

> Write a Java method that returns the largest value in an `int` array. Do not sort the array. It must work when every value is negative. Show the method only, not a full class.

> **Cut:** the greeting, the apology, the description of how long I had been trying, and my guess about the cause. None of them change what a correct answer looks like.
>
> **Note:** I said "the biggest number." The Java term is the maximum value.
>
> **Assume:** the array is never empty. The assignment does not say, so I stated it rather than asking.

Notice what the shortening exposed. The first draft never said "do not sort" and never said "all negative values must work." Those were the two constraints that mattered, and writing short forced them into the open.

---

## ASSAY — shorten a report

ASSAY is read-only. You use it on a document that already exists — your explanation, your evidence, a classmate's task description. **ASSAY never rewrites the document.** It reports what survives the floor test.

This distinction matters. If you rewrite while you assay, you stop being able to see what the original was missing.

### The steps

1. Reduce the document to its floor: the statements that carry the point.
2. List what did not survive, and name what each removed part was doing.
3. Find the operative sentence — the one that carries the actual finding. Note where it sits.
4. State the finding: is the document above or below the floor?

### A worked example

**The document — a student's evidence report:**

> So I ran my program a few times and tried some different numbers to see what would happen. Most of them worked fine and printed what I expected. I tried 5 and 10 and 100 and those were all good. Then I tried it with an empty array just to see, and it crashed with some kind of exception, I think an ArrayIndexOutOfBounds one. Anyway I think the method is basically working.

**The assay:**

> **Residue:**
> - Normal input (5, 10, 100): output matched the prediction.
> - Empty array: threw `ArrayIndexOutOfBoundsException`.
>
> **Evaporated:** "ran it a few times," "most of them worked fine," "basically working." These were confidence statements. They carried no evidence.
>
> **Operative sentence:** sentence 4 of 6, in a subordinate clause beginning "just to see."
>
> **Finding:** below the floor. The only failure the student found is buried mid-paragraph and framed as an aside, and the report closes by claiming the method works. The conclusion contradicts the evidence.

The value here is the position of the operative sentence. The student found a real bug and then talked past it. Nobody skimming that paragraph would notice.

---

## When to use which

| Situation | Operation |
|-----------|-----------|
| You are about to ask your AI teammate for code | PROVIDE |
| You are about to ask your coach a question | PROVIDE |
| You are writing an assignment description | PROVIDE |
| You are about to submit an explanation | ASSAY it first |
| A classmate asks you to review their task card | ASSAY |
| You are reading your own evidence report | ASSAY |

---

## Practice task

Take the last message you sent asking for help with code.

1. Run PROVIDE on it. Record every cut.
2. Check the four floor items. Name the one that was missing.
3. Ask your coach whether the shortened version is clearer.

Almost every first draft is missing one of the four. Finding out which one is yours is worth more than the shorter message.

---

## Attribution

The PROVIDE and ASSAY operations, the four floor items, and the record-every-cut rule come from *The Algorithm*, a prompt-shaping method used elsewhere in this program. This page is a student-facing summary written for CSC 151. The language standard both documents share is ASD Simplified Technical English, which is also taught in [submodule 0.1](../modules/m0-getting-on-the-bus/lesson-1-writing-and-diagrams.md).
