import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class l916 {
    public List<String> wordSubsets(String []words1,String[] words2){
        List<String>res = new ArrayList<>();
            int []allWords2 = new int[26];
            for (String w2: words2){
                int[] cnt = count(w2);
                for (int i = 0; i < 26; i++) {
                    allWords2[i]  = Math.max(cnt[i], allWords2[i]);
                }
            }

            for(String w1: words1){
                int[] cnt = count(w1);
                boolean f = true;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] < allWords2[i]) {
                        f = false;
                        break;
                    }
                }
                if (f)res.add(w1);
            }
            return res;
    }


    public int[] count(String s){
        char[] cs = s.toCharArray();
        int []res = new int[26];
        for (char c: cs){
            res[c-'a']++;
        }
        return res;
    }
}
