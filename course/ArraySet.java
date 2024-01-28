import java.util.*;

public class ArraySet<T> implements Iterable<T> {
    private int size;
    private final T[] array; //不考虑resize

    public ArraySet() {
        array = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x != null && !contains(x)) {
            array[size] = x;
            size += 1;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * returns an iterator (a.k.a. seer) into ME
     */
    public Iterator<T> iterator() {
//        // 使用匿名类实现
//        return new Iterator<T>() {
//            private int wizPos;
//
//            public boolean hasNext() {
//                return wizPos < size;
//            }
//
//            public T next() {
//                T returnItem = array[wizPos];
//                wizPos += 1;
//                return returnItem;
//            }
//        };


        //返回实现了Iterator接口的内部类实例
        return new ArraySetIterator();
    }

    class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = array[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public String toString() {
        List<String> printList = new LinkedList<>();
        for (T item : this) {
            printList.add(item.toString());
        }
        return "{" + String.join(" ", printList) + "}";
    }

    public static <T> ArraySet<T> of(T... items) {
        ArraySet<T> returnSet = new ArraySet<>();
        for (T item : items) {
            returnSet.add(item);
        }
        return returnSet;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        for (String item : s) {
            System.out.println(item);
        }
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}