package mainIdea.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/26 8:10 下午
 */
public class Sory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i =0;i<n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(fun(n,nums));

    }
    public static int fun(int n ,int[] nums){
        int[] sortArr = Arrays.copyOf(nums,n);
        Arrays.sort(sortArr);
        int p= n-1,q = n-1;
        while (p>=0 && q>=0){
            if (nums[p] == sortArr[q]){
                --p;
                --q;
            }else {
                while (p>=0 && nums[p]!=sortArr[q]){
                    --p;
                }
            }
        }
        return q+1;
    }
}
