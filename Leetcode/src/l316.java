import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xgl
 * @date 2023/6/26 17:49
 */
public class l316 {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        int n = s.length();
        boolean[] clean = new boolean[n];
        int []index = new int[n];
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a';
            letters[j]++;
            if (letters[j] > 1) {
                for (int k = 0; k <= j; k++) {
                    if (letters[k] >= 1) {
                        clean[index[j]] = true;
                        letters[j]--;
                        index[j] = j;
                        break;
                    }
                }
            }else{
                index[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!clean[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new l316().removeDuplicateLetters("bcabc");
    }
}
