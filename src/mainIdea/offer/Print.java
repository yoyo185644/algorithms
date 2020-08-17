package mainIdea.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 4:29 下午
 */
/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int line = 0;
        while (!queue.isEmpty()){
            line++;
            int size  = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size>0){
                TreeNode node = queue.poll();
                if (line%2 ==1){
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
               if(node.left!=null) queue.add(node.left);
               if (node.right!=null) queue.add(node.right);
                size--;
            }
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            res.add(arrayList);
        }
        return res;


    }
}
