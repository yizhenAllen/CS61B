public class SLList<T> {
    public static class IntNode<T> {
        public T item;
        public IntNode<T> next;

        public IntNode(T i, IntNode<T> n) {
            item = i;
            next = n;
        }
    }

    private int size;
    /**
     * The first item(if it exits) is at sentinel.next
     */
    private final IntNode<T> sentinel;

    public SLList(T x) {
        sentinel = new IntNode<>(null, new IntNode<>(x, null));
        size = 1;
    }

    private SLList(IntNode<T> s) {
        sentinel = s;
        size = 0;
    }

    public SLList() {
        sentinel = new IntNode<>(null, null);
        size = 0;
    }

    /**
     * Adds an item to the front of the list.
     */
    public void addFirst(T x) {
        sentinel.next = new IntNode<>(x, sentinel.next);
        size += 1;
    }

    /**
     * Retrieves the front item from the list.
     */
    public T getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds an item to the end of the list.
     */
    public void addLast(T x) {
        IntNode<T> cur = sentinel;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new IntNode<>(x, null);
        size += 1;
    }
    /**
     * Remove an item at the end of the list.
     */
    public T removeLast() {
        if (size < 1) {
            return null;
        }
        IntNode<T> cur = sentinel;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        T removeItem = cur.next.item;
        cur.next = null;
        size -= 1;
        return removeItem;
    }

    /**
     * Returns the number of items in the list using recursion.
     */
    public int sizeRecursive() {
        if (sentinel.next == null) {
            return 0;
        } else {
            SLList<T> nextList = new SLList<>(sentinel.next);
            return 1 + nextList.sizeRecursive();
        }
    }

    public void print() {
        IntNode<T> cur = sentinel.next;
        while (cur != null) {
            System.out.println(cur.item + " ");
            cur = cur.next;
        }
    }

    public int size() {
        return size;
    }
}