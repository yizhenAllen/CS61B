package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yizhenAllen.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> trueArray = new AListNoResizing<>();
        BuggyAList<Integer> testArray = new BuggyAList<>();
        for (int add = 4; add < 7; add++) {
            trueArray.addLast(add);
            testArray.addLast(add);
        }
        assertEquals(trueArray.removeLast(), testArray.removeLast());
        assertEquals(trueArray.removeLast(), testArray.removeLast());
        assertEquals(trueArray.removeLast(), testArray.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> testArray = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                testArray.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int testSize = testArray.size();
                assertEquals(size, testSize);
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    assertEquals(L.getLast(), testArray.getLast());
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    int right = L.removeLast();
                    int test = testArray.removeLast();
                    assertEquals(right, test);
                }
            }
        }
    }
}
