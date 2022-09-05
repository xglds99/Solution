

import java.util.*;

public class l652findDuplicateSubtrees {
    HashMap<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return new ArrayList<>(repeat);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        String ans = root.val + ",";
        ans += serialize(root.left);
        ans += serialize(root.right);
        if (seen.containsKey(ans)) {
            repeat.add(seen.get(ans));
        } else {
            seen.put(ans, root);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []tries = {1,2,3};
        String s = Arrays.toString(tries);
        System.out.println(s);
    }
}


class Solution {
    Map<String, TreeNode> seen = new HashMap<String, TreeNode>();
    Set<TreeNode> repeat = new HashSet<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }
}
//class Solution_1 {
//    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<String, Pair<TreeNode, Integer>>();
//    Set<TreeNode> repeat = new HashSet<TreeNode>();
//    int idx = 0;
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        dfs(root);
//        return new ArrayList<TreeNode>(repeat);
//    }
//
//    public int dfs(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        int[] tri = {node.val, dfs(node.left), dfs(node.right)};
//        String hash = Arrays.toString(tri);
//        if (seen.containsKey(hash)) {
//            Pair<TreeNode, Integer> pair = seen.get(hash);
//            repeat.add(pair.getKey());
//            return pair.getValue();
//        } else {
//            seen.put(hash, new Pair<TreeNode, Integer>(node, ++idx));
//            return idx;
//        }
//    }
//}
