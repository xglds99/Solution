import java.util.ArrayList;
import java.util.List;

public class l1177 {

    /**
     * 给你一个字符串 s，请你对 s 的子串进行检测。
     * <p>
     * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
     * <p>
     * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
     * <p>
     * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
     * <p>
     * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] g = new int[n + 1][26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            g[i + 1] = g[i].clone();
            int k = cs[i] - 'a';
            g[i + 1][k] = g[i][k] + 1;
        }

        List<Boolean> res = new ArrayList<>();
        for(var q: queries){
            int l = q[0], r = q[1], k = q[2], m = 0;
            for (int i = 0; i < 26; i++) {
                m +=  (g[r + 1][i] - g[l][i]) % 2;
            }
            res.add( m / 2 <= k);
        }
        return  res;
    }

}
