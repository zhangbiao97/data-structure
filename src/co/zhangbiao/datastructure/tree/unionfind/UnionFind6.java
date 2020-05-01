package co.zhangbiao.datastructure.tree.unionfind;

/**
 * 描述：并查集（版本4）进行优化（路径压缩第二种方式）
 * <p>
 * Create By ZhangBiao
 * 2020/5/1
 */
public class UnionFind6 implements UF {

    //parent[i]表示第i个元素所指向的父节点
    private int[] parent;

    //rank[i]表示以i为根的集合所表示的树的层数
    //在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
    //这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
    private int[] rank;

    public UnionFind6(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            this.rank[i] = i;
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
        //path compression 2，递归算法
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
        //根据两个元素所在树的rank不同判断合并方向
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {    // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            //维护rank的值
            rank[qRoot] += 1;
        }

    }

}
