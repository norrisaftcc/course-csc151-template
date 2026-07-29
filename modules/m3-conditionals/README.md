# Module 3: Conditionals

**Course:** CSC 151 Java Programming I  
**Position in sequence:** Fourth module (after Input and Output)  
**Estimated time:** 2–3 class sessions  
**Work surface:** Codespace or local VS Code — both work for every task in this module.

---

## What this module covers

- Relational operators: `<`, `>`, `==`, `!=`, `<=`, `>=`.
- Logical operators `&&`, `||`, and `!`, with a truth table for two conditions.
- Short-circuit evaluation: `&&` stops as soon as the answer is decided.
- `if`, `if-else`, and the `else if` chain, and why a chain is tested from the highest band down.
- `switch` as an alternative to a chain that matches exact values.
- Comparing two `String` values with `.equals`, and what `==` asks instead.

Every example in this module keeps all code inside `main`. Students write their first method
in Module 5.

---

## Learning goal

After this module, students can:

1. Write a boolean expression using a relational operator.
2. Combine two conditions with `&&`, `||`, or `!` and state the result from a truth table.
3. Write an `else if` chain over bands and order the tests correctly.
4. State which branch of a chain runs, and which tests the chain skipped.
5. Compare two `String` values with `.equals`, and explain why `==` produces a branch that
   never runs.

---

## The LPAA cycle in this module

| Beat | Course name | What you do here |
|------|------------|------------------|
| **Learn** | Study the Play | Read the six relational operators, the truth table for `&&`, `\|\|` and `!`, why an `else if` chain runs from the highest band down, what `switch` does with a `break`, and what `.equals` asks that `==` does not. Worked example: `TicketPrice.java`. |
| **Practice** | Run the Play | Trace `TicketPrice.java` for age 12 with member `no` and for age 70 with member `yes`, naming which branch sets the price and which tests are never reached. Repair `RepairBands`, which has two defects: the chain is written lowest band first, and the membership test uses `==` on a word the user typed. |
| **Apply** | Team Practice | Complete the handshake, then write `ShippingCost.java`: read a weight and a destination word, print the cost band, and reject an unknown destination. |
| **Assess** | The Big Game | Write `MovieRating.java`, which decides admission from an age **and** a guardian word combined with `&&`. |

*The four course names are American football terms. Their literal meanings, and the rule the
cycle keeps, are in the [Course Map](../../docs/course-map.md#the-lpaa-cycle). You do not need
to know anything about football to take this course.*


**The transfer task changes what the decision reads and not how it is written.** `&&` is
taught in the Concept explanation, traced in `TicketPrice`, and repaired in `RepairBands`.
`.equals` follows the same three beats. The chain order is rehearsed in the same repair. The
one changed condition is that both inputs now enter the same test, instead of one input
selecting among bands.

**This module carries a skill Module 8 depends on.** The dispatcher in Module 8 matches a
command word the user typed against a registered command name, and the characteristic failure
— a registered handler that never runs — is a `==` comparison on two `String` values. That
defect is taught, traced, and repaired here, five modules before it is graded.

---

## Files in this module

| File | Description |
|------|-------------|
| [lesson.md](lesson.md) | Full lesson with the chain, the truth table, the handshake, and the transfer task |
| [examples/TicketPrice.java](examples/TicketPrice.java) | Runnable program: an `else if` chain over age bands, with one band combined by `&&` |
| [examples/StringMatch.java](examples/StringMatch.java) | Runnable program: one typed word compared with `==` and with `.equals`, printing both answers |
| [examples/MenuSwitch.java](examples/MenuSwitch.java) | Runnable program: the same decision written as a `switch` and as an `else if` chain |

`StringMatch` and `MenuSwitch` read input. Each ships a `.stdin` fixture beside it, so
`bash scripts/verify.sh examples` runs them with no keyboard.

---

## Instructor facilitation notes

### Before class

1. Run `bash scripts/verify.sh all` and confirm it passes.
2. Run `examples/StringMatch.java` in a visible terminal before you explain anything. The
   three printed lines disagree with each other, and the disagreement is the lesson. Ask
   students to account for it before you name the cause.
3. Prepare the chain-order demonstration on the board: write the `TicketPrice` chain from the
   lowest band up, then ask which branch runs for an age of 70. Students who answer "the
   senior branch" have found the defect the Practice beat repairs.

### Common mistakes

| Mistake | What it looks like | The single diagnostic question |
|---------|-------------------|-------------------------------|
| Chain written lowest band first | Every case prints the cheapest band | "Which test is true first for an age of 70?" |
| `==` on two `String` values | A branch never runs, and nothing reports an error | "Where did that `String` come from — your source, or the keyboard?" |
| `=` written where `==` belongs | Compile error, or a `boolean` quietly reassigned | "Is that line asking a question or answering one?" |
| Missing `break` in a `switch` | The next case overwrites the answer the previous one set | "What runs after this case body ends?" |
| Wrong edge on a band | 5.0 kg is charged as a light parcel | "Does the edge belong to the band above or below?" |

The `==` row is the important one. It produces no message of any kind, so a student who
trusts the compiler to report mistakes has no way in. Ask them to print the condition itself
— `System.out.println(member == "yes");` — before they change anything.

### Accessible facilitation

- Read the `else if` chain aloud as a numbered list of questions, one per line. The flowchart
  in the lesson carries a plain-text description for the same purpose.
- Allow students to trace a chain on paper as a table of `true` and `false` before typing.
- Never rely on colour alone when marking which branch ran. Circle the branch and label it in
  words.
- Give the truth table to students who prefer it as four written sentences instead of a grid.

---

## How this module connects to the next

Module 4 (Loops) repeats a decision instead of making it once. A loop condition is the same
kind of boolean expression students write here, checked again before every pass. The sentinel
loop in Module 4 stops when a comparison becomes `false`, and that comparison is a `.equals`
call or a relational operator taught in this module.

> "You don't throw where they're standing; you throw where they're going to be."  
> Literal meaning: close this module by writing one `if` on the board and asking what would
> happen if the same test ran again after its body finished. Students already write the
> condition. They are about to learn how to run it repeatedly.
