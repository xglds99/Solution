import java.util.*;



public class l662widthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree_1(node));
    }

    public static int widthOfBinaryTree_1(TreeNode root) {
        int result = 0;
        Deque<TreeNode> deque = new ArrayDeque();
        deque.addLast(new TreeNode(1, root.left, root.right));
        while (!deque.isEmpty()) {
            int count = deque.size(), startIndex = -1, endIndex = -1;
            for (int i = 0; i < count; i++) {
                TreeNode node = deque.pop();
                endIndex = node.val;
                if (startIndex == -1) startIndex = node.val;
                if (node.left != null) deque.addLast(new TreeNode(node.val * 2, node.left.left, node.left.right));
                if (node.right != null)
                    deque.addLast(new TreeNode(node.val * 2 + 1, node.right.left, node.right.right));
            }
            result = Math.max(result, endIndex - startIndex + 1);
        }
        return result;
    }

    int result = 0;
    Map<Integer, Integer> minValue = new HashMap();

    public int widthOfBinaryTree(TreeNode root) {
        depth(root, 1, 0);
        return result;
    }

    public void depth(TreeNode node, int nodeIndex, int level) {
        if (node == null) return;
        //如果Map中不存在该level的最小值，则将该节点的值放入到map中作为当前level下的最小值
        minValue.putIfAbsent(level, nodeIndex);
        result = Math.max(result, nodeIndex - minValue.get(level) + 1);
        depth(node.left, 2 * nodeIndex, level + 1);
        depth(node.right, 2 * nodeIndex + 1, level + 1);
    }
}
