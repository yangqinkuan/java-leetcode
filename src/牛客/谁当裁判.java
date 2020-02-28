package 牛客;

import java.util.Arrays;
import java.util.Scanner;

public class 谁当裁判 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] persons = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            persons[i] = sc.nextInt();
            max = Math.max(max,persons[i]);
        }
        int res = 0;
        while(max!=0){
            int min = Integer.MAX_VALUE;
            int minindex = -1;
            for(int i=0;i<n;i++){
                if(persons[i]<min){
                    min = persons[i];
                    minindex = i;
                }
            }
            max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(i!=minindex&&persons[i]>0){
                    persons[i]--;
                }
                max = Math.max(max,persons[i]);
            }
            res++;
        }
        System.out.println(res);
    }
}
