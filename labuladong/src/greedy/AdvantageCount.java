package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        //����nums1�������򣬶���nums2���ǲ��ܶ���������ΪҪ����˳��õ���
        //��ô����һ��������nums2�������±��ֵ������ֵ���н�������
        PriorityQueue<int []> maxVal = new PriorityQueue<>( (int []pair1,int []pair2) -> pair2[1] - pair1[1]);
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            maxVal.add(new int[]{i,nums2[i]});
        }
        int right = n - 1;
        int left = 0;
        int []res = new int[n];
        while(maxVal.size()>0){
            int[] num2 = maxVal.poll();
            int i = num2[0], val = num2[1];
            if (val < nums1[right]){
                res[i] = nums1[right];
                right--;
            }else{
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
