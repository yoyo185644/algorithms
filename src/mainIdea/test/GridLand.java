package mainIdea.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/8 11:47 上午
 */
public class GridLand {
    public static void main(String[] args) {
        List<String> journeys = new LinkedList<>();
        journeys.add("2 2 2");
        journeys.add("2 2 3");
        getSafePaths(journeys);
    }
    public static List<String> getSafePaths(List<String> journeys) {
        int len = journeys.size();
        List<String> list = new ArrayList<>();
        for (int i = 0 ;i<len;i++){
            List<String> res = new ArrayList<>();
            String str = journeys.get(i);
            String[] chars = str.split(" ");
            int k = Integer.parseInt(String.valueOf(chars[2]));
            int step = Integer.parseInt(String.valueOf(chars[0]))*Integer.parseInt(String.valueOf(chars[1]));
            DFS(res,new ArrayList<>(),step);
            list.add(res.get(k));
        }
        return list;

    }
    public static void DFS(List<String> res ,List<Character> list,int step){
        if (list.size() == step){
            res.add(new ArrayList<>(list).toString());
            return;
        }
        for (Character i : new char[]{'H','V'}){
            list.add(i);
            DFS(res,list,step);
            list.remove(list.size()-1);
        }

    }

}
