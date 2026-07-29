# FAQ — Common Beginner Errors in Java

This page describes the 10 most common errors that new Java programmers encounter. Each entry names the error, explains what it means, and gives a diagnosis and fix in plain language.

Use your browser's search (Ctrl+F or Cmd+F) to find an error by its name or message text.

---

## 1. Missing semicolon

**Error message:**
```
error: ';' expected
        System.out.println("Hello")
                                   ^
```

**What it means:** Java requires a semicolon at the end of every statement. The compiler found a statement that does not end with one.

**Diagnosis:** Look at the line the caret (`^`) points to, and the line immediately before it. One of them is missing a `;`.

**Fix:** Add `;` at the end of the statement.

```java
// Before (broken)
System.out.println("Hello")

// After (fixed)
System.out.println("Hello");
```

---

## 2. Using `=` instead of `==`

**Error message:** No compile error. The program runs but produces unexpected results.

**What it means:** `=` assigns a value. `==` compares two values. Using `=` inside an `if` condition attempts an assignment where a comparison is expected.

**Diagnosis:** In Java, `=` inside an `if` condition often causes a compile error if the variable is not a `boolean`. If it is a `boolean`, the code compiles but does the wrong thing.

**Fix:** Replace `=` with `==` in comparisons.

```java
// Before (wrong)
if (score = 100) { ... }

// After (correct)
if (score == 100) { ... }
```

---

## 3. `ArrayIndexOutOfBoundsException`

**Error message:**
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
```

**What it means:** You tried to access an array element at an index that does not exist. Arrays of length 5 have indices 0 through 4. Index 5 is one past the last element.

**Diagnosis:** Check the loop or index expression that accesses the array. A `for` loop that uses `<=` instead of `<` is the most common cause.

**Fix:** Use `< array.length`, not `<= array.length`.

```java
// Before (broken — accesses index 5 in a 5-element array)
for (int i = 0; i <= numbers.length; i++) { ... }

// After (fixed)
for (int i = 0; i < numbers.length; i++) { ... }
```

---

## 4. `NullPointerException`

**Error message:**
```
Exception in thread "main" java.lang.NullPointerException
```

**What it means:** You tried to call a method or access a field on a variable that holds `null` (no object). `null` is not an object; it has no methods.

**Diagnosis:** Find the line in the stack trace. Look at each object reference on that line. One of them has not been initialized.

**Fix:** Make sure the variable points to an actual object before you use it.

```java
// Before (broken — name is null)
String name = null;
System.out.println(name.length());   // NullPointerException

// After (fixed)
String name = "Jordan";
System.out.println(name.length());   // prints 6
```

---

## 5. Integer division discards the decimal

**Error message:** No error. The program runs but the result is a whole number when a decimal was expected.

**What it means:** When both operands of `/` are `int`, Java performs integer division: the result is a whole number and the remainder is discarded. `7 / 2` evaluates to `3`, not `3.5`.

**Diagnosis:** Check whether both operands of `/` are `int`. If so, the result is an `int`.

**Fix:** Cast one operand to `double`, or use a `double` literal.

```java
// Before (gives 3, not 3.5)
int result = 7 / 2;

// After (gives 3.5)
double result = (double) 7 / 2;
// or
double result = 7.0 / 2;
```

---

## 6. `cannot find symbol`

**Error message:**
```
error: cannot find symbol
        System.out.println(scroe);
                           ^
  symbol:   variable scroe
  location: class HelloWorld
```

**What it means:** The compiler cannot find a variable, method, or class with the name you used. This is almost always a spelling mistake.

**Diagnosis:** Read the symbol name in the error message carefully. Compare it to where you declared the variable.

**Fix:** Fix the spelling so the name matches the declaration exactly. Java is case-sensitive: `score` and `Score` are different variables.

```java
// Before (typo)
int score = 85;
System.out.println(scroe);   // error: cannot find symbol

// After (fixed)
System.out.println(score);
```

---

## 7. Class name does not match file name

**Error message:**
```
error: class MyProgram is public, should be in a file named MyProgram.java
```

**What it means:** Java requires that a `public` class name match the name of the file that contains it, including uppercase letters.

**Diagnosis:** Read the class name in your source code. Check whether the file name matches it exactly.

**Fix:** Rename the file to match the class name, or rename the class to match the file.

```
// File is named hello.java but the class is HelloWorld — mismatch
// Fix: rename the file to HelloWorld.java
```

---

## 8. `reached end of file while parsing`

**Error message:**
```
error: reached end of file while parsing
}
 ^
```

**What it means:** The compiler reached the end of the file before it found a closing brace `}` that matches an opening brace `{`.

**Diagnosis:** Count opening and closing braces from the top of the file. There should be the same number of each.

**Fix:** Add the missing `}`. Check your class body and your method body.

```java
// Before (missing closing brace for the class)
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
// missing }

// After (fixed)
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

---

## 9. Infinite loop

**Error message:** No compile error. The program runs but never stops printing or never returns to the prompt.

**What it means:** The loop condition never becomes `false`, so the loop continues forever.

**Diagnosis:** Check the loop condition and the update expression. Confirm that the variable in the condition changes during each iteration.

**Fix:** Correct the update expression or the condition.

```java
// Before (infinite loop — i never changes)
int i = 0;
while (i < 10) {
    System.out.println(i);
    // missing i++
}

// After (fixed)
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

---

## 10. Off-by-one error

**Error message:** No error. The program runs and produces output that is close to correct but processes one too many or one too few elements.

**What it means:** The loop starts or ends at the wrong index. For an array of length `n`, valid indices are `0` through `n-1`. Starting at `1` skips the first element; ending at `n` causes an `ArrayIndexOutOfBoundsException`.

**Diagnosis:** Trace the loop manually for a small array (two or three elements). Write the value of the index at each iteration on paper.

**Fix:** Adjust the starting index or the boundary condition.

```java
// Before (skips the first element)
for (int i = 1; i < numbers.length; i++) { ... }

// After (processes all elements, 0 through length-1)
for (int i = 0; i < numbers.length; i++) { ... }
```

---

## Quick reference

| Error | Type | Most common cause |
|-------|------|-------------------|
| `';' expected` | Compile | Missing semicolon |
| Wrong result, no error | Logic | `=` instead of `==` |
| `ArrayIndexOutOfBoundsException` | Runtime | `<=` instead of `<` in loop |
| `NullPointerException` | Runtime | Uninitialized object reference |
| Wrong decimal result | Logic | Integer division |
| `cannot find symbol` | Compile | Spelling or capitalization mistake |
| Class/file name mismatch | Compile | File name does not match class name |
| `reached end of file` | Compile | Missing closing `}` |
| Program never stops | Logic | Loop update missing |
| Wrong count | Logic | Off-by-one (start or end index) |
