import java.util.List;

public interface MyMap<K, V> {
    boolean containsKey(K key);

    void put(K k, V v);

    V get(K k);

    int size();

    List<K> keys();
}
