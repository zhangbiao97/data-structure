package co.zhangbiao.datastructure.tree.unionfind;

/**
 * 描述：并查集（版本2，底层虽然还是数组存储的，但是实现的思路上其实是树，不过就是使用数组存储数据而已）
 * isConnected()和unionElements()两个函数复杂度均为O(h)，h为树的高度
 * <p>
 * Create By ZhangBiao
 * 2020/5/1
 */
public class UnionFind2 implements UF {

    //parent[i]表示第i个元素所指向的父节点
    private int[] parent;

    public UnionFind2(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        //不断去查询自己的父亲节点，直到到达根节点
        //根节点的特点：parent[p] == p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看块元素p和元素q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
