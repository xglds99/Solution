package dynamicprogramming.����DP;



import common.TreeNode;

import java.util.HashMap;

/**
 * @author xgl
 * @date 2023/5/4 13:52
 */
public class l2458 {
        HashMap<TreeNode, Integer> heightMap = new HashMap<>();//��¼ÿ��������������߶�
        HashMap<Integer,Integer> restMap = new HashMap<>();//��¼�ڵ�ֵΪi�ĵ�ɾ�����ʣ�����߶ȡ�
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
            restMap.put(root.val, rest); //������֮ǰ���Ѿ�������ˡ�
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
