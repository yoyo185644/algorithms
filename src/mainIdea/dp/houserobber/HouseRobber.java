package mainIdea.dp.houserobber;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/31 6:44 下午
 */
/*
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：
0 <= nums.length <= 100
0 <= nums[i] <= 400

 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));

    }
    public static int rob(int[] nums) {
        if (nums.length == 0 ) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0;i<len;i++){
            dp[i] = nums[i];
        }

        if (nums.length >= 2) {
            dp[1] = Math.max(dp[0],dp[1]);
        }
        for (int i = 2;i<len;i++){
            dp[i] = Math.max(dp[i-1] , nums[i] + dp[i-2]);
        }
        return dp[len-1];
    }
}
