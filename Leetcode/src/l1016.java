import java.util.HashSet;

/**
 * @author xgl
 * @date 2023/5/11 10:49
 */
public class l1016 {


    public boolean queryString(String query, int n) {
        HashSet<Integer> seen = new HashSet<>();
        char[] s = query.toCharArray();
        //��s���ж����Ʊ�ʾ���Ӵ�ȫ��ת��10������ ����hashset�У���� hashset.size() == n
        //��ʾ1---n���е����Ķ����Ʊ�ʾ��������s��
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
