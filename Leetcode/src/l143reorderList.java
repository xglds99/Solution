import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class l143reorderList {

    public void reorderList(ListNode head) {
        Queue<ListNode> queue = new LinkedList<>();
        Deque<ListNode> deque = new LinkedList<>();
        int n = 0;
        ListNode temp = head.next;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
    }
}
