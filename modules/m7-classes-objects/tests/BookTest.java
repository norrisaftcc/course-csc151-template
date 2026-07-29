// BookTest.java
// Module 7 — Classes and Objects
// CSC 151 Java Programming I
//
// Unit tests for ../examples/Book.java.
//
// Run them with:  bash scripts/verify.sh test
//
// Book.java holds two classes. Book is the public one: private fields, a
// constructor, getters, a validating setPages, and toString. Shelf is a
// package-private class in the same file, and it holds an ArrayList<Book>.
// Both live in one file because the verifier compiles each example on its
// own, so an example may not reach into a second file for a class it needs.
//
// This file shows the three test tiers this course requires as evidence:
//
//   Normal   — an ordinary book, and a shelf holding two of them.
//   Boundary — the lowest page count the setter accepts, and a shelf with
//              nothing on it.
//   Failure  — page counts the setter must reject, and the shelf total that
//              must not move when it rejects one.
//
// Every method below is named for what it claims, because the name is the
// first thing you read when a test fails. "setPages_keepsPreviousValue_forZero"
// tells you what broke. "test3" does not.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    // ---- Normal: one ordinary book -------------------------------------

    @Test
    @DisplayName("the constructor stores the title the caller passes")
    void getTitle_returnsConstructorArgument_forNewBook() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        // A constructor that writes title = title instead of this.title = title
        // assigns the parameter to itself, and this test reads null.
        assertEquals("Dune", book.getTitle());
    }

    @Test
    @DisplayName("the constructor stores the author the caller passes")
    void getAuthor_returnsConstructorArgument_forNewBook() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        assertEquals("Frank Herbert", book.getAuthor());
    }

    @Test
    @DisplayName("the constructor stores the page count the caller passes")
    void getPages_returnsConstructorArgument_forNewBook() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        assertEquals(412, book.getPages());
    }

    @Test
    @DisplayName("toString describes the book in one line")
    void toString_returnsTitleAuthorAndPages_forNewBook() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        // A method spelled ToString overrides nothing, so println falls back
        // to the inherited version and prints a class name and a hash code.
        assertEquals("Dune by Frank Herbert (412 pages)", book.toString());
    }

    // ---- Normal: a shelf holding two books ------------------------------

    @Test
    @DisplayName("a shelf counts the books added to it")
    void size_returnsTwo_forShelfWithTwoBooks() {
        Shelf shelf = new Shelf();
        shelf.add(new Book("Dune", "Frank Herbert", 412));
        shelf.add(new Book("Field Notes", "R. Alvarez", 188));
        assertEquals(2, shelf.size());
    }

    @Test
    @DisplayName("a shelf totals the pages of every book on it")
    void totalPages_returnsSixHundred_forShelfWithTwoBooks() {
        Shelf shelf = new Shelf();
        shelf.add(new Book("Dune", "Frank Herbert", 412));
        shelf.add(new Book("Field Notes", "R. Alvarez", 188));
        assertEquals(600, shelf.totalPages());
    }

    @Test
    @DisplayName("two books built from one class hold separate page counts")
    void getPages_returnsSeparateValues_forTwoBooks() {
        // One class, two objects, two copies of every field. Changing one
        // leaves the other where it was.
        Book first = new Book("Dune", "Frank Herbert", 412);
        Book second = new Book("Field Notes", "R. Alvarez", 188);

        first.setPages(300);

        assertEquals(300, first.getPages());
        assertEquals(188, second.getPages());
    }

    // ---- Boundary: the lowest accepted page count, and an empty shelf ----

    @Test
    @DisplayName("setPages accepts 1, the lowest valid page count")
    void setPages_storesOne_forLowestValidPageCount() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        book.setPages(1);
        // 1 is inside the range. A guard written pages <= 1 rejects it and
        // this test reads 412.
        assertEquals(1, book.getPages());
    }

    @Test
    @DisplayName("a shelf with no books reports a size of 0")
    void size_returnsZero_forEmptyShelf() {
        Shelf shelf = new Shelf();
        assertEquals(0, shelf.size());
    }

    @Test
    @DisplayName("a shelf with no books reports a total of 0 pages")
    void totalPages_returnsZero_forEmptyShelf() {
        // The loop body never runs, so the total comes from the starting value.
        Shelf shelf = new Shelf();
        assertEquals(0, shelf.totalPages());
    }

    // ---- Failure: page counts the setter must reject ---------------------
    //
    // The setter validates rather than throws, so the evidence that it worked
    // is the value it left alone. Each test reads the field back after the
    // rejected call.

    @Test
    @DisplayName("setPages rejects 0 and keeps the previous page count")
    void setPages_keepsPreviousValue_forZero() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        book.setPages(0);
        assertEquals(412, book.getPages());
    }

    @Test
    @DisplayName("setPages rejects a negative page count and keeps the previous one")
    void setPages_keepsPreviousValue_forNegativePageCount() {
        Book book = new Book("Dune", "Frank Herbert", 412);
        book.setPages(-10);
        assertEquals(412, book.getPages());
    }

    @Test
    @DisplayName("a shelf total does not move when the setter rejects a value")
    void totalPages_isUnchanged_afterRejectedSetter() {
        Shelf shelf = new Shelf();
        Book book = new Book("Dune", "Frank Herbert", 412);
        shelf.add(book);

        book.setPages(-10);

        // The shelf holds the same object the test changed, so a total that
        // moved here would mean the setter stored the rejected value.
        assertEquals(412, shelf.totalPages());
    }
}
