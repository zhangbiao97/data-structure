package co.zhangbiao.datastructure.map;

import co.zhangbiao.datastructure.tree.avl.AVLTree;

import java.util.ArrayList;

/**
 * 描述：基于AVL树实现映射。
 *
 * Create By ZhangBiao
 * 2020/5/4
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap() {
        this.avl = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.set(key, newValue);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("E:\\workspace\\idea-workspace\\data-structure\\src\\co" +
                "\\zhangbiao\\datastructure\\map\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words：" + words.size());
            AVLMap<String, Integer> map = new AVLMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("total different words：" + map.getSize());
            System.out.println("Frequency of PRIDE：" + map.get("pride"));
            System.out.println("Frequency of PREJUDICE：" + map.get("prejudice"));
        }
    }

}
