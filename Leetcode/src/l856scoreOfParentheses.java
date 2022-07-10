import org.junit.Test;

import java.util.Stack;

public class l856scoreOfParentheses {
//    ����һ��ƽ�������ַ���S�����������������ַ����ķ�����
//
//          () �� 1 �֡�
//    AB ��A + B�֣����� A �� B ��ƽ�������ַ�����
//         (A) ��2 * A�֣����� A ��ƽ�������ַ�����
@Test
public void test(){
    String s="(()(()))";
    System.out.println(scoreOfParentheses1(s));
}

    public int scoreOfParentheses(String s){
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: s.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();

    }

    public int scoreOfParentheses1(String s){
        char[] chars = s.toCharArray();
        int sign=0;
        int resu=1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='('){
                sign=i;
            }
        }
        for (int j=sign-1 ; j>=0 ; j--){
            if(chars[j]=='('){
                resu *=2;
            }else {
                resu+=1;
                j--;
            }
        }
        return  resu;
    }
}
