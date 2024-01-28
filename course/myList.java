public interface myList<T> {
    /**
     * Inserts X into the back of the list.
     */
    void addLast(T x);

    /**
     * Returns the item from the back of the list.
     */
    T getLast();

    /**
     * Gets the ith item in the list (0 is the front).
     */
    T get(int i);

    /**
     * Returns the number of items in the list.
     */
    int size();

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    T removeLast();

    default void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }
}
