package deque;

public class DequeUtil {
    public static boolean equals(Deque<?> deque, Object o) {
        if (o == deque) {
            return true;
        }
        if (!(o instanceof Deque<?>)) {
            return false;
        }
        Deque<?> newO = (Deque<?>) o;
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
