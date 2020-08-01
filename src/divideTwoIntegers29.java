/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/6 2:30 下午
 */
/*
29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。

https://leetcode-cn.com/problems/divide-two-integers/
 */
public class divideTwoIntegers29 {

    /*
计算a/b（如果是负数，先转成正数，保证a和b都不是负数），基本思路是a一直减b，每减一次result+=1，直到0<= a <b（这里的a指的是上一次减完之后剩余的a）。

例如7/3，7 - 3 - 3 = 1, 0 <= 1 < 3，结果为2。

如果每次只减b，耗时太长，因此借助移位操作，每次减 b*2^n，同时result+=2^n。这里要满足b*2^n <= a（这里的a指的是上一次减完之后剩余的a）。

例如100/3，100 - 3*32 - 3 = 1，result = 32+1 = 33。

对于溢出的问题，考虑几种情况：

a = -2^31, b = -1, a/b = 2^31，直接返回 2^32-1
a = -2^31, b = -2^31, a/b = 1，直接返回1
a != -2^31, b = -2^31, a/b = 0，直接返回0
a = -2^31, b != -2^31，因为需要将a、b转成正数，而a转换后会溢出，因此先在a的基础上加 / 减b，使其绝对值减小，同时最终的result也需要再加上-1或1（也就是代码中的fix）。

作者：jzj1993
链接：https://leetcode-cn.com/problems/divide-two-integers/solution/javabu-shi-yong-longxing-yi-wei-xiang-jian-by-jzj1/
    */
    public static int divide(int a, int b) {
        // a = -2^31, b = -1, a/b = 2^31
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        // a = -2^31, b = -2^31, a/b = 1
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) return 1;
        // a != -2^31, b = -2^31, a/b = 0
        if (b == Integer.MIN_VALUE) return 0;
        // a = -2^31, b != -2^31:  a <= a + abs(b), fix = b > 0 ? -1 : 1
        int fix = 0;
        if (a == Integer.MIN_VALUE) {
            if (b > 0) {
                a += b;
                fix = -1;
            } else {
                a -= b;
                fix = 1;
            }
        }
        boolean neg = false;
        if (a < 0) {
            a = -a;
            neg = !neg;
        }
        if (b < 0) {
            b = -b;
            neg = !neg;
        }
        int result = 0;
        while (a >= b) {
            int x = b;
            int r = 1;
            while (x <= (a>>1)) {
                x <<= 1;
                r <<= 1;
            }
            a -= x;
            result += r;
        }
        return (neg ? -result : result) + fix;

    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
}
