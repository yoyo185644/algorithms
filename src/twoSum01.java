import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/27 5:23 下午
 */
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

*/
public class twoSum01 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        int temp = 0;
        for(int i = 0 ; i < nums.length ; i++){
            temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res= twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
}
