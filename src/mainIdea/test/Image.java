package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/3 8:07 下午
 */
public class Image {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0;i<n;i++){
            for (int j = 0 ;j<m;j++){
                nums[i][j] = in.nextInt();
            }
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                double sum = nums[i][j];
                int t = 1;
                if (i>0){
                    sum+=nums[i-1][j];
                    t++;
                }
                if (i<n-1){
                    sum+=nums[i+1][j];
                    t++;
                }
                if (j>0){
                    sum+=nums[i][j-1];
                    t++;
                }
                if (j<m-1){
                    sum+=nums[i][j+1];
                    t++;
                }
                nums[i][j] = (int) Math.round(sum/t);
                System.out.print(nums[i][j]);
                if (j<m-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
