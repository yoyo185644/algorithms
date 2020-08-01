import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/4 2:24 下午
 */
/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

https://leetcode-cn.com/problems/4sum/
 */
public class fourSum18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for (int i = 0 ;i<nums.length ;i++){
            while( i>0 && i<nums.length-1 && nums[i] == nums[i-1]) i++;
            for (int j = i+1; j< nums.length ; j++){
                while (j>i+1 && j <nums.length-1 && nums[j] == nums[j-1]) j++;
                int twosum = target - nums[i] - nums[j];
                int p = j + 1;
                int q = nums.length -1;
                while (p<q){
                    while (p>j+1 && p<q && nums[p-1] == nums[p]) p++;
                    while (q<nums.length-1 && p<q && nums[q+1] == nums[q]) q--;
                    if (p<q && nums[p]+nums[q] == twosum){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[p]);
                        temp.add(nums[q]);
                        res.add(temp);
                        p++;q--;
                    }
                    else if(nums[p]+nums[q] > twosum){
                        q--;
                    }else {
                        p++;
                    }
                }
            }
        }

        return res;


    }


    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0,0},0));

    }
}
