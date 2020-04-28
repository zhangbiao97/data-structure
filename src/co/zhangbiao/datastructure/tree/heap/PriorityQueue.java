package co.zhangbiao.datastructure.tree.heap;

import co.zhangbiao.datastructure.queue.Queue;

/**
 * 描述：基于二叉堆（最大堆）实现优先队列。
 * <p>
 * Create By ZhangBiao
 * 2020/4/28
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> heap;

    public PriorityQueue() {
        this.heap = new MaxHeap();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }

    @Override
    public int getSize() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

}
