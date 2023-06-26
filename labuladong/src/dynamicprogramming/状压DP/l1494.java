package dynamicprogramming.状压DP;

import java.util.Arrays;

public class l1494 {

        private int[] pre1, memo;
        private int k, u;

    /**
     * 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中，
     * relations[i] = [xi, yi]  表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
     *
     * 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
     * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
     * @param n
     * @param relations
     * @param k
     * @return
     */
        public int minNumberOfSemesters(int n, int[][] relations, int k) {
            this.k = k;
            pre1 = new int[n];
            for (var r : relations)
                pre1[r[1] - 1] |= 1 << (r[0] - 1); // r[1] 的先修课程集合，下标改从 0 开始

            u = (1 << n) - 1; // 全集
            memo = new int[1 << n];
            Arrays.fill(memo, -1); // -1 表示没有计算过
            return dfs(u);
        }

        private int dfs(int i) {
            if (i == 0) return 0; // 空集
            if (memo[i] != -1) return memo[i]; // 之前算过了
            int i1 = 0, ci = u ^ i; // i 的补集
            for (int j = 0; j < pre1.length; j++)
                if ((i >> j & 1) > 0 && (pre1[j] | ci) == ci) // pre1[j] 在 i 的补集中，可以学（否则这学期一定不能学）
                    i1 |= 1 << j;
            if (Integer.bitCount(i1) <= k)  // 如果个数小于 k，则可以全部学习，不再枚举子集
                return memo[i] = dfs(i ^ i1) + 1;
            int res = Integer.MAX_VALUE;
            for (int j = i1; j > 0; j = (j - 1) & i1) // 枚举 i1 的子集 j
                if (Integer.bitCount(j) == k)
                    res = Math.min(res, dfs(i ^ j) + 1);
            return memo[i] = res;
        }


        public int minNumberOfSemestersDp(int n, int[][] relations, int k) {
            var pre1 = new int[n];
            for (var r : relations)
                pre1[r[1] - 1] |= 1 << (r[0] - 1); // r[1] 的先修课程集合，下标改从 0 开始

            int u = (1 << n) - 1; // 全集
            var f = new int[1 << n];
            f[0] = 0;
            for (int i = 1; i < 1 << n; i++) {
                int i1 = 0, ci = u ^ i; // i 的补集
                for (int j = 0; j < n; j++)
                    if ((i >> j & 1) > 0 && (pre1[j] | ci) == ci) // pre1[j] 在 i 的补集中，可以学（否则这学期一定不能学）
                        i1 |= 1 << j;
                if (Integer.bitCount(i1) <= k) { // 如果个数小于 k，则可以全部学习，不再枚举子集
                    f[i] = f[i ^ i1] + 1;
                    continue;
                }
                f[i] = Integer.MAX_VALUE;
                for (int j = i1; j > 0; j = (j - 1) & i1) // 枚举 i1 的子集 j
                    if (Integer.bitCount(j) == k)
                        f[i] = Math.min(f[i], f[i ^ j] + 1);
            }
            return f[u];
        }

}
