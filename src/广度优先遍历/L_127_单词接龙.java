package 广度优先遍历;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 *     每次转换只能改变一个字母。
 *     转换过程中的中间单词必须是字典中的单词。
 *
 * 说明:
 *
 *     如果不存在这样的转换序列，返回 0。
 *     所有单词具有相同的长度。
 *     所有单词只由小写字母组成。
 *     字典中不存在重复的单词。
 *     你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//挺经典的题目
public class L_127_单词接龙 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));

    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length.
        int L = beginWord.length();
        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        for(String word:wordList){
            for(int i=0;i<L;i++){
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations =
                        allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        while(!Q.isEmpty()){
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i=0;i<L;i++){
                // Visited to make sure we don't repeat processing same word.
                String newWord = word.substring(0,i) + "*" + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for(String adjacentWord:allComboDict.getOrDefault(newWord, new ArrayList<String>())){

                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.

                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }

                }
            }
        }
        return 0;
    }
}
