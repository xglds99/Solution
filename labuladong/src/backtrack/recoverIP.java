package backtrack;

import java.util.ArrayList;
import java.util.List;

public class recoverIP {
    List<String> res = new ArrayList<String>();
    int[] segs = new int[4];

    /**
     * ������ʵ���Ǻ������������ݹ����ϡ�
     * ���룺s = "25525511135"
     * �����["255.255.11.135","255.255.111.35"]
     * ˼·��
     * �������⿴���������ǻ������⣬ �е��������Ӽ��ĸо�
     * ���ȶ���dfs(segStart, segID)�ֱ�����´α�����������һ�ε�����
     * //��Ϊip���ܺ���ǰ��0 ��������һ��������������ip�ֶξͰ�����һ��0
     * ��segStart == s.length && segId == 4��ʱ�� ���ҵ���һ���𰸣����뵽res
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        dfs(0, 0, length, s);
        return res;
    }

    /**
     * @param start  ÿһ�ο�ʼ�����
     * @param segId  ��ǰλ����һ��
     * @param length �ַ�������
     * @param s      ԭʼ�ַ���
     */
    public void dfs(int start, int segId, int length, String s) {
        if (start == length && segId == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(segs[i]);
                sb.append('.');
            }
            sb.append(segs[3]);
            res.add(new String(sb));
            return;
        }

        if (start >= length || segId >= 4) {
            return;
        }
        // ���ڲ�����ǰ���㣬�����ǰ����Ϊ 0����ô��һ�� IP ��ַֻ��Ϊ 0
        if (s.charAt(start) == '0') {
            segs[segId] = 0;
            dfs(start + 1, segId + 1, length, s);
        }
        int addr = 0;
        for (int segEnd = start; segEnd < length; segEnd++) {
            addr = addr * 10 + s.charAt(segEnd) - '0';
            if (addr > 0 && addr <= 255) {
                segs[segId] = addr;
                dfs(segEnd + 1, segId + 1, length, s);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new recoverIP().restoreIpAddresses(
                "25525511135");
    }
}
