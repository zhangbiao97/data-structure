package co.zhangbiao.datastructure.tree.trie;

import java.util.TreeMap;

/**
 * 描述：解答LeetCode中 677、键值映射一题。
 * <p>
 * Create By ZhangBiao
 * 2020/4/30
 */
public class MapSum {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int result = node.value;
        for (Character c : node.next.keySet()) {
            result += sum(node.next.get(c));
        }
        return result;
    }

    private class Node {

        public int value;

        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }

    }

}
