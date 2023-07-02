
public class l2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(l1 != null || l2 != null || carry != 0){
            int k = carry;
            if (l1 != null){
                k += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                k += l2.val;
                l2 = l2.next;
            }
            ListNode cur = new ListNode(k % 10);
            carry = k / 10;
            tail.next = cur;
            tail = tail.next;
        }
        return dummy.next;
    }
}
