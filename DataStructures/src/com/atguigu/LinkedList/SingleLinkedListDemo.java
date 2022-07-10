package com.atguigu.LinkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addHeroNodeById(new HeroNode(4, "�ν�", "��ʱ��"));
        singleLinkedList.addHeroNodeById(new HeroNode(8, "¬����", "������"));
        singleLinkedList.addHeroNodeById(new HeroNode(2, "���", "��ʤ����"));
        singleLinkedList.addHeroNodeById(new HeroNode(3, "����", "�Ƕ���"));
        singleLinkedList.addHeroNodeById(new HeroNode(3, "����", "�Ƕ���"));
        singleLinkedList.list();
        singleLinkedList.updateHeroNodeById(2, "����","������ͷ");
        singleLinkedList.deleteHeroNodeById(2);
        singleLinkedList.deleteHeroNodeById(20);
        singleLinkedList.list();
    }
}


class SingleLinkedList{
    //ͷ�ڵ㣬����ž�������
    private HeroNode head=new HeroNode(1, null, null);

    public void  addHeroNode( HeroNode heroNode ){
        HeroNode temp=head;
        while (temp.next!=null)
            temp=temp.next;
        temp.next=heroNode;
    }

    public void addHeroNodeById(HeroNode heroNode){
        Boolean flag=true;
        HeroNode temp=head.next;
        HeroNode pre=head;
        if(temp==null){
            addHeroNode(heroNode);
        }else{
            while(temp.id < heroNode.id  && temp.next!=null){
                    temp=temp.next;
                    pre=pre.next;
            }
            if(temp.id== heroNode.id){
                System.out.println("�ýڵ��Ѵ��ڣ����ܼ������룡");
            }
            else if(temp.next!=null){
                heroNode.next=temp;
                pre.next=heroNode;
            }else {
                addHeroNode(heroNode);
            }
        }
    }

    public void updateHeroNodeById(int id,String name,String nickNime){
        HeroNode temp=head.next;
        while (temp.id!=id && temp.next!=null){
            temp=temp.next;
        }
        if(temp!=null){
            temp.name=name;
            temp.nickName=nickNime;
        }else {
            System.out.println("�����ڸ�Ӣ�ۣ�");
        }
    }

    public void deleteHeroNodeById(int id){
        HeroNode temp=head.next;
        HeroNode pre=head;
        if(temp.id==id){
            head.next=temp.next;
        }else {
            while(temp.id!=id && temp.next!=null){
                temp=temp.next;
                pre=pre.next;
            }
            if(temp.next==null &&temp.id==id){
                pre.next=null;
            }else if(temp.next!=null &&temp.id==id){
                pre.next=temp.next;
            }else {
                System.out.println("��Ӣ�۲����ڣ�");
            }
        }
    }

    public void list(){
        if(head.next==null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        HeroNode temp=head.next;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

class HeroNode{  //ÿһ��HeroNode����һ������
    int id;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
