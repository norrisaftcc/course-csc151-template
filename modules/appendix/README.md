# Appendix: Reference

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Not a step in the sequence. A reference students consult from any module.  
**Estimated time:** Minutes at a time, throughout the course  
**Work surface:** Codespace or local VS Code — every page here applies to both.

---

## What this module covers

The Appendix is an **index**, not a document. It is composed from the files in
[`docs/`](../../docs/), which stay the single source of truth. Nothing here restates a
definition, a rule, or an error message. A definition that lived in two places would eventually
disagree with itself, and a student who found the two copies would have no way to tell which one
the course meant.

This module covers one skill: **finding an answer here rather than guessing at one.**

| What you need | Where it lives | Source document |
|---------------|---------------|-----------------|
| The meaning of a course term | Glossary | [docs/glossary.md](../../docs/glossary.md) |
| The ten errors beginners meet first, each with its message, diagnosis, and fix | FAQ | [docs/faq.md](../../docs/faq.md) |
| What a complete piece of evidence contains, and how work is judged | Rubric | [docs/rubric.md](../../docs/rubric.md) |
| What honest AI teammate use requires, and what must be disclosed | AI teammate policy | [docs/ai-teammate-policy.md](../../docs/ai-teammate-policy.md) |
| PROVIDE and ASSAY, and the four floor items | Prompting guide | [docs/prompting-your-ai-teammate.md](../../docs/prompting-your-ai-teammate.md) |
| The four gate parts, role rotation, and what to do when stuck | Student guide | [docs/student-guide.md](../../docs/student-guide.md) |
| The module sequence, the LPAA cycle, and the no-new-plays rule | Course map | [docs/course-map.md](../../docs/course-map.md) |
| Which outcome each module serves | CLO/MLO map | [docs/clo-mlo-map.md](../../docs/clo-mlo-map.md) |
| Diagrams of the workflow, the gate, and the lesson shape | Workflow diagrams | [docs/workflow-diagrams.md](../../docs/workflow-diagrams.md) |
| How to facilitate a beat, a handshake, or a handoff | Instructor guide | [docs/instructor-guide.md](../../docs/instructor-guide.md) |
| Week-by-week timing for a 16-week or 8-week term | Pacing guide | [docs/pacing-guide.md](../../docs/pacing-guide.md) |

**The diagnosis pattern.** Every entry in [docs/faq.md](../../docs/faq.md) is written in the
same four steps, and the steps work on errors that have no entry:

1. Read the **file and the line** the compiler or the stack trace names.
2. Read the **symbol** it names — a variable, a method, a type, a file name.
3. Compare that symbol to its **declaration**. One of the two is not what you thought.
4. Change **one thing** and recompile.

**Two items the [Course Map](../../docs/course-map.md#appendix--reference) lists have no source
document today:** the full work-surface matrix, and the command reference for the course
verifier. A teaching subset of the work-surface material is already a table in
[Module 0 lesson 3](../m0-getting-on-the-bus/lesson-3-work-surfaces-and-ai-teammate.md), and
writing a second copy here would create exactly the drift this module exists to prevent. This is
recorded as an open question for curriculum review rather than resolved here. Until it is
resolved, the verifier's own usage text is the reference:

```
bash scripts/verify.sh
```

---

## Learning goal

After using this module, students can:

1. Name which document answers a given question, without opening all of them.
2. Apply the four-step diagnosis pattern to a compiler or runtime message.
3. Diagnose an error that has no FAQ entry, using the same pattern.
4. Write a request that uses the glossary's term for the thing that broke and the FAQ's name for
   the error.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | Read the index above and the four-step diagnosis pattern. Open each of the four most-used documents once — glossary, FAQ, rubric, AI teammate policy — so you know what each one looks like before you need it in a hurry. |
| **Practice** | Run the Play | Take three of the messages already printed in [docs/faq.md](../../docs/faq.md). For each one, name the entry, the cause, and the one-line fix **before** you read the entry's answer. No new Java file is needed: the broken and fixed snippets are already there. |
| **Apply** | Team Practice | Before you ask anyone for help, write the request using the four floor items from [Module 0 lesson 3](../m0-getting-on-the-bus/lesson-3-work-surfaces-and-ai-teammate.md). Use the glossary's term for the thing that broke and the FAQ's name for the error. Hand it to a coach and confirm it can be acted on without a question back. |
| **Assess** | The Big Game | **This beat is an ungraded self-check.** Diagnose an error that is not one of the ten, using the same four-step pattern, then note in one sentence which document you would consult first next time. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**Why the Assess beat is not graded.** The Appendix carries no CLO. It is a reference module, and
its beats exist so that students practice consulting rather than guessing. Nothing here appears
on a transcript, and no instructor should treat this self-check as a score. Every graded task in
this course lives in Module 0 through Module 8. See
[docs/clo-mlo-map.md](../../docs/clo-mlo-map.md) for the outcome mapping.

**The self-check task.** Diagnose this message, which has no FAQ entry:

```
Mix.java:3: error: incompatible types: String cannot be converted to int
        int count = "12";
                    ^
1 error
```

Work the four steps in order: the file and line, the symbol, the declaration, then one change.
Write two sentences naming the cause and the fix. **Changed condition:** the error has no entry,
so the pattern carries you instead of the entry.

---

## Files in this module

| File | Description |
|------|-------------|
| [README.md](README.md) | This index, and the reference-use beats |

The Appendix ships as this one file. Its content is **composed from `docs/`** rather than
written twice, so a definition can never disagree with itself. The table under *What this module
covers* records which document each section comes from.

An Appendix page published to the delivery platform is generated from its source document by the
`csc151-canvas-compositor` skill. Edit the document in `docs/`, then regenerate. Editing a
published page directly puts the correction where nobody else will find it.

---

## Instructor facilitation notes

### Before class

1. Confirm every student can open [docs/faq.md](../../docs/faq.md) from their work surface and
   search it with `Ctrl+F` or `Cmd+F`. A reference nobody can search is a reference nobody uses.
2. Choose the three FAQ entries for the Practice beat before the session. Entries 1, 5, and 7 —
   the missing semicolon, integer division, and the class-and-file-name mismatch — cover one
   compile-time error, one logic error, and one that a student meets while their program still
   compiles everywhere else.
3. Decide when you will introduce this module. It works as a twenty-minute session in the first
   week and as a five-minute revisit whenever a student meets an error for the first time.

### Common mistakes

| Mistake | What it looks like | The single diagnostic question |
|---------|-------------------|-------------------------------|
| Reading the message and not the line number | A student edits a line the compiler never mentioned | "Which file and line does it name?" |
| Reading the first line of a stack trace only | The deepest frame is library code the student did not write | "Which frame names a file you wrote?" |
| Guessing before consulting | Three changes made at once, none of them explained | "Which one thing did you change?" |
| Copying an answer without the term | A request that a reader cannot act on | "What does the glossary call that?" |
| Treating this module as graded work | A student asks what the self-check is worth | "Which CLO does the Appendix map to?" |

### Accessible facilitation

- Read compiler messages aloud in the four-step order, naming the line number before the message
  text. The order is the skill.
- Allow students to answer the Practice beat in prose, as a table, or out loud.
- Keep the index table on screen during the Practice beat. Recall is not the skill being
  practiced; consulting is.
- Never rely on colour to mark which document holds an answer. The table above names each one in
  words.

---

## How this module connects to the rest of the course

The Appendix connects to every module and follows none of them. Students reach it from Module 0
when they first meet a compiler message, from Module 5 when they read a stack trace, and from
Module 8 when they write a proposal and need the rubric's standard for evidence.

The one direction that matters is inward: **a question answered here should send the student back
to their own program with one thing to change.** A reference that ends in more reading has not
finished its job.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: when a student asks what an error means, answer with the four steps rather
> than with the fix. They will meet an error with no entry, and the steps are what carries them
> then.
