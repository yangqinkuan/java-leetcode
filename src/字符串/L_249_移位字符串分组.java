package 字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_249_移位字符串分组 {

    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        groupStrings(strings);
    }


    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        boolean[] table = new boolean[strings.length];
        for(int i=0;i<strings.length;i++){
            List<String> list = new ArrayList<>();
            list.add(strings[i]);
            table[i] = true;
            for(int j=i;j<strings.length;j++){
                if(table[j]) continue;
                if(strings[i].length()!=strings[j].length()) continue;
                boolean flag = true;
                for(int k=0;k<strings[i].length()-1;k++){
                    int num1 = strings[i].charAt(k+1)-strings[i].charAt(k);
                    int num2 = strings[j].charAt(k+1)-strings[j].charAt(k);
                    if(num1!=num2){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(strings[j]);
                    table[j] = true;
                }
            }
            res.add(list);
        }

        return res;

    }
}
