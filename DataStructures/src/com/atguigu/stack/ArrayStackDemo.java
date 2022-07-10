package com.atguigu.stack;


import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        Boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        while (loop) {
            System.out.println("**********************");
            System.out.println("*   (p)进栈:           *");
            System.out.println("*   (t)出栈:           *");
            System.out.println("*   (s)查看:           *");
            System.out.println("*   (e)退出:           *");
            System.out.println("*   请输入操作:         *");
            System.out.println("**********************");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'p':
                    System.out.println("请输入进栈的数值：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case 't':
                    arrayStack.pop();
                    break;
                case 's':
                    arrayStack.list();
                    break;
                case 'e':
                    loop = false;
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}

class ArrayStack {

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
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
}