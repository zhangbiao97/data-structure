package co.zhangbiao.datastructure.set;

import co.zhangbiao.datastructure.tree.avl.AVLTree;

/**
 * 描述：基于AVL树实现集合。
 * <p>
 * Create By ZhangBiao
 * 2020/5/4
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> avl;

    public AVLSet() {
        this.avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
    
}
