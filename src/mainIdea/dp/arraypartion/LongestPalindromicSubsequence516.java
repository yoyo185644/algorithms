package mainIdea.dp.arraypartion;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/2 3:50 下午
 */
/*
516. 最长回文子序列
给定一个字符串s，找到其中最长的回文子序列，并返回该序列的长度。可以假设s的最大长度为1000。

示例 1:
输入:
"bbbab"
输出:
4
一个可能的最长回文子序列为 "bbbb"。

示例 2:
输入:
"cbbd"
输出:
2
一个可能的最长回文子序列为 "bb"。
 */
public class LongestPalindromicSubsequence516 {
    public static int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        //在[i,j]中最长回文子串是dp[i][j]
        int[][] dp = new int[chars.length][chars.length];
        for (int i= 0;i<chars.length;i++){
                dp[i][i] = 1;
            }
        for (int i = len-1 ; i>=0 ;i--){
            for (int j = i+1 ; j<len ;j++){
                if (chars[i] == chars[j]) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][len-1];

    }
}
