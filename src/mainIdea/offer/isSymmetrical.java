package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 3:35 下午
 */
//请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        return isSame(pRoot,pRoot);

    }
    public static boolean isSame(TreeNode p1 ,TreeNode p2){
        if (p1 == null && p2 == null) return true;
        if (p1 == null || p2 == null) return false;
        return p1.val == p2.val && isSame(p1.left,p2.right) && isSame(p1.right,p2.left);
    }

}
