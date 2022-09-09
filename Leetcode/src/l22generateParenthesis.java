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
        // ��������ʣ�µĶ࣬˵�����Ϸ�
        if (right < left) return;
        // ����С�� 0 �϶��ǲ��Ϸ���
        if (left < 0) return;
        // ���������Ŷ�ǡ������ʱ���õ�һ���Ϸ����������
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
