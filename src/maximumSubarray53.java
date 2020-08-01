/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/14 2:57 下午
 */
/*
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

解法：暴力/分治/动态规划

https://leetcode-cn.com/problems/maximum-subarray/
 */
public class maximumSubarray53 {
    //暴力解法
    public static int maxSubArray(int[] nums) {
        //求最大值 ，初始化为最小值
        int res = Integer.MIN_VALUE;
        for (int i =0 ;i<nums.length;i++){
            int sum = nums[i],max=nums[i];
            for (int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if (sum>max) max = sum;
            }
            if (max>res) res = max;

        }
        return res;

    }
    //动态规划 O(n)
    public static int maxSubArray_dp(int[] nums){
        int len = nums.length;
        //首先确定动态规划数组表示的含义：存放以nums[i]结尾的最大子序和！！！！
        int[] dp = new int[len];
        int res = Integer.MIN_VALUE;
        dp[0] = nums[0];
        res = dp[0];
        for (int i = 1; i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;

    }


    //分治 O(logn)
    /*
    假设[i,j]为我们所寻找的子序列
    nums[left,right]考虑任何连续子数组nums[i,j]必然位于下列三种情况 method(getMaxSubArray(int[] nums,int left,int right)
    1. 完全位于子数组nums[left,mid]中，因此left<=i<=j<=mid
    2. 完全位于子数组nums[mid+1,right]中，因此mid+1<=i<=j<=right
    3. 跨越了中点，因此left<=i<=mid<=j<=right
    4. 比较三种情况 返回最大值
    关键在于情况3 如何对于跨越中点子序列求解(其实并不难) 其实就是两侧最大子序列和相加 method public int midSumMax(int left,int mid,int right,int[] nums)
    1. 求出以mid为定点，从mid down to left 的子序列 [i,mid] 也就是leftMaxSum;
    2. 求出以mid+1为定点，从mid+1 up to right 的子序列 [mid+1,j] 也就是RightMaxSum;
    3. 求和leftMaxSum+RightMaxSum 从而得出中间最大子序列和
     */
    public static int maxSubArray_fz(int[] nums){
        return SumMax(nums,0,nums.length-1);
    }
    public static int SumMax(int[] nums, int left,int right){
        //递归终止条件
        if (left == right) return nums[left];
        else {
            int mid = (left + right)/2;
            //必须要考虑极端的情况，如果left=0 right=1,这个时候mid的取值为0，所有right只能为0
            int max_left = SumMax(nums,left,mid);
            int max_right = SumMax(nums,mid+1,right);
            int max_mid = midSumMax(nums,left,right,mid);
            int temp = Math.max(max_left,max_right);
            int res = Math.max(temp,max_mid);
            return res;
        }
    }
    public static int midSumMax(int[] nums,int left,int right,int mid){
        int max_left = Integer.MIN_VALUE,max_right = Integer.MIN_VALUE;
        int sum_left = 0,sum_right = 0;
        for (int i = mid; i>=left; i--){
            sum_left = sum_left + nums[i];
            if (sum_left>max_left) max_left = sum_left;
        }
        for (int i = mid+1; i<=right; i++){
            sum_right = sum_right + nums[i];
            if (sum_right>max_right) max_right = sum_right;
        }
        return max_left+max_right;

    }





    public static void main(String[] args) {
        System.out.println(maxSubArray_fz(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
