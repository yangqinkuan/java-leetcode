import java.io.*;

/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-8-15 15:46
 * Description:
 */

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream s = new BufferedInputStream(new FileInputStream(new File("")));
        byte[] bb  = new byte[1024];
        int ch = 0;
        while ((ch=s.read(bb))!=-1){
            System.out.println((char)ch);
        }
        OutputStream o = new BufferedOutputStream(new FileOutputStream(new File("")));
        o.write(bb,0,bb.length);

        String s1 = "你是傻逼";
        byte[] b1=s1.getBytes();
        byte[] b2 = addHeadData(b1);
        String s2= new String(b2);
        System.out.println(s2);

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
