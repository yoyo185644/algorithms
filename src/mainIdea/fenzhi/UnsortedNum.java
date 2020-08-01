package mainIdea.fenzhi;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/29 3:43 下午
 */
/*
程求出一组数据的有序对个数或者逆序对个数呢?
2,4,3,1,5,6
逆序队个数：4
 */
public class UnsortedNum {
    private static int num = 0;
    public static void Unsorted(int[] nums, int left, int right){
        //终止条件
        if (left>=right) return ;
        int mid = left + ((right - left) >> 1);
        Unsorted(nums, left  ,mid);
        Unsorted(nums, mid+1 ,right);
        //利用归并排序的思想计算逆序对
        merge(nums , left ,mid+1 ,right);

    }
    public static void merge(int[] nums ,int left , int mid , int right ){
        int[] temp = new int[nums.length];
        int i = left , j = mid , k= left;
        while (i<=mid-1 && j <= right){
            if (nums[i]<=nums[j]) {
                temp[k++] = nums[i++];
            }else {
                num += mid - i;
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid-1) temp[k++] = nums[i++];
        while (j<= right) temp[k++] = nums[j++];

        for (int t = left ;t<= right; t++){
            nums[t] = temp[t];
        }

    }
    public static void main(String[] args){
        int[] nums = {2,4,3,1,5,6};
        Unsorted(nums, 0 , nums.length-1);
        //for (int i = 0;i<nums.length;i++) System.out.println(nums[i]);
        System.out.println(num);

    }
}
