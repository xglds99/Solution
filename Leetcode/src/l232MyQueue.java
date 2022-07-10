import java.util.Deque;
import java.util.LinkedList;

public class l232MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());

    }

}
class  MyQueue{
Deque<Integer> deque1;
Deque<Integer> deque2;
    public MyQueue() {
    deque1 =new LinkedList<>();
    deque2 =new LinkedList<>();
    }

    public void push(int x) {
        if(deque1.isEmpty()){
            deque1.push(x);
        }else {
            int n=deque1.size();
            for (int i = 0; i < n; i++) {
                deque2.push(deque1.pop());
            }
            deque1.push(x);
            n=deque2.size();
            for (int i = 0; i < n; i++) {
                deque1.push(deque2.pop());
            }
        }

    }

    public int pop() {
        return deque1.pop();
    }

    public int peek() {
    return deque1.peek();
    }

    public boolean empty() {
    return deque1.isEmpty();
    }
}