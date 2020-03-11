package 数组;

public class L_1013_将数组分成和相等的三个部分 {

    public static void main(String[] args) {
        int[] A = new int[]{12,-4,16,-5,9,-3,3,8,0};
        L_1013_将数组分成和相等的三个部分 test = new L_1013_将数组分成和相等的三个部分();
        test.canThreePartsEqualSum(A);
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum += A[i];
        }
        if(sum%3!=0) return false;
        sum = sum/3;
        int index = 0;
        int count = 0;
        int count_part = 0;
        while(index<A.length){
            while(index<A.length&&count!=sum){
                count += A[index];
                index++;
            }
            if(count==sum) count_part++;
            count = 0;
        }
        return count_part==3;
    }

}
