package co.zhangbiao.datastructure.queue;

/**
 * 描述：队列所需的方法。
 *
 * Create By ZhangBiao
 * 2020/4/21
 */
public interface Queue<E> {

    /**
     * 入队操作
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     *
     * @return
     */
    E dequeue();

    /**
     * 获取队首
     *
     * @return
     */
    E getFront();

    /**
     * 获取队列元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

}
