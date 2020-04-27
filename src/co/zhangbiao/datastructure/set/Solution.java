package co.zhangbiao.datastructure.set;

import java.util.TreeSet;

/**
 * 描述：解答LeetCode中唯一摩尔斯密码词一题。
 * <p>
 * Create By ZhangBiao
 * 2020/4/27
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-." +
                ".", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-" +
                ".--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                result.append(codes[word.charAt(i) - 'a']);
            }
            set.add(result.toString());
        }
        return set.size();
    }

}
