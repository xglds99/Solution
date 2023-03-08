package backtrack;

import java.util.ArrayList;
import java.util.List;

public class recoverIP {
    List<String> res = new ArrayList<String>();
    int[] segs = new int[4];

    /**
     * 回溯其实就是横向遍历，纵向递归的组合。
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 思路：
     * 这种问题看起来就像是回溯问题， 有点像条件子集的感觉
     * 首先定义dfs(segStart, segID)分别代表下次遍历的起点和那一段的数据
     * //因为ip不能含有前导0 所以这是一种特殊情况，这个ip字段就包含这一个0
     * 当segStart == s.length && segId == 4的时候 就找到了一个答案，加入到res
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
     * @param start  每一段开始的起点
     * @param segId  当前位于那一段
     * @param length 字符串长度
     * @param s      原始字符串
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
        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
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
