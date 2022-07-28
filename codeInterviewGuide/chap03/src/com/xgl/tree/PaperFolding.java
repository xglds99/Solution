package com.xgl.tree;

import java.util.*;

public class PaperFolding {

    static int n = 0;
    /**
     * down == true ��   down == false ͹
     *
     * @param i    ��ǰ������
     * @param n    �ܲ���
     * @param down �Ƿ�͹
     */
    public static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "��" : "͹");
        printProcess(i + 1, n, false);
    }


    public static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    public static void main(String[] args) {
        printAllFolds(3);
        int[] arr = new int[]{37,12,28,9,100,56,80,5,12};
        int []resu =new int[arr.length];
        System.arraycopy(arr, 0, resu, 0, arr.length);
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int sort = 1;
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, sort++);
            }
        }
        for (int i = 0; i < resu.length; i++) {
            resu[i] = map.get(resu[i]);
        }
        for (int i : resu) {
            System.out.print(i);
        }
    }
}

