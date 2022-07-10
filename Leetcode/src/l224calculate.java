import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class l224calculate {

    @Test
    public void test() {
        String s = "-5+(3-2) + 7 -10 +25";
        System.out.println(calculate1(s));
    }
    public int calculate1(String s){
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
    public int calculate(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> operStack = new LinkedList<>();
        String keepNum = "";
        int num1 = 0;
        int num2 = 0;
        int resu = 0;
        char oper = ' ';
        int index = 0;
        boolean flag = false;
        char ch = ' ';
        if (s.charAt(index) == '-')
        {
            index = 1;
            flag = true;
        }
        while (true) {
            ch = s.charAt(index);
            if (isOper(ch)) {
                if (operStack.isEmpty() || ch == '(' || operStack.peek() =='(') {
                    operStack.push(ch);
                } else if (ch == ')') {
                    while (true) {
                        if (operStack.peek() == '(') {
                            operStack.pop();
                            break;
                        }
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        resu = cal(num1, num2, oper);
                        numStack.push(resu);
                    }
                } else {
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    oper = operStack.pop();
                    resu = cal(num1, num2, oper);
                    numStack.push(resu);
                    operStack.push(ch);
                }
            } else if (ch == ' ') {

            } else {
                keepNum += ch;
                if (index == s.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (isOper(s.substring(index + 1, index + 2).charAt(0)) || (s.substring(index + 1, index + 2).charAt(0)) == ' ') {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= s.length()) {
                break;
            }
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            resu = cal(num1, num2, oper);
            numStack.push(resu);
        }
        if(flag){
            return (-1)*numStack.pop();
        }else {
            return  numStack.pop();
        }
    }


    public boolean isOper(char var) {
        return var == '+' || var == '-' || var == '*' || var == '/' || var == '(' || var == ')';
    }

    public int cal(int num1, int num2, int oper) {
        int resu = 0;
        switch (oper) {
            case '+':
                resu = num1 + num2;
                break;
            case '-':
                resu = num2 - num1;
                break;
            case '*':
                resu = num1 * num2;
                break;
            case '/':
                resu = num2 / num1;
                break;
            default:
                break;
        }
        return resu;
    }
}
