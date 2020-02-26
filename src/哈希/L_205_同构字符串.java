package 哈希;

import java.util.*;

/**
 * 分清楚情况，写最基础过程
 */
public class L_205_同构字符串 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        int[][] arr = new int[2][2];
        Arrays.sort(arr, (o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);

    }

    public boolean isIsomorphic(String s, String t) {
        int i = 0;
        Map<Character,Character> map = new HashMap<>();
        while(i<s.length()){
            Character c = map.get(s.charAt(i));
            if(c==null){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else{
                if(!c.equals(t.charAt(i))) return false;
            }
            i++;
        }
        return true;
    }
}
