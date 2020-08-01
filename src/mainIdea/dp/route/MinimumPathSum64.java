package mainIdea.dp.route;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/1 2:12 下午
 */
/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小
 */
//最值问题 可以使用动态规划解决
public class MinimumPathSum64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        //到达i，j的最小路径
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0 ; i<m ;i++){
            for (int j = 0; j<n ;j++){
                if (i-1>=0 && j-1>=0)
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                if (i-1>=0 && j-1<0)
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                if (j-1>=0 && i-1<0)
                    dp[i][j] = dp[i][j-1]+grid[i][j];
            }

        }
        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
