/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/15 2:09 下午
 */
/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

https://leetcode-cn.com/problems/jump-game/
 */
public class jumpGame55 {
    //只要存在一个位置 xx，它本身可以到达，并且它跳跃的最大长度为 x +nums[x]，这个值大于等于 yy，即 x+nums[x]≥y，那么位置 y 也可以到达。
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int rightmax = 0;
        for (int i =0; i<len; i++){
            if (rightmax>=i){
                rightmax = Math.max(rightmax,i+nums[i]);
                if (rightmax>=len-1) return true;
            }

        }
        return false;


    }
    //动态规划
    public static boolean canJump_dp(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        //表示每个元素能否到达
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }

        return dp[nums.length - 1];


    }

    //递归
//    public static void isCan(int[] nums,int p,int end,int len){
//        if (p>=len && len!=1) {
//            flag = false;
//            return ;
//        }
//        if (len==1 ) return;
//        while (p<len){
//            if (nums[end-p]>=p){
//                isCan(nums,1,end-p,len-p);
//            }else {
//                isCan(nums,p+1,end,len);
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(canJump_dp(new int[]{2,3,1,1,4}));

    }

}
