package com.atguigu.queue;


import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("������һ������");
                    int value= scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int i = arrayQueue.getQueue();
                        System.out.println("ȡ�������ݣ�"+i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
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

class ArrayQueue {
    private int maxSize; //�����������
    private int front;  //����ͷ
    private int rear; //����β
    private int array[]; //��Ŷ�������

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        array = new int[maxSize];
        front = -1;  //ָ�����ͷ��,������front��ָ�����ͷ��ǰһ��λ��
        rear = -1;        //ָ�����β����ָ���β������

    }

    public Boolean isEmpty() {
        return front == rear;
    }

    public Boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        //�����ж��Ƿ���
        if (isFull()) {
            System.out.println("���������ܼ������ݣ�");
            return;
        }
        rear++;
        array[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("���п�");
        }
        front++;
        return array[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("���пգ�");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }
    }

    //��ʾ���е�ͷ����
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("���пգ�");
        }
        return array[front + 1];
    }
}
