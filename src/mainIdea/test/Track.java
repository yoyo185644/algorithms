package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/13 8:29 下午
 */
public class Track {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();
        char[][] nums = new char[N][N];
        in.nextLine();
        for (int i = 0;i<N;i++){
            nums[i] = in.nextLine().toCharArray();
        }
        int[][] dp = new int[N][N];
        dp[0][0] = 0;
        for (int i = 1 ;i<N;i++){
            int pre = dp[i-1][0];
            if (nums[i][0]=='0' && pre != Integer.MAX_VALUE){
                dp[i][0] = pre + 1;
            }else if (nums[i][0] == '#' &&  pre != Integer.MAX_VALUE){
                dp[i][0] = pre+ 1+k;
            }else {
                dp[i][0] = Integer.MAX_VALUE;
            }
        }
        for (int j = 1 ;j<N;j++){
            int pre = dp[0][j-1];
            if (nums[0][j]=='0' && pre != Integer.MAX_VALUE){
                dp[0][j] = pre + 1;
            }else if (nums[0][j] == '#' && pre != Integer.MAX_VALUE){
                dp[0][j] = pre + 1 + k;
            }else {
                dp[0][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1;i<N;i++){
            for (int j = 1;j<N;j++){
                int min = Math.min(dp[i-1][j],dp[i][j-1]);
                if (nums[i][j]=='0' && min != Integer.MAX_VALUE){
                        dp[i][j] = min + 1;
                }else if (nums[i][j] == '#' && min != Integer.MAX_VALUE){
                    dp[i][j] = min + 1+k;
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        if (dp[N-1][N-1] == Integer.MAX_VALUE){
            System.out.println("No solution");
            return;
        }
        System.out.println(dp[N-1][N-1]);
    }


}
