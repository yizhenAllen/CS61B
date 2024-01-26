public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private int size;
    /**
     * The first item(if it exits) is at sentinal.next
     */
    private IntNode sentinal;

    public SLList(int x) {
        sentinal = new IntNode(0, new IntNode(x, null));
        size = 1;
    }

    public SLList() {
        sentinal = new IntNode(0, null);
        size = 0;
    }

    /**
     * Adds an item to the front of the list.
     */
    public void addFirst(int x) {
        sentinal.next = new IntNode(x, sentinal.next);
        size += 1;
    }

    /**
     * Retrieves the front item from the list.
     */
    public int getFirst() {
        return sentinal.next.item;
    }

    /**
     * Adds an item to the end of the list.
     */
    public void addLast(int x) {
        IntNode cur = sentinal;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new IntNode(x, null);
        size += 1;
    }

    /**
     * Returns the number of items in the list using recursion.
     */
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        } else {
            return 1 + size(p.next);
        }
    }

    public int size() {
        return size;
    }
}