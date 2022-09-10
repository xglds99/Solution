package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ����һ����ѡ�˱�ŵļ���candidates��һ��Ŀ����target���ҳ�candidates�����п���ʹ���ֺ�Ϊtarget����ϡ�
 * <p>
 * candidates�е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 * <p>
 * ע�⣺�⼯���ܰ����ظ�����ϡ�
 */
public class combinationSum_2 {
    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return resu;
    }

    public void dfs(int[] candidates, int start, int target) {
        if (trackSum == target) {
            resu.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            //��Ϊÿ��Ԫ��ֻ��ʹ��һ�Σ�������һ�������Ҫ�� i + 1 ��ʼ
            dfs(candidates, i + 1, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }

}
