public class l24swapPairs {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            //��������û�нڵ��ֻ��һ���ڵ㣬�޷���ɷ�ת
            if(head ==null || head.next== null){
                return head;
            }
            //������ת����ǰ�ڵ�ĵ���ͷ�ڵ�Ϊ֮ǰ�ĺ�̽ڵ�
            ListNode newHead=head.next;
            //��ǰ�ڵ��next�ĺ�̽ڵ㣬Ӧ��Ϊ��һ����µ�ͷ�ڵ�
            head.next = swapPairs(newHead.next);
            //�µ�ͷ�ڵ��next�ڵ�Ϊ��ǰ�ڵ�
            newHead.next = head;
            //f�����µ�ͷ�ڵ㣡
            return newHead;
        }
    }
}
