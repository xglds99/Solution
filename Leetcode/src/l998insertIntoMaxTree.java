public class l998insertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                parent.right = new TreeNode(val, cur, null);
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
}
