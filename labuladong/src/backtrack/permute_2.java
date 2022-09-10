package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * nums�����ظ�Ԫ��
 */
public class permute_2 {

    List<List<Integer>> resu = new ArrayList<>();
    LinkedList<Integer> track =new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean []used = new boolean[nums.length];
        dfs(nums,0,used);
        return resu;
    }

    public void dfs(int []nums,int start,boolean []used){
        if(start == nums.length){
            resu.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length ; i++){
            //��׼ȫ�����㷨֮���Գ����ظ�������Ϊ����ͬԪ���γɵ�����������Ϊ��ͬ�����У���ʵ��������Ӧ������ͬ�ģ�������̶���ͬԪ���γɵ�����˳�򣬵�Ȼ�ͱ������ظ���
            //��֦���ԣ���֤������ͬԪ�ص����λ�ò��䣬����֤û���ظ��ļ��ϡ� // ���ǰ����������Ԫ��û���ù���������
           //�������ظ�Ԫ��ʱ���������� nums = [1,2,2',2'']��2' ֻ���� 2 �Ѿ���ʹ�õ�����²Żᱻѡ��
            // ͬ��2'' ֻ���� 2' �Ѿ���ʹ�õ�����²Żᱻѡ����ͱ�֤����ͬԪ���������е����λ�ñ�֤�̶�
            if( i > 0 && nums[i] == nums[i -1] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                track.addLast(nums[i]);
                used[i] = true;
                dfs(nums,start + 1,used);
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
