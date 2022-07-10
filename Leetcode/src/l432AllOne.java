import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class l432AllOne {



    @Test
    public void test(){
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());

    }


}

class AllOne{
    Node root;
    Map<String, Node> hashmap;

    public AllOne() {
        root = new Node();
        root.prev = root;
        root.next = root;  // 初始化链表哨兵，下面判断节点的 next 若为 root，则表示 next 为空（prev 同理）
        hashmap = new HashMap<String, Node>();
    }

    public void inc(String key) {
        if(hashmap.containsKey(key)){
            Node cur=hashmap.get(key);
            Node next=cur.next;
            if(next==root ||next.count > cur.count +1  ){
                hashmap.put(key, new Node(key,cur.next.count +1));
            }else {
                next.keys.add(key);
                hashmap.put(key, next);
            }
            cur.keys.remove(key);
            if(cur.keys.isEmpty()){
                cur.remove();
            }
        }else {
            if(root.next== root || root.next.count >1){
                hashmap.put(key, root.insert(new Node(key,1)));
            }else {
                root.next.keys.add(key);
                hashmap.put(key, root.next);
            }
        }
    }

    public void dec(String key) {
        Node cur = hashmap.get(key);
        if (cur.count == 1) {  // key 仅出现一次，将其移出 hashmap
            hashmap.remove(key);
        } else {
            Node pre = cur.prev;
            if (pre == root || pre.count < cur.count - 1) {
                hashmap.put(key, cur.prev.insert(new Node(key, cur.count - 1)));
            } else {
                pre.keys.add(key);
                hashmap.put(key, pre);
            }
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()) {
            cur.remove();
        }
    }

    public String getMaxKey() {
        return root.prev != null ? root.prev.keys.iterator().next() : "";
    }

    public String getMinKey() {
        return root.next != null ? root.next.keys.iterator().next() : "";
    }
}

class AllOne1 {
    HashMap<String, Integer> map;

    public AllOne1() {
        map = new HashMap<String, Integer>();
    }

    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
        System.out.println(map.get(key));
    }

    public void dec(String key) {
        map.put(key, map.getOrDefault(key, 0) - 1);

        if (map.get(key) == 0) {
            map.remove(key);
        }
    }

    public String getMaxKey() {
        String resu = "";
        int max = Integer.MIN_VALUE;
        for (String str : map.keySet()) {
            if (map.get(str) > max) {
                resu = str;
            }
        }
        return resu;
    }

    public String getMinKey() {
        String resu = "";
        int min = Integer.MAX_VALUE;
        for (String str : map.keySet()) {
            if (map.get(str) < min) {
                min=map.get(str);
                resu = str;
            }
        }
        return resu;
    }


}

class Node{
    Node next;
    Node prev;
    Set<String> keys;
    int count;

    public Node() {
     this("",0);
    }


    public Node(String key, int count) {
        this.count = count;
        keys = new HashSet<String>();
        keys.add(key);
    }

    public Node insert(Node node) {  // 在 this 后插入 node
        node.prev = this;
        node.next = this.next;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }

    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}
