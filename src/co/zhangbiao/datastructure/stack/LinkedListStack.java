package co.zhangbiao.datastructure.stack;

import co.zhangbiao.datastructure.linkedlist.LinkedList;

/**
 * 描述：使用链表实现栈。
 * <p>
 * Create By ZhangBiao
 * 2020/4/22
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        stack.addFirst(e);
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public E peek() {
        return stack.getFirst();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("LinkedListStack：top ");
        result.append(stack);
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Object> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

}
