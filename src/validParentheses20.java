import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/4 3:55 下午
 */
/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
https://leetcode-cn.com/problems/valid-parentheses/
 */
public class validParentheses20{
    //错误解答
//    public static boolean isValid(String s) {
//        String ins = s;
//        String[] strings = {"()" , "[]" , "{}"} ;
//        for (String str : strings){
//            while (ins.contains(str)){
//                ins=ins.replace(str,"");
//            }
//        }
//        System.out.println(ins);
//        if (ins.length() == 0) return true;
//        if (ins.length() % 2 == 1) return false;
//        char[] cs = ins.toCharArray();
//        int left = 0;
//        int right = ins.length()-1;
//        while(left<right){
//            if ((cs[left]=='(' && cs[right]==')' )||
//                    (cs[left]=='[' && cs[right]==']' )||
//                    (cs[left]=='{' && cs[right]=='}' )){
//                if (right-left==1) {
//                    return true;
//                }
//                left++;
//                right--;
//            }else break;
//
//        }
//        return false;
//
//    }
    //使用栈的思想

    public static boolean isValid_leetcode (String s){
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            //用来判断出现[]}这种情况
            else if(stack.empty() || c != stack.pop()) return false;
        }
        //()[]栈内元素全部弹出
        if (stack.empty()) return true;
        //防止出现[]{
        return false;
    }
    public static void main(String[] args) {

        System.out.println(isValid_leetcode("{}[{}]((){})(){"));

    }
}
