package co.zhangbiao.datastructure.set;

/**
 * 描述：集合所需的方法。
 * <p>
 * Create By ZhangBiao
 * 2020/4/27
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

}
