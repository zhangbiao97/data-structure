package co.zhangbiao.datastructure.set;

import co.zhangbiao.datastructure.tree.binarysearch.BinarySearch;

/**
 * 描述：基于二分搜索树实现集合。
 * <p>
 * Create By ZhangBiao
 * 2020/4/27
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearch<E> bst;

    public BinarySearchTreeSet() {
        this.bst = new BinarySearch<>();
    }

    @Override
    public void add(E e) {
        this.bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return this.bst.contains(e);
    }

    @Override
    public void remove(E e) {
        this.bst.remove(e);
    }

    @Override
    public int getSize() {
        return this.bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.bst.isEmpty();
    }
}
