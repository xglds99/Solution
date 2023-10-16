package dynamicprogramming.��ҽ���;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/4 14:28
 */
public class l198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];//dp[i]͵����iΪ���һ������ֵ
        int mx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            mx = Math.max(mx, dp[i]);
        }
        return mx;
    }


    public int rob_1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 10]; //ǰi�����ݣ�����͵�����ֵ
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); //͵��͵
        }
        return dp[n - 1];
    }

    /*
     * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
     */

    /**
     * @description: ��ҽ�������
     * @fileName: PACKAGE_NAME.Leecode198
     *
     * ����͵��·��
     * @author: WWX1062477
     * @date: 2022-05-24 10:38
     **/
    public class Leecode198 {
        public static List<Integer> rob(int[] nums) {
//        dp���鶨�壺dp[i][0]����͵��i�ŷ������ܻ�������
//        dp[i][1]����͵��i�ŷ������ܻ�������

            int length = nums.length;
            if (length == 0) {
                return null;
            }
            if (length == 1) {
                return new ArrayList<Integer>(nums.length);
            }
            //����һ��n��2�е���������ʾ͵ǰn�ŷ��ܻ�õ������
            int[][] dp = new int[length][2];
            dp[0][0] = 0;//��ʾ��͵��һ�䷿
            dp[0][1] = nums[0];//��ʾ͵��һ�䷿

            dp[1][0] = nums[0];//��͵�ڶ��ŷ����ǾͿ϶�Ҫ͵��һ�䷿
            dp[1][1] = nums[1];//͵�ڶ��ŷ����ǾͿ϶���Ҫ͵��һ�䷿

            for (int i = 2; i < length; i++) {
                //��͵��i�䷿,�ǾͿ϶�͵�˵�i-1�䷿
                dp[i][0] = dp[i - 1][1];
                //͵�˵�i�䷿
                dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 2][1] + nums[i]);
            }
            int target = Math.max(dp[length - 1][0], dp[length - 1][1]);
            List<Integer> track = new ArrayList<>();
            for (int i = length - 1; i >= 0; i--) {
                if (dp[i][1] == target) {
                    target = target - nums[i];
                    track.add(nums[i]);
                }
            }

            Collections.reverse(track);
            return track;
        }

        public static void main(String[] args) {
            int[] money1 = {1, 2, 3, 1};
            int[] money2 = {2, 7, 9, 3, 1};
//        System.out.println("rob(money1) = " + rob(money1));
            System.out.println("rob(money2) = " + rob(money2));
        }
    }

}
