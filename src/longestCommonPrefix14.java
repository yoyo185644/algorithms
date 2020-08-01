/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/29 5:15 下午
 */
/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class longestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder res = new StringBuilder();
        int index = 0;
        int min_len =Integer.MAX_VALUE;
        for(int i =0; i< strs.length ;i++){
            if(min_len > strs[i].length()) min_len = strs[i].length();
        }
        while(index<min_len){
            char c = strs[0].charAt(index);
            for(int i=0;i<strs.length;i++)
            {
                if(strs[i].charAt(index)!=c){
                    return res.toString();
                }
            }
            res.append(c);
            index++;
        }
        return res.toString();
    }
    //leetcode优化解法
    public static String  longestCommonPrefix_leetcode(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                //indexOf()如果找不到字符串返回-1
                //System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }



    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix_leetcode(strs));

    }
}
