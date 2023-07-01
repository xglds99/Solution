package greedy;

import java.util.Arrays;
import java.util.Date;

/**
 * @author xgl
 * @date 2023/6/29 11:34
 */
public class L517 {
    public int findMinMoves(int[] machines) {
        int cnt = Arrays.stream(machines).sum();
        int n = machines.length;
        if (cnt % n!= 0) {
            return -1;
        }
        int avg = cnt / n;
        int res = 0, sum = 0;
        for(int num: machines) {
            num -= avg;
            sum += num;
            res = Math.max(res,Math.max(Math.abs(sum),num));
        }
        return  res;
    }
    public static void main(String[] args) {
        int [] m = new int[1000];
        for (int i = 0; i < 1000; i++) {
            m[i] = 1;
        }
        // ��ȡ����ʼʱ��
        long startTime = System.nanoTime();

        // ������д����ĳ������
        // ...
        int sum = Arrays.stream(m).sum();
        // ��ȡ�������ʱ��
        long endTime = System.nanoTime();

        // ����ִ��ʱ�䣨�Ժ���Ϊ��λ��
        long executionTime = (endTime - startTime) / 1_000_000;

        System.out.println("����ִ��ʱ�䣺" + executionTime + " ����");
        // ��ȡ����ʼʱ��
        long startTime1 = System.nanoTime();

        // ������д����ĳ������
        // ...
        long sum1 = 0;
        for (int i = 0; i < m.length; i++) {
            sum1 += m[i];
        }
        // ��ȡ�������ʱ��
        long endTime1 = System.nanoTime();

        // ����ִ��ʱ�䣨�Ժ���Ϊ��λ��
        long executionTime1 = (endTime1 - startTime1) / 1_000_000;

        System.out.println("����ִ��ʱ�䣺" + executionTime1 + " ����");
    }
}
