package mainIdea.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/1 1:48 下午
 */
/*
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {

    public static void main(String[] args) {
       List<String> l1 =  Permutation("aa");

    }
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<String> Permutation(String str){
        ArrayList<String> strs = new ArrayList<>();
        if (str == null || str.length() == 0) return strs;
        List<Integer> track = new ArrayList<>();
        char[] chars = str.toCharArray();
        DFS(track,chars);

        for (ArrayList<Integer> temp : res){
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer i : temp){
                stringBuilder.append(chars[i]);
            }
            if (strs.contains(stringBuilder.toString())){
                continue;
            }
            strs.add(stringBuilder.toString());
        }
        return strs;

    }
    public static void DFS(List<Integer> track , char[] chars ){
        if (track.size() == chars.length){
            res.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = 0 ; i < chars.length ;i++){
            if (track.contains(i)){
                continue;
            }
            track.add(i);
            DFS(track,chars);
            track.remove(track.size()-1);
        }
    }

}
