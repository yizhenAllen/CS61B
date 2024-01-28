package deque;

public class DequeUtil {
    public static <T> boolean equals(Deque<T> deque, Object o) {
        if (o == deque) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> newO = (Deque<T>) o;
        if (deque.size() != newO.size()) {
            return false;
        }
        for (int i = 0; i < deque.size(); i++) {
            if (!deque.get(i).equals(newO.get(i))) {
                return false;
            }
        }
        return true;
    }
}
