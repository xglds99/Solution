public class l328oddEvenList {


    public ListNode oddEvenList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        //结束条件不好想
        /**
         * 1 -> 2 -> 3 -> 4 -> 5
         * 当链表存在奇数个结点时 ：最后一次循环
         * odd = 3 even = 4
         *  odd.next = even.next = 5
         *  odd = odd.next
         *  even.next = odd.next = null
         *  even = even.next = null
         */
        /**
         * 1 -> 2 -> 3 -> 4
         * 单链表存在偶数个结点时
         * odd = 3 even = 4
         * odd.next = even.next = null
         * odd = odd.next
         * even.next = odd.next = null
         * even = even.next
         */
        //因为不论时偶数个结点还是奇数个结点，最后一次循环有相同的条件 就是 even.next == null && even == null
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
