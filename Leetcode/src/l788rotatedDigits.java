public class l788rotatedDigits {
    int must[] = {1, 1, 1, 0, 0, 1, 1, 0, 1, 1}, exist[] = {0, 0, 1, 0, 0, 1, 1, 0, 0, 1};

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                ans++;
            }
        }
        return ans;
    }

    boolean isGood(int k) {
        boolean ans = false;
        while (k > 0) {
            int r = k % 10;
            if (must[r] == 0) {
                return false;
            }
            if (exist[r] == 1) {
                ans = true;
            }
            k /= 10;
        }
        return ans;
    }
}
