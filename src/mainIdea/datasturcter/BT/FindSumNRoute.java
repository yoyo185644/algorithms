package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 2:07 下午
 */
//输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
//路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
public class FindSumNRoute {

    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> sumN(TreeNode root ,int N){
        if (root == null) return res;
        dfs(root,N,new ArrayList<>());
        return res;

    }
    //dfs回朔法
    public static void dfs(TreeNode root , int target ,List<Integer> list){
        if (target == 0 && root==null ){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(root.val);

        dfs(root.left , target - root.val ,list);
        dfs(root.right , target -root.val ,list);

        list.remove(list.size() - 1);

    }

}
