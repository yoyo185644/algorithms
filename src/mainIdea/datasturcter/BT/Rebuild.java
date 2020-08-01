package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 3:12 下午
 */
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树（假设没有重复数字）
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}则则重建二叉树并返回。
public class Rebuild  {
    public static TreeNode reBuild(List<Integer> pre ,List<Integer> mid){
        List<Integer> pre_left = new ArrayList<>();
        List<Integer> mid_left = new ArrayList<>();
        List<Integer> pre_right = new ArrayList<>();
        List<Integer> mid_right = new ArrayList<>();
        int root_val = pre.get(0);
        TreeNode root = new TreeNode(root_val);
        int root_index = 0;
        for ( ;root_index<mid.size() ;root_index++){
            if (mid.get(root_index) == root_val){
                break;
            }
        }
        for (int i = 0; i <mid.size() ;i++){
            if (i<root_index){
                pre_left.add(pre.get(i+1));
                mid_left.add(mid.get(i));
            }
            if (i>root_index){
                pre_right.add(pre.get(i));
                mid_right.add(mid.get(i));
            }
        }
        root.left = reBuild(pre_left,mid_left);
        root.right = reBuild(pre_right ,mid_right);

        return root;

    }

}
