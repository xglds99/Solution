package com.atguigu.sparseArray;

import java.io.*;
import java.nio.charset.Charset;

public class SparseArray {

    public static void main(String[] args) throws IOException {


        //0表示空，1表示黑子，2表示蓝子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][5] = 1;
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /*
        将二维数组转稀疏数组
        1、先遍历二维数组得到稀疏数组的个数
         */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        int count = 1;
        //创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];

        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                    count++;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 3; j++)
                System.out.printf("%d\t", sparseArray[i][j]);
            System.out.println();
        }

        //将稀疏数组恢复
        int chessArray2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        File file = new File("G:\\map.data");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        OutputStreamWriter osw=new OutputStreamWriter(fileOutputStream, "utf-8");
        for (int i = 0; i < sparseArray.length; i++) {
            osw.write(sparseArray[i][0]+","+ sparseArray[i][1] + "," + sparseArray[i][2] + "," );
        }

        osw.close();
        fileOutputStream.close();
        System.out.println("写入磁盘成功！");

        System.out.println("从磁盘中读取....");

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr=new InputStreamReader(fis, Charset.forName("UTF-8"));
        String str="";
        while(isr.ready()){
            str+=(char)isr.read();
        }
        System.out.println(str);
        isr.close();
        fis.close();

        String[] split = str.split(",");
        int sum1=3;
        int [][]sparseArray3=new int[split.length/3][3];
        sparseArray3[0][0]=Integer.parseInt(split[0]);
        sparseArray3[0][1]=Integer.parseInt(split[1]);
        sparseArray3[0][2]=Integer.parseInt(split[2]);
        for (int i = 1; i <= Integer.parseInt(split[2]); i++) {
            sparseArray3[i][0] = Integer.parseInt(split[sum1++]);
            sparseArray3[i][1] = Integer.parseInt(split[sum1++]);
            sparseArray3[i][2] = Integer.parseInt(split[sum1++]);
        }
        for (int i = 0; i <= Integer.parseInt(split[2]); i++) {
            for (int j = 0; j < 3; j++)
                System.out.printf("%d\t", sparseArray3[i][j]);
            System.out.println();
        }
    }
}
