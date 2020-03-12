package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class L_51_N皇后 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[] table = new int[n];
        search(table,0,n);
        return res;

    }

    public void search(int[] table,int cur,int n){
        if(cur==n){
            buildres(table,n);
        }else{
            for(int i=0;i<n;i++){
                table[cur] = i;
                int ok = 1;
                for(int j=0;j<cur;j++){
                    if(table[cur]==table[j]||cur-table[cur]==j-table[j]||cur+table[cur]==j+table[j]){
                        ok = 0;
                        break;
                    }
                }
                if(ok==1){
                    search(table,cur+1,n);
                }
            }
        }
    }
    // 收集结果
    public void buildres(int[] table,int n){
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==table[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
