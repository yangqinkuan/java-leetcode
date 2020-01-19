package 广度优先遍历;

import java.util.LinkedList;

/**
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * 示例：
 *
 * 给定二维网格：
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * 运行完你的函数后，该网格应该变成：
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walls-and-gates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */




public class L_286_墙与门 {
    int[][] arr = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public void wallsAndGates(int[][] rooms) {
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(queue.size()!=0){
            int[] pair = queue.pollLast();
            for(int[] step:arr){
                int x = pair[0]+step[0];
                int y = pair[1]+step[1];
                if(x<0||y<0||x>=rooms.length||y>=rooms[0].length) continue;
                if(rooms[x][y]>rooms[pair[0]][pair[1]]+1){
                    rooms[x][y] = rooms[pair[0]][pair[1]]+1;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}
