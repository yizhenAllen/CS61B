package deque;

import java.util.*;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] array;
    private int size;
    private int nextFirst, nextLast;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int circleNext(int toBePlus, int len) {
        if (toBePlus == len - 1) {
            return 0;
        } else {
            return ++toBePlus;
        }
    }

    private int circlePrev(int toBeMinus, int len) {
        if (toBeMinus == 0) {
            return len - 1;
        } else {
            return --toBeMinus;
        }
    }

    private void expend() {
        int len = array.length;
        T[] newArray = (T[]) new Object[len * 2];
        for (int i = 1; i <= size; i++) {
            newArray[i] = array[circleNext(nextFirst, len)];
            nextFirst = circleNext(nextFirst, len);
        }
        nextFirst = 0;
        nextLast = size + 1;
        array = newArray;
    }

    private void contract() {
        if (array.length >= 16) {
            int len = array.length;
            int targetLen = array.length / 2;
            T[] newArray = (T[]) new Object[targetLen];
            for (int i = 1; i <= size; i++) {
                newArray[i] = array[circleNext(nextFirst, len)];
                nextFirst = circleNext(nextFirst, len);
            }
            nextFirst = 0;
            nextLast = size + 1;
            array = newArray;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int cur = circleNext(nextFirst, array.length);
            private boolean first = true;

            @Override
            public boolean hasNext() {
                if (size != array.length) {
                    return cur != nextLast;
                } else {
                    return (cur != nextLast) || first;
                }
            }

            @Override
            public T next() {
                T item = array[cur];
                cur = circleNext(cur, array.length);
                first = false;
                return item;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        return DequeUtil.equals(this, o);
    }

    @Override
    public void addFirst(T item) {
        if (size == array.length) {
            expend();
        }
        array[nextFirst] = item;
        size += 1;
        nextFirst = circlePrev(nextFirst, array.length);
    }

    @Override
    public void addLast(T item) {
        if (size == array.length) {
            expend();
        }
        array[nextLast] = item;
        size += 1;
        nextLast = circleNext(nextLast, array.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (T item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            int realIndex = (nextFirst + 1 + index) % array.length;
            return array[realIndex];
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if ((size - 1) / (double) array.length < 0.25) {
            contract();
        }
        T result = array[circleNext(nextFirst, array.length)];
        array[circleNext(nextFirst, array.length)] = null;
        size -= 1;
        nextFirst = circleNext(nextFirst, array.length);
        return result;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if ((size - 1) / (double) array.length < 0.25) {
            contract();
        }
        T result = array[circlePrev(nextLast, array.length)];
        array[circlePrev(nextLast, array.length)] = null;
        size -= 1;
        nextLast = circlePrev(nextLast, array.length);
        return result;
    }
}
