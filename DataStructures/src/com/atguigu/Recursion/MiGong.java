package com.atguigu.Recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //�����Թ�Χǽ
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //���õ���
        map[3][1]=1;
        map[3][2]=1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        Boolean aBoolean = setWays(map, 1, 1);
        System.out.println("�Թ�·��");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * ���С�����ҵ�map[5][6]λ�����ʾͨ·�ҵ���
     * Լ������map[i][j]Ϊ0��ʾ�õ��Ѿ��߹���2��ʾͨ·���ߣ�3��ʾ�õ���ȥ���������߲�ͨ
     * ���� �� ->�� -> �� ->��
     *
     * @param map �Թ���ͼ
     * @param i
     * @param j   i,j
     *            ��ʾ�Թ�����λ��
     * @return
     */
    public static Boolean setWays(int map[][], int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWays(map, i + 1, j)) {  //������
                    return true;
                } else if (setWays(map, i, j + 1)) {
                    return true;
                } else if (setWays(map, i - 1, j)) {
                    return true;
                } else if (setWays(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
