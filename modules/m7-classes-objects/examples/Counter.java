// Counter.java
// Module 7 — Classes and Objects
// CSC 151 Java Programming I
//
// One field, one method that changes it, one method that reports it, and two
// objects built from the same class and stepped in an interleaved order.
// Trace this file before running it: after every line, write down what each
// of the two counters holds.
//
// Expected output:
//   start: left 0, right 0
//   left.increment(): left 1, right 0
//   left.increment(): left 2, right 0
//   right.increment(): left 2, right 1
//   left.increment(): left 3, right 1
//   right.increment(): left 3, right 2

public class Counter {

    private int count;

    /** Builds a counter that starts at 0. */
    public Counter() {
        this.count = 0;
    }

    /**
     * Adds one to this counter.
     *
     * The word "this" names the object the call was made on. left.increment()
     * changes left and nothing else, because each object carries its own copy
     * of the count field. Two objects of one class do not share a field.
     */
    public void increment() {
        this.count = this.count + 1;
    }

    /** Returns this counter's current value. */
    public int count() {
        return this.count;
    }

    public static void main(String[] args) {
        // new runs the constructor once and hands back one object. Two calls
        // to new build two separate objects, so left and right start equal
        // and then part ways.
        Counter left = new Counter();
        Counter right = new Counter();

        System.out.println("start: left " + left.count() + ", right " + right.count());

        left.increment();
        System.out.println("left.increment(): left " + left.count() + ", right " + right.count());

        left.increment();
        System.out.println("left.increment(): left " + left.count() + ", right " + right.count());

        right.increment();
        System.out.println("right.increment(): left " + left.count() + ", right " + right.count());

        left.increment();
        System.out.println("left.increment(): left " + left.count() + ", right " + right.count());

        right.increment();
        System.out.println("right.increment(): left " + left.count() + ", right " + right.count());
    }
}
