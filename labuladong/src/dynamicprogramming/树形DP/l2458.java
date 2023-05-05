package dynamicprogramming.树形DP;



import common.TreeNode;

import java.util.HashMap;

/**
 * @author xgl
 * @date 2023/5/4 13:52
 */
public class l2458 {
        HashMap<TreeNode, Integer> heightMap = new HashMap<>();//记录每个结点子树的最大高度
        HashMap<Integer,Integer> restMap = new HashMap<>();//记录节点值为i的点删除后的剩余最大高度。
        public int[] treeQueries(TreeNode root, int[] queries) {
            getHeight(root);
            dfs(root, -1, 0);
            for(int i = 0; i < queries.length; i++){
                queries[i] = restMap.get(queries[i]);
            }
            return queries;
        }
        public void dfs(TreeNode root, int depth, int rest){
            if(root == null) return;
            restMap.put(root.val, rest); //进入结点之前就已经算出来了。
            depth +=1;
            dfs(root.left,depth, Math.max(rest, heightMap.getOrDefault(root.right, 0) + depth));
            dfs(root.right,depth, Math.max(rest, heightMap.getOrDefault(root.left, 0) + depth));
        }

        public int getHeight(TreeNode root){
            if(root == null) return 0;
            int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
            heightMap.put(root, height);
            return height;
        }

}
