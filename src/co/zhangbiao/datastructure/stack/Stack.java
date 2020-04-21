package co.zhangbiao.datastructure.stack;

/**
 * 描述：栈所需要的方法
 * <p>
 * Create By ZhangBiao
 * 2020/4/21
 */
public interface Stack<E> {

    /**
     * 入栈操作
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈操作
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 获取栈元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();

}
