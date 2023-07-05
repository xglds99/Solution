/**
 * @ClassName l845
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/5 19:49
 * @Version 1.0
 */
public class l845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3)return 0;
        int []l = new int[n];
        l[0] = 1;
        int []r = new int[n];
        r[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = arr[i] > arr[i - 1] ? l[i - 1] + 1 : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = arr[i] > arr[i + 1] ? r[i + 1] + 1: 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, l[i] + r[i] - 1);
        }
        return res < 3 ? 0 : res;
    }
}
