package greedy;

/**
 * @author xgl
 * @date 2023/4/22 10:04
 */
public class l2311 {

//
//    public int longestSubsequence(String s, int k) {
//        int n = s.length(), m = Integer.toBinaryString(k).length();
//        if (n < m){
//            return n;
//        }
//        int ans = m - 1;
//        if(Integer.parseInt(s.substring(n - m, n + 1), 2) <= k){
//            ans = m;
//        }
//        for(int i = 0; i < n - m; i++){
//            if (s.charAt(i) == '0') ans += 1;
//        }
//        return ans;
//    }

    public int longestSubsequence(String s, int k) {
        int n = s.length(), m = 32 - Integer.numberOfLeadingZeros(k);
        if (n < m) return n;
        var ans = Integer.parseInt(s.substring(n - m), 2) <= k ? m : m - 1;
        return ans + (int) s.substring(0, n - m).chars().filter(c -> c == '0').count();
    }
}
