/**
 * Array based list.
 *
 * @author yizhen Zeng
 */

public class AList<Test> {
    public int[] array;
    public int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        array = new int[100];
        size = 0;
        Test[] testArray = (Test[]) new Object[10];
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        if (size == array.length) {
            int[] newArray = new int[size * 2];
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
    public int getLast() {
        return array[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        return array[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public int removeLast() {
        int last = array[size - 1];
        array[size - 1] = 0;
        size -= 1;
        return last;
    }
}