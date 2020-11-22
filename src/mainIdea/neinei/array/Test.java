package mainIdea.neinei.array;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/21 8:08 下午
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int di[] = new int[]{0,1,0,-1};
        int dj[] = new int[]{1,0,-1,0};
        int[] fib = new int[110];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3 ; i<= n*n ;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        int matrix[][] = new int[15][15];
        boolean vis[][] = new boolean[15][15];
        int i = 0 ,j = 0;
        int d = 0;
        int r = n * n;
        while (r>0){
            matrix[i][j] = fib[r];
            vis[i][j] = true;
            if (i + di[d] >= n||i+di[d]<0||j+dj[d]>=n ||j+dj[d] < 0 || vis[i+di[d]][j+dj[d]]){
                d = (d+1)%4;
            }
            i += di[d];
            j += dj[d];
            r--;
        }

        for (int m = 0; m<n ;m++){
            for (int k = 0 ; k< n ;k++){
                System.out.print(matrix[m][k]);
                if (k<n-1){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}
