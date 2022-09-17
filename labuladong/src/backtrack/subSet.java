package backtrack;

import org.junit.Test;

import java.util.*;

public class subSet {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public void subsets(int[] nums) {
        backtrack(nums, 0);
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
           // System.out.println("递归前=>" + track);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            //使用start的参数保证不会向前遍历（保证不使用相同的元素），之后在本位置数组之后的位置遍历。
            //这个 i 从 start 开始，那么下一层回溯树就是从 start + 1 开始，从而保证 nums[start] 这个元素不会被重复使用：
            backtrack(nums, i + 1);
            track.removeLast();
            // 撤销选择
            //System.out.println("递归后==>" + track);
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        new subSet().subsets(nums);

    }

}
