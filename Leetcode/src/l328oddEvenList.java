public class l328oddEvenList {


    public ListNode oddEvenList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        //��������������
        /**
         * 1 -> 2 -> 3 -> 4 -> 5
         * ������������������ʱ �����һ��ѭ��
         * odd = 3 even = 4
         *  odd.next = even.next = 5
         *  odd = odd.next
         *  even.next = odd.next = null
         *  even = even.next = null
         */
        /**
         * 1 -> 2 -> 3 -> 4
         * ���������ż�������ʱ
         * odd = 3 even = 4
         * odd.next = even.next = null
         * odd = odd.next
         * even.next = odd.next = null
         * even = even.next
         */
        //��Ϊ����ʱż������㻹����������㣬���һ��ѭ������ͬ������ ���� even.next == null && even == null
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
