package com.atguigu.Recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //设置迷宫围墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        Boolean aBoolean = setWays(map, 1, 1);
        System.out.println("迷宫路线");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 如果小球能找到map[5][6]位置则表示通路找到，
     * 约定：当map[i][j]为0表示该点已经走过，2表示通路可走，3表示该点已去过，但是走不通
     * 策略 下 ->右 -> 上 ->左
     *
     * @param map 迷宫地图
     * @param i
     * @param j   i,j
     *            表示迷宫起点的位置
     * @return
     */
    public static Boolean setWays(int map[][], int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWays(map, i + 1, j)) {  //向下走
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
