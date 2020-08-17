package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/8 4:11 下午
 */
public class Sushu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        for (int i = 0 ;i<n ;i++){
            int ai = Integer.parseInt(strArr[i]);
            arr[i] = ai;
        }
        System.out.println(max(arr));
    }
    public static int max(int[] arr){
        int maxSum = 0;
        for (int val : arr){
            maxSum += val/2;
        }
        return maxSum;
    }
}
