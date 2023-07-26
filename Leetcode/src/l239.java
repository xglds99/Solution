
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName l239
 * @Description
 * @Author xgl
 * @Date 2023/7/21 11:10
 * @Version 1.0
 */
public class l239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int []res=  new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //����һ���Ӵ�С�ĵ������У�С�ڵ�ǰԪ�ص�ֱ�ӵ���
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            //ȥ�������ڵ�ǰ���ڵ�Ԫ��
            if (i - k >= queue.peekFirst()){
                queue.pollFirst();
            }
            //�ӵ�k��Ԫ�ؿ�ʼ����¼��
            if (i + 1 >= k){
                res[i + 1 - k] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
//    if(nums == null || nums.length < 2) return nums;
//    // ˫����� ���浱ǰ�������ֵ������λ�� ��֤����������λ�õ���ֵ���Ӵ�С����
//    LinkedList<Integer> queue = new LinkedList();
//    // �������
//    int[] result = new int[nums.length-k+1];
//    // ����nums����
//        for(int i = 0;i < nums.length;i++){
//        // ��֤�Ӵ�С ���ǰ����С����Ҫ���ε�����ֱ������Ҫ��
//        while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
//            queue.pollLast();
//        }
//        // ��ӵ�ǰֵ��Ӧ�������±�
//        queue.addLast(i);
//        // �жϵ�ǰ�����ж��׵�ֵ�Ƿ���Ч
//        if(queue.peek() <= i-k){
//            queue.poll();
//        }
//        // �����ڳ���Ϊkʱ ���浱ǰ���������ֵ
//        if(i+1 >= k){
//            result[i+1-k] = nums[queue.peek()];
//        }
//    }
//        return result;
}
