package mainIdea.dp.sequence;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/1 2:59 下午
 */
/*
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

//最值问题可以使用动态规划来解决
public class LongestIncreasingSubsequence300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) return 0;
        //以i结尾的最长数组的长度
        int[] dp = new int[len];
        for (int i= 0 ;i<len; i++) dp[i] = 1;
        for (int i= 1 ;i<=len-1 ;i++){
            int val = nums[i];
            int j = i-1;
            for (;j>=0 ;j--){
                if (nums[j]<val){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i = 0 ;i<len ;i++)
        {
            res = Math.max(dp[i],res);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

}
