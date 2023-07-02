package backtrack;

/**
 * @author xgl
 * @date 2023/7/1 15:59
 */
public class l698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        // �ų�һЩ�������
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        // k ��Ͱ�����ϣ�����¼ÿ��Ͱװ������֮��
        int[] bucket = new int[k];
        // ������ÿ��Ͱ�����ϣ������ֵĺ�
        int target = sum / k;
        // ��٣����� num s �Ƿ��ܻ��ֳ� k ����Ϊ target ���Ӽ�
        return backtrack(nums, 0, bucket, target);
    }

    // �ݹ���� nums �е�ÿ������
    boolean backtrack(
            int[] nums, int index, int[] bucket, int target) {

        if (index == nums.length){
            for (int b : bucket){
                if (b != target) return false;
            }
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

}
