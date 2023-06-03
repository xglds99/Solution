/**
 * @author xgl
 * @date 2023/5/22 14:39
 */
public class l450 {


    class Solution {

        public TreeNode deleteNode(TreeNode root, int key) {

            dfs(root, null, key);
            if (root != null && root.val == key) {
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                TreeNode newroot = root.right;
                if (newroot.left == null) newroot.left = root.left;
                else {
                    TreeNode p = newroot.left;
                    while (p.left != null) {
                        p = p.left;
                    }
                    p.left = root.left;
                }
                return newroot;
            }
            return root;

        }

        public void dfs(TreeNode root, TreeNode parent, int key) {
            if (root == null) return;
            dfs(root.left, root, key);
            dfs(root.right, root, key);
            if (parent == null) return;
            if (root.val == key) {
                if (root.val < parent.val) {
                    if (root.left == null && root.right == null) {
                        parent.left = null;
                        return;
                    }
                    if (root.right == null) {
                        parent.left = root.left;
                        return;
                    }
                    if (root.left == null) {
                        parent.left = root.right;
                        return;
                    }
                    parent.left = root.right;
                    TreeNode p = parent.left;
                    while (p.left != null) {
                        p = p.left;
                    }
                    p.left = root.left;
                } else {
                    if (root.left == null && root.right == null) {
                        parent.right = null;
                        return;
                    }
                    if (root.right == null) {
                        parent.right = root.left;
                        return;
                    }
                    if (root.left == null) {
                        parent.right = root.right;
                        return;
                    }
                    parent.right = root.right;
                    TreeNode p = parent.right;
                    while (p.left != null) {
                        p = p.left;
                    }
                    p.left = root.left;
                }
            }

        }

    }

    class Solution1 {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
                return root;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
                return root;
            }
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                if (root.right == null) {
                    return root.left;
                }
                if (root.left == null) {
                    return root.right;
                }
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.right = deleteNode(root.right, successor.val);
                successor.right = root.right;
                successor.left = root.left;
                return successor;
            }
            return root;
        }
    }
}
