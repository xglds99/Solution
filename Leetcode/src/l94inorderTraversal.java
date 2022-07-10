import java.util.ArrayList;
import java.util.List;

public class l94inorderTraversal {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        TreeNode treeNode2=new TreeNode(8);
        TreeNode treeNode3=new TreeNode(9);
        TreeNode treeNode4=new TreeNode(7);
        root.left=treeNode2;
        root.right=treeNode3;
        treeNode3.left=treeNode4;
        l94inorderTraversal l94inorderTraversal=new l94inorderTraversal();
        List<Integer> list = l94inorderTraversal.inorderTraversal(root);
        System.out.println(list.toString());
    }


    public  List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return  list;
    }

    public void inorder(TreeNode root ,List<Integer> res){
        if(root.left!=null){
            inorder(root.left,res);
        }
        res.add(root.val);
        if(root.right!=null){
            inorder(root.right,res);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}