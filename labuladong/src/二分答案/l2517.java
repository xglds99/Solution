package ���ִ�;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/1 10:07
 */
public class l2517 {

    /**
     * @return �����������ǹ��۸���Բ����Сֵ���ȼ��ڡ�������������������ǹ��۸���Բ����Сֵ����
     * <p>
     * �����Ŀ���С������Сֵ�����ߡ���С�����ֵ����һ�㶼�Ƕ��ִ𰸣����ס�����·��
     * <p>
     * Ϊʲô�����ڱ�����˵�����۶�Խ����ѡ����ǹ�Խ�٣��е����ԣ����Կ��Զ��֡�
     * <p>
     * ���� f(d)f(d)f(d) ��ʾ���۶�����Ϊ ddd ʱ��������ѡ�������ǹ���
     * <p>
     * ���ִ� ddd��
     * <p>
     * ��� f(d)��kf(d)\ge kf(d)��k��˵��������Ϊ ddd��
     * ��� f(d)<kf(d)< kf(d)<k��˵��������Ϊ d?1d-1d?1��
     * ���ֽ��������Ϊ d0\textit{d}_0d
     * 0
     * <p>
     * ����ô f(d0)��kf(d_0)\ge kf(d
     * 0
     * <p>
     * )��k �� f(d0+1)<kf(d_0+1)< kf(d
     * 0
     * <p>
     * +1)<k��
     * ��μ��� f(d)f(d)f(d)���� price\textit{price}price ��С��������̰�ĵؼ��� f(d)f(d)f(d)���� price[0]\textit{price}[0]price[0] ��ʼѡ��������һ��ѡ������ pre\textit{pre}pre����ô�� price[i]��pre+d\textit{price}[i] \ge \textit{pre}+dprice[i]��pre+d ʱ���ſ���ѡ price[i]\textit{price}[i]price[i]��
     * <p>
     * �����½����ȡ 111���Ͻ����ȡ ?max?(price)?min?(price)k?1?\left\lfloor\dfrac{\max(\textit{price})-\min(\textit{price})}{k-1}\right\rfloor?
     * k?1
     * max(price)?min(price)
     * <p>
     * ?��������Ϊ��Сֵ���ᳬ��ƽ��ֵ����ƽ��ֵָѡ�� price\textit{price}price ��С����Լ��м��һЩ�ǹ��������ǹ���ֵ��ƽ��ֵ����
     * <p>
     * ��ע�⣬���ֵ�����Ķ����ǣ���δȷ�� f(d)f(d)f(d) �� kkk �Ĵ�С��ϵ�� ddd ��ֵ��ɵļ��ϣ���Χ������������������ ddd ���� f(d)��kf(d)\ge kf(d)��k �ģ��������Ҳ������ ddd ���� f(d)<kf(d)< kf(d)<k �ġ���������ʱ�����μ�����Ķ��弰�����ʡ�
     * <p>
     * ���ߣ����ɽ����
     * ���ӣ�https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/solutions/2031994/er-fen-da-an-by-endlesscheng-r418/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @Author xgl
     * @Description ����һ������������ price ������ price[i] ��ʾ�� i ���ǹ��ļ۸������һ�������� k ��
     * <p>
     * �̵���� k �� ��ͬ �ǹ��������г��ۡ���е� ���۶� ����������������ǹ� �۸� ���Բ����Сֵ��
     * <p>
     * ������е� ��� ���۶ȡ�
     * @Date 10:07 2023/6/1
     * @Param
     **/

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        // ����ģ�塤������������д����https://www.bilibili.com/video/BV1AP41137w7/
        int left = 0, right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left  <= right) { // �����䲻Ϊ��
            // ѭ����������
            // f(left) >= k
            // f(right) < k
            int mid = left + (right - left) / 2;
            if (f(price, mid) >= k) left = mid; // ��һ�ֶ��� (mid, right)
            else right = mid; // ��һ�ֶ��� (left, mid)
        }
        return left;
    }

    private int f(int[] price, int d) {
        int cnt = 1, pre = price[0];
        for (int p : price) {
            if (p >= pre + d) {
                cnt++;
                pre = p;
            }
        }
        return cnt;
    }

}
