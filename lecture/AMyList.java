/**
 * Array based list.
 *
 * @author yizhen Zeng
 */

public class AMyList<T> implements myList<T> {
    public T[] array;
    public int size;

    /**
     * Creates an empty list.
     */
    public AMyList() {
        array = (T[]) new Object[100];
        size = 0;
        SLList<Integer>[] tmp = (SLList<Integer>[]) new Object[100];
        tmp[0] = new SLList<>(1);
        System.out.println(tmp[0].getFirst());
    }

    /**
     * Inserts X into the back of the list.
     */
    @Override
    public void addLast(T x) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            newArray[size] = x;
            array = newArray;
        } else {
            array[size] = x;
        }
        size += 1;
    }

    /**
     * Returns the item from the back of the list.
     */
    @Override
    public T getLast() {
        return array[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    @Override
    public T get(int i) {
        return array[i];
    }

    /**
     * Returns the number of items in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    @Override
    public T removeLast() {
        T last = array[size - 1];
        array[size - 1] = null;
        size -= 1;
        return last;
    }
}