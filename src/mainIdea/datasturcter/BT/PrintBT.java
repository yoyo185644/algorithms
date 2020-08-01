package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/4 3:56 下午
 */
/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
//用队列实现层次遍历
//用一个变量记录奇数层还是偶数层 奇数层插入list后面 偶然数层插入list前面 如果队列不为空就循环取
public class PrintBT {
    public static List<List<Integer>> printZBt(TreeNode root){
        //层次遍历
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue =  new LinkedList<>();
        TreeNode node = null;
        queue.offer(root);
        //层数
        int line = 1;
        while (!queue.isEmpty()){
            int n = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (n>0){
                node =  queue.poll();
                if (line % 2== 1){
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                n--;
            }
            res.add(list);
            line++;
        }
        return res;
    }
}
