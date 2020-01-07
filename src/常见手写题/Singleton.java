/**
 * FileName: Singleton
 * Author:   yangqinkuan
 * Date:     2019-8-28 16:16
 * Description:
 */

package 常见手写题;

public class Singleton {
    private static volatile Singleton INSTANCE;
    private Singleton(){}
        public static Singleton getInstance(){
            if(INSTANCE==null){
                synchronized (Singleton.class){
                    if (INSTANCE==null){
                        INSTANCE = new Singleton();
                    }
                }
            }
            return INSTANCE;
    }
   
}
