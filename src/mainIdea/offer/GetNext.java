package mainIdea.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 2:50 下午
 */
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
//注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class GetNext {
    List<TreeLinkNode> res = new ArrayList<>();
    public void mid(TreeLinkNode root){
        if (root == null) return ;
        mid(root.left);
        res.add(root);
        mid(root.right);
    }
    //暴力解
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = pNode;
        while (root.next!=null){
            root = root.next;
        }
        mid(root);
        int index = res.indexOf(pNode);
        return res.get(index+1);



    }
    //最优解
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        // 1.有右子树
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        // 2.无右子树，有左子树
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        // 3.直找到父节点的左子树是该节点
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;


    }

}
