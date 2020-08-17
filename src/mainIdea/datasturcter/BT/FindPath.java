package mainIdea.datasturcter.BT;


import java.util.ArrayList;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/2 3:27 下午
 */
/*
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        ArrayList<ArrayList<Integer>> rr = FindPath(n1,5);


    }
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return res;
        ArrayList<Integer> track = new ArrayList<>();
        DFS(track , root ,target ,0);
        return res;

    }
    public static void DFS(ArrayList<Integer> track , TreeNode node ,int target, int sum){
        track.add(node.val);
        if (sum == target - node.val && node.left == null && node.right == null){
            res.add(new ArrayList<>(track));
            return;
        }
//        if (sum > target - node.val){
//            track.remove(track.size() -1);
//            return;
//        }
        if (node.left != null ) {
            DFS(track, node.left, target, sum + node.val);
            track.remove(track.size() -1);
        }
        if (node.right != null){
            DFS(track ,node.right ,target, sum + node.val);
            track.remove(track.size() -1);
        }





        }
    }

