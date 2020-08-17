package mainIdea.offer;

import java.util.ArrayList;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 6:11 下午
 */
/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int sum = 3;
        for (int i =  1 ; i< 35;i++){
            int total = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j< 35 ;j++){
                if (total < sum){
                    list.add(j);
                    total += j;
                }
                if (total > sum){
                    break;
                }
                if (total == sum && list.size()>1){
                    res.add(new ArrayList<>(list));
                    total += j;
                }
            }
        }


    }
    public static void DFS(ArrayList<Integer> list , int begin,int sum){
        if (sum == 100){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin ; i<35 ; i++){
            sum += i;
            list.add(i);

        }
    }
}
