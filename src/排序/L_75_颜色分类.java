/**
 * FileName: L_75_颜色分类
 * Author:   yangqinkuan
 * Date:     2019-7-16 15:12
 * Description:
 */

package 排序;

public class L_75_颜色分类 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int i =0;
        int j = 0;
        while(i<3){
            int num = count[i];
            while(num>0){
                nums[j] = i;
                j++;
                num--;
            }
            i++;
        }
    }
    public void sortColors1(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }



}
