package mainIdea.dp.arraypartion;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/1 2:37 下午
 */
/*
303. 区域和检索 - 数组不可变
给定一个整数数组 nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
//除了简单的数组下标方法 还可以使用缓存 存放所有的sum
public class RangeSumQueryImmutable303 {
    public static int[] sum;
    public RangeSumQueryImmutable303(int[] nums) {
        int len = nums.length;
        sum = new int[len+1];
        for (int i = 0 ;i < len ;i++){
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public static int sumRange(int i, int j) {
        return sum[j+1] - sum[i];

    }
}
