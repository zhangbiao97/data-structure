package co.zhangbiao.datastructure.tree.heap;

import java.util.Random;

/**
 * 描述：传入一个数组并让这个数组转换为最大堆。
 * 方式1：传入数组，使用add方法进行添加。
 * 方式2：传入数组，通过查找最后一个非叶子节点进行siftDown操作。
 * 比较两种方式的效率。
 * <p>
 * Create By ZhangBiao
 * 2020/4/28
 */
public class Test {

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(testData[i]);
            }
        }
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + "s");
        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + "s");
    }

}
