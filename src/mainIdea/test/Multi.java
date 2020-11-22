package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/29 7:42 下午
 */
public class Multi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        multi(n,n);

    }
    public static void multi(int n,int m){
        if (m ==1 || m == 0){
            return;
        }
        for (int i = 2;i<=n;i++){
            if (m%i==0){
                if (m/i==1){
                    System.out.print(i);
                }else {
                    System.out.print(i+"*");
                }
                multi(n,m/i);
                break;
            }
        }
    }
}
