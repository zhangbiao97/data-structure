package co.zhangbiao.datastructure.hashtable;

import java.util.TreeMap;

/**
 * 描述：哈希表（通过红黑树解决哈希冲突问题）
 * <p>
 * Create By ZhangBiao
 * 2020/5/7
 */
public class HashTable<K, V> {

    private static final int UPPER_TOL = 10;

    private static final int LOWER_TOL = 2;

    private static final int INIT_CAPACITY = 7;

    private TreeMap<K, V>[] hashtable;

    private int size;

    private int M;

    public HashTable(int M) {
        this.M = M;
        this.size = 0;
        this.hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(INIT_CAPACITY);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= UPPER_TOL * M) {
                resize(2 * M);
            }
        }
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = this.M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            for (K key : hashtable[i].keySet()) {
                newHashTable[hash(key)].put(key, hashtable[i].get(key));
            }
        }
        this.hashtable = newHashTable;
    }

    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size <= LOWER_TOL * M && M > INIT_CAPACITY) {
                resize(M / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

}
