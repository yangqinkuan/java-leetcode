package 华为机试题;

public class 字符数组压缩 {

    public static void main(String[] args) {
        System.out.println(yasuo("aaa"));
    }

    public static String yasuo(String str){
        StringBuffer sb = new StringBuffer();
        int count = 1;
        for(int i=0;i<str.length();i++){
            if(i!=str.length()-1&&str.charAt(i)==str.charAt(i+1)){
                count++;
            }else{
                if(count!=1){
                    sb.append(count);
                }
                sb.append(str.charAt(i));
                count = 1;
            }
        }

        return sb.toString();
    }
}
