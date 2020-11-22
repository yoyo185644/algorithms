package mainIdea.datasturcter.BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/12 7:31 下午
 */
class STreeNode{
    char val;
    STreeNode left,right;
    STreeNode(char val){
        this.val = val;
    }
}
public class RebuildPre {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs  = str.split(" ");
        List<Character> mid = new ArrayList<>();
        List<Character> back = new ArrayList<>();
        for (Character c : strs[0].toCharArray()){
            mid.add(c);
        }
        for (Character c : strs[1].toCharArray()){
            back.add(c);
        }
        STreeNode root = reBuild(back,mid);
        dfs(root);

    }
    public static void dfs(STreeNode root){
        if (root == null) return;
        System.out.print(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public static STreeNode reBuild(List<Character> back , List<Character> mid){

        List<Character> back_left = new ArrayList<>();
        List<Character> mid_left = new ArrayList<>();
        List<Character> back_right = new ArrayList<>();
        List<Character> mid_right = new ArrayList<>();
        if (back.size()<=0) return null;
        char root_val = back.get(back.size()-1);
        STreeNode root = new STreeNode(root_val);
        int root_index = 0 ;
        for ( ;root_index<mid.size();root_index++){
            if (mid.get(root_index) == root_val){
                break;
            }
        }
        for (int i = 0; i <mid.size();i++){
            if (i<root_index){
                back_left.add(back.get(i));
                mid_left.add(mid.get(i));
            }
            if (i>root_index){
                back_right.add(back.get(i-1));
                mid_right.add(mid.get(i));
            }
        }

        root.left = reBuild(back_left,mid_left);
        root.right = reBuild(back_right ,mid_right);
        return root;

    }
}
