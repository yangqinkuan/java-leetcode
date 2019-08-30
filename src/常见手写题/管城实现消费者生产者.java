/**
 * FileName: 管城实现消费者生产者
 * Author:   yangqinkuan
 * Date:     2019-8-28 9:00
 * Description:
 */

package 常见手写题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 管城实现消费者生产者 {
    int capacity = 10;
    int count = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition notfull=lock.newCondition();
    Condition notEmpty = lock.newCondition();

    private class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                lock.lock();
                try {
                    while (count == 0) {
                        notEmpty.await();
                    }
                    count--;
                    notfull.signal();
                    System.out.println(Thread.currentThread().getName() + "消费了1个，总数为" + count);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    }finally {
                    lock.unlock();
                }
                }

            }
        }





    private class Producer implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();

                try{
                    while(count==capacity){
                        notfull.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                    notEmpty.signal();
                }catch (InterruptedException e){

                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
