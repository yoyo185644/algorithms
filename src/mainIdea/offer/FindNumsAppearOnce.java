package mainIdea.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 5:46 下午
 */
/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int [] array = new int[]{2,4,3,6,3,2,5,5};
        int num1[] = new int[1] ;
        int num2[] = new int[1];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0;i<array.length;){
            if (i < array.length-1 && array[i] == array[i+1]){
                 i = i + 2;
            }else {
                list.add(array[i]);
                i++;
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
        System.out.println(num1[0]+" "+num2[0]);


    }
}
