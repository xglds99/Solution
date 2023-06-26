package com.bytedance1;

import java.io.*;
import java.util.Scanner;

/**
 * @ClassName A
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 15:48
 * @Version 1.0
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            String s = reader.readLine();
            int n = s.length();
            StringBuilder sb = new StringBuilder(s);
            for (int j = 0; j < n; j++) {
                while (j + 2 < sb.length() && sb.charAt(j) == sb.charAt(j + 1) && sb.charAt(j + 1) == sb.charAt(j + 2)){
                    sb.deleteCharAt(j + 2);
                }
                while (j + 3 <sb.length() &&  sb.charAt(j) == sb.charAt(j + 1) && sb.charAt(j + 2) == sb.charAt(j + 3)){
                    sb.deleteCharAt(j + 3);
                }
            }
            writer.write(sb.toString());
            writer.flush();
        }
    }
}
