package mainIdea.dp.bag;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/29 4:35 下午
 */
/*
给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？

典型的背包问题就是每个数只能选一次
*/

public class bag0_1 {

    public static int cal_max(int[] wts, int[] vals ,int w){

        //对于前 i 个物品，当前背包的容量为j，这种情况下可以装的最大价值是 dp[i][j]。
        int[][] dp = new int[wts.length+1][w+1];
        //base case
        for (int i = 0 ;i<w+1;i++) dp[0][i] = 0;
        for (int i = 0 ; i<wts.length+1 ;i++) dp[i][0] = 0;
        for (int i = 1;i<=wts.length;i++){
            for (int j = 1; j<=w ;j++){
                if (j-wts[i-1]<0) dp[i][j] = dp[i-1][j];
                //面临的选择是选第i个物品和不选第i个物品
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wts[i-1]]+vals[i-1]);
            }
        }
        //返回前wts.length容量为w的最大价值
        return dp[wts.length][w];

    }

    public static void main(String[] args) {
        int[] wets = {2,1,3};
        int[] vals = {4,2,3};
        int res = cal_max(wets ,vals, 4);
        System.out.println(res);
    }

}

