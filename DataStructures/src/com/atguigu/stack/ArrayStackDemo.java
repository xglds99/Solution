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
            System.out.println("*   (p)��ջ:           *");
            System.out.println("*   (t)��ջ:           *");
            System.out.println("*   (s)�鿴:           *");
            System.out.println("*   (e)�˳�:           *");
            System.out.println("*   ���������:         *");
            System.out.println("**********************");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'p':
                    System.out.println("�������ջ����ֵ��");
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
}