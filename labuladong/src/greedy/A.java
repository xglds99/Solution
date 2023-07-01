package greedy;

/**
 * @author xgl
 * @date 2023/6/25 10:32
 */
public class A {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (gcd(getf(nums[i]), getl(nums[j]) ) == 1)res++;
            }

        }
        return res;
    }
    public  int gcd(int a, int b){
        if (b == 0)return a;
        return gcd(b, a % b);
    }

    public int getf(int  a){
        return String.valueOf(a).charAt(0) - '0';
    }

    public int  getl(int a){
        String s = String.valueOf(a);
        int n = s.length();
        return s.charAt(n - 1) - '0';
    }
}
