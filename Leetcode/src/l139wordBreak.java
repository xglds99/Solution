import java.util.List;

public class l139wordBreak {

    /**
     * ∏–æıœÒ¡„«Æ∂“ªª°£
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            StringBuilder temp = new StringBuilder(sb.substring(0,i));
            for (var word : wordDict) {
               // if () dp[i] = true;
                sb.delete(i, word.length());
            }
        }
    return dp[n];
    }
}
