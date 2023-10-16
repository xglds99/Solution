package dynamicprogramming.打家劫舍;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xgl
 * @date 2023/5/4 14:27
 */
public class l337 {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>(); //选择node节点的能偷到的最大值
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();//不选择node节点能偷到的最大值

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

    class Solution{
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }
        public int [] dfs(TreeNode node){
            if (node == null) return new int[]{0,0};
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            int []res = new int[2];
            res[0] = node.val + left[1] + right[1];
            res[1] = Math.max(left[0],left[1]) + Math.max(right[1], right[0]);
            return res;
        }
    }
}
