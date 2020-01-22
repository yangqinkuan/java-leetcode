package 常见手写题;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 实现阻塞队列<T> {
    int capacity;
    LinkedList<T> list;
    volatile int size;
    ReentrantLock lock = new ReentrantLock();
    Condition unempty = lock.newCondition();
    Condition unfull = lock.newCondition();
    public 实现阻塞队列(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public T take(){
        lock.lock();
        T t = null;
        try {
            while(list.size()==0){
                unempty.await();
            }
            t = list.pollFirst();
            unfull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public boolean put(T t){
        lock.lock();
        boolean result = false;
        try{
            while (list.size()==capacity){
                unfull.await();
            }
            list.add(t);
            result = true;
            System.out.println("当前大小为"+list.size());
            unempty.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return result;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue(2,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        PriorityBlockingQueue queue = new PriorityBlockingQueue(2,new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        queue.add(2);

        实现阻塞队列<Integer> a = new 实现阻塞队列(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    a.put(i);
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10;i++){
                        Thread.sleep(1000);
                        System.out.println(a.take());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
