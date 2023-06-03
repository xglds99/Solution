package 二分答案;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/1 10:07
 */
public class l2517 {

    /**
     * @return 「任意两种糖果价格绝对差的最小值」等价于「排序后，任意两种相邻糖果价格绝对差的最小值」。
     * <p>
     * 如果题目中有「最大化最小值」或者「最小化最大值」，一般都是二分答案，请记住这个套路。
     * <p>
     * 为什么？对于本题来说，甜蜜度越大，能选择的糖果越少，有单调性，所以可以二分。
     * <p>
     * 定义 f(d)f(d)f(d) 表示甜蜜度至少为 ddd 时，至多能选多少类糖果。
     * <p>
     * 二分答案 ddd：
     * <p>
     * 如果 f(d)≥kf(d)\ge kf(d)≥k，说明答案至少为 ddd。
     * 如果 f(d)<kf(d)< kf(d)<k，说明答案至多为 d?1d-1d?1。
     * 二分结束后，设答案为 d0\textit{d}_0d
     * 0
     * <p>
     * ，那么 f(d0)≥kf(d_0)\ge kf(d
     * 0
     * <p>
     * )≥k 且 f(d0+1)<kf(d_0+1)< kf(d
     * 0
     * <p>
     * +1)<k。
     * 如何计算 f(d)f(d)f(d)？对 price\textit{price}price 从小到大排序，贪心地计算 f(d)f(d)f(d)：从 price[0]\textit{price}[0]price[0] 开始选；假设上一个选的数是 pre\textit{pre}pre，那么当 price[i]≥pre+d\textit{price}[i] \ge \textit{pre}+dprice[i]≥pre+d 时，才可以选 price[i]\textit{price}[i]price[i]。
     * <p>
     * 二分下界可以取 111，上界可以取 ?max?(price)?min?(price)k?1?\left\lfloor\dfrac{\max(\textit{price})-\min(\textit{price})}{k-1}\right\rfloor?
     * k?1
     * max(price)?min(price)
     * <p>
     * ?，这是因为最小值不会超过平均值。（平均值指选了 price\textit{price}price 最小最大以及中间的一些糖果，相邻糖果差值的平均值。）
     * <p>
     * 请注意，二分的区间的定义是：尚未确定 f(d)f(d)f(d) 与 kkk 的大小关系的 ddd 的值组成的集合（范围）。在区间左侧外面的 ddd 都是 f(d)≥kf(d)\ge kf(d)≥k 的，在区间右侧外面的 ddd 都是 f(d)<kf(d)< kf(d)<k 的。在理解二分时，请牢记区间的定义及其性质。
     * <p>
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/solutions/2031994/er-fen-da-an-by-endlesscheng-r418/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @Author xgl
     * @Description 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
     * <p>
     * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
     * <p>
     * 返回礼盒的 最大 甜蜜度。
     * @Date 10:07 2023/6/1
     * @Param
     **/

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        // 二分模板·其三（开区间写法）https://www.bilibili.com/video/BV1AP41137w7/
        int left = 0, right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left  <= right) { // 开区间不为空
            // 循环不变量：
            // f(left) >= k
            // f(right) < k
            int mid = left + (right - left) / 2;
            if (f(price, mid) >= k) left = mid; // 下一轮二分 (mid, right)
            else right = mid; // 下一轮二分 (left, mid)
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
