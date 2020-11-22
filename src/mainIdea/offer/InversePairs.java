package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 4:16 下午
 */
/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,4};
        int res = 0;
        //冒泡排序思想
        for (int i = 0 ;i<arr.length; i++){
            for (int j = i ;j<arr.length-1 ;j++){
                if (arr[j] > arr[j+1]){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
    //归并排序思想
    public static int res;
    public static void mergeSort(int[] array,int left,int right){
        if (array.length == 0 ) return;
        int mid = left + ((right-left)>>1);
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid+1,right);
    }
    public static void merge(int[] array ,int left,int mid ,int right){
            int[] temp = new int[array.length];
            int i = left,j = mid,k = left;
            while (i<=mid-1 && j<=right){
                if (array[i]>array[j]){
                    temp[k++] = array[i++];
                    res += (mid-i+1);
                }else{
                    temp[k++] = array[j++];
                }
            }
            while (i<=mid-1) temp[k++] = array[i++];
            while (j<=right) temp[k++] = array[j++];

           //将排好序的数组放入原来的数组中
          for (int p = left; p <= right; p++) {
            array[p] = temp[p];
           }

    }
}
