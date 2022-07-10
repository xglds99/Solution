import java.util.Stack;

public class l32longestValidParentheses {
    public static void main(String[] args) {
        String test="()(()";
        l32longestValidParentheses l32longestValidParentheses=new l32longestValidParentheses();
        int i = l32longestValidParentheses.longestValidParentheses(test);
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        Stack stack=new Stack();//´æ·Å×óÀ¨ºÅ
        int resu=0;
        char key= ' ';
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    resu=Math.max(resu,i-(int)stack.peek());
                }
            }
        }

        return  resu;
    }
}
