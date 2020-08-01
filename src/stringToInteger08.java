/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/28 3:23 下午
 */
/*
8. 字符串转换整数 (atoi)
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：

本题中的空白字符只包括空格字符 ' ' 。
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。


示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
 */
public class stringToInteger08 {

    public static int myAtoi(String str) {
        //字符串为空
        if(str == null) return 0;

        //除空白字符外没有其他字符
        str = str.trim();
        if(str.length()==0) return 0;

//        //判断第一个字符
//        int start = 0; int end = 1;
//        char str0 = str.charAt(start);
//        if(str0!='-' && str0!='+' && (str0 > 57 || str0 < 48)) return 0;
//

        //截取字符串
//        while(end< str.length() && Character.isDigit(str.charAt(end))){
//
//            end++;
//        }
//
//        String temp = str.substring(start,end);
//        if (temp.equals("+") || temp.equals("-")) return 0;
//        double res = Double.parseDouble(temp);
//        System.out.println(res);
//        if (res>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        if (res<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
//        return (int)res;

        //优化代码：不截取字符串进行类型转化 float int 转化会导致精度丢失
        // Character.isDigit(char c)判断一个字符是否是数字
        //判断第一个字符,提取出符号
        int res =0;
        int signal = 1;
        char str0 = str.charAt(0);
        if(str0=='-' ) {
            signal = -1;
        }else if ( str0=='+' ) {

        }else if(Character.isDigit(str0)){
            res = str0 - '0';
        }else return 0;
        int index =1;
        while (index<str.length() && Character.isDigit(str.charAt(index))){
            int temp = str.charAt(index) - '0';
            if (res > (Integer.MAX_VALUE - temp)/10){
                // 本来应该是 res * 10 + temp > Integer.MAX_VALUE
                // 但是 *10 和 + temp 都有可能越界，所有都移动到右边去就可以了。
                return signal==1 ? Integer.MAX_VALUE :Integer.MIN_VALUE;
            }
            res = res * 10 + temp;
            index++;
        }

        return signal==1 ? res : -1*res;
    }
    public static void main(String[] args) {

        System.out.println(myAtoi("2147483646"));
    }
}
