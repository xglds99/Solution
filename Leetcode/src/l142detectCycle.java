import java.util.HashSet;
import java.util.Set;

public class l142detectCycle {


    public static void main(String[] args) {
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode n1 = headA;
        ListNode n2 = headB;
        int n = 0;
        while (n1.next != null) {
            n++;
            n1 = n1.next;
        }
        while (n2.next != null) {
            n--;
            n2 = n2.next;
        }
        if (n1 != n2) {
            return null;
        }
        n1 = n > 0 ? headA : headB;
        n2 = n1 == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            n1 = n1.next;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //使用hashset去重
    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> isVisited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (isVisited.contains(cur)) {
                return cur;
            } else {
                isVisited.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}
