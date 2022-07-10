package com.atguigu.queue;

import java.util.Scanner;

public class CircleQueueDemo {
    public static void main(String[] args) {

        CircleQueue circleQueue=new CircleQueue(3);
        char key=' ';//�����û�����
        Boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("s(show): ��ʾ����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ����");
            System.out.println("e(exit): �˳�����");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("������һ������");
                    int value= scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int i = circleQueue.getQueue();
                        System.out.println("ȡ�������ݣ�"+i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("�����˳���");
                    loop=false;
                    break;
                default:break;
            }

        }
    }
}

class CircleQueue {
    private int maxSize; //�����������
    private int front;  //����ͷ,ָ�����ͷ�ĵ�һ��Ԫ��
    private int rear; //����β��ָ�����β�����һ��Ԫ�ص���һ��λ��
    private int array[]; //��Ŷ�������

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
            System.out.println("����������");
            return;
        }
        array[rear]=n;
        rear=(rear + 1)%maxSize;
    }

    public  int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("���пգ�");
        }
        //front��ָ������е�һ��Ԫ��
        int value=array[front];
        front=(front + 1)%maxSize;
        return front;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("���пգ�");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("%d\t", array[i%maxSize]);
        }
    }

    //�����ǰ������Ч���ݸ���
    public int size(){
        if(isEmpty()){
            throw new RuntimeException("���п�");
        }
        return (rear + maxSize - front) % maxSize;
    }

    //��ʾ���е�ͷ����
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("���пգ�");
        }
        return array[front];
    }
}
