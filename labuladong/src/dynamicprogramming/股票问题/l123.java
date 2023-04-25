package dynamicprogramming.��Ʊ����;

import java.util.Arrays;

/**
* @Author xgl
* @Description
* @Date ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�����������������������ʽ��ס�
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ�� 2023/4/24
 * @author xgl
 * @date 2023/4/24 21:46
 */
public class l123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n + 1][10][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= 9; ++j)
                Arrays.fill(f[i][j], Integer.MIN_VALUE / 2);
        for (int j = 1; j <= 9; ++j)
            f[0][j][0] = 0;

        for (int i = 0; i < n; ++i)
            for (int j = 1; j <= 2; ++j) {
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j - 1][0] - prices[i]);
            }
        return f[n][2][0];
    }
}
