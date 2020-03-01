package 华为机试题;

public class 集五福 {

    public static void main(String[] args) {
        String[] strs = new String[1];
        System.out.println(wufu(new String[]{"11111","11111"}));
    }

    public static int wufu(String[] strs){
        int res = Integer.MAX_VALUE;
        int[] nums = new int[strs[0].length()];
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    nums[j] +=1;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            res = Math.min(nums[i],res);
        }
        return res;
    }
}
