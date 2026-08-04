<!-- compositor: M8 · learn -->
# Module 8a: Swing Track Addendum

**Module:** 8 — Events and Capstone  
**Position in sequence:** Optional local addendum after Submodule 8.1  
**Work surface:** Local machine with a display. The console path remains complete and carries full credit.

This addendum gives local students a graphical trigger for the same handlers they used in the
console path. It does not add a new assessment requirement. Students in a Codespace can skip it.

---

## Learning goal

After this addendum, you can:

- Describe how a `JButton` press becomes an `ActionEvent`.
- Connect an `ActionListener` to an existing `CommandHandler`.
- Keep Swing wiring separate from calculator logic.
- Explain why the console and Swing paths produce the same handler call.

## Prior knowledge check

Before starting, confirm that you can:

- [ ] Declare a `CommandHandler` interface and implement `handle`.
- [ ] Register and dispatch a command in the console version.
- [ ] Explain why `CalculatorEngine` does not know which trigger produced an event.
- [ ] Run Java locally with a display.

If you cannot confirm the first three items, return to [Lesson 8.1](lesson-1-event-driven-programming.md).
If you do not have a local display, use the console path instead.

## Concept explanation

Swing is Java's desktop user-interface toolkit. A `JButton` emits an `ActionEvent` when a user
presses it. An `ActionListener` receives that event through `actionPerformed`.

The listener adapts the Swing method shape to the course handler shape:

```java
class AddButtonListener implements ActionListener {
    private CommandHandler handler;

    public AddButtonListener(CommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.handler.handle(5.0);
    }
}
```

The listener does not calculate anything. It calls the same `handle` method that the console
dispatcher calls. The logic class stays independent of Swing.

Create the window on Swing's event-dispatch thread with `SwingUtilities.invokeLater`. This keeps
user-interface work on the thread Swing expects:

```java
SwingUtilities.invokeLater(() -> {
    JFrame frame = new JFrame("Calculator");
    JButton addButton = new JButton("Add 5");
    addButton.addActionListener(new AddButtonListener(new AddHandler(engine)));
    frame.add(addButton);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
});
```

The default visual treatment for course examples uses black structure, restrained gold emphasis,
and grayscale surfaces. Color never carries meaning alone. Button text and labels must also state
the action.

## Worked example

Start with the existing `EventDemo` classes. Replace only the console trigger with a small Swing
window. Keep `CalculatorEngine`, `AddHandler`, and the other handler classes unchanged.

```java
CalculatorEngine engine = new CalculatorEngine();
CommandHandler add = new AddHandler(engine);

JButton addButton = new JButton("Add 5");
addButton.addActionListener(new AddButtonListener(add));
```

When the player presses **Add 5**, Swing calls `actionPerformed`. The listener calls
`AddHandler.handle(5.0)`. The handler updates the engine and prints the same result as the
console command `add 5`.

## Trace before running

Trace this sequence without opening a window:

1. The program constructs `CalculatorEngine`.
2. The program constructs `AddHandler` with that engine.
3. The program constructs a button labelled `Add 5`.
4. The program registers `AddButtonListener`.
5. The player presses the button.
6. Swing calls `actionPerformed`.
7. The listener calls `handle(5.0)`.
8. The engine total changes from `0.0` to `5.0`.

## Repair code

Repair this listener. It has two defects: it calls the engine directly, and it ignores the handler
that the constructor receives.

```java
class BrokenAddButtonListener implements ActionListener {
    private CommandHandler handler;

    public BrokenAddButtonListener(CommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        engine.add(5.0);
    }
}
```

The repaired method calls `this.handler.handle(5.0)`. That keeps the trigger layer separate from
the logic layer.

## Execute-gate handshake

Before you run the window, complete the handshake:

| Part | Your statement |
|------|----------------|
| **Goal** | The button press calls the existing add handler. |
| **Constraints** | I may change Swing wiring. I may not change the handler or engine logic. |
| **Prediction** | One press prints the add result and changes the total to `5.0`. |
| **Success check** | The window opens, the button responds, and the console output matches the console path. |

The coach says **“Agreed.”** That word opens the gate. Then run the program.

## Small coding task

Add a second button for the existing clear handler. Use a label that states the action. Keep the
calculator engine and both handlers unchanged.

## Test evidence

Record three observations:

| Tier | Action | Expected | Actual | Match? |
|------|--------|----------|--------|--------|
| Normal | Press Add 5 | The add handler runs | | |
| Boundary | Press Clear before adding | The total remains zero | | |
| Failure | Press a button whose listener is not registered | No handler runs | | |

## Explanation

Explain why changing the trigger from a console command to a button does not require a change to
`CalculatorEngine`. Name the method that Swing calls and the method that the listener calls.

## Role rotation

Switch roles after the first successful button press. The new coach asks the player to identify
the event source, the listener method, the handler method, and the success evidence.

## Transfer task

Wire the existing multiply handler to a new button. Do not copy the calculator logic into the
listener. The changed condition is the event source: the dispatcher no longer supplies the event.
The same handler class must still perform the calculation.

## Reflection

Write three sentences:

1. The part of the console path that stayed unchanged was...
2. The Swing listener's only responsibility was...
3. A student without a local display can demonstrate the same CLO-4 skill by...

## Mastery record

| Skill | Evidence | Complete |
|-------|----------|----------|
| Identify the Swing event and listener method | Explanation | [ ] |
| Connect a button to an existing handler | Working button | [ ] |
| Keep logic independent of Swing | Code inspection | [ ] |
| Compare normal, boundary, and failure behavior | Test evidence table | [ ] |

