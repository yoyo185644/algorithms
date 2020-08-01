package mainIdea.dp.bag;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/30 4:12 下午
 */
/*
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 

示例 1:
输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2:

输入: amount = 3, coins = [2]
输出: 0
解释: 只用面额2的硬币不能凑成总金额3。
示例 3:

输入: amount = 10, coins = [10]
输出: 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange2 {
    public static int cal(int[] coins ,int sum){
        //dp表示用前i个金币可以凑金额为j的硬币数
        int[][] dp = new int[coins.length+1][sum+1];

        //base case
        for (int j = 0 ;j< sum+1 ;j++) dp[0][j] = 0;
        for (int i = 0 ;i< coins.length+1 ;i++) dp[i][0] = 1;

        for (int i = 1;i <= coins.length ;i++){
            for (int j = 1 ;j <= sum ;j++){
                if (j-coins[i-1]>=0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; //有两种可能性 使用这个硬币和不使用这个硬币
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[coins.length][sum];
    }
    public static int cal_leetcode(int[] coins ,int sum){
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int coin:coins){
            for(int t = coin;t<=sum;t++){
                dp[t] += dp[t-coin];
            }
        }
        return dp[sum];


    }
}
