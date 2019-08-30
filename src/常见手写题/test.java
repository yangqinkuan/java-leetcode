/**
 * FileName: test
 * Author:   yangqinkuan
 * Date:     2019-8-28 15:17
 * Description:
 */

package 常见手写题;

public class test {
    public static void main(String[] args) throws InterruptedException {
        new test().test1();
    }
    public void test1() throws InterruptedException {
        for (int i=0;i<100;i++){
            System.out.println("------------------------------");
            if(i%5==0){
                this.wait();
            }
        }
    }
}
