/**
 * Copyright (C), 2018-2019,
 * FileName: L_11_盛水最多的容器
 * Author:   Administrator
 * Date:     2019/8/19 22:51
 * Description:
 */
package 容器盛水类;

public class L_11_盛水最多的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = (right-left)*Math.min(height[left],height[right]);

        while (left<right){
            if(height[left]<height[right]){
                left+=1;
            }else {
                right+=1;
            }
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));

        }
        return max;
    }
}