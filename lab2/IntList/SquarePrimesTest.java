package IntList;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple2() {
        IntList input = IntList.of(1, 2, 3, 4, 5, 6, 7);
        String expected = IntList.of(1, 4, 9, 4, 25, 6, 49).toString();
        boolean output = IntListExercises.squarePrimes(input);
        assertTrue(output);
        assertEquals(expected, input.toString());
    }

    @Test
    public void testSquarePrimesSimple3() {
        IntList input = IntList.of(1, 4, 6, 8, 10);
        String expected = IntList.of(1, 4, 6, 8, 10).toString();
        boolean output = IntListExercises.squarePrimes(input);
        assertFalse(output);
        assertEquals(expected, input.toString());
    }
}
