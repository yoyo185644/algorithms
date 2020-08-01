/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/4/29 2:10 下午
 */
/*
11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
https://leetcode-cn.com/problems/container-with-most-water/
 */
public class containerWithMostWater11 {

    public static int maxArea(int[] height) {
        if(height.length<2) return 0;

        int res = 0;
        int start =0;
        int end = height.length-1;
        while(start<=end){
            res = Math.max(res,(Math.min(height[start], height[end]) * (end - start)));
            if(height[start] >= height[end]) end-- ;
            else start++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }


}
