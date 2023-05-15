import java.util.HashSet;

/**
 * @author xgl
 * @date 2023/5/6 11:14
 */
public class l1419 {


    // ����ȹ�ϣ��졣's' ��֤ "croak" �е������ַ�������Խ��
    private static final char[] PREVIOUS = new char['s'];

    static { // Ԥ����ÿ����ĸ�� "croak" �е���һ����ĸ
        var s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++)
            PREVIOUS[s[i]] = s[i - 1];
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        var cnt = new int['s'];
        for (var ch : croakOfFrogs.toCharArray()) {
            var pre = PREVIOUS[ch]; // pre Ϊ ch �� "croak" �е���һ����ĸ
            if (cnt[pre] > 0) // ��������ܷ����� pre ������
                cnt[pre]--; // ����һֻ
            else if (ch != 'c') // �������ܱ���� 'c' ��ʼ����
                return -1; // ������Ҫ��
            cnt[ch]++; // ������ ch ������
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0)
            return -1; // �з����������������ܣ�������Ҫ��
        return cnt['k']; // ��������Ƕ������� 'k' ������
    }

    public static void main(String[] args) {
    }

}
