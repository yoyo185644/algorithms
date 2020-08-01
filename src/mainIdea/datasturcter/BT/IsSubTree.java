package mainIdea.datasturcter.BT;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 10:53 下午
 */
//572. 另一个树的子树
//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
//
//示例 1:
//给定的树 s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//给定的树 t：
//
//   4
//  / \
// 1   2
//返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
//示例 2:
//给定的树 s：
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//给定的树 t：
//
//   4
//  / \
// 1   2
//返回 false。
public class IsSubTree {

    //找到相同节点 然后再判断是否是同一个树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        } else if (s.val == t.val && isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    //判断两个树是否是同一个树
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null&&root2!=null) || (root2 == null&&root1!=null) ) return false;
        if (root1.val != root2.val) return false;
        else return isSameTree(root1.left , root2.left) && isSameTree(root1.right ,root2.right);
    }

}
