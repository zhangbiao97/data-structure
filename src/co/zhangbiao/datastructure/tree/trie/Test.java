package co.zhangbiao.datastructure.tree.trie;

/**
 * Create By ZhangBiao
 * 2020/4/30
 */
public class Test {

    public static void main(String[] args) {

        TrieTree trie = new TrieTree();
        trie.add("panda");
        System.out.println(trie.contains("pan"));
        trie.add("pan");
        System.out.println(trie.contains("pan"));

    }

}
