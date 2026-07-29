# Lesson 2: Input and Output

**Module:** 2 — Input and Output  
**Estimated time:** 50–75 minutes  
**Prerequisites:** You can compile and run a Java program. You can declare `int`, `double`, and `String` variables (Module 1).

---

## Learning goal

After this lesson, you can:

- Read user input using `Scanner` for `int`, `double`, and `String` values.
- Format output using `System.out.printf`.
- Write a program that completes an input → process → output cycle.

---

## Prior knowledge check

Before starting, confirm you can do the following:

- [ ] Declare and assign a variable of type `int`, `double`, and `String`.
- [ ] Compile and run a Java program from the command line or your IDE.

If you cannot do both of these, complete Module 1 (Variables and Expressions) first.

---

## Concept explanation

### What is input?

So far every value in your programs has been written directly in the code — for example, `int score = 85;`. A program that reads values from the **user at run time** is more useful. The user can provide a different score each time without changing the source code.

In Java, the standard way to read keyboard input is the `Scanner` class.

### Importing Scanner

`Scanner` lives in the `java.util` package. You must import it before you can use it:

```java
import java.util.Scanner;
```

Place this line at the top of your file, above the `public class` line.

### Creating a Scanner

```java
Scanner input = new Scanner(System.in);
```

This creates a `Scanner` object named `input` that reads from the keyboard (`System.in`).

### Reading values

| What you want to read | Method | Example |
|-----------------------|--------|---------|
| One `int` | `input.nextInt()` | `int age = input.nextInt();` |
| One `double` | `input.nextDouble()` | `double price = input.nextDouble();` |
| One word (stops at whitespace) | `input.next()` | `String word = input.next();` |
| A full line (stops at Enter) | `input.nextLine()` | `String line = input.nextLine();` |

**Order of output and input:** Always print a prompt with `System.out.print` before calling a read method. This tells the user what to type.

```java
System.out.print("Enter your age: ");
int age = input.nextInt();
```

### Closing the Scanner

When you are done reading input, close the `Scanner`:

```java
input.close();
```

### Formatted output with printf

`System.out.println` always prints a line break at the end. `System.out.printf` lets you control the format more precisely using **format specifiers**.

| Specifier | Meaning | Example |
|-----------|---------|---------|
| `%d` | `int` | `printf("%d", 42)` → `42` |
| `%f` | `double` | `printf("%f", 3.14)` → `3.140000` |
| `%.2f` | `double`, 2 decimal places | `printf("%.2f", 3.14)` → `3.14` |
| `%s` | `String` | `printf("%s", "hello")` → `hello` |
| `%n` | newline (platform-safe) | use instead of `\n` in printf |

Example:
```java
double price = 4.99;
int qty = 3;
System.out.printf("Price: $%.2f  Qty: %d%n", price, qty);
// Output: Price: $4.99  Qty: 3
```

### The input → process → output pattern

Most useful programs follow this pattern:

1. **Input:** Read values from the user.
2. **Process:** Compute a result.
3. **Output:** Print the result.

```java
// Input
System.out.print("Enter a number: ");
int n = input.nextInt();

// Process
int doubled = n * 2;

// Output
System.out.printf("Double: %d%n", doubled);
```

---

## Worked example

The following program reads a name, a score, and a bonus, then prints a formatted summary.

```java
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your score (int): ");
        int score = input.nextInt();

        System.out.print("Enter your bonus multiplier (double): ");
        double bonus = input.nextDouble();

        double adjusted = score * bonus;

        System.out.println("-------------------------");
        System.out.printf("Name:     %s%n", name);
        System.out.printf("Score:    %d%n", score);
        System.out.printf("Bonus:    %.1f%n", bonus);
        System.out.printf("Adjusted: %.1f%n", adjusted);

        input.close();
    }
}
```

**Sample interaction** (user types after the colon):
```
Enter your name: Jordan
Enter your score (int): 85
Enter your bonus multiplier (double): 1.5
-------------------------
Name:     Jordan
Score:    85
Bonus:    1.5
Adjusted: 127.5
```

**What to notice:**
- `import java.util.Scanner;` appears before `public class`.
- `System.out.print` (without `ln`) keeps the cursor on the same line as the prompt.
- `%.1f` prints a `double` with exactly one decimal place.
- `input.close()` releases the resource when input is done.

---

## Trace before running

**Task:** Read the following code. Do not run it yet. Answer the questions, then check your answers.

```java
import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bill amount: ");
        double bill = input.nextDouble();

        double tip = bill * 0.20;
        double total = bill + tip;

        System.out.printf("Tip: $%.2f%n", tip);
        System.out.printf("Total: $%.2f%n", total);

        input.close();
    }
}
```

Assume the user enters `50.00`.

**Prediction questions:**

1. What is the value of `tip`?
2. What is the value of `total`?
3. What does the program print?

Write your answers before continuing.

<details>
<summary>Answers (open after recording your predictions)</summary>

1. `tip = 50.00 * 0.20 = 10.0`
2. `total = 50.00 + 10.0 = 60.0`
3.
```
Tip: $10.00
Total: $60.00
```

</details>

---

## Repair code

The following code contains two errors. Find them and fix them.

```java
import java.util.Scanner;

public class Broken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a whole number: ");
        double n = sc.nextInt();

        System.out.printf("Double: %f%n", n * 2);
    }
}
```

**Errors to find:**

1. A type mismatch: the variable type does not match the method used.
2. A format mismatch: the format specifier does not produce the cleanest output for an integer result.

Write your fix for each before checking.

<details>
<summary>Answers</summary>

1. `n` is declared as `double` but `nextInt()` returns `int`. Either change `double n` to `int n`, or use `nextDouble()`.
2. `%f` prints six decimal places. Use `%d` if `n` is an `int`, or `%.0f` if it must stay `double`.

</details>

---

## Execute-gate handshake

Before writing your own code, complete the handshake with your coach.

**Coach provides:**

> Write a program named `AreaCalc` that reads two `double` values from the user — the width and the height of a rectangle — and prints the area formatted to two decimal places. The prompt for width must appear before the prompt for height.

**Player must confirm:**

- Goal: "The program must read width and height, compute width × height, and print the result to two decimal places."
- Constraints: "I may use `Scanner`, `double`, and `printf`. I may not hard-code the width or height values."
- Prediction: "If the user enters `5.0` and `3.0`, I expect the output to be `Area: 15.00`."
- Success check: "We know it works when entering different values produces the correct area, formatted with two decimal places."

**Gate opens when the coach says: "Agreed."**

---

## Small coding task

**Task:** Write a program named `AreaCalc` that:

1. Prompts the user for the width of a rectangle (`double`).
2. Prompts the user for the height of a rectangle (`double`).
3. Computes the area (`width * height`).
4. Prints the result using `printf` in this format: `Area: 15.00`

Requirements:
- Use `Scanner` for input.
- Use `printf` with `%.2f` for output.
- Close the `Scanner` when done.

Test cases to pass:
- Width `5.0`, height `3.0` → `Area: 15.00`
- Width `10.0`, height `2.5` → `Area: 25.00`
- Width `1.0`, height `1.0` → `Area: 1.00`

---

## Test evidence

After running your code, record the following:

| Test | Expected output | Actual output | Pass? |
|------|----------------|---------------|-------|
| 5.0 × 3.0 | `Area: 15.00` | | |
| 10.0 × 2.5 | `Area: 25.00` | | |
| 1.0 × 1.0 | `Area: 1.00` | | |

---

## Explanation

Answer the following in writing or out loud to your coach:

1. What is the difference between `System.out.println` and `System.out.printf`?
2. Why must you print a prompt before calling `input.nextDouble()`?
3. What evidence shows your area calculation is correct?
4. What would go wrong if you used `%d` instead of `%.2f` to print a `double`?

---

## Role rotation

Switch roles with your partner. The new coach describes the next task. The new player restates the plan and completes the handshake.

---

## Transfer task

**Changed condition:** Instead of area, compute the perimeter of the rectangle.

**Task:** Modify or copy your `AreaCalc` program to read width and height, then print both the area and the perimeter. Format both values to two decimal places. Use the format:

```
Area:      15.00
Perimeter: 16.00
```

Complete the full handshake with your coach before writing any code.

---

## Reflection

Answer one of the following:

- What does `System.in` represent? What would you pass instead of `System.in` if you wanted to read from a file?
- Why does `input.nextLine()` behave differently from `input.next()`? When would you choose each one?
- What is the difference between `print` and `println`? Give an example where using the wrong one would cause a bug.

---

## Mastery record

| Skill | Not yet | Developing | Secure |
|-------|---------|------------|--------|
| Import `java.util.Scanner` and create a `Scanner` object | | | |
| Read an `int` with `nextInt()` | | | |
| Read a `double` with `nextDouble()` | | | |
| Read a `String` with `nextLine()` | | | |
| Print a prompt before each read | | | |
| Format output with `printf` and `%.2f` | | | |
| Write a complete input → process → output program | | | |
| Complete the execute-gate handshake | | | |
| Coach role completed | | | |
| Transfer task completed independently | | | |
