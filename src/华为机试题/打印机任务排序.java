package 华为机试题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class 打印机任务排序 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int index = 2;
        prin(nums,index);
    }

    public static void prin(int[] nums,int index){
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        int[] sort = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sort[i] = nums[i];
            queue.add(i);
        }
        int count = 0;
        Arrays.sort(sort);
        for(int i=sort.length-1;i>=0;i--){
            while(nums[queue.peek()]!=sort[i]){
                queue.addLast(queue.pollFirst());
            }
            if(queue.peek()==index) count=nums.length-i;
            res.addLast(queue.pollFirst());
        }
        System.out.println(count);
        while(res.size()!=0){
            System.out.print(res.pollFirst()+" ");
        }


    }
}
