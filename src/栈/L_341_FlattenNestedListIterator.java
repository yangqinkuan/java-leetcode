package 栈;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class L_341_FlattenNestedListIterator {




    /*public class NestedIterator implements Iterator<Integer> {
        private List<Integer> numList;
        private int count;
        private int cur=0;
        public NestedIterator(List<NestedInteger> nestedList) {

            numList = new ArrayList();
            get(nestedList,numList);
            count = numList.size();
        }
        public void get(List<NestedInteger> list,List<Integer> numList){
            for(int i=0;i<list.size();i++){
                if(list.get(i).isInteger()){
                    numList.add(list.get(i).getInteger());
                }else{
                    get(list.get(i).getList(),numList);
                }
            }
        }

        @Override
        public Integer next() {
            return numList.get(cur++);
        }

        @Override
        public boolean hasNext() {
            return cur>=count?false:true;
        }
    }*/
    public static void main(String[] args) {
        LoadPo loadPo1 = new LoadPo("A",1);
        LoadPo loadPo2 = new LoadPo("B",2);
        LoadPo loadPo3 = new LoadPo("C",3);
        Queue<LoadPo> queue = new PriorityQueue<>(3, new Comparator<LoadPo>() {
            @Override
            public int compare(LoadPo o1, LoadPo o2) {
                return o1.getLoad()<o2.getLoad()?-1:1;
            }
        });
        queue.add(loadPo2);
        queue.add(loadPo1);
        queue.add(loadPo3);
        while(queue.size()>0){
            System.out.println(queue.poll().getName());
        }
    }
}

class LoadPo{
    private String name;
    private double load;

    public LoadPo() {
    }

    public LoadPo(String name, double load) {
        this.name = name;
        this.load = load;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
}