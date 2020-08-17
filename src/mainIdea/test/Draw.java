package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/11 8:06 下午
 */
/*
N*M的方格
最少使用多少种颜色 使得涂满、每种颜色使用次数相同、相邻颜色不同
 */
public class Draw {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i = 0;
        int[][] arr = new int[N][2];
        while (i<N){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            i++;
        }
        for (i=0;i<N;i++){
            if (arr[i][0] == 1 && arr[i][1] == 1){
                System.out.println(1);
            }else if (arr[i][0]%2 == 0 || arr[i][1]%2 == 0){
                System.out.println(2);
            }else {
                int n = (int) Math.sqrt(arr[i][0]) * 2 + 1;
                int m = (int) Math.sqrt(arr[i][1]) * 2 + 1;

                if ((arr[i][0] % n == 0 && arr[i][1] % n % 2 == 0) || (arr[i][1] % n == 0 && arr[i][0] % n % 2 == 0)) {
                    int minn = n;
                }
                if ((arr[i][0] % m == 0 && arr[i][1] % m % 2 == 0) || (arr[i][1] % m == 0 && arr[i][0] % m % 2 == 0)) {
                    int minm = m;
                }
                System.out.println(Math.min(n, m));

            }
        }
    }
}
