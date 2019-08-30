/**
 * FileName: Singleton1
 * Author:   yangqinkuan
 * Date:     2019-8-28 16:19
 * Description:
 */

package 常见手写题;

public class Singleton1 {

    private Singleton1(){
    }
    private static class Holder{
        private static final Singleton1 INSTANCE = new Singleton1();
    }
    public static Singleton1 get() {
        return Holder.INSTANCE;
    }
}
