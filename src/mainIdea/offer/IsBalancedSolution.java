package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 5:33 下午
 */
/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class IsBalancedSolution {
    public static void main(String[] args) {

    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(dep(root.left)-dep(root.right))>1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }
    public static int dep(TreeNode node){
        if (node == null) return 0;

        return Math.max(dep(node.left),dep(node.right))+1;

    }


}
