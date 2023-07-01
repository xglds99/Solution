/**
 * @author xgl
 * @date 2023/6/27 18:11
 */
public class l61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        int cnt = 0;
        while(p != null){
            p = p.next;
            cnt++;
        }
        k = k % cnt;
        if(k == 0){
            return head;
        }
        p = head;
        int i = 0;
        while(i < cnt - k - 1){
            i++;
            p = p.next;
        }
        ListNode res = p.next;
        ListNode q = p.next;
        p.next = null;
        while(q.next != null) q = q.next;
        q.next = head;
        return res;
    }
}
