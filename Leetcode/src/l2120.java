import org.junit.Test;

/**
 * @author xgl
 * @date 2023/5/30 21:15
 */
public class l2120 {


    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] res = new int[len];
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int x = startPos[0];
            int y = startPos[1];
            int newC = 0, newR = 0;
            for (int j = i; j < len; j++) {
                char c = cs[j];
                if (c == 'R') {
                    newR = x;
                    newC = y + 1;
                } else if (c == 'L') {
                    newR = x;
                    newC = y - 1;
                } else if (c == 'D') {
                    newR = x + 1;
                    newC = y;
                } else if (c == 'U') {
                    newR = x - 1;
                    newC = y;
                }
                if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                    res[i] += 1;
                    x = newR;
                    y = newC;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        executeInstructions(3,new  int[]{0,1}, "RRDDLU");
    }
}
