package dynamicprogramming.ÏßÐÔDP;

/**
 * @ClassName l474
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/4 20:06
 * @Version 1.0
 */
public class l474 {
    public int findMaxForm(String[] strs, int m, int n) {
        return 0;
    }

    public int[] help(String s){
        int c1 = 0, c0 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') c0++;
            else c1++;
        }
        return new int[]{c0, c1};
    }
}
