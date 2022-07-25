import java.awt.*;
import java.util.*;
import java.util.List;

public class l102levelOrder {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(0);
        head.left = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(3);
        List<List<Integer>> lists = new l102levelOrder().levelOrder(head);

        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode head) {
        List<List<Integer>> resu = new ArrayList<>();
        if (head == null) {
            return resu;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                levelList.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            resu.add(levelList);
        }
        return resu;
    }
}
