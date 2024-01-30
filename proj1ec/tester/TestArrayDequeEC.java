package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    /* test addFirst(), addLast(), removeFirst(), removeLast() */
    @Test
    public void testDeque() {
        StudentArrayDeque<Integer> wrongDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctDeque = new ArrayDequeSolution<>();
        String operations = "";
        for (int i = 0; i < 500; i++) {
            int random = StdRandom.uniform(4);
            if (random == 0) {
                // test addFirst
                Integer toAdd = StdRandom.uniform(11) - 5;
                wrongDeque.addFirst(toAdd);
                correctDeque.addFirst(toAdd);
                String operation = "addFirst(" + toAdd + ")\n";
                operations += operation;
                assertEquals(operations, correctDeque.get(0), wrongDeque.get(0));
            } else if (random == 1) {
                // test addLast
                Integer toAdd = StdRandom.uniform(11) - 5;
                wrongDeque.addLast(toAdd);
                correctDeque.addLast(toAdd);
                String operation = "addLast(" + toAdd + ")\n";
                operations += operation;
                assertEquals(operations, correctDeque.get(correctDeque.size() - 1), wrongDeque.get(wrongDeque.size() - 1));
            } else if (random == 2 && !correctDeque.isEmpty()) {
                // test removeFirst
                Integer wrongFirst = wrongDeque.removeFirst();
                Integer correctFirst = correctDeque.removeFirst();
                String operation = "removeFirst()\n";
                operations += operation;
                assertEquals(operations, correctFirst, wrongFirst);
            } else if (random == 3 && !correctDeque.isEmpty()) {
                // test removeLast
                Integer wrongLast = wrongDeque.removeLast();
                Integer correctLast = correctDeque.removeLast();
                String operation = "removeLast()\n";
                operations += operation;
                assertEquals(operations, correctLast, wrongLast);
            }
        }
    }
}
