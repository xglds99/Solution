package ������;

/**
 * @author xgl
 * @date 2023/4/27 22:38
 */
public class l543 {
    int max = 0;
    /**
    * @Author xgl
    * @Description ������������ֱ��
    * @Date 22:39 2023/4/27
    * @Param [root]
    * @return int
    **/
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;

    }

    /**
    * @Author xgl
    * @Description ��ĳ���ڵ��������
    * @Date 22:38 2023/4/27
    * @Param [root]
    * @return int
    **/
    public int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int l_len = dfs(root.left) + 1;
        int r_len = dfs(root.right) + 1;
        max = Math.max(max, l_len + r_len);
        return Math.max(l_len, r_len);
    }

}
