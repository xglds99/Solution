import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class l234isPalindrome {


    @Test
    public void main() {
        System.out.println(1 / 2);
    }

    private ListNode head = new ListNode(1);

    public static void main(String[] args) {
        l234isPalindrome l234isPalindrome = new l234isPalindrome();
        l234isPalindrome.addListNode(new ListNode(2));
        l234isPalindrome.addListNode(new ListNode(2));
        l234isPalindrome.list();
        System.out.println(isPalindrome(l234isPalindrome.head));
    }

    public void addListNode(ListNode node) {
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("Á´±íÎª¿Õ£¡");
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static Boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode temp = head;
        int n = 1;
        Boolean isFlag = true;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                deque.push(temp.val);
                temp = temp.next;
            }
            while (temp != null) {
                if (temp.val != deque.pop()) {
                    isFlag = false;

                }
                temp = temp.next;
            }
        } else {
            for (int i = 1; i <= n / 2; i++) {
                deque.push(temp.val);
                temp = temp.next;
            }
            temp = temp.next;
            while (temp != null) {
                if (temp.val != deque.pop()) {
                    isFlag = false;
                }
                temp = temp.next;
            }
        }
        return isFlag;
    }
}



class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}