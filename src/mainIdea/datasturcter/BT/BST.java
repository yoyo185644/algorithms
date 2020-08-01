package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 3:03 下午
 */

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class BST {
    public static boolean isBST(List<Integer> list){

        if (list.size() == 0) return false;
        List<Integer> post_left = new ArrayList<>();
        List<Integer> post_right = new ArrayList<>();

        int root_val = list.get(list.size()-1);
        TreeNode root = new TreeNode(root_val);

        int index_mid = 0 , index_pre=0;
        while (list.get(index_mid)>root_val) index_mid++;
        while (index_pre<index_mid){
            if (list.get(index_pre)<root_val){
                break;
            }
            post_right.add(list.get(index_pre));
            index_pre ++ ;
        }
        while (index_mid<list.size()-1){
            if (list.get(index_pre)>root_val){
                return false;
            }
            post_left.add(list.get(index_mid));
            index_mid++;
        }
        //初始是正确的
        boolean left =true ,right =true;
        left = isBST(post_left);
        right = isBST(post_right);


        return left&&right;


    }

}
