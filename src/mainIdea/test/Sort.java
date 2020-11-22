package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/29 7:13 下午
 */
public class Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str  = in.nextLine();
        int[] nums =  new int[n];
        String[] strs = str.split(",");
        for (int i = 0 ;i<n;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        for (int i = 0; i < n; i++) {
            //初始化最小值
            int min = i;
            //寻找最小值的位置
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        for (int i = 0;i<n;i++){
            System.out.print(nums[i]);
            if (i<n-1){
                System.out.print(",");
            }
        }

    }

}
