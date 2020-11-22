package mainIdea.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/8 11:10 上午
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("aaa");
        List<String> list2 = new ArrayList<>();
        list2.add("bba");
        list2.add("bbb");
        List<Integer> res = getMinimumDifference(list1,list2);
    }
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        int n = a.size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i<n;i++){
            res.add(PK(a.get(i),b.get(i)));
        }
        for (Integer i : res){
            System.out.println(i);
        }
        return res;

    }
    public static int PK(String s1,String s2){
        int len = s1.length();
        if (len!=s2.length()) return -1;
        Map<Character,Integer> map = new HashMap<>();
        for (Character c : s1.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        int num = 0;
        for (Character c: s2.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }
        for (Character c: map.keySet()){
            if (map.get(c)>0){
                num+=map.get(c);
            }
        }
        return num;

    }
}
