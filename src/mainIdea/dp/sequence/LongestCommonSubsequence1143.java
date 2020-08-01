package mainIdea.dp.sequence;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/2 2:54 下午
 */
/*
1143. 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

示例 1:

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。

提示:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。
 */
/*
模版：
int n = arr.length;
int[][] dp = new dp[n][n];

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (arr[i] == arr[j])
            dp[i][j] = dp[i][j] + ...
        else
            dp[i][j] = 最值(...)
    }
}
在子数组 arr1[0..i] 和子数组 arr2[0..j] 中，我们要求的子序列（最长公共子序列）长度为 dp[i][j]
 */
public class LongestCommonSubsequence1143 {
    //双指针法
    //动态规划
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray(),ch2 = text2.toCharArray();
        int len1 = ch1.length,len2 = ch2.length;
        //表示前i个text1 和 前j个text2中最长公共子串
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 0 ;i<len1;i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ;j<len2;j++){
            dp[0][j] = 0;
        }
        for (int i = 1;i<=len1; i++){
            for (int j =1 ;j<=len2; j++){
                if (ch1[i-1] == ch2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        for (int i = 0;i<=len1;i++){
            for (int j = 0;j<=len2 ;j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
