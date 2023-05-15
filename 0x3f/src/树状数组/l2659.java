package ��״����;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xgl
 * @date 2023/5/5 21:02
 */
public class l2659 {


    class Solution {
        public long countOperationsToEmptyArray(int[] nums) {
            int n = nums.length;
            var id = new Integer[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
            Arrays.sort(id, Comparator.comparingInt(i -> nums[i]));

            long ans = n; // �Ȱ� n �����
            var t = new BIT(n + 1); // �±�� 1 ��ʼ
            int pre = 1; // ��һ����Сֵ��λ�ã���ʼΪ 1
            for (int k = 0; k < n; ++k) {
                int i = id[k] + 1; // �±�� 1 ��ʼ
                if (i >= pre) // �� pre �ƶ��� i�������Ѿ�ɾ������
                    ans += i - pre - t.query(pre, i);
                else // �� pre �ƶ��� n���ٴ� 1 �ƶ��� i�������Ѿ�ɾ������
                    ans += n - pre + i - k + t.query(i, pre - 1);
                t.inc(i); // ɾ�� i
                pre = i;
            }
            return ans;
        }
    }

    // ��״����ģ��
    static class BIT {
        private final int[] tree;

        public BIT(int n) {
            tree = new int[n];
        }

        // ���±� i �ϵ�����һ
        public void inc(int i) {
            while (i < tree.length) {
                ++tree[i];
                i += i & -i;
            }
        }

        // ���ر����� [1, i] ��Ԫ�غ�
        public int sum(int x) {
            int res = 0;
            while (x > 0) {
                res += tree[x];
                x &= x - 1;
            }
            return res;
        }

        // ���ر����� [left, right] ��Ԫ�غ�
        public int query(int left, int right) {
            return sum(right) - sum(left - 1);
        }
    }

}
