package backtrack;

import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return resu;
    }

    public void dfs(int[] candidates, int target, int start) {
        if (trackSum == target) {
            resu.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            // ͬһԪ�ؿ��ظ�ʹ�ã�ע�����
            //���Զ��ڵݹ�Ĳ�������ÿһ������������ӵ�ǰ��i��ʼ���Ϳ���ʹ����ͬ��Ԫ��
            //���ǲ������ɻ�����һֱ�ݹ���ȥ�������޶������������������ĵݹ�
            dfs(candidates, target, i);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }


}
