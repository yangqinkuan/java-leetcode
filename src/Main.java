import com.oracle.jrockit.jfr.Producer;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = in.nextInt();
        int[] nums = new int[n];
        int res = 0;
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }

        System.out.println(res);
    }


    //合并区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int index=0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<intervals.length;i++){
            if(stack.size()==0){
                stack.add(intervals[i]);
            }else{
                int[] temp = stack.pop();
                if(temp[1]<intervals[i][0]){
                    stack.add(temp);
                    stack.add(intervals[i]);
                }else{
                    int left = temp[0];
                    int right = temp[1];
                    temp[0] = Math.min(left,intervals[i][0]);
                    temp[1] = Math.max(right,intervals[i][1]);
                    stack.add(temp);
                }
            }

        }
        int[][] result = new int[stack.size()][2];
        for(int i=stack.size()-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }

    //快速排序
    public static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int leftpoint = left;
        int rightpoint = right;
        int temp = nums[leftpoint];
        while(leftpoint<rightpoint){
            while(leftpoint<rightpoint&&nums[rightpoint]>=temp){
                rightpoint--;
            }
            nums[leftpoint] = nums[rightpoint];
            while(leftpoint<rightpoint&&nums[leftpoint]<=temp){
                leftpoint++;
            }
            nums[rightpoint] = nums[leftpoint];
        }
        nums[leftpoint] = temp;
        quickSort(nums,left,leftpoint-1);
        quickSort(nums,leftpoint+1,right);
    }

    //生产者消费者模型
    int  count = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition notfull=lock.newCondition();
    Condition notEmpty = lock.newCondition();
    public void producerAndConsumer(){
        for(int i=0;i<5;i++){
            new Thread(new Producer()).start();
            new Thread(new Comsumer()).start();
        }

    }
    public class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            lock.lock();
            try{
                while(count>=10){
                    try {
                        notfull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName()+"生产了1个，总数为"+count);
                notEmpty.signal();
            }finally {
                lock.unlock();
            }
            }
        }
    }

    public class Comsumer implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while(count<=0){
                        try {
                            notEmpty.await();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"消费了1个，总数为"+count);
                    count--;
                    notfull.signal();;
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void divide(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            while(left<right&&nums[left]<=0){
                left++;
            }
            while(left<right&&nums[right]>0){
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
       /* int p1 = 0;
        while(p1<nums.length){
            if(nums[p1]<=0){
                p1++;
            }else {
                for(int i=p1+1;i<nums.length;i++){
                    if(nums[i]>0){
                        continue;
                    }else {
                        int temp = nums[p1];
                        nums[p1] = nums[i];
                        nums[i] = temp;
                        break;
                    }

                }
                p1++;
            }
        }*/
/*
        int i = 0;
        int temp = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                continue;
            }else {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }*/
    }


    public ArrayList<String> Permutation(String str) {
        char[] chararr = str.toCharArray();
        Set<String> set = new HashSet<>();
        getS(chararr,0,set,"");
        ArrayList<String> result = new ArrayList<>();
        for (String s: set) {
            result.add(s);
        }
        return  result;
    }

    public static void getS(char[] chararr,int index,Set<String> set,String s) {
        if (index >= chararr.length) {
            set.add(s);
            return;
        }
        for (int i = index; i < chararr.length; i++) {
            s = s + chararr[i];
            getS(chararr, index + 1, set, s);
        }




    }












    class Job implements Runnable {
        private PrintQueue printQueue;

        public Job(PrintQueue printQueue) {
            this.printQueue = printQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
            printQueue.printJob(new Object());
            System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());

        }
    }



    class PrintQueue {
        private final Semaphore semaphore;

        public PrintQueue() {
            semaphore = new Semaphore(1);
        }

        public void printJob(Object document) {
            try {
                semaphore.acquire();//获取共享资源，如果计数器为0会等待
                long duration = (long) (Math.random() * 10);
                System.out.printf("%s: PrintQueue: Printing a job during %d seconds \n", Thread.currentThread().getName(), duration);
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }}