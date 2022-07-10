import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class l564nearestPalindromic {
    public static void main(String[] args) {
        System.out.println(new l564nearestPalindromic().nearestPalindromic("1234"));

    }

    public  String nearestPalindromic(String num){
        long selfNumber = Long.parseLong(num), ans = -1;
        List<Long> candidates = getCandidates(num);
        for (long candidate : candidates) {
            if (candidate != selfNumber) {
                if (ans == -1 ||
                        Math.abs(candidate - selfNumber) < Math.abs(ans - selfNumber) ||
                        Math.abs(candidate - selfNumber) == Math.abs(ans - selfNumber) && candidate < ans) {
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }

    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<Long>() {{
            add((long) Math.pow(10, len - 1) - 1);
            add((long) Math.pow(10, len) + 1);
        }};
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1));
            String candidate = sb.toString();
            candidates.add(Long.parseLong(candidate));
        }
        return candidates;
    }

    @Test
    public  void  test(){
        String n="1234";
        int len=n.length();
        System.out.println(1&1);
        System.out.println(2&1);
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        System.out.println(selfPrefix);
    }


}
