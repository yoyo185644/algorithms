package mainIdea.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 4:50 下午
 */
/*
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，
按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    static List<TreeNode> res = new ArrayList<>();
    public static void preOrder(TreeNode node){
        if (node==null) return;

        preOrder(node.left);
        res.add(node);
        preOrder(node.right);
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        preOrder(pRoot);
        if (k>res.size() || k==0) return null;
        return res.get(k-1);
    }
}
