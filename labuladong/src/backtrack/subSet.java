package backtrack;

import java.util.*;

public class subSet {

    List<List<Integer>> res = new LinkedList<>();
    // ��¼�����㷨�ĵݹ�·��
    LinkedList<Integer> track = new LinkedList<>();

    // ������
    public void subsets(int[] nums) {
        backtrack(nums, 0);
    }

    // �����㷨���ĺ����������Ӽ�����Ļ�����
    void backtrack(int[] nums, int start) {

        // ǰ��λ�ã�ÿ���ڵ��ֵ����һ���Ӽ�
        res.add(new LinkedList<>(track));

        // �����㷨��׼���
        for (int i = start; i < nums.length; i++) {
            // ��ѡ��
            track.addLast(nums[i]);
           // System.out.println("�ݹ�ǰ=>" + track);
            // ͨ�� start ����������֦�ı�������������ظ����Ӽ�
            backtrack(nums, i + 1);
            track.removeLast();
            // ����ѡ��
            //System.out.println("�ݹ��==>" + track);
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        new subSet().subsets(nums);
    }

}
