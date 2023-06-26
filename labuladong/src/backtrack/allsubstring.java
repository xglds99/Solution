package backtrack;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author xgl
 * @date 2023/5/21 15:31
 */
public class allsubstring {

    private static LinkedList<String> t = new LinkedList<>();
    private static boolean[] f = new boolean[10001];
    public static void main(String[] args) {
        String s = "1000";
        Date start = new Date();

        punishmentNumber(37);
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());

        StringBuilder sb = new StringBuilder("ABFCACB");
        System.out.println(sb.indexOf("CD"));
        sb.delete(0, 2);
        System.out.println(sb);

    }

    public  static int punishmentNumber(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            dfs(String.valueOf(i * i).toCharArray(), 0);
        }
        for (int i = 1; i <= n ; i++) {
            if (f[i]) cnt += (i * i);
        }


        return cnt;
    }


    public static void dfs(char [] cs, int start){
        if(start == cs.length){
            int cnt = 0;
            for (String s : t) {
                cnt += Integer.parseInt(s);
            }
            if (cnt  == (int)Math.sqrt(Integer.parseInt(String.valueOf(cs)))){
                f[cnt] = true;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < cs.length; i++){
            sb.append(cs[i]);
            t.addLast(sb.toString());
            dfs(cs, i + 1);
            t.removeLast();
        }
    }
}
