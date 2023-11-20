import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class l2 {
    private static final Object lock = new Object(); // 创建一个共享锁对象，用于线程同步
    private static int currentValue = 1; // 用于追踪当前应该输出的值
    private static final int maxNumber = 10; // 输出的最大数值
    public static void main(String[] args) {
        // 创建第一个线程，负责输出1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentValue <= maxNumber) {
                    synchronized (lock) {
                        while (currentValue % 3 != 1) {
                            try {
                                lock.wait(); // 当不轮到该线程输出时，释放锁并等待
                            } catch (Exception e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println(1); // 输出当前值
                        currentValue++; // 增加当前值，让下一个线程轮到
                        lock.notifyAll(); // 通知其他等待的线程继续执行
                    }
                }
            }
        });

        // 创建第二个线程，负责输出2
        Thread thread2 = new Thread(() -> {
            while (currentValue <= maxNumber) {
                synchronized (lock) {
                    while (currentValue % 3 != 2) {
                        try {
                            lock.wait(); // 当不轮到该线程输出时，释放锁并等待
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(2); // 输出当前值
                    currentValue++; // 增加当前值，让下一个线程轮到
                    lock.notifyAll(); // 通知其他等待的线程继续执行
                }
            }
        });
        // 创建第三个线程，负责输出3
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentValue <= maxNumber) {
                    synchronized (lock) {
                        while (currentValue % 3 != 0) {
                            try {
                                lock.wait(); // 当不轮到该线程输出时，释放锁并等待
                            } catch (Exception e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println(3); // 输出当前值
                        currentValue++; // 增加当前值，让下一个线程轮到
                        lock.notifyAll(); // 通知其他等待的线程继续执行
                    }
                }
            }
        });
        thread1.start(); // 启动第一个线程
        thread2.start(); // 启动第二个线程
        thread3.start(); // 启动第三个线程
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
