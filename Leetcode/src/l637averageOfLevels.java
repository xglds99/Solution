import java.util.*;

public class l637averageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root){
        List<Double> resu = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,Integer> levelMap = new HashMap<>();
        queue.add(root);
        levelMap.put(root, 1);
        int curLevel = 1;
        double curLevelNodes = 0;
        double curLevelSum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (levelMap.get(cur) == curLevel){
                    curLevelNodes++;
                    curLevelSum += cur.val;
                }else {
                    curLevel++;
                    curLevelNodes = 1;
                    curLevelSum +=cur.val;
                }
                if (cur.left != null){
                    queue.add(cur.left);
                    levelMap.put(cur.left, curLevel + 1);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    levelMap.put(cur.right, curLevel+1);
                }
            }
            resu.add((double) (curLevelSum/curLevelNodes));
        }
        return resu;
    }
}
