/**
 * FileName: 剩余价值背包
 * Author:   yangqinkuan
 * Date:     2019-8-16 18:15
 * Description:
 */

package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 剩余价值背包 {

    public static void main(String[] args) {
        String s = "cars";
        List<String> list = new ArrayList<>();
        list.add("car");
        list.add("ca");
        list.add("rs");
        //System.out.println(true&&true);
        System.out.println(wordBreak(s,list));;
	}

    public static boolean wordBreak(String s, List<String> wordDict) {

        for(int i=0;i<wordDict.size();i++){
            int p = 0;
            int j = 0;
            String str = wordDict.get(i);
            while(j<str.length()&&s.length()>=str.length()){
                if(s.charAt(j)==str.charAt(j)){
                    j++;
                    p++;
                }else{
                    break;
                }
            }
            if(j==str.length()){
                if(p==s.length()){
                    return true;
                }
                if(wordBreak(s.substring(p),wordDict)){
                    return true;
                }
            }

        }
        return false;
    }

}
