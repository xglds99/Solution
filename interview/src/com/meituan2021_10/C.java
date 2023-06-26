package com.meituan2021_10;

import javax.print.attribute.standard.Finishings;
import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());//数据组数
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(reader.readLine());
            String s = reader.readLine();
            int m = Integer.parseInt(reader.readLine());;
            String ms = reader.readLine();
            PriorityQueue<int []> pq0 = new PriorityQueue<>(
                    Comparator.comparingInt(a -> a[1]));
            PriorityQueue<int []> pq1 = new PriorityQueue<>(
                    Comparator.comparingInt(a -> a[1]));
            for (int j = 0; j < n; j++) {
                if (s.charAt(j)  == '0') pq0.add(new int[]{0, j + 1});
                if (s.charAt(j) == '1' ) pq1.add(new int[]{1, j + 1});
            }
            for (int j = 0; j < m; j++) {
                if (ms.charAt(j) == 'M') {
                    if (pq1.size() > 0){
                        int[] ints = pq1.poll();
                        writer.write(Integer.toString(ints[1]));
                        writer.newLine();

                    }else {
                        int[] ints = pq0.poll();
                        pq1.add(new int[]{1, ints[1]});
                        writer.write(Integer.toString(ints[1]));
                        writer.newLine();
                    }
                } else {
                    if (pq0.size() > 0){
                        int[] ints = pq0.poll();
                        pq1.add(new int[]{1, ints[1]});
                        writer.write(Integer.toString(ints[1]));
                        writer.newLine();
                    }else{
                        int[] ints = pq1.poll();
                        writer.write(Integer.toString(ints[1]));
                        writer.newLine();
                    }
                }
            }
            writer.flush();
        }
    }
}
