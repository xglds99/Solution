import java.util.Deque;
import java.util.LinkedList;

public class l150evalRPN {
    public static void main(String[] args) {
        String tokens[]=new String[]{"-2","1","+","3","*"};
        int i = evalRPN(tokens);
        System.out.println(i);

    }

    public  static  int evalRPN(String tokens[]) {
        Deque<Integer> stack = new LinkedList<>();
        int resu = 0;
        for (String str : tokens) {
            if (str.matches("^\\-?[0-9]+(.[0-9]+)?$")) {
                stack.push(Integer.parseInt(str));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (str.equals("+")) {
                    resu = num1 + num2;
                }else if(str.equals("-")){
                    resu=num1-num2;
                }else if(str.equals("*")){
                    resu=num1 *num2;
                }else if(str.equals("/")){
                    resu=num1 /num2;
                }else {
                    throw new RuntimeException("·ûºÅÓÐÎó£¡");
                }
                stack.push(resu);
            }
        }
        return stack.pop();
    }
}
