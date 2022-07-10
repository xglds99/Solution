package com.xgl.singlelist;


public class FindFirstInsertNode {

    public static void main(String[] args) {


    }
    public ListNode getInsertNode(ListNode headA, ListNode headB){
        if (headA == null && headB == null){
            return null;
        }
        ListNode loop1 = getLoopNode(headA);
        ListNode loop2 = getLoopNode(headB);
        if (loop1 == null && loop2 == null){
            return noLoop(headA, headB);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(headA, loop1, headB, loop2);
        }
        return null;
    }

    public ListNode getLoopNode(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
            fast = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
    }

    public ListNode noLoop(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode n1 = headA;
        ListNode n2 = headB;
        int n = 0;
        while( n1.next != null){
            n++;
            n1 = n1.next;
        }
        while (n2.next != null){
            n--;
            n2 = n2.next;
        }
        if (n1 != n2){
            return null;
        }
        n1 = n >0 ? headA :headB;
        n2 = n1 == headA ? headB : headA;
        while (n != 0){
            n--;
            n1 = n1.next;
        }
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public ListNode bothLoop(ListNode headA, ListNode loop1, ListNode headB, ListNode loop2){
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2){
            cur1 = headA;
            cur2 = headB;
            int n = 0;
            while (cur1 != loop1 ){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? headA : headB;
            cur2 = cur1 == headA ? headB : headA;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}

