package com.atguigu.queue;


import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(3);
        char key=' ';//接受用户输入
        Boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头数据");
            System.out.println("e(exit): 退出程序");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int value= scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int i = arrayQueue.getQueue();
                        System.out.println("取出的数据："+i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("程序退出！");
                    loop=false;
                    break;
                default:break;
            }

        }
    }

}

class ArrayQueue {
    private int maxSize; //数组最大容量
    private int front;  //队列头
    private int rear; //队列尾
    private int array[]; //存放队列数据

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        array = new int[maxSize];
        front = -1;  //指向队列头部,分析出front是指向队列头的前一个位置
        rear = -1;        //指向队列尾部，指向队尾的数据

    }

    public Boolean isEmpty() {
        return front == rear;
    }

    public Boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        //首先判断是否满
        if (isFull()) {
            System.out.println("队列满不能加入数据！");
            return;
        }
        rear++;
        array[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        front++;
        return array[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空！");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }
        return array[front + 1];
    }
}
