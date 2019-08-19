/**
 * FileName: L_461_汉明距离
 * Author:   yangqinkuan
 * Date:     2019-8-19 11:42
 * Description:
 */

package 二进制;

public class L_461_汉明距离 {


    /**
     *两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     *
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hamming-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
}
    //将两数亦或得结果，然后求得结果中1的个数 每进行一次num&(num-1)能消除掉一个1
    public static int hammingDistance(int x, int y) {
        int num = x^y;
        int count = 0;
        while (num!=0){
            count += 1;
            num = num&(num-1);
        }
        return count;
    }
    //通过&1的方式然后移位，得出1的个数
    public static int hammingDistance1(int x, int y) {
        int num = x^y;
        int count = 0;
        while (num!=0){
            if((num&1)==1){
                count++;
            }
            num = num>>2;
        }
        return count;
    }
}
