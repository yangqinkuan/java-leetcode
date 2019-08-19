/**
 * Copyright (C), 2018-2019,
 * FileName: 猫咪特征提取
 * Author:   Administrator
 * Date:     2019/8/18 13:48
 * Description:
 */
package toutiao;

import java.util.*;

public class 猫咪特征提取 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; ++i){
            HashMap<String, Integer> mem = new HashMap<>();
            HashMap<String, Integer> temp_mem = new HashMap<>();
            int M = sc.nextInt();
            int max = 1;
            for(int j = 0; j < M; ++j){
                temp_mem.clear();
                int n = sc.nextInt();
                for(int k = 0; k < n; ++k){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    String key = String.valueOf(x) + " " + String.valueOf(y);
                    temp_mem.put(key, mem.getOrDefault(key, 0) + 1);
                    max = Math.max(temp_mem.get(key), max);
                }
                mem.clear();
                mem.putAll(temp_mem);
            }
            if(max <= 1){
                System.out.println(1);
            }else{
                System.out.println(max);
            }
        }

    }

    int[][] biaoge = new int[10000][10000];


    public int max(List<char[]> charsList){
        Arrays.fill(biaoge,0);
        int max = 0;
        for (char[] chars: charsList) {
            for(int i=1;i<chars.length-1;i=i+2){

            }
        }



        return 0;
    }

}