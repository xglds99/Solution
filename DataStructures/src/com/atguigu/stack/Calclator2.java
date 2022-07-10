package com.atguigu.stack;

public class Calclator2 {
    public static void main(String[] args) {
        String expression = "(1+(4+5+2)-3)+(6+8)";
        ArrayStack3 numStack = new ArrayStack3(20);
        ArrayStack3 operStack = new ArrayStack3(20);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //��ÿ��ɨ�赽���ַ����浽ch
        String keepNum = "";
        while (true) {
            if(index==expression.length()){
                break;
            }
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (ch == ')') {
                    while (true) {
                        if (operStack.peek() == '(') {
                            operStack.pop();
                            break;
                        }
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                    }
                } else if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek()) && operStack.peek() != '(' && ch != '(') {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else if (ch == '(') {
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else if (ch == ' ') {
                index++;
                continue;
            } else {
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0)) || (expression.substring(index + 1, index + 2).charAt(0))==' ') {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
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
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("���ʽ%s=%d", expression, numStack.pop());
    }
}

class ArrayStack3 {

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack3(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int peek() {
        return stack[top];
    }

    public Boolean isFull() {
        return top == maxSize - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    //��ջ
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("ջ��");
        } else {
            return stack[top--];
        }
    }

    //��ջ
    public void push(int value) {
        if (isFull()) {
            System.out.println("ջ����");
            return;
        } else {
            stack[++top] = value;
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("ջ�գ�");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%d\n", i, stack[i]);
            }
        }
    }

    //�ж���������ȼ�
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '(' || oper == ')') {
            return -1;
        } else {
            return -1;
        }
    }

    //�ж��ǲ��������
    public Boolean isOper(char var) {
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

