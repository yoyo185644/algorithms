package mainIdea.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/8 3:04 下午
 */
public class ThrowMinProducts {
    private static int dp[][];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num;
        int[] arr;
        for (int i = 0 ; i<n;i++){
            num = in.nextInt();
            arr = new int[num];
            for (int j = 0 ; j< num; j++){
                arr[j] = in.nextInt();
            }
            int res = Cal(num , arr);
            System.out.println(res);

        }
    }
    public static int Cal(int num ,int[] arr){
        int res = 0;
        Arrays.sort(arr);
        int max  = 0;
        for (int i = 0;i< num ;i++){
            max += arr[i];
        }
        int sum = max;
        dp = new int[sum/2+1][sum/2+1];
        if (isEqual(arr ,0,sum/2)){
            res = 0;
            return res;
        }
        for (int i =  0 ;i<num;i++){
            sum -= arr[i];
            arr[i] = 0;
            res = arr[i];
            for (int j = i ;j<num ;j++){
                sum -= arr[j];
                arr[j] = 0;
                if (j!=i){
                    res += arr[j];
                }
                dp = new int[sum/2+1][sum/2+1];
                if (isEqual(arr,0,sum/2)){
                    return res;
                }
            }

        }

        return res;

    }

    public static boolean isEqual(int[] arr ,int index , int c ){
        if (c %2 != 0 && c == 0){
            return false;
        }
        if (index == arr.length -1){
            return c == 0;
        }

        if (dp[index][c]!=0){
            return dp[index][c] == 1;
        }
        if (isEqual(arr,index+1,c) || isEqual(arr,index+1,c-arr[index])){
            dp[index][c] = 1;
            return true;
        }
        dp[index][c] = -1;
        return false;
    }
}
