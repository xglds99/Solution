
import java.util.ArrayList;
import java.util.List;

public class l114flatten {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(7);
        root.left = treeNode2;
        root.right = treeNode3;
        treeNode3.left = treeNode4;
    }


    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        preOrder(root, list);
        int size=list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre=list.get(i-1);
            TreeNode cur=list.get(i);
            pre.left=null;
            pre.right=cur;
        }
    }

    public void preOrder(TreeNode root,List<TreeNode> res){
        if(root==null){
            return;
        }
        res.add(root);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

}
