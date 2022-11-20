import org.junit.Test;

public class l92reverseBeetween {
    public ListNode reverseBetween(ListNode head, int left, int right){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        ListNode end;
        ListNode cur = head;
        int i = 0;
        while(i < left - 1){
            preStart = start;
            start = cur;
            cur = cur.next;
            i++;
        }
        i = 0;
        while(i < right - 1){
            i++;
            cur = cur.next;
        }
        end = cur;
        ListNode pre = end.next;
        System.out.println(preStart.val + " " + start.val + " " + end.val);
        ListNode next = null;
        while(pre != end){
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        if (left != right)
        preStart.next = pre;
        return dummy.next;
    }

    @Test
    public void  test(){
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
//        head.next.next = new ListNode(3);
////        head.next.next.next = new ListNode(4);

    }
}
