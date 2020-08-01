package mainIdea.backtrack;

import java.util.ArrayList;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/29 4:10 下午
 */
/*
我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子.
八皇后问题就是期望找到所有满足这种要求的放棋子方式.

关于路径选择
 */
public class cal8Queens {
    private static StringBuilder  res = new StringBuilder();
    public static void cal(){
        backtrack(0,new ArrayList<>());
    }
    public static void backtrack(int depth, ArrayList<Integer> list){
        if (depth == 8){
            res.append(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0 ;i<8 ;i++){
            //break就会跳出循环 continue是继续遍历 区分清楚
            if (list.contains(i)) continue;
            else {
                list.add(i);
                backtrack(depth+1,list);
                list.remove(list.size()-1);
            }
        }

    }
    public static void main(String[] args){
        cal();
        System.out.println(res.toString());
    }


}
