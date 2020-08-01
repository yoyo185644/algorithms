/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/28 2:01 下午
 */
/*
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseInteger07 {
    public static int reverse(int x) {
        long mul = 0;
        if(x <= -1 * Math.pow(2,31)) return 0;
        String str = Integer.toString(Math.abs(x));
        System.out.println(str);
        int[] xs = new int[str.length()];
        int len = xs.length;
        for (int i =0 ;i<len ;i++) {
            xs[i] = Integer.parseInt(String.valueOf(str.charAt(i))) ;

        }
        long rev = 0;
        for(int i=len-1; i>=0 ;i--){
            rev += xs[i] * Math.pow(10,i);

        }

        mul = x<0 ? -1 : 1;
        rev = mul * rev;
        if(rev > Math.pow(2,31)-1 || rev < -1 * Math.pow(2,31)) return 0;
        return (int)rev;

    }
    public static int reverse_leetcode(int x) {
        long rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        if(rev > Math.pow(2,31)-1 || rev < -1 * Math.pow(2,31)) return 0;
        return (int) rev;
    }


    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse_leetcode(x));
    }
}
