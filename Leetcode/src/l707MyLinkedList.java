public class l707MyLinkedList {

    
}
class MyLinkedList {
    ListNode head;
    int size = 0;

    public MyLinkedList() {
    }

    public int get(int index) {
        if(index >= size){
            return  -1;
        }
        int i = 0;
        ListNode p = head;
        while(i < index && p.next != null){
            p = p.next;
            i++;
        }
        return p.val;
    }
    public void addAtHead(int val) {
        ListNode cur = new ListNode(val);
        if(head == null){
            head = cur;
            head.next = null;
            size +=1;
            return;
        }
        cur.next = head;
        head = cur;
        size +=1;
    }

    public void addAtTail(int val) {
        ListNode cur = new ListNode(val);
        if(head == null){
            head = cur;
            head.next = null;
            size +=1;
            return;
        }
        ListNode p = head;
        while(p.next!=null){
            p = p.next;
        }
        p.next = cur;
        cur.next = null;
        size +=1;
    }

    public void addAtIndex(int index, int val) {
        if(index  <= 0){
            addAtHead(val);
        }else if(index == size){
            addAtTail(val);
        }else if(index > size){
        }else{
            int i = 0;
            ListNode cur = new ListNode(val);
            ListNode p = head;
            while(i < index - 1){
                i++;
                p = p.next;
            }
            cur.next = p.next;
            p.next = cur;
            size +=1;
            System.out.println(size);
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= size || size <= 0)
            return;
        if(index == 0){
            head = head.next;
            size -=1;
            return;
        }
        int i = 0;
        ListNode p = head;
        while(i < index - 1 && p.next != null){
            i++;
            p = p.next;
        }
        if( i == index - 1){
            p.next = p.next.next;
            size -= 1;
        }
    }
}

