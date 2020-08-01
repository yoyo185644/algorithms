import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/12 1:34 下午
 */
/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
https://leetcode-cn.com/problems/permutations/
 */
public class permutations46 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length ,0 ,new ArrayList<Integer>(),used);
        return res;

    }
    public static void dfs(int[] nums, int length ,int depth, List<Integer> list,boolean[] used){
        if (depth == length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i<length;i++){
            if (!used[i]){
                list.add(nums[i]);
                used[i] = true;
                dfs(nums,length,depth+1,list,used);
                used[i]= false;
                list.remove(list.size()-1);
            }

            }
    }



    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));

    }

}
