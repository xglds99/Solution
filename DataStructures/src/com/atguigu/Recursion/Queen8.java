package com.atguigu.Recursion;

public class Queen8 {
    //����һ��max����ʾ�ж��ٸ��ʺ�
    int max = 8;
    int array[] = new int[max];
    static  int count;
    static int judgecount;
    public static void main(String[] args) {

        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.printf("һ����%d�������",count);
        System.out.printf("���ж�%d��",judgecount);

    }
    public void check(int n){
        if(n  == max){
            print();
            return;
        }
        //���η���ʺ󣬲��ж�
        for (int i = 0 ; i < max; i++) {
            //�Ȱѵ�ǰ�ʺ�n���ŵ����еĵ�1�У�
            array[n]=i;
            if(judge(n)){
                //����ͻ�����ŷŵ�n+1���ʺ󣬼���ʼ�ݹ�
                check(n+1);
            }
        }
    }

    /**
     * ˵����
     * 1��array[i]�жϵ�n���ʺ��Ƿ��ǰ��n-1���ʺ���ͬһ��
     * 2��Math.abs(n-i) == Math.abs(array[n]-array[n-1])�жϵ�n���ʺ��Ƿ�͵�i���ʺ��Ƿ�ͬһб��
     * 3��n=1�������ڵ�2��
     * @param n
     * @return//�鿴���õ�n���ʺ��ʱ���Ƿ���ǰn-1����ͻ
     */
    public boolean judge(int n){
        judgecount++;
        for (int i = 0; i < n; i++) {
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        count++;
        System.out.println();
    }
}
