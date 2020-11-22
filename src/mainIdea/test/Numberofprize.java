package mainIdea.test;

import java.util.Arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/5 6:35 下午
 */
public class Numberofprize {
    public static void main(String[] args) {
        System.out.println( numberofprize(4,4,2));
    }

    public static int numberofprize (int a, int b, int c) {
        double[] arr = new double[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        double count = arr[0];
        for (int i = 0;i<3;i++){
            arr[i] = arr[i]-count;
        }
        while (arr[2]>2 && arr[1]>2){
            count++;
            arr[2] = arr[2] -2;
            arr[1] = arr[1] -2;
        }
        while (arr[2]>5){
            count++;
            arr[2] = arr[2]-5;
        }
        return  (int) count;

    }
}

