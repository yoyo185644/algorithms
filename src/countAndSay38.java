/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/9 4:01 下午
 */
/*
38. 外观数列
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。

示例 1:
输入: 1
输出: "1"
解释：这是一个基本样例。

示例 2:
输入: 4
输出: "1211"
解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。

https://leetcode-cn.com/problems/count-and-say/
 */
public class countAndSay38 {
    //使用同一个StringBuilder进行多次运算3
    public static String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        int num =1;
        while (num<n){
            int index = 0,count = 1;
            char[] arr = str.toString().toCharArray();
            str.delete(0,str.length());
            while (index<arr.length){
                while (index<arr.length-1 && arr[index]== arr[index+1]) {
                    count++;
                    index++;
                }
                str.append(count).append(arr[index]);
                count=1;
                index++;
            }
            num++;
        }
        return str.toString();

    }
    public static void main(String[] args){
        System.out.println(countAndSay(1));

    }

}
