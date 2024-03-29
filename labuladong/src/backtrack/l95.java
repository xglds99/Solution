package backtrack;

import common.TreeNode;

import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName l95
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/2 19:19
 * @Version 1.0
 */
public class l95 {


    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     *
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> allTrees = new LinkedList<TreeNode>();
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }

            // 枚举可行根节点
            for (int i = start; i <= end; i++) {
                // 获得所有可行的左子树集合
                List<TreeNode> leftTrees = generateTrees(start, i - 1);

                // 获得所有可行的右子树集合
                List<TreeNode> rightTrees = generateTrees(i + 1, end);

                // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode currTree = new TreeNode(i);
                        currTree.left = left;
                        currTree.right = right;
                        allTrees.add(currTree);
                    }
                }
            }
            return allTrees;
        }
}
