package 图论;

/**
 * @author xgl
 * @date 2023/5/29 20:50
 */
public class l329 {




        private int [][]memo;
        private int [][]dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        /**
        * @Author xgl
         * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
         * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
        * @Description 记忆化搜索+深搜
        * @Date 20:52 2023/5/29
        * @Param [matrix]
        * @return int
        **/
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            memo = new int[m][n];
            int res = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    res = Math.max(res, dfs(matrix,i,j,m,n));
                }
            }
            return res;
        }

        /**
        * @Author xgl
        * @Description 从 i，j出发能得到的最长递增路径。
        * @Date 20:54 2023/5/29
        * @Param [matrix, i, j, m, n]
        * @return int
        **/
        public int dfs(int [][]matrix, int i, int j, int m, int n){
            if(memo[i][j] != 0){
                return memo[i][j];
            }
            memo[i][j] ++;
            for(int []dir : dirs){
                int newRow = i + dir[0], newCol = j + dir[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[i][j]){
                    memo[i][j] = Math.max(memo[i][j], dfs(matrix,newRow,newCol,m,n) + 1);
                }
            }
            return memo[i][j];
        }

}
