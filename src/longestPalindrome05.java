/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/27 5:40 下午
 */
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

 */
public class longestPalindrome05 {
    public String longestPalindrome(String s) {
        if("".equals(s)){
            return "";
        }
        int max = 0;
        String res = null;
        int left = 0 ,right =0;
        for(int center = 0 ;center<s.length(); center++){
            int lenWithCenter = cal(s, center, center);
            int lenWithoutCenter = cal(s, center, center+1);
            int len = Math.max(lenWithCenter,lenWithoutCenter);
            left = center - (len-1)/2;
            right = center + len/2;
            if(max < right-left+1){
                max = right-left+1;
                res = s.substring(left,right+1);
            }

        }
        return res;
    }


    private int cal(String s,int left ,int right){
        while(left > -1 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return right-left-1;
    }
}
