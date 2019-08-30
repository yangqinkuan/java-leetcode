/**
 * FileName: 实现12345轮流打印
 * Author:   yangqinkuan
 * Date:     2019-8-29 8:26
 * Description:
 */

package 常见手写题;

public class 实现12345轮流打印 {

    static volatile int count = 1;
    public static void main(String[] args) {
        new Thread(new print(1,"1")).start();
        new Thread(new print(2,"2")).start();
        new Thread(new print(3,"3")).start();
        new Thread(new print(4,"4")).start();
        new Thread(new print(0,"5")).start();

    }
    static class  print implements Runnable{
        int i;
        String name;
        public print(int i,String name){
            this.i = i;
            this.name = name;
        }
        @Override
        public void run() {
            while (true){
                if(count>=101){
                    break;
                }
                if(count%5==i){
                    synchronized (print.class){
                        System.out.println(count+"名字为"+name);
                        count++;
                    }
                }
            }
        }
    }

}
