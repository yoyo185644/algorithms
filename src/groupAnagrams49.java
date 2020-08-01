import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/12 3:55 下午
 */
/*
49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

https://leetcode-cn.com/problems/group-anagrams/
 */
public class groupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        boolean[] used = new boolean[len];
        String str = new String();
        for (int i = 0 ;i<len; i++){
            if (!used[i]) {
                List<String> list = new ArrayList<>();
                for (int j = i ;j<len ;j++){
                    if (isSame(strs[i],strs[j])){
                        list.add(strs[j]);
                        used[j] = true;
                    }
                }
                res.add(list);
            }
        }
        return res;
    }

    public static Boolean isSame(String s1,String s2){
        int len_s1 = s1.length(),len_s2 = s2.length();
        int index_s1 = 0 ,index_s2 = 0;
        if (len_s1 != len_s2) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        while (index_s1<len_s1){
            char c = s1.charAt(index_s1);
            if (map.containsKey(c)) map.put(c,map.get(c)+1);
            else map.put(c,1);
            index_s1++;

        }
        while (index_s2<len_s2){
            char c = s2.charAt(index_s2);
            if (map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                index_s2++;
            }
            else return false;
        }
        for (int count : map.values()){
            if (count!=0) return false;
        }

        return true;
    }
    //leetcode骚操作：字符串转字符数组居然可以排序
    public static List<List<String>> groupAnagrams_leetcode(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        Map<String,ArrayList> map = new HashMap<>();
        for (int i = 0 ;i<len; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String i_str = String.valueOf(ch);
            if (!map.containsKey(i_str)) map.put(i_str,new ArrayList());
            map.get(i_str).add(strs[i]);

        }
        return new ArrayList(map.values());
    }
    public static void main(String[] args) {
        System.out.println(groupAnagrams_leetcode(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }
}
