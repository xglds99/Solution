import org.junit.Test;

import java.util.Arrays;

public class l1652decrypt {


    public int[] decryptBySlideWindow(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }
        return res;
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            Arrays.fill(res, 0);
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < i + k + 1; j++) {
                    res[i] += code[j % n];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j > i - 1 + k; j--) {
                    if (j < 0) {
                        res[i] += code[n + j];
                    } else {
                        res[i] += code[j];
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] ans = decrypt(new int[]{2, 4, 9, 3}, -2);
        for (int n : ans) {
            System.out.println(n);
        }
    }
}
