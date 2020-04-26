package co.zhangbiao.datastructure.tree.binarysearch;

/**
 * Create By ZhangBiao
 * 2020/4/26
 */
public class Test {

    public static void main(String[] args) {

        BinarySearch<Integer> binarySearchTree = new BinarySearch<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        int[] nums2 = {28, 16, 13, 22, 30, 29, 42};
        int[] nums3 = {41, 58, 50, 60, 42, 53, 59, 63};
        for (int num : nums3) {
            binarySearchTree.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        /*binarySearchTree.preOrder();
        System.out.println();

        binarySearchTree.preOrderNR();
        System.out.println();*/

        /*binarySearchTree.inOrder();
        System.out.println();

        binarySearchTree.postOrder();
        System.out.println();*/

        //binarySearchTree.levelOrder();
        /*binarySearchTree.removeMin();
        binarySearchTree.removeMax();
        System.out.println(binarySearchTree.minimum());
        System.out.println(binarySearchTree.maximum());*/

        System.out.println(binarySearchTree);
        binarySearchTree.remove(58);
        System.out.println(binarySearchTree);
    }

}
