package 栈;

import java.util.List;

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
}

