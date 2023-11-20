import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xgl
 * @date 2023/6/27 15:39
 */
public class l146 {

    private static final int MAX_ENTRIES = 100; // 设置缓存的最大容量

    private LinkedHashMap<String,String> cache = new LinkedHashMap<>(MAX_ENTRIES, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            // 当缓存超过最大容量时，移除最老的元素
            return size() > MAX_ENTRIES;
        }
    };

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.getOrDefault(key, "");
    }



    public static void main(String[] args) {

    }
    class DLinkedList{
        int key;
        int value;
        DLinkedList prev;
        DLinkedList next;
        DLinkedList(int key, int value){
            this.key = key;
            this.value = value;
        }
        DLinkedList(){}
    }

    class LRUCache{
        int capacity;
        int curSize;
        DLinkedList head = new DLinkedList();
        DLinkedList tail = new DLinkedList();
        HashMap<Integer, DLinkedList> cache = new HashMap<Integer, DLinkedList>();



        LRUCache(int capacity){
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
            this.curSize = 0;
        }
        int get(int key){
            DLinkedList cur = cache.get(key);
            if (cur == null){
                return  -1;
            }else{
                moveToHead(cur);
                return cur.value;
            }
        }

        void put(int key, int value){
            DLinkedList cur = cache.get(key);
            if (cur == null){
                DLinkedList  newNode = new DLinkedList(key, value);
                cache.put(key,newNode);
                addToHead(newNode);
                curSize++;
                if (curSize > capacity){
                    int removeKey = removeTail();
                    cache.remove(removeKey);
                    curSize--;
                }
            }else{
                cur.value = value;
                moveToHead(cur);
            }
        }

        void addToHead(DLinkedList node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        void moveToHead(DLinkedList node){
            removeNode(node);
            addToHead(node);
        }


        void removeNode(DLinkedList node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        int removeTail(){
            DLinkedList prev = tail.prev;
            removeNode(prev);
            return prev.key;
        }

    }
}
