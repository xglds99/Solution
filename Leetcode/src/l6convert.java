
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l6convert {

    public static void main(String[] args) {
    String s="PAYPALISHIRING";
        String s1 = new l6convert().convert(s, 3);
        System.out.println(s1);

    }

    public  String convert(String s,int nums){
        StringBuffer[] sbf = new StringBuffer[nums];
        char []chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbf[(i+1)%nums].append(chars[i]);
        }
        String resu="";
        for(int j=0;j<nums;j++){
            resu+=sbf[j];
        }
        return resu;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> resu = new LinkedList<>();
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i< size; i++){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            resu.addFirst(temp);
        }
        return resu;
    }
}
