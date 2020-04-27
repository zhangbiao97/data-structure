package co.zhangbiao.datastructure.set;

import co.zhangbiao.datastructure.linkedlist.LinkedList;

/**
 * 描述：基于链表实现集合。
 * <p>
 * Create By ZhangBiao
 * 2020/4/27
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            this.list.addLast(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return this.list.contains(e);
    }

    @Override
    public void remove(E e) {
        this.list.removeElement(e);
    }

    @Override
    public int getSize() {
        return this.list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
