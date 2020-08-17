package mainIdea.datasturcter.arrays;

import java.util.ArrayList;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/2 5:06 下午
 */
/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class TopKMin {
    public static void main(String[] args) {
        GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);

    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res  = new ArrayList<>();
        int len = input.length;
        if (k>len) return res;
        int[] arr = new int[len+1];
        arr[0]  = 0;
        for (int i = 0;i<len;i++){
            arr[i+1] = input[i];
        }
        int n = len + 1;
        //建堆
        for (int i = n/2 ; i >0 ;i--){
            heapify(arr , n ,i);
        }
        while (k>0){
            res.add(arr[1]);
            int temp = arr[n-1];
            arr[n-1] = arr[1];
            arr[1] = temp;
            n--;
            k--;
            heapify(arr,n,1);
        }
        return res;
    }
    public static void heapify(int[] arr,int n ,int i){
        while (true){
            int minpos = i;
            while (i*2<n && arr[i*2]<arr[minpos]) minpos = i*2;
            while (i*2+1<n && arr[i*2+1]<arr[minpos]) minpos = i*2+1;
            if (i == minpos) break;
            int temp = arr[i];
            arr[i] = arr[minpos];
            arr[minpos] = temp;
            i = minpos;
        }
    }
}

