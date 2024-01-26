package deque;

public class ArrayDeque<T> {
    T[] array;
    int size;
    int nextFirst, nextLast;
    double usage;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        usage = size / (double) array.length;
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
        nextFirst += array.length;
        usage = 0.5;
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = circleNext(nextFirst, 2 * array.length); i != nextLast; i = circleNext(i, 2 * array.length)) {
            int tmp = (i - array.length) % array.length;
            int oldIndex = tmp < 0 ? tmp + array.length : tmp;
            newArray[i] = array[oldIndex];
        }
        array = newArray;
    }

    private void contract() {
        if (array.length >= 16) {
            //TODO
            int targetLen = array.length / 2;
            usage = size / (double) targetLen;
//        nextFirst -=; nextLast -=; T[] newArray = (T[]) new Object[targetLen];
        }
    }

    public void addFirst(T item) {
        if (size == array.length) {
            expend();
        }
        array[nextFirst] = item;
        size += 1;
        usage = size / (double) array.length;
        nextFirst = circlePrev(nextFirst, array.length);
    }

    public void addLast(T item) {
        if (size == array.length) {
            expend();
        }
        array[nextLast] = item;
        size += 1;
        usage = size / (double) array.length;
        nextLast = circleNext(nextLast, array.length);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void printDeque() {
        if (size > 0) {
            for (int i = circleNext(nextFirst, array.length); i != nextLast; i = circleNext(i, array.length)) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            int realIndex = (nextFirst + 1 + index) % array.length;
            return array[realIndex];
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if ((size - 1) / (double) array.length < 0.25) {
            contract();
        }
        T result = array[circleNext(nextFirst, array.length)];
        array[circleNext(nextFirst, array.length)] = null;
        size -= 1;
        usage = size / (double) array.length;
        nextFirst = circleNext(nextFirst, array.length);
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else if ((size - 1) / (double) array.length < 0.25) {
            contract();
        }
        T result = array[circlePrev(nextLast, array.length)];
        array[circlePrev(nextLast, array.length)] = null;
        size -= 1;
        usage = size / (double) array.length;
        nextLast = circlePrev(nextLast, array.length);
        return result;
    }
}
