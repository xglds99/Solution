import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName l445
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 9:55
 * @Version 1.0
 */
public class l445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> d1 = new LinkedList<>();
        Deque<ListNode> d2 = new LinkedList<>();
        while(l1 != null){
            d1.offerLast(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            d2.offerLast(l2);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while(!d1.isEmpty() || !d2.isEmpty() || carry != 0){
            int k = carry;
            if (!d1.isEmpty()){
                k += d1.pollLast().val;
            }
            if (!d2.isEmpty()){
                k += d2.pollLast().val;
            }
            ListNode cur = new ListNode(k % 10);
            carry = k / 10;
           cur.next = dummy.next;
           dummy.next = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Deque<Integer> d1 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            d1.offerLast(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(d1.pollLast());
        }
    }
}
