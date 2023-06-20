package dynamicprogramming.subStr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class l131 {

    public List<List<String>> list;
    private LinkedList<String> trcak;

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * <p>
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        trcak = new LinkedList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n + 10][n + 10];
        //将所有字串预处理出来，判断是不是子串
        //动态转移方程dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])
        //i的状态要有i+ 1的来所以i要倒序遍历，j的状态由j-1的来，所以j要正序遍历
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        dfs(s, 0, dp);
        return list;
    }

    public void dfs(String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            list.add(new ArrayList<>(trcak));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                trcak.addLast(s.substring(start, i + 1));
                dfs(s, i + 1, dp);
                trcak.removeLast();
            }
        }
    }

}
