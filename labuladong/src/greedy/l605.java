package greedy;

/**
 * @author xgl
 * @date 2023/6/29 12:24
 */
public class l605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int [] f = new int[len + 2];
        System.arraycopy(flowerbed, 0, f, 1,len);
        for (int i = 1; i < len + 1; i++) {
            if (f[i] == 0 && f[i + 1] == 0 && f[i - 1] == 0){
                n--;
                f[i] = 1;
            }
        }
        return n <= 0;
    }
}
