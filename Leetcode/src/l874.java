import javax.naming.spi.DirObjectFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName l874
 * @Description
 * @Author xgl
 * @Date 2023/7/19 15:32
 * @Version 1.0
 */
public class l874 {
    /**
     * ����������ڣ���ת��ת�Ĵ���
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        HashSet<Integer> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] * 60001 + o[1]);
            Arrays.binarySearch(o,1);
        }
        int res = 0, x = 0, y = 0, dir = 0;
        //���ȶ��山�����������ꡣ��ʼ�����򱱣���ת����ת��������Ӧ�Ĵ���
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int c : commands) {
            if (c == -1) {
                dir = (dir + 1) % 4;
            } else if (c == -2) {
                dir = (dir + 3) % 4;
            } else {
                //�ڵ�ǰ�ķ����ƶ�c��
                for (int i = 0; i < c; i++) {
                    int px = dirs[dir][0] + x;
                    int py = dirs[dir][1] + y;
                    if (set.contains(px * 60001 + py)) break;
                    x = px;
                    y = py;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }


}
