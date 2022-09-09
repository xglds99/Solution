import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class l22generateParenthesis {

    public List<String> generateParenthesis(int n){
        if(n == 0)
            return null;
        List<String> resu = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(resu,sb,n,n);
        System.out.println(resu);
        return resu;
    }

    public void dfs(List<String> resu,StringBuilder sb, int left,int right){
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            resu.add(sb.toString());
            return;
        }
        sb.append('(');
        dfs(resu, sb, left - 1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        dfs(resu, sb, left, right - 1);
        sb.deleteCharAt(sb.length() - 1);

    }
    @Test
    public void test(){
        generateParenthesis(2);
    }
}
