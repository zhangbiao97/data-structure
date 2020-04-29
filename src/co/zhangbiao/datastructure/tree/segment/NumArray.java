package co.zhangbiao.datastructure.tree.segment;

/**
 * 描述：解答LeetCode。
 * 方式1：使用线段树实现。
 * <p>
 * Create By ZhangBiao
 * 2020/4/29
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            this.segmentTree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        }
    }

    /**
     * 307、区域和检索 - 数组可修改
     *
     * @param i
     * @param val
     */
    public void update(int i, int val) {
        if (this.segmentTree == null) {
            throw new IllegalArgumentException("SegmentTree is null");
        }
        segmentTree.set(i, val);
    }

    /**
     * 303、区域和检索 - 数组不可变
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        if (this.segmentTree == null) {
            throw new IllegalArgumentException("SegmentTree is null");
        }
        return segmentTree.query(i, j);
    }

}
