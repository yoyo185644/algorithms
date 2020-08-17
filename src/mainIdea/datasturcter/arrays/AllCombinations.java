package mainIdea.datasturcter.arrays;

import java.util.ArrayList;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/13 5:05 下午
 */
/*
求所有的排列组合的可能性
 */
public class AllCombinations {
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,3,4};
        for (int i = 1; i<=arr.length; i++){
            DFS(new ArrayList<Integer>(),i,arr,0);
        }
        System.out.println(res.size());


    }
    public static void DFS(ArrayList<Integer> list ,int depth,int[] arr,int k){
        if (list.size() == depth){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = k;i< arr.length;i++){
            if (list.contains(arr[i])){
                continue;
            }
            list.add(arr[i]);
            DFS(list,depth,arr,k++);
            list.remove(list.size()-1);
        }
    }
}
