package mainIdea.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/16 4:15 下午
 */
/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
窗口大于数组长度的时候，返回空
 */
public class maxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> res = new ArrayList<>();
        if (size>num.length || size == 0) return res;
        for (int i = 0 ;i<num.length - size+1;i++){
            int max = num[i];
            for (int j = i+1;j<i+size;j++){
                if (num[j]>max){
                    max = num[j];
                }
            }
            res.add(max);
        }
        return res;


    }

    //
    public ArrayList<Integer> maxInWindows1(int [] num, int size)
    {


        ArrayList<Integer> res = new ArrayList<>();
        if (size>num.length || size == 0) return res;
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int n = 0;
        for (;n<size;n++){
            max.offer(num[n]);
        }
        while (n<num.length){
            res.add(max.peek());
            max.remove(num[n-size]);
            max.offer(num[n]);
            n++;
        }
        res.add(max.peek());
        return res;


    }
}
