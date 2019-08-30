/**
 * FileName: 实现奇数偶数交替打印
 * Author:   yangqinkuan
 * Date:     2019-8-28 9:13
 * Description:
 */

package 常见手写题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 实现奇数偶数交替打印 {
    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();
    static Condition jishu = lock.newCondition();
    static Condition oushu = lock.newCondition();


    public static void main(String[] args) {
        new Thread(new oushu()).start();
        new Thread(new jishu()).start();
    }

    private static class oushu implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count%2==1){
                        oushu.await();
                    }
                    System.out.println(count+"当前线程"+Thread.currentThread().getName());
                    count++;
                    jishu.signal();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }
    }


    private static class jishu implements Runnable{
        @Override
        public void run (){
            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try{
                    while (count%2==0){
                        jishu.await();
                    }
                    System.out.println(count+"当前线程"+Thread.currentThread().getName());
                    count++;
                    oushu.signal();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
