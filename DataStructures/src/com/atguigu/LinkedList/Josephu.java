package com.atguigu.LinkedList;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList csll=new CircleSingleLinkedList();
        csll.addBoy(25);
        csll.list();
        csll.countBoy(1, 2, 25);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("numsֵ����ȷ��");
            return;
        }
        Boy curBoy = null; //����ָ�룬����������������
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //���ݱ�Ŵ�����������
            if (i == 1) {
                first = boy;
                boy.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void list(){
        if(first==null){
            System.out.println("��������Ϊ�գ�");
        }else {
            Boy curBoy=first;
            while(true){
                System.out.println("С���ı���ǣ�"+curBoy.getId());
                if(curBoy.getNext()==first){
                    break;
                }
                curBoy=curBoy.getNext();
            }

        }
    }

    //�����û������룬�����С����Ȧ��˳��
    public void countBoy(int startId, int countNum, int nums){
        //��������У��
        if(first == null || startId <1 || startId > nums){
            System.out.println("��������");
            return;
        }

        Boy helper=first;
        while(helper.getNext() != first){
            helper=helper.getNext();
        }

        for (int j=0 ;j<startId -1; j++){
            helper=helper.getNext();
            first=first.getNext();
        }

        while (true){
            if(helper==first){
                break;
            }
            for(int j=0 ; j<countNum-1; j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("С��%d��Ȧ"+first.getId());
            first=first.getNext();

            helper.setNext(first);
        }
        System.out.println("�������Ȧ�е�С�����:"+first.getId());
    }
}


class Boy {
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}