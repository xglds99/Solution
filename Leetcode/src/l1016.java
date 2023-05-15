import java.util.HashSet;

/**
 * @author xgl
 * @date 2023/5/11 10:49
 */
public class l1016 {


    public boolean queryString(String query, int n) {
        HashSet<Integer> seen = new HashSet<>();
        char[] s = query.toCharArray();
        //把s所有二进制表示的子串全部转成10进制数 放在hashset中，如果 hashset.size() == n
        //表示1---n所有的数的二进制表示都包含在s中
        for (int i = 0, m = s.length; i < m; i++) {
            int x = s[i] - '0';
            if (x == 0) continue;
            for (int j = i + 1; x <= n; j++) {
                seen.add(x);
                if (j == m) break;
                x = (x << 1) | (s[j] - '0');
            }
        }
        return seen.size() == n;
    }
}
