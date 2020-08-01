/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/27 5:41 下午
 */
/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion

 */
public class zigConvert06 {
    public static String convert(String s, int numRows) {
        if ("".equals(s)||numRows <=1){
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        StringBuilder res = new StringBuilder();
        int index = 0;
        for (int i=0 ; i<numRows ;i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int temp = 1;
        for(char c : s.toCharArray()){
            stringBuilders[index].append(c);
            index = index + temp;
            if (index == numRows-1 || index==0) {
                temp = -temp;
            }

        }
        for (StringBuilder stringBuilder : stringBuilders){
            res.append(stringBuilder);
        }

        return res.toString();

    }

    public static void main(String[] args) {
        String s = convert("LEETCODEISHIRING" ,3);
        System.out.println(s);

    }
}
