package co.zhangbiao.datastructure.linkedlist;

/**
 * 描述：解答LeetCode中删除链表中等于给定值 val 的所有节点一题。
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * Create By ZhangBiao
 * 2020/4/23
 */
public class Solution {

    /**
     * 第一种方式，需要对头节点做特殊的处理。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 第二种方式，添加虚拟头结点，不用特殊处理头节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 第三种方式，使用递归处理。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode result = removeElements3(head.next, val);
        if (head.val == val) {
            return result;
        } else {
            head.next = result;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode result = new Solution().removeElements3(head, 6);
        System.out.println(result);
    }


}

class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    /**
     * 链表节点的构造函数，使用数组作为参数，创建一个链表，当前的ListNode为链表头节点。
     *
     * @param arr
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty.");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("LinkedList：");
        ListNode cur = this;
        while (cur != null) {
            result.append(cur.val + " -> ");
            cur = cur.next;
        }
        result.append("NULL");
        return result.toString();
    }

}
