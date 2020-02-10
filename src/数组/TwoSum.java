package 数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSum {
    List<Integer> list;
    /** Initialize your data structure here. */
    boolean sort;
    public TwoSum() {
        list = new ArrayList();
        sort = true;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        sort = false;
        list.add(number);


    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(!sort) Collections.sort(this.list);
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int sum = list.get(left)+list.get(right);
            if(sum==value) return true;
            if(sum<value){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        System.out.print(twoSum.find(3));
    }
}
