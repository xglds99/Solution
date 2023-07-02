package monotonousstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author xgl
 * @date 2023/7/1 21:49
 */
public class l85 {

        public int maximalRectangle(char[][] mat) {
            int n = mat.length, m = mat[0].length, ans = 0;
            int[][] sum = new int[n + 10][m + 10];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum[i][j] = mat[i - 1][j - 1] == '0' ? 0 : sum[i - 1][j] + 1;
                }
            }
            int[] l = new int[m + 10], r = new int[m + 10];
            for (int i = 1; i <= n; i++) {
                int[] cur = sum[i];
                for (int j = 1; j <= m; j++) {
                    System.out.print(cur[j] + " ");
                }
                System.out.println();
                Deque<Integer> d = new ArrayDeque<>();
                for (int j = 1; j <= m; j++) {
                    while (!d.isEmpty() && cur[d.peekLast()] >= cur[j]) d.pollLast();
                    l[j] = d.isEmpty() ? 0 : d.peekLast();
                    d.addLast(j);
                }
                for (int j = 1; j <= m ; j++) {
                    System.out.print(l[j] + " ");
                }
                System.out.println();
                d.clear();
                for (int j = m; j >= 1; j--) {
                    while (!d.isEmpty() && cur[d.peekLast()] >= cur[j]) d.pollLast();
                    r[j] = d.isEmpty()? m + 1 : d.peekLast();
                    d.addLast(j);
                }
                for (int j = 1; j <= m ; j++) {
                    System.out.print(r[j] + " ");
                }
                System.out.println();
                for (int j = 1; j <= m; j++) ans = Math.max(ans, cur[j] * (r[j] - l[j] - 1));
            }
            return ans;
        }

    class Solution {
        public int maximalRectangle(char[][] mat) {
            int n = mat.length, m = mat[0].length, ans = 0;
            int[][] sum = new int[n + 10][m + 10];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum[i][j] = mat[i - 1][j - 1] == '0' ? 0 : sum[i - 1][j] + 1;
                }
            }
            int[] l = new int[m + 10], r = new int[m + 10];
            for (int i = 1; i <= n; i++) {
                int[] cur = sum[i];
                Arrays.fill(l, 0); Arrays.fill(r, m + 1);
                Deque<Integer> d = new ArrayDeque<>();
                for (int j = 1; j <= m; j++) {
                    while (!d.isEmpty() && cur[d.peekLast()] > cur[j]) r[d.pollLast()] = j;
                    d.addLast(j);
                }
                d.clear();
                for (int j = m; j >= 1; j--) {
                    while (!d.isEmpty() && cur[d.peekLast()] > cur[j]) l[d.pollLast()] = j;
                    d.addLast(j);
                }
                for (int j = 1; j <= m; j++) ans = Math.max(ans, cur[j] * (r[j] - l[j] - 1));
            }
            return ans;
        }
    }
}
