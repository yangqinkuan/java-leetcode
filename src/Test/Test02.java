package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test02 {
    public static void main(String[] args) throws ParseException {
        int[][] intervals = new int[8][8];
        Arrays.sort(intervals,(o1,o2)->{return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];});
        Map<Integer,Integer> map = new HashMap<>();

    }

    public int daysBetweenDates (String date1, String date2){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = simpleDateFormat.parse(date1);
            d2 = simpleDateFormat.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = (d1.getTime()-d2.getTime())/1000/60/60/24;
        if(diff<0) diff = diff*-1L;
        return (int)diff;
    }
}
