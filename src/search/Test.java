/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-9-5 14:40
 * Description:
 */

package search;

import java.util.*;

public class Test {
    static Map<String,String> normalTitleMap = new HashMap<>();
    static Map<String,List<TitleNode>> sortTitleMap = new HashMap<>();

    public static void main(String[] args) {
        List<String> input = getInput();
        String title = "深圳东方沁园";
        char[] titleCharArr = title.toCharArray();
        List<TitleNode> list = new ArrayList<>();
        list.add(new TitleNode(titleCharArr[0],new TitleNode('*',null)));
        for(int i=1;i<titleCharArr.length;i++){
            list.add(new TitleNode(titleCharArr[i],list.get(i-1)));
        }
        Collections.sort(list,(o1,o2)->(o1.getC()-o2.getC()));
        String search = "东方沁园";
        char[] searchCharArr = search.toCharArray();


        int count = 0;
        int listindex = 0;
        int searchindex = 0;
        long start = System.currentTimeMillis();
        Arrays.sort(searchCharArr);
        for(int i=0;i<100000;i++){
            while (searchindex<searchCharArr.length&&listindex<list.size()){
                TitleNode titleNode = list.get(listindex);
                if(searchCharArr[searchindex]==titleNode.getC()){
                    count += 1;
                    for (char c: searchCharArr) {
                        if(c==titleNode.getLast().getC()){
                            count +=1;
                            break;
                        }
                    }
                    searchindex++;
                }
                listindex++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static List<String> getInput(){
        List<String> input = new ArrayList<>();
        input.add("深圳东方沁园");
        input.add("北京恒大名都");
        input.add("柳州恒大城");
        input.add("六安恒大御景湾");
        input.add("西宁恒大名都");
        input.add("济南恒大金碧新城");
        return input;
    }
    public static String getSearch(){
        return "";
    }

    public List<String> search(String search) {
        List<Score> scoreList = new ArrayList<>();
        char[] searchCharArr = search.toCharArray();
        Arrays.sort(searchCharArr);
        for (String key: sortTitleMap.keySet()) {
            List<TitleNode> list = sortTitleMap.get(key);
            short listindex = 0;
            short searchindex = 0;
            short scroe = 0;
            short searchSameStart = 0;
            while (searchindex<searchCharArr.length&&listindex<list.size()){
                if(searchCharArr[searchindex]<list.get(listindex).getC()){
                    searchindex++;
                }else if(searchCharArr[searchindex]>list.get(listindex).getC()){
                    listindex++;
                }else {
                    searchSameStart = searchindex;
                    break;
                }
            }
            while (searchindex<searchCharArr.length&&listindex<list.size()){
                TitleNode titleNode = list.get(listindex);
                if(searchCharArr[searchindex]==titleNode.getC()){
                    scroe += 1;
                    for(int i=searchSameStart;i<searchCharArr.length;i++){
                        if(searchCharArr[i]==titleNode.getLast().getC()){
                            scroe +=1;
                            break;
                        }
                    }
                    searchindex++;
                }
                listindex++;
            }
            if(scroe>0){
                scoreList.add(new Score(key,scroe));
            }
        }
        scoreList.sort((o1,o2)->(o2.getScore()-o1.getScore()));
        List<String> res = new ArrayList<>();
        for(int i=0;i<scoreList.size();i++){
            res.add(normalTitleMap.get(scoreList.get(i).getUuid()));
        }

        return res;
    }

    public void getIndex(){
        //获取样本
        List<Map> mapList =new ArrayList<>();
        for (Map map: mapList) {
            String uuid = String.valueOf(map.get("station_uuid"));
            String name = String.valueOf(map.get("station_name"));
            normalTitleMap.put(uuid,name);
            List<TitleNode> list = new ArrayList<>();
            char[] titleCharArr = name.toCharArray();
            list.add(new TitleNode(titleCharArr[0],new TitleNode('*',null)));
            for(int i=1;i<titleCharArr.length;i++){
                list.add(new TitleNode(titleCharArr[i],list.get(i-1)));
            }
            list.sort((o1, o2) -> (o1.getC() - o2.getC()));
            sortTitleMap.put(uuid,list);
        }
    }
}
