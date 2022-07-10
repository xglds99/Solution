import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class l155MinStack {
    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        MinStack minStack1=new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(4);
        minStack.push(3);
        minStack.show();
        minStack.pop();
        minStack.show();
//        System.out.println(minStack.getMin());
    }


}

class MinStack {

    SingleList singleList;
    SingleList singleList1;
    public MinStack() {

    singleList=new SingleList();
    singleList1=new SingleList();

    }

    public void push(int val) {
        singleList.addNode(val);
        singleList1.addNode(Math.min(val, singleList1.head.next.val));
    }

    public void pop() {
        singleList.delNode();
        singleList1.delNode();
    }

    public int top() {
        return singleList.head.next.val;
    }

//    public int getMin() {
//
//    }
    public void show(){
        singleList.list();
    }
}

class SingleList{


    ListNode1 head= new ListNode1(0);
    public void addNode(int x){
        ListNode1 temp=head;
        ListNode1 node=new ListNode1(x);
        if(head.next==null){
            head.next=node;
        }else {
            temp=temp.next;
            node.next=temp;
            head.next=node;
        }
    }
    public void delNode(){
        head.next=head.next.next;

    }


    public void list(){
        if(head.next==null){
            System.out.println("Á´±íÎª¿Õ£¡");
            return;
        }
        ListNode1 temp=head.next;
        while(temp!=null){
            System.out.print(temp.val);

            temp=temp.next;
        }
        System.out.println();
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    int min;

    public ListNode1() {
    }

    public ListNode1(int val) {
        this.val = val;
    }
}