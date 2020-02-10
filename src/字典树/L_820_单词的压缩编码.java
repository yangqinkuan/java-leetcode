package 字典树;

import java.util.*;

public class L_820_单词的压缩编码 {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        TreeNode root = new TreeNode();
        Map<TreeNode,Integer> nodes = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            TreeNode cur = root;
            for(int j=word.length()-1;j>=0;j--){
                cur = cur.getSon(word.charAt(j));
            }
            nodes.put(cur,i);
        }
        for(TreeNode node:nodes.keySet()){
            if(node.count==0){
                res += words[nodes.get(node)].length()+1;
            }
        }

        return res;
    }
    static class TreeNode{
        int count;
        TreeNode[] sons;
        public TreeNode(){
            count = 0;
            sons = new TreeNode[26];
        }
        public TreeNode getSon(char c){
            if(sons[c-'a']==null){
                sons[c-'a'] = new TreeNode();
                count++;
            }
            return sons[c-'a'];
        }
    }


    public int minimumLengthEncoding1(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: good)
            ans += word.length() + 1;
        return ans;
    }
}
