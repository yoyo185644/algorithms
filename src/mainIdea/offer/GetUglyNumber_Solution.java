package mainIdea.offer;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 3:39 下午
 */
/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(Cal(N));

    }
    public static int Cal(int index) {
        if (index <= 0) return 0;
        if (index < 7) return index;
        int p1=0,p2=0,p3=0;
        int[] res = new int[index];
        res[0] = 1;
        int i = 1;
        for ( ;i<index;i++){
            res[i] = Math.min(res[p1]*2 ,Math.min(res[p2]*3,res[p3]*5));
            if (res[i] == res[p1]*2) p1++;
            if (res[i] == res[p2]*3) p2++;
            if (res[i] == res[p3]*5) p3++;
        }
        return res[index-1];
    }

}
