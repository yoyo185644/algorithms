package mainIdea.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/8 9:31 上午
 */
//list中重复元素个数
public class Duplicate {
    public static void main(String[] args) {
        List  list = new ArrayList<>();
        int[] ints = new int[]{78,27,47,61,64,84,42,68,25,87,71,65,93,70,95,95,20,80,95,23,7,30,38,37,30,22,68,96,54,80,97,29,80,39,85,43,2,85,67,63,86,87,4,86,84,25,31,87,90,61,32,85,16,29,47,47,95,46,46,96,63,33,59,6,3,76,32,42,89,51,90,26,96,61,29,85,82,97,87,32,37,38,75,14,27,65,4,1,76,81,24,41,18,23,96,35,4,54,20,27};
        for (int i = 0;i<ints.length;i++){
            list.add(ints[i]);
        }
        System.out.println(countDuplicate(list));

    }
    public static int countDuplicate(List<Integer> numbers) {
        int len = numbers.size();
        System.out.println(len);
        if (numbers == null || len < 3 || len > 1000) return 0;
        HashMap<Integer,Integer> res = new HashMap<>();
        int num = 0 ;
        for (Integer i: numbers){
            if (i<1 || i>1000){
                continue;
            }
            if (res.containsKey(i)){
                res.put(i,res.get(i)+1);
            }else {
                res.put(i,1);
            }
        }
        for (Integer i : res.keySet()){
            if (res.get(i) > 1){
                num++;
            }
        }
        return num;

    }

}
