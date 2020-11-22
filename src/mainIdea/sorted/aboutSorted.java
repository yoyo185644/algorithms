package mainIdea.sorted;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/19 2:12 下午
 */
//使用个排序算法实现顺序排序
public class aboutSorted {
    // 冒泡排序
    public static void BubbleSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 0; i < nums.length-1; i++) {
            //表示没有数据可以交换
            boolean flag = false;
            //注意第二次循环的递归范围是到nums.length - i -1
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    //表示有数据可以交换
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    //插入排序
    public static void insertSort(int[] nums) {
        //原始有序数组里面的元素只有一个
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j = i - 1;
            //查找插入的位置
            for (; j >= 0; j--) {
                if (nums[j] > val) {
                    nums[j + 1] = nums[j];
                } else break; //一定要停止
            }
            nums[j + 1] = val;
        }

    }

    //选择排序 不稳定
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //初始化最小值
            int min = i;
            //寻找最小值的位置
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //将最小值放在最后
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }


    //归并排序
    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        //取中间值
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid + 1, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        //开辟临时空间
        //因为在双指针法的时候用到了原数组的元素
        int[] temp = new int[nums.length];
        //i是遍历左边的数组 j是遍历右边的数组 k是定位temp数组用来新增元素
        int i = left, j = mid, k = left;
        while (i <= mid - 1 && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        //把左边剩余的元素加进数组中
        while (i <= mid - 1) temp[k++] = nums[i++];
        //把右边剩余的元素放入数组中
        while (j <= right) temp[k++] = nums[j++];
        //将排好序的数组放入原来的数组中
        for (int p = left; p <= right; p++) {
            nums[p] = temp[p];
        }

    }


    //快速排序
    public static void quickSort(int[] nums) {
        if (nums.length <= 1 || nums == null) return;
        quick(nums, 0, nums.length - 1);
    }

    public static void quick(int[] nums, int begin, int end) {
        if (begin > end) return;
        int pivot = nums[begin];
        //i从begin开始 考虑到极端情况
        int i = begin, j = end;
        //双指针法
        while (i != j) {
            //从后往前找到第一个小于pivot的数
            while (nums[j] > pivot && i < j) j--;
            //从前往后找到第一个大于pivot的数
            //保证i指向的是比pivot小的数字
            while (nums[i] <= pivot && i < j) i++;
            //交换这两元素
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        //定位到中间的点i，于pivot交换
        nums[begin] = nums[i];
        nums[i] = pivot;
        //递归pivot左边的数组
        quick(nums, begin, i - 1);
        //递归pivot右边的数组
        quick(nums, i + 1, end);

    }


}

class Heap{
    private static int[] a; //用数组表述堆
    private static int n; //堆中最大存储的元素个数
    private static int count; //堆中已经存储的元素个数

    Heap(int capacity){
        this.a = new int[capacity+1];
        this.n = capacity;
        count = 0;
    }
    public  static void insertHeap(int data){
        if (count>=n) return;
        //数组下标从1开始
        ++count;
        a[count] = data;
        //从下而上堆化
        int i =count;
        while (i>=0 && a[i] > a[i/2]){ //在数组中i/2表示其父节点
            int temp = a[i/2];
            a[i/2] = a[i];
            a[i] = temp;
            i = i/2;
        }
    }
    public static void removeHeap(){
        if (count == 0) return;
        //删除元素时 把最后一个元素放在堆顶，让它满足完全二叉树的条件
        a[1] = a[count];
        --count;

    }
    //自顶向下堆化
    public static void heapify(int[] a ,int n ,int i){
        while (true){
            int maxPos = i;
            //从左右子节点里面找出最大的
            if (i*2<=n && a[i*2]>a[maxPos]) maxPos = i*2;
            if (i*2+1<=n && a[i*2+1]>a[maxPos]) maxPos = i*2+1;
            if (maxPos == i) break;
            int temp = a[maxPos];
            a[maxPos] = a[i];
            a[i] = temp;
            //向下遍历
            i = maxPos;
        }
    }
    //堆排序
    public static void buildHeap(int[] a ,int n){ //建立一个大顶堆
        //遍历非叶子节点 进行调整建立大顶堆
        for(int i = n/2 ; i>=1 ; i--){
            heapify(a,n,i);
        }
    }
    public static void sort(int[] a,int n){ // 堆排序
        buildHeap(a,n);
        int k = n;
        while (k>1){
            int temp = a[k];
            a[k] = a[1];
            a[1] = temp;
            k--;
            heapify(a,k,1);//重新堆化
        }
    }
    public static void main(String[] args){
        int[] a = {0,9,6,3,1,5};
        sort(a,5);
        for (int i= 1; i<6 ;i++){
            System.out.println(a[i]);
        }



    }


}





