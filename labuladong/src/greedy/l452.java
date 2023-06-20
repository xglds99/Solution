package greedy;

import java.util.Arrays;

public class l452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] < b[1] ? -1 : 1);
        int count = 1;
        int end = points[0][1];
        for (var point : points) {
            if (point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
