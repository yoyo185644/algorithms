/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/28 5:18 下午
 */
/*
9. 回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class isPalindrome09 {
    public static boolean isPalindrome(int x) {

        char[] chars = String.valueOf(x).toCharArray();
        int start = 0;
        int end = chars.length-1;
        while(start <= end && chars[start] == chars[end]) {
            start++;end--;
            if (start>=end) return true;
        }
        return false;


    }
    //leetcode优化方案：不实用整形转字符串得到
    public static boolean isPalindrome_leetcode(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int x_rev = 0;
        //将整数反转
        //通过反转数的位数来判断是否到了一半
        while (x > x_rev){
            x_rev = x_rev*10 + x%10;
            x = x/10;
        }
        return x == x_rev|| x ==x_rev/10;

    }
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(isPalindrome_leetcode(10));


    }
}
