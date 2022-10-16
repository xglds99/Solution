

import java.util.*;

public class l451frequencySort {
    public static int[] productQueries(int n, int[][] queries) {
        int []res = new int[queries.length];
        LinkedList<Long> powers = new LinkedList<>();
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0'  == 1){
                powers.addFirst((long) Math.pow(2, s.length() - 1 - i));
            }
        }
        System.out.println(powers.size());
        powers.forEach(System.out::println);
        for (int i = 0; i < queries.length; i++) {
            long tmp = 1L;
            for (int j = queries[i][0]; j <= queries[i][1]; j++){
                tmp *= powers.get(j);
            }
            res[i] = (int) (tmp % 1000000007);
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(l451frequencySort.productQueries(806335498, new int[][] {
                new int[]{0,1},new int[]{2,2}, new int[]{0,3}

    })));
        int mod = (int) (1e9 + 7);
        System.out.println(Integer.MAX_VALUE);
        long tmp1 = 1024L;
        long tmp2 = 1024L;
        int  s = 67108864;
        tmp1 *= s %  mod;
        tmp2 = tmp2 * s % mod;
        System.out.println(s);
        System.out.println("tmp1 :" + tmp1);
        System.out.println("tmp2 :" + tmp2);
        long  L = 67108864L * 1024L;
        System.out.println(L);
}
}
