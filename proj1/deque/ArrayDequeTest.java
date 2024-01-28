package deque;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Performs some basic linked list tests.
 */
public class ArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */ public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */ public void addRemoveTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */ public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/ public void multipleParamTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */ public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */ public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /* check if get methods work properly */ public void testGetItems() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        for (int i = 0; i < 9; i++) {
            lld2.addLast(i);
        }
        lld.addLast(4);
        lld.addFirst(3);
        lld.addLast(5);
        lld.addFirst(2);
        lld.addLast(6);
        lld.addFirst(1);
        lld.addLast(7);
        lld.addFirst(0);
        lld.printDeque();
        System.out.println("-----------------------------");
        lld.addLast(8);
        lld.printDeque();
        System.out.println("-----------------------------");
        lld.removeFirst();
        lld.removeLast();
        lld.removeFirst();
        lld.removeLast();
        lld.removeFirst();
        lld.printDeque();
        System.out.println("-----------------------------");
        lld.removeFirst();
        lld.printDeque();
        System.out.println("-----------------------------");
        System.out.print(lld.get(0) + " ");
        System.out.print(lld.get(1) + " ");
        System.out.print(lld.get(2) + " ");
        System.out.print(lld.get(3) + " ");
        System.out.print(lld.get(4) + " ");
        System.out.print(lld.get(5) + " ");
        System.out.print(lld.get(6) + " ");
        System.out.print(lld.get(7) + " ");
        System.out.print(lld.get(8) + " ");
        System.out.println("\n-----------------------------");

        System.out.println(lld.equals(lld2));
        lld2.removeFirst();
        lld2.removeLast();
        lld2.removeFirst();
        lld2.removeLast();
        lld2.removeFirst();
        lld2.removeFirst();
        System.out.println(lld.equals(lld2));
        System.out.println(lld2.equals(lld));
    }

    @Test
    public void autoGrader() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(4);
        lld.addLast(6);
        lld.removeFirst();
        lld.removeLast();
        lld.addFirst(9);
        lld.addLast(11);
        lld.addLast(12);
        lld.addFirst(13);
        lld.addLast(14);
        lld.addFirst(15);
        lld.addLast(16);
        lld.removeLast();
        lld.removeFirst();
        lld.removeLast();
        lld.removeLast();
        lld.removeFirst();
        lld.removeLast();
        lld.removeFirst();
        System.out.println(lld.get(2));
    }

}