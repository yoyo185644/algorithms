import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/2 1:49 下午
 */
/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

//超时解法
public class threeSum15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Map<Integer , Integer> tmap = new HashMap<>();
        for(int i : nums){
            if(tmap.containsKey(i)) {
                tmap.put(i , tmap.get(i)+1);
            }else {
                tmap.put(i,1);
            }
        }
        for(int i: nums){
            Map<Integer , Integer> map = new HashMap<>(tmap);
            //map = insertMap(nums);
            map.put(i,map.get(i)-1);
            List<List<Integer>> temp = twoSum(map ,0-i);
            for(List<Integer> l : temp){
                l.add(i);
                Collections.sort(l);
                res.add(l);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());


    }
    public static List<List<Integer>> twoSum(Map<Integer,Integer> map, int sum){
        List<List<Integer>> listWithlist = new ArrayList<>();
        for(int i : map.keySet()){
            map.put(i , map.get(i)-1);
            if(map.get(i)>=0 && map.containsKey(sum - i) && map.get(sum - i)>0){
                map.put(sum-i , map.get(sum - i)-1);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(sum-i);
                listWithlist.add(list);
            }else {
                map.put(i , map.get(i)+1);
            }
        }
        return listWithlist;
    }

    //用双指针解法 leetcode优化解法：
    //结合twoSum的双指针算法
    public static List<List<Integer>> threeSum_leetcode(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i < nums.length ; i++){
            //去重
            while (i>0 && nums[i] == nums[i-1] && i< nums.length-1 ){
                i = i + 1;
            }
            //if (i == nums.length-1) break;
            int twosum = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (left < right && nums[left] + nums[right] == twosum){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    //去重
                    while (left<nums.length && nums[left]==nums[left-1]) left++;
                    while (left<right && nums[right]==nums[right+1]) right--;
                }else if(nums[left] + nums[right] < twosum){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-5,1,-3,-1,-4,-2,4,-1,-1};
        System.out.println(threeSum_leetcode(nums));

    }
}
