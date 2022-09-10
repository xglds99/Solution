package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ����һ���������� nums �����п��ܰ����ظ�Ԫ�أ����㷵�ظ��������п��ܵ��Ӽ����ݼ�����
 * <p>
 * �⼯ ���� �����ظ����Ӽ������صĽ⼯�У��Ӽ����԰� ����˳�� ���С�
 * [1,2,2]
 */
public class subSet_2 {

    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return resu;
    }

    public void dfs(int start, int[] nums) {
        resu.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            //��֦���ԣ�����ݹ���ͬһ�㣬����ֵܽ����ͬ����ô�Ͱ������ͬ��Ԫ�ؽ��м�֦�����ڴ����Ͼ��� nums[i] == nums[i  -1] continue;
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            dfs(i + 1, nums);
            track.removeLast();
        }
    }
}
