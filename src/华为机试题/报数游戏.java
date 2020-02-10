package 华为机试题;

import java.util.LinkedList;

public class 报数游戏 {

    public static void main(String[] args) {
        baoshu1(2,100);
        baoshu(2,100);
    }

    public static void baoshu1(int m,int n){
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.addLast(i);
        }
        int num = 1;
        while (queue.size()!=1){
            if(num%3==0){
                queue.pollFirst();
            }else{
                queue.addLast(queue.pollFirst());
            }
            num++;
        }
        while (queue.size()!=0){
            System.out.println(queue.pollFirst());
        }

    }


    public static void baoshu(int m,int n){
        boolean[] person = new boolean[n];
        int remain = n;
        int count = 1;
        int index = 0;
        while(remain>=m){
            if(person[index%n]){
                index++;
            }else{
                if(count%3==0){
                    person[index%n] = true;
                    remain--;
                }
                count++;
                index++;
            }
        }
        for(int i=0;i<person.length;i++){
            if(!person[i]){
                System.out.print(i+1+" ");
            }
        }
    }
}
