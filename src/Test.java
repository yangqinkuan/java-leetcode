import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-8-15 15:46
 * Description:
 */

public class Test {
    public static void main(String[] args) throws IOException {





        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            String path = "D:/dict2.txt";
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"gb2312"));
            Set<String> set = new HashSet<>();
            String s;
            int count = 0;

            List<String> list = new ArrayList<>();
            while ((s=bufferedReader.readLine())!=null){
                //System.out.println(s);
                list.add(s);
                //System.out.println(count++);
                //set.add(s);
            }

            long start = System.currentTimeMillis();
            for (String s1:
            list) {
                count++;
                /*if(s1.contains("恒")){
                    set.add(s1);

                }*/
            }
            long end = System.currentTimeMillis();

            System.out.println(end-start);
            System.out.println("================");
            System.out.println(count);
            //System.out.println(set.size());
          /*  bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path)),"gb2312"));

            for (String str: set) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }*/
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                //bufferedWriter.close();;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public static byte[] addHeadData(byte[] data) {
        byte[] tdata = new byte[data.length+4];
        int val = data.length;
        byte[] lbyte = new byte[4];
        for(int i=0;i<4;i++) {
            lbyte[4-i-1] = (byte)((val >> 8 * i) & 0xff);
        }
        System.arraycopy(lbyte, 0, tdata, 0, 4);
        System.arraycopy(data, 0, tdata, 4, data.length);
        return tdata;
    }


}
