import java.util.HashMap;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/27 5:38 下午
 */
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
public class lengthOfLongestSubstring03 {
    public int lengthOfLongestSubstring(String s) {
        //考虑特例
        if("".equals(s)){
            return 0;
        }
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap();
        //max:最大值变量 dir/j:不重复数 start:开始重新计数下标
        int max = 1 , dir = 0 , j =0 ,start = 0, temp=0, index=0;
        for(int i = 0 ; i < chars.length ; i++){
            if(map.containsKey(chars[i])){
                //fg:abba 需要重新定位起始点
                start = Math.max(map.get(chars[i]),start);
            }
            //fg：aus
            max = Math.max(max,(i-start+1));
            map.put(chars[i],i+1);
        }
        return max;

    }
}
