package co.zhangbiao.datastructure.linkedlist;

/**
 * Create By ZhangBiao
 * 2020/4/22
 */
public class Test {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        linkedList.add(1, 3);
        System.out.println(linkedList);

    }

}
