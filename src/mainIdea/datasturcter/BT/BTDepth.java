package mainIdea.datasturcter.BT;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 9:36 下午
 */
//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class BTDepth {
    //递归
    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
    //非递归
    public static int maxDepth_BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null ) queue.offer(root);
        //从0开始
        int line = 0;
        while (!queue.isEmpty()){
            int size =  queue.size();
            int n = 0;
            while (n<size){
                TreeNode temp = queue.poll();
                if (temp.left!=null) queue.offer(temp.left);
                if (temp.right!=null) queue.offer(temp.right);
                n++;
            }
            line++;
        }
        return line;



    }

    //递归
    public static int minDepth(TreeNode root){
        if (root == null) return 0;
        return Math.min(maxDepth(root.left),maxDepth(root.right))+1;
    }
    //非递归
    public  static int minDepth_BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null ) queue.offer(root);
        //从0开始
        int line = 0;
        while (!queue.isEmpty()){
            int size =  queue.size();
            //直接在这执行行数加一
            line++;
            int n = 0;
            while (n<size){
                TreeNode temp = queue.poll();
                if (temp.left==null && temp.right == null) return line;
                if (temp.left!=null) queue.offer(temp.left);
                if (temp.right!=null) queue.offer(temp.right);
                n++;
            }

        }
        return line;

    }
}
