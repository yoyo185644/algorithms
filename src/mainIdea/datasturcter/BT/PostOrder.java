package mainIdea.datasturcter.BT;

import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/9 5:43 下午
 */
public class PostOrder {
    public static void postOrder(TreeNode root){
        Stack<TreeNode> sk = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        if (root!=null) sk.push(root);
        while (!sk.isEmpty()){
            TreeNode temp = sk.pop();
            res.push(temp);
            if (temp.left!=null) sk.push(temp.left);
            if (temp.right!=null) sk.push(temp.right);
        }
        while (!res.isEmpty()){
            System.out.println(res.pop());
        }
    }

}
