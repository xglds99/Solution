package Graph;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/27 22:01
 */
public class l406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
