package mainIdea.datasturcter.BT;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 10:18 下午
 */
//操作给定的二叉树，将其变换为源二叉树的镜像，在给定的树上操作，不需要返回新的树
public class Mirror {
    public static void changMirror(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left!=null) changMirror(root.left);
        if (root.right!=null) changMirror(root.right);
    }
}
