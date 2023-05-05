package com.atguigu.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DoubleLinedListDemo {


    public static void main(String[] args) {
        DoubleLinkedList dll=new DoubleLinkedList();
        dll.addHeroNode(new HeroNode2(2, "卢俊义","玉麒麟"));
        dll.addHeroNode(new HeroNode2(3, "宋江","及时雨"));
        dll.addHeroNode(new HeroNode2(4, "李广","花将军"));
        dll.list();
        Map<String,Object> map= new HashMap<>();
        dll.deleteHeroNode2ById(2);
        dll.list();
    }
}

class DoubleLinkedList {
    private final HeroNode2 head = new HeroNode2(1, null, null);

    public void addHeroNode(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void deleteHeroNode2ById(int id) {
        HeroNode2 temp = head;
        if (temp.next == null) {
            System.out.println("链表为空！");
            return;
        }
        while (temp.id != id && temp.next != null) {
            temp = temp.next;
        }
        if (temp.next != null && temp.id == id) {
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
        }else if(temp.next==null && temp.id==id){
            temp.pre=null;
        }else {
            System.out.println("该节点不存在！");
        }
    }

    public void list(){
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode2 temp=head.next;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }

}

class HeroNode2 {
    int id;
    String name;
    String nickName;
    HeroNode2 next;
    HeroNode2 pre;
    public HeroNode2(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
