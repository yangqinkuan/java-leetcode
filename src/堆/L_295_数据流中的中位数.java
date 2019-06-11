/**
 * FileName: L_295_数据流中的中位数
 * Author:   yangqinkuan
 * Date:     2019-6-11 10:24
 * Description:
 */

package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L_295_数据流中的中位数 {
    private Queue<Integer> queueMinHeap;
    private Queue<Integer> queueMaxHeap;
    private int flag;
    public L_295_数据流中的中位数() {
        queueMinHeap = new PriorityQueue();
        queueMaxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?-1:1;
            }
        });
    }

    public void addNum(int num) {
        if(queueMinHeap.isEmpty()||num>queueMinHeap.peek()){
            queueMinHeap.add(num);
            flag++;
        }else {
            queueMaxHeap.add(num);
            flag--;
        }
        if(flag>1){
            queueMaxHeap.add(queueMinHeap.poll());
            flag -=2;
        }
        if(flag<-1){
            queueMinHeap.add(queueMaxHeap.poll());
            flag +=2;
        }
    }

    public double findMedian() {
        if(queueMinHeap.isEmpty()&&queueMaxHeap.isEmpty()){
            return 0;
        }
        if(flag==0){
            return (queueMinHeap.peek()+queueMaxHeap.peek())/2.0;
        } else if (flag == 1) {
            return queueMinHeap.peek();
        }else {
            return queueMaxHeap.peek();
        }
    }

    public static void main(String[] args) {
        L_295_数据流中的中位数 a = new L_295_数据流中的中位数();
        a.findMedian();
        a.addNum(1);
        System.out.println(a.findMedian());
    }
}
