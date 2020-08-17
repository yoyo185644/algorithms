package mainIdea.datasturcter.BT;

import java.util.Arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/17 2:10 下午
 */
/*
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length<1) return null;
        int max = getMax(nums);
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,max));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,max+1,nums.length));
        return root;
    }
    int getMax(int[] nums){
        int max = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[max]<nums[i]){
                max = i;
            }
        }
        return max;
    }

}
