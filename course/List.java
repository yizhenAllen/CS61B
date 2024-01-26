public interface List<Test> {
    /**
     * Inserts X into the back of the list.
     */
    void addLast(Test x);

    /**
     * Returns the item from the back of the list.
     */
    Test getLast();

    /**
     * Gets the ith item in the list (0 is the front).
     */
    Test get(int i);

    /**
     * Returns the number of items in the list.
     */
    int size();

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    Test removeLast();
}
