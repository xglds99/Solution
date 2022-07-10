package com.atguigu.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "300+2*6-5+6/1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描到的字符保存到ch
        String keepNum = "";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //‘1’的ascii码对应的49，得到1数值需要减去48
                //numStack.push(ch -48);  //这样会出问题，多位数被分成一个个个位数
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
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
        System.out.printf("表达式%s=%d", expression, numStack.pop());
    }

}

class ArrayStack2 {

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
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

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        } else {
            return stack[top--];
        }
    }

    //进栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        } else {
            stack[++top] = value;
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空！");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%d\n", i, stack[i]);
            }
        }
    }

    //判断运算符优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是运算符
    public Boolean isOper(char var) {
        return var == '+' || var == '-' || var == '*' || var == '/';
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