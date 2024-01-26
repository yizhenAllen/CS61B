/**
 * Array based list.
 *
 * @author yizhen Zeng
 */

public class AList<Test> implements List<Test> {
    public Test[] array;
    public int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        array = (Test[]) new Object[100];
        size = 0;
    }

    /**
     * Inserts X into the back of the list.
     */
    @Override
    public void addLast(Test x) {
        if (size == array.length) {
            Test[] newArray = (Test[]) new Object[size * 2];
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
    public Test getLast() {
        return array[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    @Override
    public Test get(int i) {
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
    public Test removeLast() {
        Test last = array[size - 1];
        array[size - 1] = null;
        size -= 1;
        return last;
    }
}