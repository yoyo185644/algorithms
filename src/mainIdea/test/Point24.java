package mainIdea.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/13 7:27 下午
 */
//24点
public class Point24 {
    public static boolean res = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] nums = new double[4];
        int i = 0;
        List<Double> list = new ArrayList<>();
        while (i<4){
            nums[i] = in.nextDouble();
            list.add(nums[i]);
            i++;
        }

        res = DFS(list);
        System.out.println(res);

    }
    public static boolean DFS(List<Double> list){
        if (list.size() == 1){
            if (Math.abs(list.get(0)-24.0)<0.01){
                return true;
            }
            return false;
        }
        for (int i = 0;i<list.size();i++){
            for (int j = i+1;j<list.size();j++){
                for (double c : compute(list.get(i),list.get(j))){
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0;k<list.size();k++){
                        if (k==j || k==i){
                            continue;
                        }
                        nextRound.add(list.get(k));
                    }
                    if (DFS(nextRound)) return true;

                }
            }
        }
       return false;
    }
    public static List<Double> compute(double a,double b){
        List<Double> res = Arrays.asList(a+b,a-b,a*b,a/b);
        return res;
    }

}
