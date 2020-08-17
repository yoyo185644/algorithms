package mainIdea.test;

import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/13 8:02 下午
 */
//判断括号是否有效
public class isValid {
    public static void main(String[] args) {

    }
    public static boolean IsValidExp (String s) {
        // write code here
        if (s.length() == 0 || s==null) return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else {
                if (stack.isEmpty() || c!=stack.pop()) return false;
            }

        }
        return stack.isEmpty();
    }
}
