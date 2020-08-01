import java.util.Arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/3 1:56 下午
 */
/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
https://leetcode-cn.com/problems/3sum-closest/
 */
public class threeSumClosest16 {
    //时间复杂度过高
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0 ; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                for (int k = j+1; k<nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(sum - target)<min){
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                }
            }
        }
        return res;

    }
    //leetcode 优化算法 ： 现排序仔双指针
    public static int threeSumClosest_leetcode(int[] nums, int target){
        Arrays.sort(nums);
        int res =Integer.MAX_VALUE;
        int abs = Math.abs(res-target);
        for(int i =0 ; i<nums.length ;i++){
            int left = i + 1;
            int right = nums.length -1;
            while (left < nums.length && left < right){
                int sum = nums[i] + nums[left] + nums[right];
                //-4,-1,1,2
                if (Math.abs(sum-target)<abs) {
                    res = sum;
                }
                System.out.println(i + " " + left + " " + right + " "+ sum);
                if (sum < target){
                    left++;
                }else if (sum > target){
                    right--;
                }else {
                    res = sum;
                }

            }

        }
        return res;

    }
    public static void main(String[] args){
        System.out.println(threeSumClosest_leetcode(new int[]{-1,2,1,-4},1));

    }
}
