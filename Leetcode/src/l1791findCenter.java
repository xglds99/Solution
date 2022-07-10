import java.util.HashMap;
import java.util.Map;

public class l1791findCenter {

    public static void main(String[] args) {
        int[][]edges=new int[][]{{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(edges));
    }
    public static int findCenter(int[][]edges){
        Map<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                map.put(edges[i][j],map.getOrDefault(edges[i][j], 0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (Integer i : map.keySet() ){
            if(map.get(i)>max){
                max = map.get(i);
                res = i;
            }
        }
        return res;
    }
}
