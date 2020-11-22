package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/9 9:11 下午
 */
public class Max {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] sirs = str.split(",");
        int len = sirs.length;
        int[] nums = new int[len];
        int[] dp = new int[len];
        for (int i =0;i<len;i++){
            nums[i] = Integer.parseInt(sirs[i]);
            dp[i] = nums[i];
        }
        dp[1] = Math.max(dp[0],dp[1]);
        for(int i = 2;i<len;i++){
            dp[i] = Math.max(dp[i-1],dp[i]+dp[i-2]);
        }
        System.out.println(dp[len-1]);



    }

}
