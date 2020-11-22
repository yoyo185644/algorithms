package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/29 4:53 下午
 */
public class Find {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  s = in.nextLine();
        String[] strs = s.split(",");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);

        int[][] num = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                num[i][j] = in.nextInt();
            }
        }
        dp[0][0] = num[0][0];
        for (int i =  1 ;i<m;i++){
            dp[i][0] = dp[i-1][0]+num[i][0];
        }
        for (int j =  1 ;j<n;j++){
            dp[0][j] = dp[0][j-1]+num[0][j];
        }
        for (int i =1 ;i<m;i++){
            for (int j = 1;j<n;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + num[i][j];
            }
        }
        System.out.println(dp[m-1][n-1]);

    }
}
