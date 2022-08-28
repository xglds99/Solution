public class l172trailingZeroes {
    public static void main(String[] args) {
        System.out.println(calcZero(25));
        System.out.println(calcZero(30));
        for (int i = 0; i < 0; i++) {
            System.out.println(1111);
        }
    }


    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

    public static int calcZero(long n) {
        int ans = 0;
        while (n != 0) {
            n = n / 5;
            //System.out.println(n);
            ans += n;
        }
        return ans;
    }

}
