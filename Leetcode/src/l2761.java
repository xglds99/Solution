import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName l2761
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 15:34
 * @Version 1.0
 */
public class l2761 {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] primes = sieveOfEratosthenes(n);
        int x = 1;
        int y = n;
        while (x <= y) {
            if (x + y == n) {
                if (primes[x] && primes[y]) {
                    res.add(Arrays.asList(x, y));
                }
                x++;
                y--;
            } else if (x + y > n) {
                y--;
            } else if (x + y < n) {
                x++;
            }
        }
        return res;
    }


    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false; // 0和1不是素数
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false; // i的倍数不是素数
                }
            }
        }
        return primes;
    }
}
