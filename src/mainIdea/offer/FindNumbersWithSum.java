package mainIdea.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 9:40 上午
 */
/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int [] array = new int[]{1,2,3,4,5};
        int sum = 5;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ;i< array.length ;i++){
            map.put(array[i],i);
        }
        for (int i = 0;i < array.length ;i++){
            int num = sum - array[i];
            if (map.containsKey(num) && map.get(num)>i){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(array[i]);
                list.add(num);
                res.add(list);
            }

        }
        if(res.size() == 0){
            return null;
        }
        int m_index = 0 ;
       if (res.size()>1){
           int min = Integer.MIN_VALUE;
           for (int i = 0;i<res.size();i++){
               ArrayList<Integer> list = res.get(i);
               if (list.get(0) * list.get(1)<min){
                   min = list.get(0) * list.get(1);
                   m_index = i;
               }
           }

       }
       return  res.get(m_index);



    }
}
