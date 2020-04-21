package co.zhangbiao.datastructure.stack;

import co.zhangbiao.datastructure.array.Array;

/**
 * 描述：基于动态数组实现栈。
 * <p>
 * Create By ZhangBiao
 * 2020/4/21
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        this.array = new Array<>();
    }

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.getLast();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack: ");
        result.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1) {
                result.append(", ");
            }
        }
        result.append("] top");
        return result.toString();
    }
}
