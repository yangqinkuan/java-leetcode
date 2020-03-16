package ACM;


import java.util.Arrays;

/**
 * n 只蚂蚁以每秒1cm的速度在长为Lcm的竿子上爬行。
 * 当蚂蚁爬到竿子的断点时，就会掉落。由于竿子太细，两只蚂蚁相遇时，它们不能交错通过，
 * 只能各自返回爬回去。对于每只蚂蚁，我们知道它距离竿子左端的距离Xi,但不知道它当前的朝向。
 * 请计算所有蚂蚁落下竿子所需的最短时间和最长时间
 *
 * 限制条件
 * 1<=L<=10^6
 * 1<=n<=10^6
 * 0<=Xi<=L
 */

public class Ants {

    public static void main(String[] args) {
        Ants test = new Ants();
        System.out.println(Arrays.toString(test.ants(10,3,new int[]{2,6,7})));
    }


    public int[] ants(int L,int n,int[] nums){
        int max = 0;
        int min = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,Math.max(nums[i],L-nums[i]));
            min = Math.max(min,Math.min(nums[i],L-nums[i]));
        }

        return new int[]{max,min};
    }
}
