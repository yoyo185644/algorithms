import java.util.Arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/8 2:24 下午
 */
/*
33. 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class searchInRotatedSortedArray33 {
    //找到最大值和最小值,分成两个有序数组
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int i = len-1;
        int min = 0, max = 0, res = 0,index = -1;
        //找到最大值和最小值
        while (i>0){
            if ((i == nums.length-1 && nums[i] < nums [i-1])||(nums[i]<nums[i-1] && nums [i] < nums             [i+1]))
            {
                min = i;
                max=i-1;
            }

            i--;
        }
        if (target>=nums[0] && target <= nums[max])
        {
            index = Arrays.binarySearch(nums,0,max+1,target);
        }else if (target>=nums[min] && target<=nums[len -1]){
            index = Arrays.binarySearch(nums,min,len,target);
        }
        return index>=0 ? index : -1;
    }

    //使用二分法
    public static int search_leetcode(int[] nums, int target){
        int len = nums.length;
        if (len == 0) return -1;
        int low = 0,high = len-1,mid =0;
        while (low<=high){
            mid = (low+high)>>>1;
            if (nums[mid] == target) return mid;
            // 先根据 nums[mid] 与 nums[low] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[low]){
                if (target>=nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if (target<=nums[high] && target>nums[mid]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        System.out.println(search_leetcode(new int[]{4,5,6,7,0,1,2,3},0));
    }
}
