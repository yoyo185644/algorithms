package mainIdea.datasturcter.BT;

import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 4:10 下午
 */
//给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
public class FindBSTKth {
    public static TreeNode findKth(TreeNode root ,int k){
        Stack<TreeNode> sk = new Stack<>();
        TreeNode p = root;
        while (p!=null){
            sk.push(p);
            p = p.left;
        }
        int num =0;
        while (!sk.isEmpty()){
            TreeNode temp = sk.pop();
            num++;
            if (num == k) {
                return temp;
            }
            TreeNode tright = temp.right;
            while (tright!= null){
                sk.push(tright);
                tright = tright.left;
            }

        }
        return null;

    }
}
