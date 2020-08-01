package mainIdea.dp.bag;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/31 2:47 下午
 */
/*
474. 一和零
在计算机界中，我们总是追求用有限的资源获取最大的收益。

现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。

你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

注意:

给定 0 和 1 的数量都不会超过 100。
给定字符串数组的长度不会超过 600。
示例 1:

输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
输出: 4

解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
示例 2:

输入: Array = {"10", "0", "1"}, m = 1, n = 1
输出: 2

解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 */
public class OnesAndZeroes {
    public static int  findMaxForm(String[] strs, int m, int n) {
        //用i个1和j个0能组成的最多的数
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        for (String str:strs){
            int[] num = cal(str);
            for (int i = m ;i>=num[0] ;i--){
                for (int j = n ;j>=num[1]; j--){
                    if (i-num[0]>=0 && j-num[1]>=0){
                        //一般出现与自己本身比较就从后往前推
                        dp[i][j] = Math.max(dp[i][j],1+dp[i-num[0]][j-num[1]]);
                    }
                }
            }
        }
        for (int i = 0;i<=m ;i++){
            for (int j = 0;j<=n ;j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[m][n];

    }
    public static int[] cal(String str){
        char[] chars = str.toCharArray();
        int[] num = {0,0};
        for (char c : chars){
            if (c=='0') num[0]++;
            if (c=='1') num[1]++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
    }
}
