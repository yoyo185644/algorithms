package mainIdea.datasturcter.BT;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 10:24 下午
 */
//判断一个二叉树是否是平衡二叉树
public class IsBalancedBT {
    public static boolean isBalanced(TreeNode root){
        if (root == null) return true;

        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left-right)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    public static int depth(TreeNode node){
        if (node == null) return 0;
        return Math.max(depth(node.left),depth(node.right))+1;
    }

    //上面的方法会重复计算树的深度
    //下面使用一个剪枝的思想
    static boolean balance = true;
    public static boolean isBalanced_(TreeNode root){

        return depth_(root) != -1;
    }
    public static int depth_(TreeNode node){
        if (node == null) return 0;
        int left = depth_(node.left);
        //不满足条件 立即退出
        if (left == -1) return -1;
        int right = depth_(node.right);
        if ( right == -1) return  -1;
        //设置一个非法标记 -1
        return Math.abs(left - right) > 1?-1:Math.max(left,right)+1;

    }

}
