package co.zhangbiao.datastructure.queue;

/**
 * Create By ZhangBiao
 * 2020/4/21
 */
public class Main {

    public static void main(String[] args) {
        ArrayQueue<Object> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }

}
