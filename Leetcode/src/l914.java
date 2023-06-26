import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l914 {
    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * 思路：计算每个数字出现的次数，计算这个出现数组的最小公约数，最后最小公约数>=2即可
     * 既可以分组，每组有X，且x张数字相同
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
       int n = deck.length;
       int []f = new int[10001];
       for (int i: deck){
           f[i]++;
       }
       int g = 0;
        for (int i = 0; i < 10001; i++) {
            g = gcd(f[i],g);
        }
        return g >= 2;
    }

    public static int gcd(int a, int b){
        if (b == 0)return a;
        return gcd(b,a % b);
    }

    public static void main(String[] args) {
        int s = gcd(2,0);
        System.out.println(s);
    }
}
