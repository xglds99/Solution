package greedy;

/**
 * @author xgl
 * @date 2023/6/28 9:51
 */
public class l680 {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        char[] cs = s.toCharArray();
        while(l < r){
            if (cs[l] == cs[r]){
                l++;
                r--;
            }else {
                return valid(cs,l, r- 1) || valid(cs,l + 1,r);
            }
        }
        return true;
    }

    public boolean valid(char []cs , int l, int r){
        while(l < r){
            if (cs[l] != cs[r]) return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
