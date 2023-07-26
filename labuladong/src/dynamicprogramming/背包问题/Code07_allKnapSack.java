package dynamicprogramming.��������;

public class Code07_allKnapSack {

    /**
    * @Author xgl
    * @Description
    * @Date 14:36 2023/4/25
    * @Param [N, M] N����Ʒ������ΪM
    * @return int
    **/
    int allKnapSack(int N, int M, int[] wt, int[] val){
        int [][]dp = new int[N + 10][M + 10];
        dp[0][0] = 0;
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];//������������װ�뱳��
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]); //װ�벻װ������
                }
            }
        }
        return dp[N][M];
    }
}
//public class test {
//
//    public static void main(String[] args) {
//
//        int[] w= {2,5,4,2,3};
//        int[] v= {6,3,5,4,6};
//        System.out.println(bagkiller(w,v,10));
//    }
//    public static int bagkiller(int[] w,int[] v,int n) {
//        int [][] dp=new int[w.length+1][n+1];
//        for (int i=1;i<=w.length;i++) {
//            for (int j=1;j<=n;j++) {
//                if(j<w[i-1]) //װ����
//                    dp[i][j]=dp[i-1][j]; //�͵���i-1����Ʒ��������jʱ��ļ�ֵ
//                else
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-w[i-1]]+v[i-1]);//װ���·�Ϊ�������1.װ 2.��װ
//            }
//        }
//        return dp[w.length][n];
//    }
//}
