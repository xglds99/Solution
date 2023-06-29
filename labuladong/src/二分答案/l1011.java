package ¶þ·Ö´ð°¸;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/28 22:49
 */
public class l1011 {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int maxVal = Arrays.stream(weights).sum();
        int r = maxVal;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(!f(weights,mid,days)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return Math.min(l,maxVal);
    }


    public boolean f(int []weights, int capcity, int days){
        int cnt = 0;
        int i = 0;
        int n = weights.length;
        int cur = 0;
        while(i < n){
            cur += weights[i];
            if(cur == capcity){
                System.out.println(i);
                cnt++;
                cur = 0;
                i++;
            }else if(cur > capcity){
//                System.out.println(i);
                cnt++;
                cur = 0;
            }else{
                if (i == n - 1)cnt++;
                i++;
            }
        }
        return cnt <= days;
    }

    public static void main(String[] args) {
        int []weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        l1011 l1011 = new l1011();
        boolean f = l1011.f(weights, 15, 5);
        System.out.println(f);

    }
}
