import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("Tokyo");
        s.add("Lagos");
        System.out.println(s.contains("Tokyo")); // true
        ArraySet<Integer> testSet = ArraySet.of(1, 3, 5, 56);
        System.out.println(testSet);
    }
}