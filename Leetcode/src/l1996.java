import java.util.Arrays;

/**
 * @ClassName l1996
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/5 23:29
 * @Version 1.0
 */
public class l1996 {
    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
            int maxDef = 0;
            int ans = 0;
            for (int[] p : properties) {
                if (p[1] < maxDef) {
                    ans++;
                } else {
                    maxDef = p[1];
                }
            }
            return ans;
        }
    }



}
