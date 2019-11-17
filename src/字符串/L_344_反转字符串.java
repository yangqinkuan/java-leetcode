/**
 * Copyright (C), 2018-2019, FileName: L_344_反转字符串 Author:   Administrator Date:     2019/11/18 0:13 Description:
 */
package 字符串;

public class L_344_反转字符串 {
    public void reverseString(char[] s) {
        if(s.length==0){
            return;
        }
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}