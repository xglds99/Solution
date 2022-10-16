public class l6210minimizeArrayValue {
    static boolean check(int[] nums, int k) {
        long have = 0;//ǰ�������ֻ����԰����Ǻ󷽵Ĵ������ض�������
        for (int n : nums) {
            if (n <= k) {
                have += k - n;//��С�����������������
            } else {
                if (have < n - k) return false;//���ز����ˣ��ô𰸲�����
                else have -= (n - k);//��ȥ������
            }
        }
        return true;
    }

    public int minimizeArrayValue(int[] nums) {
        int left = 0, right = 1000000000;
        while (left < right) {//���ִ𰸣�Ѱ�����ֵ
            int mid = left + (right - left) / 2;
            if (check(nums, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }




}
