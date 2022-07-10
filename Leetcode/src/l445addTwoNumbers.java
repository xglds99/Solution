import java.util.Deque;
import java.util.LinkedList;

public class l445addTwoNumbers {

    //双栈+头插法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> deque1 = new LinkedList<>();
        Deque<ListNode> deque2 = new LinkedList<>();
        ListNode head = new ListNode();  //返回计算后链表的头节点
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int sum = 0;
        int sign = 0; //记录进位
        while (temp1 != null) {
            deque1.push(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            deque2.push(temp2);
            temp2 = temp2.next;
        }
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            ListNode p = new ListNode();
            sum = sign + deque1.pop().val + deque2.pop().val;
            p.val = sum % 10;
            sign = sum / 10;
            p.next = head.next;
            head.next = p;
        }
        while (!deque1.isEmpty()) {
            ListNode p = new ListNode();
            sum = sign + deque1.pop().val;
            p.val = sum % 10;
            sign = sum / 10;
            p.next = head.next;
            head.next = p;
        }
        while (!deque2.isEmpty()) {
            ListNode p = new ListNode();
            sum = sign + deque2.pop().val;
            p.val = sum % 10;
            sign = sum / 10;
            p.next = head.next;
            head.next = p;
        }
        if (sign != 0) {
            ListNode p = new ListNode();
            p.val = sign;
            p.next = head.next;
            head.next = p;
        }
        return head.next;
    }
}
