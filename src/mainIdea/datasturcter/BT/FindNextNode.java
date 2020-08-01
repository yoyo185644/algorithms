package mainIdea.datasturcter.BT;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 2:38 下午
 */
//给定一个二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
//树中的节点除了有两个分别指向左右孩子的指针，以及一个指向父节点的指针。
/*
1. 这个节点有右子树，那么下一个节点就是这个右子树的左孩子节点。
2. 这个节点没有右子树，并且这个点是父节点的左孩子，那么他的下一个节点就是其父节点。
3. 这个节点没有右子树，并且这个点是父节点的右孩子，则情况稍微复杂一点，沿着其父节点向上遍历，找到一个是它父节点的左孩子节点的节点，则他下一个节点就是该节点的父亲节点。
4.如果不是以上三类情况，那么说明该节点没有下一个节点，返回NULL或nullptr.
*/

class TNode{
    int val;
    TNode left;
    TNode right;
    TNode parent;
    TNode(int val){
        this.val = val;
    }
}
public class FindNextNode {
    public static TNode findNext(TNode root, TNode node){
        if (node == null) return null;
        TNode res = null;
        if (node.right != null) {
            TNode temp = node.right;
            while (temp.left!=null){
                temp = temp.left;
            }
            res = temp;
        }else {
            TNode temp = node;
            while (temp.parent!=null){
                if (temp.parent.left == temp){
                    res = temp.parent;
                    break;
                }
                temp = temp.parent;
            }
        }
        return res;


    }



}
