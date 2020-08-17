package mainIdea.backtrack;

import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/29 4:31 下午
 */
/*
我们有一个背包，背包总的承载重量是 Wkg。
现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 */


public class Bag0_1 {
    private static List<Integer> res = new ArrayList<>();
    public static void calMax(int[] pros, int w){
        Arrays.sort(pros);
        backtrack(pros,0,0,w);
    }
    public static void backtrack(int[] nums , int begin ,int sum ,int w){
        for (int i = begin ; i<nums.length;i++){
            if (sum + nums[i] > w){
                res.add(sum);
                break;
            }else {
                sum += nums[i];
                backtrack(nums,i+1,sum,w);
                sum -= nums[i];
            }
        }

    }
    public static void main(String[] args){
        int[] pros = {5,7,3,6};
        calMax(pros,8);
        System.out.println( Collections.max(res));


    }
}
