package mainIdea.dp.arraypartion;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/2 2:06 下午
 */
/*
312. 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。
这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
求所能获得硬币的最大数量。

说明:
你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

示例:
输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons312 {

    public static int maxCoins(int[] nums) {
        int len = nums.length;
        int[] points = new int[len+2];
        points[0] = points[len+1] = 1;
        for (int i =1;i < len+1;i++) points[i] = nums[i-1];

        //表示戳破i到j中的所有气球数 不包括i j所得到的最大值
        int[][] dp = new int[len+2][len+2];


        //设i到j中最后一个戳破的气球是k
        //因为初始值都是0 所以应该从后往前遍历 可以将 base case 和最终的状态在 DP table 上画出来：然后再选择遍历方向
        for (int i = len; i>=0 ;i--){
            for (int j =i+1;j<len+2 ;j++){
                for (int k = i+1; k<j ;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][len+1];


    }
}
