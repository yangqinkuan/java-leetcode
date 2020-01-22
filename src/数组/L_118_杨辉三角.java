package 数组;

import java.util.ArrayList;
import java.util.List;

public class L_118_杨辉三角 {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for(int i=1;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1;j<i;j++){
                list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
