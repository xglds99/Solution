import java.util.ArrayList;
import java.util.List;

public class l654buildMaxTree {


    public static void main(String[] args) {
        int []nums = new int[]{3,2,0,6,1,5,4};
        System.out.println(findMaxIndex(nums, 0, 0));
        System.out.println(constructMaximumBinaryTree(nums));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    public static TreeNode buildTree(int[] nums, int left, int right){
        int maxIndex = findMaxIndex(nums,left,right);
        if(maxIndex == -1 || left > right)
            return null;
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = buildTree(nums,left,maxIndex - 1);
        node.right = buildTree(nums,maxIndex + 1,right);
        return node;
    }


    public static int findMaxIndex(int[] nums, int left, int right){
        int index = -1;
        int max =Integer.MIN_VALUE;
        for(int i = left ; i <= right ; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
