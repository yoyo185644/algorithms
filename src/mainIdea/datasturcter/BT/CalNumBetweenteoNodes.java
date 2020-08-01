package mainIdea.datasturcter.BT;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/4 4:24 下午
 */
//求两个节点之间的路径
public class CalNumBetweenteoNodes {
    //首先计算两个节点的深度 在计算找出公共父节点
    public static int cal(TreeNode root , TreeNode node1 , TreeNode node2){
        int depth1 = caldepth(root,node1);
        int depth2 = caldepth(root,node2);
        int depthFather = caldepth(root,commomFather(root,node1,node2));
        return depth1+depth2-depthFather;
        //两者直接的长度

    }
    public static int caldepth(TreeNode root,TreeNode node){
        //用一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = null;
        int line = 1;
        if (root.val == node.val) return 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count>0){
                temp = queue.poll();
                if (temp.val == node.val){
                    return line;
                }
                if (temp.left!=null) queue.offer(temp.left);
                if (temp.left!=null) queue.offer(temp.right);
            }
            line++;

        }
        return 0;

    }
    //递归找出公共父节点
    public static TreeNode commomFather(TreeNode root, TreeNode node1, TreeNode node2){
        if (root == null || root == node1 || root==node2) return root;
        TreeNode left = commomFather(root.left ,node1 ,node2);
        TreeNode right = commomFather(root.right ,node1 ,node2);
        if (left == null && right==null) return null;
        else if (left!=null && right == null) return left;
        else return right;

    }

}
