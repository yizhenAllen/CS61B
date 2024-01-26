package deque;

public class LinkedListDeque<T> {
    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        public Node() {
        }

        public Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    private LinkedListDeque(Node<T> s, int size) {
        sentinel = s;
        this.size = size;
    }

    public void addFirst(T item) {
        Node<T> first;
        first = sentinel.next = new Node<>(item, sentinel, sentinel.next);
        first.next.prev = first;
        size += 1;
    }

    public void addLast(T item) {
        Node<T> last;
        last = sentinel.prev = new Node<>(item, sentinel.prev, sentinel);
        last.prev.next = last;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void printDeque() {
        Node<T> cur = sentinel.next;
        while (cur != sentinel) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node<T> cur = sentinel;
            while (index >= 0) {
                cur = cur.next;
                index--;
            }
            return cur.item;
        }
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return sentinel.next.item;
        } else {
            LinkedListDeque<T> tmp = new LinkedListDeque<>(sentinel.next, size);
            return tmp.getRecursive(--index);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T firstItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return firstItem;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T lastItem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return lastItem;
        }
    }
}
