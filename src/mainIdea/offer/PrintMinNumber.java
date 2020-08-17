package mainIdea.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 3:22 下午
 */
/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    static List<Long> res = new ArrayList<>();
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        int[] nums = new int[]{3,32,321};
        DFS(new ArrayList<Integer>(),nums.length,nums);
        long data = Collections.min(res);
        System.out.println(String.valueOf(data));

    }
    public static void DFS(List<Integer> list,int len,int[] nums){
        if (list.size() == len){
            StringBuilder str = new StringBuilder();
            for (Integer i : list){
                str.append(nums[i]);
            }
            res.add(Long.parseLong(str.toString()));
            return;
        }
        for (int i = 0 ;i<len;i++){
            if (list.contains(i)){
                continue;
            }
            list.add(i);
            DFS(list,len,nums);
            list.remove(list.size()-1);
        }

    }
}
