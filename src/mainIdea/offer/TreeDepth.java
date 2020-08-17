package mainIdea.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 5:24 下午
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return 0;
        queue.add(root);
        int dep = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode t = queue.poll();
                if (t.left!=null){
                    queue.offer(t.left);
                }
                if (t.right!=null){
                    queue.offer(t.right);
                }
                size--;
            }
            dep++;
        }
        return dep;

    }
}
