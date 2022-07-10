package com.atguigu.queue;

import java.util.Scanner;

public class CircleQueueDemo {
    public static void main(String[] args) {

        CircleQueue circleQueue=new CircleQueue(3);
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
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int value= scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int i = circleQueue.getQueue();
                        System.out.println("取出的数据："+i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
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

class CircleQueue {
    private int maxSize; //数组最大容量
    private int front;  //队列头,指向队列头的第一个元素
    private int rear; //队列尾，指向队列尾的最后一个元素的下一个位置
    private int array[]; //存放队列数据

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public Boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public Boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满！");
            return;
        }
        array[rear]=n;
        rear=(rear + 1)%maxSize;
    }

    public  int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空！");
        }
        //front是指向队列中第一个元素
        int value=array[front];
        front=(front + 1)%maxSize;
        return front;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空！");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("%d\t", array[i%maxSize]);
        }
    }

    //求出当前队列有效数据个数
    public int size(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }
        return array[front];
    }
}
