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
        // 获取程序开始时间
        long startTime = System.nanoTime();

        // 在这里写下你的程序代码
        // ...
        int sum = Arrays.stream(m).sum();
        // 获取程序结束时间
        long endTime = System.nanoTime();

        // 计算执行时间（以毫秒为单位）
        long executionTime = (endTime - startTime) / 1_000_000;

        System.out.println("程序执行时间：" + executionTime + " 毫秒");
        // 获取程序开始时间
        long startTime1 = System.nanoTime();

        // 在这里写下你的程序代码
        // ...
        long sum1 = 0;
        for (int i = 0; i < m.length; i++) {
            sum1 += m[i];
        }
        // 获取程序结束时间
        long endTime1 = System.nanoTime();

        // 计算执行时间（以毫秒为单位）
        long executionTime1 = (endTime1 - startTime1) / 1_000_000;

        System.out.println("程序执行时间：" + executionTime1 + " 毫秒");
    }
}
