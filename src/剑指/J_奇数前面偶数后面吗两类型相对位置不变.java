/**
 * FileName: J_奇数前面偶数后面吗两类型相对位置不变
 * Author:   yangqinkuan
 * Date:     2019-8-13 8:38
 * Description:
 */

package 剑指;

import java.util.ArrayList;
import java.util.List;

public class J_奇数前面偶数后面吗两类型相对位置不变 {
    public void reOrderArray(int [] array) {
        int[] newarray = new int[array.length];

        List<Integer> list1 = new ArrayList<>(array.length);
        List<Integer> list2 = new ArrayList<>(array.length);
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                list2.add(array[i]);
            }else{
                list1.add(array[i]);
            }
        }
        int a = 0;
        while(a<list1.size()){
            array[a] = list1.get(a);
            a++;
        }
        int b = 0;
        while(b<list2.size()){
            array[a+b] = list2.get(b);
        }
    }
}
