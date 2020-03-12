package 数组;

import java.util.ArrayList;
import java.util.List;

public class L_163_缺失的区间 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        findClosestElements(arr,3,5);
    }



    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        if(k==0||arr.length==0) return list;
        int search = erfen(arr,x);
        if(search==arr.length){
            search = search-1;
        } else{
            search = x-arr[search-1]<=arr[search]-x?search-1:search;
        }
        int l = search;
        int r = search;

        k--;
        while(k>0){
            if(l==0){
                r++;
                k--;
            }else if(r==arr.length-1){
                l--;
                k--;
            }else{
                if(x-arr[l-1]<=arr[r+1]-x){
                    l--;
                }else{
                    r++;
                }
                k--;
            }
        }
        for(int i=l;i<=r;i++){
            list.add(arr[i]);
        }
        return list;
    }

    public static int erfen(int[] arr,int x){
        int left = 0;
        int right = arr.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]==x){
                return mid;
            }else if(x<arr[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
