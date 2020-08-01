import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/9 4:26 下午
 */
/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

https://leetcode-cn.com/problems/combination-sum/
 */
public class combinationSum39 {
    //回朔法
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
          Arrays.sort(candidates);
          int len = candidates.length;
          Sum(candidates,new ArrayList<Integer>(),target,res,0,len);
          return res;

    }
    public static void Sum(int[] candidates ,List<Integer> list , int target,List<List<Integer>> res,int begin , int len){
        if (target == 0)
        {
            //必须要新创建一个list对象，下面还会对原来的list进行操作
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin ;i<len;i++){
            //// 在数组有序的前提下，剪枝
            if (target-candidates[i] < 0) break;
            list.add(candidates[i]);
            Sum(candidates,list,target-candidates[i],res,i,len);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{2,3,5},8));

    }

}
