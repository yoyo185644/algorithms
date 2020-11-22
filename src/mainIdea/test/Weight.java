package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/3 8:31 下午
 */
public class Weight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int W = in.nextInt();
        int V = in.nextInt();
        int[] prices = new int[n];
        int[] ws = new int[n];
        int[] Vs = new int[n];
        for (int i = 0 ;i<n;i++){
                prices[i] = in.nextInt();
                ws[i] = in.nextInt();
                Vs[i] = in.nextInt();
        }
        System.out.print(cal_max(ws,prices,Vs,W));

    }
    public static int cal_max(int[] wts, int[] vals , int[] Vs ,int w){
        int[][] dp = new int[wts.length+1][w+1];
        //base case
        for (int i = 0 ;i<w+1;i++) dp[0][i] = 0;
        for (int i = 0 ; i<wts.length+1 ;i++) dp[i][0] = 0;
        for (int i = 1;i<=wts.length;i++){
            for (int j = 1; j<=w ;j++){
                if (j-wts[i-1]<0) dp[i][j] = dp[i-1][j];
                    //面临的选择是选第i个物品和不选第i个物品
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wts[i-1]]+1);
            }
        }
        //返回前wts.length容量为w的最大价值
        return dp[wts.length][w];

    }
}
