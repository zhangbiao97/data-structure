package co.zhangbiao.datastructure.tree.heap;

import java.util.TreeMap;
import java.util.PriorityQueue;

/**
 * 描述：解答LeetCode中 347.前K个高频元素一题。
 * <p>
 * Create By ZhangBiao
 * 2020/4/28
 */
public class Solution {

    private class Freq implements Comparable<Freq> {

        public int e;

        public int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.peek().freq) {
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove().e;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = solution.topKFrequent(nums, 2);
    }

}
