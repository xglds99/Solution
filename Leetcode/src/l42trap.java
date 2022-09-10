public class l42trap {

    public int trap(int[] nums) {
        int maxIndex = getMaxIndex(nums);
        int i = 0;
        int k = nums.length - 1;
        int ans = 0;
        int index = 0;
        int index_1 = 0;
        while (i < maxIndex) {
            index = getNextIndex(nums, i, maxIndex);
            //System.out.println(index);
            if (index > i) {
                for (int j = i + 1; j < index; j++) {
                    ans += nums[i] - nums[j];
                    System.out.println(ans);
                }
            } else {
                index++;
            }
            i = index;
        }
        while (k > maxIndex) {
            index_1 = getLeftIndex(nums, k, maxIndex);
            if (index_1 < k) {
                for (int j = k - 1; j > index_1; j--) {
                    ans += nums[k] - nums[j];
                    System.out.println(ans);
                }
            } else {
                index_1--;
            }
            k = index_1;
        }
        return ans;
    }


    public int getMaxIndex(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    public int getNextIndex(int[] nums, int left, int maxIndex) {
        int index = left;
        for (int i = left + 1; i <= maxIndex; i++) {
            if (nums[i] >= nums[left]) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public int getLeftIndex(int[] nums, int right, int maxIndex) {
        int index = right;
        for (int i = right - 1; i >= maxIndex; i--) {
            if (nums[i] >= nums[index]) {
                index = i;
                return index;
            }
        }
        return index;
    }
}
