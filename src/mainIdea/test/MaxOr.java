package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/11 7:18 下午
 */
/*
输入N 长度为N的数组
连续或运算最大，长度最小值
 */
public class MaxOr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i = 0;
        int[] arr = new int[N];
        while (i<N){
            arr[i] = in.nextInt();
            i++;
        }
        //前n个连续子序列的最大值
        int[] dp = new int[N];
        int minlen = 1;
        for (int n =0 ;n<N ;n++){
            dp[n] = arr[n];
        }
        for (int k = 1 ;k <N ;k++){
            int odium = dp[k-1]|arr[k];
            if (odium> arr[k]){
                dp[k] = odium;
                minlen++;
            }else if (odium == arr[k]){
                minlen = 1;
            }else {
                dp[k] = arr[k];
            }
        }
        System.out.println(minlen);

    }
}
