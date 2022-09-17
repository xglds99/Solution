package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code04_minDistance {

    int minDistance_1(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // i，j 初始化指向最后一个索引
        return dp_1(s1, m - 1, s2, n - 1);
    }

    // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    int dp_1(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp_1(s1, i - 1, s2, j - 1); // 啥都不做
        }
        return min(
                dp_1(s1, i, s2, j - 1) + 1,    // 插入
                dp_1(s1, i - 1, s2, j) + 1,    // 删除
                dp_1(s1, i - 1, s2, j - 1) + 1 // 替换
        );
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    //************************************************************************
    //使用备忘录记录重叠子问题的答案，不用重复计算以降低时间复杂度
    int[][] dp;

    //使用dp[i][j]来记录s1[0...i] s2[0...j]的最短编辑距离
    int minDistance_2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp_2(s1, m -1, s2, n - 1);
    }

    int dp_2(String s1, int i, String s2, int j) {
        //base case 递归结束的地方
        //如果 是s1 的i匹配完了，s2的j还没匹配完，说明 s2还有元素未被s1匹配，所以将s2剩下的元素全部插入到s1，所以需要 j +1步
        //同理，s2的j匹配完了，s1的i还未匹配完，说明s1的剩余元素多余，需要将s1剩下的元素删除，所以需要 i + 1步
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j] = dp_2(s1, i - 1, s2, j - 1);
        else {
            dp[i][j] = min(dp_2(s1, i, s2, j - 1) + 1, //s1插入一个元素，i不变，j向前移动，i匹配下一个j
                    dp_2(s1, i - 1, s2, j) + 1, //s1删除一个元素，i向前匹配，j不变
                    dp_2(s1, i - 1, s2, j - 1) + 1);//s1替换一个元素，i继续向前-1匹配 ，j继续向前-1匹配
        }
        return dp[i][j];
    }

    int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        //s1需要匹配的字符串长度 0....m-1   s2需要匹配的字符串长度 0....n-1
        // 定义：s1[0..i] 和 s2[0..j] 的最小编辑距离是 dp[i+1][j+1]
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的最小编辑距离是 dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1, // 删除
                            dp[i][j - 1] + 1, // 插入
                            dp[i - 1][j - 1] + 1 //替换
                    );
                }
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

   @Test
    public void test(){
       int i = minDistance("rad", "apple");
       System.out.println(i);
   }


}
