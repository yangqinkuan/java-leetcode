/**
 * FileName: TrappingRainWater
 * Author:   yangqinkuan
 * Date:     2019-5-16 16:26
 * Description:
 */

package 栈;

public class TrappingRainWater {
    /*思路
    * 1、先确定一个固定一边，寻找最高柱子，分别从两次向中间移动
    *2、分别从两边用指针逐个靠近最高柱子，
    * 3、  (1)当指针所指的高度，小于移动来源方向最高点时，可以得出当前位置的纵向储水，
    *       (2)当指针所指的高度，大于或者等于移动来源方向最高点时,更新来源处最高点
    * */
    public int trap(int[] height) {
        int count = 0;
        if(height.length==0){
            return 0;
        }
        int heightindex = 0;
        for(int i=0;i<height.length;i++){
            if(height[heightindex]<height[i]){
                heightindex = i;
            }
        }
        int tempmaxheight = height[0];
        for(int i=0;i<heightindex;i++){
            if(height[i]<tempmaxheight){
                count += tempmaxheight-height[i];
            }else{
                tempmaxheight = height[i];
            }
        }
        tempmaxheight = height[height.length-1];
        for(int i=height.length-1;i>heightindex;i--){
            if(height[i]<tempmaxheight){
                count += tempmaxheight-height[i];
            }else{
                tempmaxheight = height[i];
            }
        }
        return count;
    }
}
