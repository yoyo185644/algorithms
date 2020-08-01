import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/12 1:58 下午
 */
/*
47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
https://leetcode-cn.com/problems/permutations-ii/
 */
public class permutationsII47 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
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
                //重在剪枝 ，如果当前的数等于前一个数 ，并且前一个数已经使用过，则剪枝
                if (i>0 && nums[i]==nums[i-1] && used[i-1]) break;
                list.add(nums[i]);
                used[i] = true;
                dfs(nums,length,depth+1,list,used);
                //撤销操作和原来的操作正好对称
                used[i]= false;
                list.remove(list.size()-1);
            }

        }
    }
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{3,3,0,3}));

    }

}



