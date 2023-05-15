/**
 * @author xgl
 * @date 2023/5/12 22:57
 */
public class l814 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public TreeNode pruneTree(TreeNode root) {
        boolean s = dfs(root);
        return !s && root.val == 0 ? null : root;
    }


    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (!l) root.left = null;
        if (!r) root.right = null;
        int t = root.val;
        return t == 1 || (l || r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = null;
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        new l814().pruneTree(root);
    }
}
