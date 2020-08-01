package mainIdea.datasturcter.BT;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public static void dfs(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    //非递归 迭代
    public static List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> sk = new Stack<>();
        List<Integer> res =  new ArrayList<>();
        if (root != null) sk.push(root);
        while (!sk.isEmpty()){
            TreeNode temp = sk.pop();
            res.add(temp.val);
            //压入左边的元素
            if (temp.right != null){
                sk.push(temp.right);
            }
            if (temp.left != null){
                sk.push(temp.left);
            }
        }
        return res;
    }
}
