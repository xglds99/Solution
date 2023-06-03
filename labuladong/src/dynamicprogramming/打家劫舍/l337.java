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
}
