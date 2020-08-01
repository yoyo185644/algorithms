import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/3 3:50 下午
 */
/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
/*
回朔算法：https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
 */
public class letterCcombinationsOfPhoneNumber17 {

    private static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if ( digits.length() == 0) return res;
        dfs(digits,new StringBuilder(),0);
        return res;
    }
    private static String getValue(char i){
        switch (i){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "nmo";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default:return "";
        }
    }
    public static void dfs(String digits,StringBuilder str,int depth){
        if (depth == digits.length() ){
            res.add(str.toString());
            //阻止其进一步操作
            return;
        }
        char[] cs = getValue(digits.charAt(depth)).toCharArray();
        for (char c : cs){
            //选择:相当于前序遍历
            str.append(c);
            dfs(digits,str,depth+1);
            //撤销选择：相当于后序遍历
            str.deleteCharAt(str.length() - 1);
        }

    }
    public static void main(String[] args){
        System.out.println(letterCombinations("34"));
    }
}
