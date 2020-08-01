package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 10:04 下午
 */
//层次遍历的相关问题
public class BFS {
    //自上而下一次遍历

    //之字形打印二叉树
    public List<List<Integer>> printZ(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        if (root!=null) queue.offer(root);
        int line = 0;
        while (!queue.isEmpty()){
            //list存储一行的数据
            LinkedList<Integer> linelist = new LinkedList<>();
            line++;
            int size = queue.size();
            int n = 0;
            while (n < size){
                TreeNode temp = queue.poll();
                if (line % 2 == 1){
                    linelist.addLast(temp.val);
                }
                else linelist.addFirst(temp.val);
                if (temp.left!=null) queue.offer(temp.left);
                if (temp.right!=null) queue.offer(temp.right);
                n++;
            }
            res.add(linelist);
        }
        return res;

    }
    //把二叉树打印成多行
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            //list存储一行的数据
            List<Integer> linelist = new ArrayList<>();
            int size = queue.size();
            int n = 0;
            while (n < size){
                TreeNode temp = queue.poll();
                linelist.add(temp.val);
                if (temp.left!=null) queue.offer(temp.left);
                if (temp.right!=null) queue.offer(temp.right);
                n++;
            }
            res.add(linelist);
        }
        return res;

    }

}
