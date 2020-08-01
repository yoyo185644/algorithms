package mainIdea.datasturcter.BT;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 3:53 下午
 */
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
//要求不能创建任何新的结点，只能调整树中结点指针的指向。 输出链表的”头节点“。
public class BSTToLinklist {
    public static TreeNode BstToLinkedList(TreeNode root){
        if (root == null) return null;
        TreeNode pre =  null;
        convert(root,pre);
        TreeNode res = root;
        //找到链表头
        while (res.left!=null) res = res.left;
        return res;


    }
    public static void convert(TreeNode root , TreeNode pre){
        if (root == pre) return;
        //转换左子树
        convert(root.left,pre);

        root.left = pre;
        if (pre!=null) pre.right = root;

        //转化右节点
        convert(root.right ,pre);


    }

}
