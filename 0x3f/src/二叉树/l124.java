package 二叉树;

/**
 * @author xgl
 * @date 2023/4/27 22:39
 */
public class l124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
    * @Author xgl
    * @Description 求其左右子树的最大路径和
    * @Date 22:45 2023/4/27
    * @Param [root]
    * @return int
    **/
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l_val = dfs(root.left);
        int r_val = dfs(root.right);
        res = Math.max(res, l_val + r_val + root.val);
        return Math.max(0,Math.max(l_val, r_val) + root.val);
    }
}
