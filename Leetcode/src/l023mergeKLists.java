public class l023mergeKLists {


    public ListNode merge(ListNode []lists, int i, int j){
        if(i == j) return lists[i];
        if(i > j) return null;
        int mid = (i + j) >> 1;
        return mergeTwoLists(merge(lists, i, mid), merge(lists, mid + 1, j));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while( list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
}
