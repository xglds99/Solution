import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class l2 {
    private static final Object lock = new Object(); // ����һ�����������������߳�ͬ��
    private static int currentValue = 1; // ����׷�ٵ�ǰӦ�������ֵ
    private static final int maxNumber = 10; // ����������ֵ
    public static void main(String[] args) {
        // ������һ���̣߳��������1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentValue <= maxNumber) {
                    synchronized (lock) {
                        while (currentValue % 3 != 1) {
                            try {
                                lock.wait(); // �����ֵ����߳����ʱ���ͷ������ȴ�
                            } catch (Exception e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println(1); // �����ǰֵ
                        currentValue++; // ���ӵ�ǰֵ������һ���߳��ֵ�
                        lock.notifyAll(); // ֪ͨ�����ȴ����̼߳���ִ��
                    }
                }
            }
        });

        // �����ڶ����̣߳��������2
        Thread thread2 = new Thread(() -> {
            while (currentValue <= maxNumber) {
                synchronized (lock) {
                    while (currentValue % 3 != 2) {
                        try {
                            lock.wait(); // �����ֵ����߳����ʱ���ͷ������ȴ�
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(2); // �����ǰֵ
                    currentValue++; // ���ӵ�ǰֵ������һ���߳��ֵ�
                    lock.notifyAll(); // ֪ͨ�����ȴ����̼߳���ִ��
                }
            }
        });
        // �����������̣߳��������3
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentValue <= maxNumber) {
                    synchronized (lock) {
                        while (currentValue % 3 != 0) {
                            try {
                                lock.wait(); // �����ֵ����߳����ʱ���ͷ������ȴ�
                            } catch (Exception e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println(3); // �����ǰֵ
                        currentValue++; // ���ӵ�ǰֵ������һ���߳��ֵ�
                        lock.notifyAll(); // ֪ͨ�����ȴ����̼߳���ִ��
                    }
                }
            }
        });
        thread1.start(); // ������һ���߳�
        thread2.start(); // �����ڶ����߳�
        thread3.start(); // �����������߳�
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(l1 != null || l2 != null || carry != 0){
            int k = carry;
            if (l1 != null){
                k += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                k += l2.val;
                l2 = l2.next;
            }
            ListNode cur = new ListNode(k % 10);
            carry = k / 10;
            tail.next = cur;
            tail = tail.next;
        }
        return dummy.next;
    }
}
class AlternateThreadPrinting {


    public void t1() {

    }

}

class LRUCache extends LinkedHashMap<Integer, Integer> {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,2);
        cache.put(3,4);
        System.out.println(cache.get(3));
        cache.put(5,6);
        System.out.println(cache.get(1));
    }
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
