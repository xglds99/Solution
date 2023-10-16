public class l24swapPairs {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            //当链表中没有节点或只有一个节点，无法完成翻转
            if(head ==null || head.next== null){
                return head;
            }
            //两两反转，则当前节点的的新头节点为之前的后继节点
            ListNode newHead=head.next;
            //当前节点的next的后继节点，应该为下一组的新的头节点
            head.next = swapPairs(newHead.next);
            //新的头节点的next节点为当前节点
            newHead.next = head;
            //f返回新的头节点！
            return newHead;
        }
    }
}
