import java.util.LinkedList;
import java.util.Queue;

public class l225MyStack {

}

class MyStack {
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

//    public void push(int x) {
//        int n=queue1.size();
//        queue1.offer(x);
//        for (int i = 0; i < n; i++) {
//            queue1.offer(queue1.poll());
//        }


    public void push(int x){
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = new LinkedList<>();
        queue2 = temp;
        queue2 = queue1;
        queue1 = temp;
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

