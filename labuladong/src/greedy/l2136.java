package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class l2136 {

    /**
     *你有 n 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。给你两个下标从 0 开始的整数数组 plantTime 和 growTime ，每个数组的长度都是 n ：
     * <p>
     * plantTime[i] 是 播种 第 i 枚种子所需的 完整天数 。每天，你只能为播种某一枚种子而劳作。无须 连续几天都在种同一枚种子，但是种子播种必须在你工作的天数达到 plantTime[i] 之后才算完成。
     * growTime[i] 是第 i 枚种子完全种下后生长所需的 完整天数 。在它生长的最后一天 之后 ，将会开花并且永远 绽放 。
     * 从第 0 开始，你可以按 任意 顺序播种种子。
     *
     * 返回所有种子都开花的 最早 一天是第几天。
     *
     * 首先 播种时间不能并行， 生成时间可以并行， 让并行的时间最长， 所需要的时间最短
     * 贪心: 对生成时间进行降序排序，生长时间长的先种下
     * 播种时间不可以并行。所以总的答案就是 所有播种时间和 并行的
     * @param plantTime
     * @param growTime
     * @return
     */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Integer[] id = IntStream.range(0, plantTime.length).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);
        int res = 0, day = 0;
        for (int i : id){
            day += plantTime[i];
            res = Math.max(res, day + growTime[i]);
        }
        return res;
    }
}
