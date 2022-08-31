import java.util.ArrayDeque;
import java.util.Deque;

public class l946validateStackSequences {

    public boolean validateStackSequences(int []pushed, int []poped){
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0,j=0; i< pushed.length; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == poped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
