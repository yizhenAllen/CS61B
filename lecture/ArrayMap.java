import java.util.*;
import java.util.ArrayList;

/***
 * An array-based implementation of Map61B.
 ***/
public class ArrayMap<K, V> implements MyMap<K, V> {

    private final K[] keys;
    private final V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public static <K, V> V get(MyMap<K, V> map, K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K max(MyMap<K, V> map) {
        // 注意, 上一行必须写extends, 不能写implements!
        List<K> keyList = map.keys();
        K maxKey = keyList.getFirst();
        for (K key : keyList) {
            if ((key).compareTo(maxKey) > 0) {
                maxKey = key;
            }
        }
        return maxKey;
    }
}

/**
 * Returns the index of the key, if it exists. Otherwise returns -1.
 **/
private int keyIndex(K key) {
    for (int i = 0; i < size; i++) {
        if (keys[i].equals(key)) {
            return i;
        }
    }
    return -1;
}

public boolean containsKey(K key) {
    int index = keyIndex(key);
    return index > -1;
}

public void put(K key, V value) {
    int index = keyIndex(key);
    if (index == -1) {
        keys[size] = key;
        values[size] = value;
        size += 1;
    } else {
        values[index] = value;
    }
}

public V get(K key) {
    int index = keyIndex(key);
    return values[index];
}

public int size() {
    return size;
}

public List<K> keys() {
    List<K> keyList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
        keyList.add(keys[i]);
    }
    return keyList;
}
}