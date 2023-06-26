import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName l85
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 11:42
 * @Version 1.0
 */
public class l85 {
    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * @param mat
     * @return
     */
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
            Arrays.fill(l, 0);
            Arrays.fill(r, m + 1);
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
