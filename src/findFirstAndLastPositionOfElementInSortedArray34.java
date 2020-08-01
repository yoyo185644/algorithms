import java.util.Arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/9 1:47 下午
 */
/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class findFirstAndLastPositionOfElementInSortedArray34 {
    //双指针 二分查找
    public static int[] searchRange(int[] nums, int target) {
        int lindex = 0,rindex = 0;
        int left = 0,right = nums.length-1,mid=0;
        while (left<=right){
            mid = (left+right) >>> 1;
            if (nums[mid] == target){
                lindex = rindex =  mid;
                while (lindex >= 0 && nums[lindex] == target) lindex--;
                while (rindex <= nums.length-1 && nums[rindex] == target) rindex++;
                return new int[]{lindex+1,rindex-1};
            }
            else if (nums[mid]<target) left = mid+1;
            else right=mid-1;
        }

        return new int[]{-1,-1};


    }
    public static void main(String[] args){
        int[] res = searchRange(new int[]{1},1);
       Arrays.stream(res).forEach((i)-> System.out.println(i));

    }
}
