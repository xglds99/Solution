import java.util.HashMap;
import java.util.Map;

public class l2024maxConsecutiveAnswers {


    public int maxConsecutiveAnswers(String answerKey, int k) {
        int t = 0;
        int f = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            char c = answerKey.charAt(i);
            if (c == 'F') {
                f++;
            } else {
                t++;
            }
        }



        return 0;
    }
}
