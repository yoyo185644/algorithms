import java.util.Arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/7 4:36 下午
 */
/*
31. 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
/*
其实就是从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个最小的比nums[i]大的元素交换。
交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
 */
public class nextPermutation31 {
    public static int[] nextPermutation(int[] nums) {
        int len = nums.length;
        if (len<=1) return nums;
        int right = len -1;
        int left =  right-1;
        int min = 0;
        while (left < right && left>=0){
            if (nums[left]<nums[right])
            {
                min  = right;
                break;
            }
            else {
                left--;
                right--;
            }
        }
        if (left<0) {
            Arrays.sort(nums);
        }else {
            for (int i = right+1;i<len;i++){
                if (nums[i]<nums[min] && nums[i]>nums[left]){
                    min = i;
                }
            }
            nums = swap(nums,left,min);
            System.out.println("left:" +  left + ",right:" +right);
            Arrays.sort(nums,right,len);
        }

        return nums;
    }
    public static int[] swap(int[] nums ,int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return nums;

    }
    public static void main(String[] args) {
        int[] nums =  nextPermutation(new int[]{2,1,2,2,2,2,1});
//        for (int i = 0;i<nums.length;i++)
//        {
//            System.out.println(nums[i]);
//        }
        Arrays.stream(nums).forEach(i-> System.out.println(i));

    }
}
