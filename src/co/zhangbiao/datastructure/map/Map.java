package co.zhangbiao.datastructure.map;

/**
 * 描述：映射所需要的方法。
 * <p>
 * Create By ZhangBiao
 * 2020/4/27
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();

}
