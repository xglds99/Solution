/**
 * @author xgl
 * @date 2023/6/26 17:11
 */
public class l215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quicSortSlect(nums,0,n-1,k);

    }

    public int quicSortSlect(int[] nums, int left, int right, int k){
        if (left == right)return nums[left];
        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i < j){
            while(i < j && nums[j] < pivot)j--;
            if (i < j) nums[i++] = nums[j];
            while(i < j && nums[i] > pivot)i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = pivot;
        if (i == k-1)return nums[i];
        if (i < k - 1) return quicSortSlect(nums,i + 1, right, k);
        else return quicSortSlect(nums,left,i - 1, k);
    }
}
