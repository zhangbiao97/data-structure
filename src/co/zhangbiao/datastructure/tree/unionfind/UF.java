package co.zhangbiao.datastructure.tree.unionfind;

/**
 * 描述：并查集所需的方法。
 * <p>
 * Create By ZhangBiao
 * 2020/5/1
 */
public interface UF {

    /**
     * 元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 查看元素p和元素q是否所属同一个集合
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 合并元素p和元素q所属的集合
     *
     * @param p
     * @param q
     */
    void unionElements(int p, int q);

}
