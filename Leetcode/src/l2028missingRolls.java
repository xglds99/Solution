import org.junit.Test;

import java.util.Arrays;

public class l2028missingRolls {


    @Test
    public void test() {
        int[] rolls = new int[]{3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        int[] rolls1 = missingRolls(rolls, 4, 2);
        System.out.println(Arrays.toString(rolls1));

    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        if (n == 0) {
            return new int[0];
        }
        int Sum = 0;
        for (int i = 0; i < m; i++) {
            Sum += rolls[i];
        }
        int missSum = mean * (m + n) - Sum;
        if (missSum < n || missSum > 6 * n) {
            return new int[0];
        }
        int avg = missSum / n;
        int remainder = missSum % n;
        int[] resu = new int[n];
        for (int i = 0; i < n; i++) {
            resu[i] = avg + (i < remainder ? 1 : 0);
        }
        return resu;
    }
}
