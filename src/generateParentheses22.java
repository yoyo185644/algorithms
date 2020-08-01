import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/5 2:53 下午
 */
/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

https://leetcode-cn.com/problems/generate-parentheses/
 */
/*
解法1、回朔法
解法2、动态规划
      https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie
 */
public class generateParentheses22 {
    public static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        StringBuilder strs = new StringBuilder();
        dfs(n,strs,0,0);
        return res;
    }
    //回朔法
    public static void dfs(int n , StringBuilder strs , int open ,int close){
        //退出条件
        if (strs.length() == n * 2){
            if (isValid(strs.toString())){
                res.add(strs.toString());
            }
        }
        //选择：与全排列解法不一样的地方
        if (open < n){
            strs.append('(');
            dfs(n,strs,open+1,close);
            //撤回选择
            strs.deleteCharAt(strs.length()-1);
        }
        //选择
        if (close < n){
            strs.append(')');
            dfs(n,strs,open,close+1);
            //撤回选择
            strs.deleteCharAt(strs.length()-1);
        }

    }
    //判断有效性
    public static Boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (stack.empty() || stack.pop()!=')') return false;
        }
        if (stack.empty()) return  true;
        return false;
    }
    //动态规划
    //https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
    public static List<String> generateParenthesis_dp(int n) {
        List<List<String>> res = new LinkedList<>();
        res.add(new LinkedList<>(Arrays.asList("")));
        res.add(new LinkedList<>(Arrays.asList("()")));
        for (int i = 2; i <= n; i++) {
            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = res.get(j);
                List<String> str2 = res.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String str = "(" + s1 + ")" + s2;
                        tmp.add(str);
                    }
                }
            }
            res.add(tmp);
        }
        return res.get(n);
    }

    public static void main(String[] args){
       // System.out.println(isValid("()(()"));
        System.out.println(generateParenthesis_dp(2));
    }
}
