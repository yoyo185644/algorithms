package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 10:04 上午
 */
/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str.substring(2));
        System.out.println(LeftRotateString(str,2));
    }
    public static String LeftRotateString(String str,int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str.length() == 0 || str == null){
            return stringBuilder.toString();
        }
        stringBuilder.append(str.substring(n));
        stringBuilder.append(str.substring(0,n));

        return stringBuilder.toString();


    }
}
