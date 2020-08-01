package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 9:12 下午
 */
//中序排序
public class MidOrder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> sk = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root!=null){
            sk.push(root);
            root = root.left;
        }
        while (!sk.isEmpty()) {
            TreeNode temp = sk.pop();
            res.add(temp.val);
            TreeNode p = temp.right;
            while (p != null) {
                sk.push(p);
                p = p.left;
            }
        }
        return res;
    }

    }

