package 深度优先遍历;

import java.util.*;

public class 克隆图 {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Map<Integer,Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        boolean[] table = new boolean[101];
        while(stack.size()!=0){
            Node n = stack.pop();
            if(table[n.val]) continue;
            table[n.val]=true;
            Node nNode = map.get(n.val);
            if(nNode==null){
                nNode = new Node(n.val);
            }

            List<Node> list = nNode.neighbors;
            if(list==null) list = new ArrayList<>();
            for(Node nei:n.neighbors)   {
                stack.add(nei);
                Node neiberNode = map.get(nei.val);
                if(neiberNode==null){
                    neiberNode = new Node(nei.val);
                    map.put(nei.val,neiberNode);
                }
                list.add(neiberNode);
            }
        }
        return map.get(node.val);
    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}