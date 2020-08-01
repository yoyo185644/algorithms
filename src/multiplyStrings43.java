/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/10 2:33 下午
 */
/*
43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

https://leetcode-cn.com/problems/multiply-strings/
 */
public class multiplyStrings43 {
    public static String multiply(String num1, String num2) {
        if (("0").equals(num1)||("0").equals(num2)) return "0";
        int len_num1 = num1.length(),len_num2 = num2.length();
        StringBuilder[] mul = new StringBuilder[len_num2];
        int n = len_num1-1, m= len_num2-1;
        while (m>=0){
            mul[m] =  new StringBuilder();
            int arr = 0;
            int num_zero = len_num2-m-1;
            while (num_zero>0) {
                mul[m].append("0");
                num_zero--;
            }
            while (n>=0){
                int temp = (num1.charAt(n)-'0')*(num2.charAt(m)-'0')+arr;
                mul[m].append(temp%10);
                arr = temp/10;
                if (n==0) mul[m].append(arr);
                n--;
            }
            //System.out.println(mul[m].toString());
            m--;n=len_num1-1;
        }
        return Sum(mul,len_num2,len_num1+len_num2);

    }
    public static String Sum(StringBuilder[] mul,int len,int max){
        StringBuilder res = new StringBuilder();
        //System.out.println(mul[0].toString());
        int p=0,arr = 0;
        while (p<max){
            int t_sum = 0;
            for (int i = 0;i<len;i++){
                if (p>= mul[i].length()) t_sum+=0;
                else t_sum = t_sum+ mul[i].charAt(p)-'0';
            }
            t_sum += arr;
            arr = t_sum/10;
            res.append(t_sum%10);
            p++;
        }
        if (res.charAt(res.length()-1)=='0') res.deleteCharAt(res.length()-1);
        return res.reverse().toString();

    }
    //模拟数字乘法 运行时间提高五倍
    //num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
    //
    //链接：https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
    public static String muitiply_leetCode(String num1,String num2){
        if (num1.equals("0") || num2.equals("0")) return "0";
        //使用char数组存放每一位的结果
        int len_num1 = num1.length(),len_num2 = num2.length(),len = len_num1+len_num2;
        int[] res = new int[len];
        for (int i = len_num1 - 1; i >= 0; i--){
            int t_a = num1.charAt(i) - '0';
            for (int j = len_num2-1; j >=0; j--){
                int t_b = num2.charAt(j) - '0';
                res[i+j+1] += t_a * t_b;
            }
        }
        for (int i = len-1; i>0;i--){
            if (res[i]>9){
                res[i-1] += res[i]/10;
                res[i] = res[i]%10;
            }
        }
        //用StringBuilder存放后结果
        StringBuilder sb = new StringBuilder();
        int i =0;
        for (;;i++) if (res[i]!=0) break;
        for (;i<len;i++) sb.append(res[i]);

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(muitiply_leetCode("123","456"));

    }

}
