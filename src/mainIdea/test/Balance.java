package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/26 7:48 下午
 */
public class Balance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] nums = new long[4];
        long sum = 0;
        for (int i = 0;i<4;i++){
            nums[i] = in.nextInt();
            sum += nums[i];
        }

        long res = 0;
        for (int i = 0;i<sum/2;i++){
            res = sum - i;
            if (res % 4==0){
                System.out.println(res);
                return;
            }
        }


    }
}
