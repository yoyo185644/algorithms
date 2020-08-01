/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/14 1:52 下午
 */
/*
50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:
输入: 2.00000, 10
输出: 1024.00000

示例 2:
输入: 2.10000, 3
输出: 9.26100

示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class powx50 {
    //暴力解法
    public static double myPow(double x, int n) {
        if (x==1) return 1;
        double res = 1;
        int i = 0;
        //防止越界的有效手段
        double N = Math.abs(n);
        while(i<N){
            res*=x;
            i++;
        }
        return n>0?res:1/res;

    }
    //提高效率 分治算法：二分法
    public static double myPow_leetcode(double x, int n){
        long N = n;
        return N>=0?half(x,N):1/half(x,-N);

    }
    //迭代
    public static double half(double x ,long n){
        if (x==1) return 1;
        double res = 1;
        double x_contribute=x;
        while (n>0){
            if (n%2==1) res*=x_contribute;
            x_contribute *= x_contribute;
            n=n/2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow_leetcode(2,Integer.MIN_VALUE));
        //double a = Integer.MIN_VALUE;
        //System.out.println(a);
    }
}
