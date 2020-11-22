package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/27 8:17 下午
 */
public class Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] dp = new int[n][n*2+10];
        for (int i =0;i<n;i++){
            for (int j = 0; j<2*i+1;j++){
                dp[i][j] = in.nextInt();
            }
        }
        for (int i = n-2 ;i>=0;i--){
            for (int j = 0;j<2*i+1;j++){
                dp[i][j] += Math.max(dp[i+1][j],Math.max(dp[i+1][j+1],dp[i+1][j+2]));
            }
        }
        System.out.println(dp[0][0]);

    }
}
