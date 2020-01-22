/**
 * FileName: Test01
 * Author:   yangqinkuan
 * Date:     2020-1-2 11:35
 * Description:
 */

package Test;

import java.util.*;

public class Test01 extends Father{
    @Override
    public void m1(String s,String a){

    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

       Character[] chars = new Character[list.size()];
       String.valueOf(chars);
        String s = new String();
       System.out.println(list.toString());

    }
}
class Father{
    public final void m1(String s){
        System.out.println("你好");
    }
    public void m1(String s, String a){

    }
}