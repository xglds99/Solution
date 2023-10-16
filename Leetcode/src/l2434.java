import java.util.ArrayDeque;

/**
 * @author xgl
 * @date 2023/6/26 20:43
 */
public class l2434 {
    /**
     * @return java.lang.String
     * @Author xgl
     * @Description 给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
     * <p>
     * 删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
     * 删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
     * 请你返回纸上能写出的字典序最小的字符串。
     * @Date 20:45 2023/6/26
     * @Param [s]
     **/
//    public String robotWithString(String s) {
//        int[] min = new int[s.length()];
//        for (int i = s.length() - 1; i > 0; i--) {
//            min[i - 1] = Math.min(s.charAt(i), i < s.length() - 1 ? min[i] : 'z');
//        }
//        StringBuilder sb = new StringBuilder();
//        ArrayDeque<Character> deque = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++) {
//            for (deque.push(s.charAt(i)); !deque.isEmpty() && deque.peek() <= min[i]; ) {
//                sb.append(deque.pop());
//            }
//        }
//        while (!deque.isEmpty()) {
//            sb.append(deque.pop());
//        }
//        return sb.toString();
//    }

    class Solution {
        /**
         * @return java.lang.String
         * @Author xgl
         * @Description 思路:
         * 首先使用一个数组记录每个字母出现的次数
         * 遍历字符串s， 用一个min记录当前剩余字符串的最小的字符·····
         * 当前字符c ，如果之后还有比c字典序更小的字符则将c压栈，否则加入答案
         * 然后更新当前的最小字符
         * 如果栈顶的字符比当前的最小字符小，则将栈顶字符出栈加入答案
         * @Date 20:59 2023/6/26
         * @Param [S]
         **/
        public String robotWithString(String S) {
            var res = new StringBuilder();
            var s = S.toCharArray();
            var map = new int[26];
            for (var c : s) {
                map[c - 'a']++;
            }

            int min = 0;
            var stack = new ArrayDeque<Character>();
            for (var c : s) {
                map[c - 'a']--;
                while (min < 25 && map[min] == 0) min++;
                if (c - 'a' == min) {
                    res.append(c);
                } else {
                    stack.push(c);
                }
                while (!stack.isEmpty() && stack.peek() - 'a' <= min) {
                    res.append(stack.pop());
                }
            }
            return res.toString();
        }
    }
}
