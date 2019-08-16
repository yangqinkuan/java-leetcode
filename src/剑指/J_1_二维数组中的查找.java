/**
 * FileName: J_1_二维数组中的查找
 * Author:   yangqinkuan
 * Date:     2019-7-29 11:30
 * Description:
 */

package 剑指;

public class J_1_二维数组中的查找 {
    public static boolean Find(int target, int [][] array) {
        if(array.length==0){
            return false;
        }
        int m = 0;
        int n = array[0].length-1;
        while(m<array.length-1&&n>=0){
            if(target<array[m][n]){
                n--;
            }else if(target>array[m][n]){
                m++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0][0] = 5;
        arr[0][1] = 2;
        arr[0][2] = 1;
        arr[1][0] = 6;
        arr[1][1] = 3;
        arr[1][2] = 2;
        arr[2][0] = 7;
        arr[2][1] = 4;
        arr[2][2] = 3;
        Find(5,arr);

    }
}
