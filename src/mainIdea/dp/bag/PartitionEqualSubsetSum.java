package mainIdea.dp.bag;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/30 5:05 下午
 */
/*
416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 */
public class PartitionEqualSubsetSum {

    //可以看成是和为sum/2的0-1背包问题 每个数只能选一次
    public static boolean isTrue(int[] nums){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 !=0) return false;

        //前i个数中有满足总和为j的子集
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];

        for (int j = 0 ; j< sum/2+1 ; j++) dp[0][j] = false;
        for (int i = 0 ;i<=nums.length; i++) dp[i][0] = true;

        for (int i = 1 ;i<=nums.length ;i++){
            for (int j = 1 ; j<=sum/2;j++){

                if (j-nums[i-1]>=0){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else dp[i][j] = dp[i-1][j];

            }
        }

        return dp[nums.length][sum/2];

    }

    //从二维降到一维
    public static boolean leetcode_isTrue(int[] nums){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 !=0) return false;
        boolean[] dp = new boolean[sum/2+1];

        dp[0] = true;
        for (int num : nums){
            for (int j = sum/2 ; j>=num ;j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[sum/2];


    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(leetcode_isTrue(nums));
    }
}
