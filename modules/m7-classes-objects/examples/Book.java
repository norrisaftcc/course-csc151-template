// Book.java
// Module 7 — Classes and Objects
// CSC 151 Java Programming I
//
// One class definition, several objects built from it, and a second class
// that holds those objects in an ArrayList. Shelf lives in this same file on
// purpose: the course verifier copies each .java file into an empty directory
// and compiles it alone, so a file that names a class defined elsewhere does
// not compile.
//
// The tests for this file are in ../tests/BookTest.java.
// Run them with:  bash scripts/verify.sh test
//
// Expected output:
//   Dune by Frank Herbert (412 pages)
//   The Odyssey by Homer (541 pages)
//   Books on the shelf: 2
//   Total pages: 953
//   setPages(0) refused, pages still 412
//   setPages(350) accepted, pages now 350
//   Total pages: 891

import java.util.ArrayList;

public class Book {

    // private fields. Code outside this class reaches them only through the
    // methods below, so the class controls what a Book may become.
    private String title;
    private String author;
    private int pages;

    /**
     * Builds one Book.
     *
     * @param title  the book's title
     * @param author the book's author
     * @param pages  the page count, expected to be 1 or more
     */
    public Book(String title, String author, int pages) {
        // this.title names the field and title names the parameter. Written
        // as title = title, the parameter is assigned to itself, the field
        // keeps its starting value of null, and the object prints "null" with
        // no error anywhere to point at the line that caused it.
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    /** Returns the book's title. */
    public String getTitle() {
        return this.title;
    }

    /** Returns the book's author. */
    public String getAuthor() {
        return this.author;
    }

    /** Returns the book's current page count. */
    public int getPages() {
        return this.pages;
    }

    /**
     * Sets the page count when the new value is valid.
     *
     * @param pages the proposed page count; 0 and negative values are refused
     *              and the previous page count stays in place
     */
    public void setPages(int pages) {
        // A setter that stores whatever it is handed is a field with extra
        // typing. The guard is the reason the field is private: a book with
        // zero pages can never exist, no matter what a caller asks for.
        if (pages > 0) {
            this.pages = pages;
        }
    }

    /**
     * Returns a one-line description of this book.
     *
     * @return the title, the author and the page count
     */
    @Override
    public String toString() {
        // println and string concatenation call toString for you. Without
        // this method they print the class name and a hash code, which looks
        // like Book@6d06d69c and tells a reader nothing.
        return this.title + " by " + this.author + " (" + this.pages + " pages)";
    }

    public static void main(String[] args) {
        Book dune = new Book("Dune", "Frank Herbert", 412);
        Book odyssey = new Book("The Odyssey", "Homer", 541);

        // Two objects, one class. dune and odyssey hold separate values in
        // separate fields, so changing one leaves the other where it was.
        System.out.println(dune);
        System.out.println(odyssey);

        Shelf shelf = new Shelf();
        shelf.add(dune);
        shelf.add(odyssey);

        System.out.println("Books on the shelf: " + shelf.size());
        System.out.println("Total pages: " + shelf.totalPages());

        dune.setPages(0);
        System.out.println("setPages(0) refused, pages still " + dune.getPages());

        dune.setPages(350);
        System.out.println("setPages(350) accepted, pages now " + dune.getPages());

        // The shelf holds the same Book object, not a copy of it, so the new
        // page count reaches the total without the shelf being told anything.
        System.out.println("Total pages: " + shelf.totalPages());
    }
}

/**
 * Holds Book objects and reports totals across them.
 *
 * This class is package-private and lives in Book.java, because the verifier
 * compiles each file on its own. A file carries one public class at most.
 */
class Shelf {

    private ArrayList<Book> books = new ArrayList<>();

    /**
     * Puts one book on the shelf.
     *
     * @param book the book to hold
     */
    public void add(Book book) {
        this.books.add(book);
    }

    /** Returns how many books the shelf holds. */
    public int size() {
        return this.books.size();
    }

    /**
     * Returns the page count of every book on the shelf, added together.
     *
     * @return 0 when the shelf holds no books
     */
    public int totalPages() {
        int total = 0;
        for (Book book : this.books) {
            total += book.getPages();
        }
        return total;
    }
}
