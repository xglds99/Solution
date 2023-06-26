import java.util.*;

public class l16_19 {

    public int[] pondSizes(int [][]land){
        int m = land.length;
        int n = land[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0){
                    list.add(bfs(land, i, j, m, n));
                }
            }
        }
        int index = 0;
        int [] res = new int[list.size()];
        Collections.sort(list);
        for (int num: list) res[index ++] = num;
        return res;
    }


    public int bfs(int [][]land, int i, int j, int m, int n){
        Queue<int[]> queqe = new LinkedList<>();
        int res = 1;
        land[i][j] = -1;
        queqe.add(new int[]{i, j});
        while(!queqe.isEmpty()){
            int[] curs = queqe.poll();
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1 ; l++) {
                    if (k == 0 && l == 0)continue;
                    int newi = k + curs[0];
                    int newj = l + curs[1];
                    if (newi < 0 || newi >= m || newj < 0 || newj >= n || land[newi][newj] != 0) continue;
                    res ++;
                    queqe.offer(new int[]{newi, newj});
                }
            }
        }
        return  res;
    }
}
