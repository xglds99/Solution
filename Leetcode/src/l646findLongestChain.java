public class l646findLongestChain {


    public int findLongestChain(int [][]pairs){

        int m = pairs.length;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (pairs[j][1] < pairs[j+1][0]){
                    ans++;
                }
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}

