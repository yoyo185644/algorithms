package mainIdea.datasturcter;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/3 3:17 下午
 */
public class Heap {

    //自顶向下小顶堆
    public static void heapify(int[] nums,int n){
        //len表示实际堆的长度
        int len = n;
        for (int i = len/2;i>=1;i--){
            int maxpos = i;
            //从左右字节点中找出最大的
            if (i*2<=len && nums[i*2] > nums[maxpos]) maxpos = i*2;
            if (i*2+1<=len &&nums[i*2+1] > nums[maxpos]) maxpos = i*2+1;
            if (maxpos != i) {
                int temp = nums[maxpos];
                nums[maxpos] = nums[i];
                nums[i] = temp;
            }
        }
    }
    //找出前k个最大的
    public static void sort(int[] a,int k){
        int n = a.length;
        int[] nums = new int[n+1];
        nums[0] = 0;
        for (int i = 0;i<n;i++){
            nums[i+1] = a[i];
        }
        while (k>0){
            heapify(nums,n);
            System.out.println(nums[1]);
            int temp = nums[n];
            nums[n] = nums[1];
            nums[1] = temp;
            n--;
            k--;
        }
    }

    public static void main(String[] args) {
        sort(new int[]{2,1,3,5,6},3);

    }
}
