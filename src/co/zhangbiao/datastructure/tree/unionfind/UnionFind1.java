package co.zhangbiao.datastructure.tree.unionfind;

/**
 * 描述：并查集（版本1）
 * isConnected()函数复杂度为O(1)，unionElements()函数复杂度为O(n)
 * <p>
 * Create By ZhangBiao
 * 2020/5/1
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];
        //初始化，每一个id[i]都指向自己，没有合并的元素
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        //合并过程需要遍历一遍所有元素，将两个元素的所属集合编号合并
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
