package co.zhangbiao.datastructure.tree.unionfind;

/**
 * 描述：基于版本2的并查集进行优化（根据树的元素个数方面进行优化）
 *
 * Create By ZhangBiao
 * 2020/5/1
 */
public class UnionFind3 implements UF {

    //parent[i]表示第i个元素所指向的父节点
    private int[] parent;

    private int[] size;

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            this.size[i] = i;
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
        //根据两个元素所在的元素个数不同判断合并方向，将元素个数少的集合合并到元素个数多的集合上
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

    }

}
