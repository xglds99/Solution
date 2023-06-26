import java.util.ArrayList;
import java.util.List;

public class l1177 {

    /**
     * ����һ���ַ��� s������� s ���Ӵ����м�⡣
     * <p>
     * ÿ�μ�⣬�����Ӵ������Ա�ʾΪ queries[i] = [left, right, k]�����ǿ��� �������� �Ӵ� s[left], ..., s[right]��������ѡ�� ��� k ���滻���κ�СдӢ����ĸ��
     * <p>
     * ����������������У��Ӵ����Ա�ɻ�����ʽ���ַ�������ô�����Ϊ true��������Ϊ false��
     * <p>
     * ���ش����� answer[]������ answer[i] �ǵ� i �������Ӵ� queries[i] �ļ������
     * <p>
     * ע�⣺���滻ʱ���Ӵ��е�ÿ����ĸ��������Ϊ ������ ����м�����Ҳ����˵����� s[left..right] = "aaa" �� k = 2������ֻ���滻���е�������ĸ�������⣬�κμ�ⶼ�����޸�ԭʼ�ַ��� s��������Ϊÿ�μ�ⶼ�Ƕ����ģ�
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] g = new int[n + 1][26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            g[i + 1] = g[i].clone();
            int k = cs[i] - 'a';
            g[i + 1][k] = g[i][k] + 1;
        }

        List<Boolean> res = new ArrayList<>();
        for(var q: queries){
            int l = q[0], r = q[1], k = q[2], m = 0;
            for (int i = 0; i < 26; i++) {
                m +=  (g[r + 1][i] - g[l][i]) % 2;
            }
            res.add( m / 2 <= k);
        }
        return  res;
    }

}
