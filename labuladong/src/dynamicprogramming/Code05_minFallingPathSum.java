package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code05_minFallingPathSum {
        int minFallingPathSum(int[][] matrix) {
          int n = matrix.length;

            int res = Integer.MAX_VALUE;
            memo = new int[n][n];
            for (int[] ints : memo) {
                Arrays.fill(ints, 6666);
            }
            for (int i = 0; i < n; i++) {
                res = Math.min(res,dp(matrix,n - 1,i));
            }
            return res;
        }

    /**
     * dp函数定义，从matrix[0][j]到 i，j的最短下降路径和
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    int[][] memo;
    private int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length){
            return 6666;
        }
        if(matrix[i][j] != 6666){
            return matrix[i][j];
        }
        if (i == 0){
            return matrix[i][j];
        }
        memo[i][j] = matrix[i][j] + min(dp(matrix,i - 1,j-1),
                dp(matrix, i - 1, j),
                dp(matrix, i -1 , j +1 ));
        return memo[i][j];
    }
    int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
}
