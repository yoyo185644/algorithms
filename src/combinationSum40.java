import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/10 2:02 下午
 */
/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class combinationSum40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //使用set集合去重
        Set<List<Integer>> res = new HashSet<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates,0,len,target,new ArrayList<>(),res);
        return new ArrayList<>(res);
    }
    //回朔法
    public static void dfs(int[] cadidates,int begin,int len,int target,List<Integer> list,Set<List<Integer>> res){
        if (target == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i<len ; i++){
            if (target - cadidates[i] < 0) continue;
            list.add(cadidates[i]);
            dfs(cadidates,i+1,len,target-cadidates[i],list,res);
            list.remove(list.size()-1);
        }

    }
    public static void main(String[] args){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

}
