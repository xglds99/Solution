package Tree;

public class l1483 {

}

class TreeAncestor{
    private int[][]dp;

    public TreeAncestor(int n, int []parent){
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }

        for (int i = 1; ; i++) {
            boolean allneg = true;
            for (int j = 0; j < n; j++) {
                int t = dp[j][i - 1] != -1 ? dp[dp[j][i - 1]][i - 1]:-1;

            }
        }
    }
}
