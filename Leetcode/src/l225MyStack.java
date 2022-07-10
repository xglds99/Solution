import java.util.LinkedList;
import java.util.Queue;

public class l225MyStack {

}

class MyStack {
    public Queue<Integer> queue1;

    public MyStack() {
        queue1=new LinkedList<>();
    }

    public void push(int x) {
        int n=queue1.size();
        queue1.offer(x);
        for (int i = 0; i < n; i++) {
            queue1.offer(queue1.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return  queue1.isEmpty();
    }
}

