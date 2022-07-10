import org.junit.Test;

public class l104maxDepth {

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(7);
        root.left = treeNode2;
        root.right = treeNode3;
        treeNode3.left = treeNode4;
        int i = maxDepth(root);
        System.out.println(i);
    }


    public int maxDepth(TreeNode root) {
        int depth=0;
        preOrder(root,depth);
        return depth;
    }

    public void preOrder(TreeNode root,int depth){
        if(root==null){
            return;
        }
        depth++;
        if(root.left!=null){
            preOrder(root.left,depth);
        }
        if(root.right!=null){
            preOrder(root.right,depth);
        }
    }
}
