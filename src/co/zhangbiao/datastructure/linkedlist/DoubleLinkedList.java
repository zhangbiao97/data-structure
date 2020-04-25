package co.zhangbiao.datastructure.linkedlist;

/**
 * 描述：双向链表。
 * <p>
 * Create By ZhangBiao
 * 2020/4/25
 */
public class DoubleLinkedList<E> {

    private Node head;

    private Node tail;

    private int size;

    public DoubleLinkedList() {
        this.head = new Node();
        this.tail = null;
        this.size = 0;
    }

    /**
     * 链表中元素个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 从头部插入元素
     *
     * @param val
     */
    public void addFirst(E val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
        }
        this.head = newNode;
        this.size++;
    }

    /**
     * 从尾部插入元素
     *
     * @param val
     */
    public void addLast(E val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this.size++;
    }

    /**
     * 删除头结点
     *
     * @return
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed, Cannot remove for empty linkedlist" +
                    ".");
        }
        Node temp = this.head;
        if (this.head.next == null) {
            this.tail = null;
        } else {
            this.head.next.prev = null;
        }
        this.head = this.head.next;
        this.size--;
        return temp.val;
    }

    /**
     * 删除尾结点
     *
     * @return
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed. Cannot remove for empty linkedlist" +
                    ".");
        }
        Node temp = this.tail;
        if (this.tail.prev == null) {
            this.head = null;
        } else {
            this.tail.prev.next = null;
        }
        this.tail = this.tail.prev;
        this.size--;
        return temp.val;
    }

    /**
     * 根据索引获取相应的值
     *
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 获取头结点元素
     *
     * @return
     */
    public E getFirst() {
        return this.head.val;
    }

    /**
     * 获取尾结点元素
     *
     * @return
     */
    public E getLast() {
        return this.tail.val;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("DoubleLinkedList：");
        Node cur = this.head;
        while (cur != null) {
            result.append(cur + " -> ");
            cur = cur.next;
        }
        result.append(" NULL");
        return result.toString();
    }


    private class Node {

        E val;

        public Node prev;

        public Node next;

        public Node(E val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return val.toString();
        }

    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            doubleLinkedList.addFirst(i);
        }
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.getFirst());
        System.out.println(doubleLinkedList.getLast());
        System.out.println(doubleLinkedList.get(0));
        System.out.println(doubleLinkedList.get(1));
    }

}
