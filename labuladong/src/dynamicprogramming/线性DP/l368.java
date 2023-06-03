package dynamicprogramming.线性DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/30 11:06
 */
public class l368 {

    /***
    * @Author xgl
    * @Description
     * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
     * answer[i] % answer[j] == 0 ，或
     * answer[j] % answer[i] == 0
     * 如果存在多个有效解子集，返回其中任何一个均可。
     *
     * //和最长递增子序列相同，但是需要比较的是 nums[i] % nums[j] == 0
    * @Date 11:08 2023/5/30
    * @Param [nums]
    * @return List<Integer>
    **/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int mxLen = 0;
        int mxIndex = -1;
        //1.dp数组定义，dp[i]为以i为结尾的最长子集长度。
        int [] dp = new int[n + 10];
        //因为要记录最长子集，所以定义前一个下标的数组，和并查集类似。
        int [] prev = new int[n + 10];
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //如果和之前的下标满足条件，
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    //i的前一个坐标就是j
                    prev[i] = j;
                }
                if (dp[i] > mxLen) {
                    //更新最长子集的长度
                    mxLen = dp[i];
                    //更新以i为结尾的最长子集的下标
                    mxIndex = i;
                }
            }
        }
        //仿照并查集，一直将这条联通分量上的点加入到答案中，
        while (mxIndex != -1){
            ans.add(nums[mxIndex]);
            mxIndex = prev[mxIndex];
        }
        return ans;
    }
}
