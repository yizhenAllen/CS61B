package deque;

import java.util.*;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> compareMethod;

    public MaxArrayDeque(Comparator<T> c) {
        compareMethod = c;
    }

    /**
     * return max item using compareMethod, return null if Deque is empty
     */
    public T max() {
        if (size() == 0) {
            return null;
        } else {
            T maxItem = get(0);
            for (T item : this) {
                if (compareMethod.compare(item, maxItem) > 0) {
                    maxItem = item;
                }
            }
            return maxItem;
        }
    }

    /**
     * return max item using arbitrary Comparator c, return null if Deque is empty
     */
    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        } else {
            T maxItem = get(0);
            for (T item : this) {
                if (c.compare(item, maxItem) > 0) {
                    maxItem = item;
                }
            }
            return maxItem;
        }
    }

    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };

        Comparator<Double> c2 = new Comparator<>() {
            @Override
            public int compare(Double a, Double b) {
                return a.compareTo(b);
            }
        };

        MaxArrayDeque<Integer> amd = new MaxArrayDeque<>(c);
        MaxArrayDeque<Double> amd2 = new MaxArrayDeque<>(c2);
        amd2.addFirst(-5.3);
        amd2.addFirst(6.3);
        amd2.addFirst(-8.3);
        amd2.addFirst(-7.3);
        amd2.printDeque();
        System.out.println(amd2.max());
    }
}
