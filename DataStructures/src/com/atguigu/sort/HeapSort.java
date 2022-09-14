package com.atguigu.sort;

import java.util.PriorityQueue;

public class HeapSort {

    public int findKthLargest(int[] nums, int k) {
        // С���ѣ��Ѷ�����СԪ��
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : nums) {
            // ÿ��Ԫ�ض�Ҫ��һ������
            pq.offer(e);
            // ����Ԫ�ض��� k ��ʱ��ɾ���Ѷ�Ԫ��
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq ��ʣ�µ��� nums �� k �����Ԫ�أ�
        // �Ѷ�����С���Ǹ������� k �����Ԫ��
        return pq.peek();
    }
}
