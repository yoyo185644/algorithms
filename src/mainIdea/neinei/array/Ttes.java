package mainIdea.neinei.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/21 7:32 下午
 */
public class Ttes {
    public static ArrayList<ArrayList<Integer>> res = new ArrayList();
    public static int num =0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DFS(new ArrayList<>(),n);
        System.out.println(num);
        res.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        for (ArrayList<Integer> list : res){
            System.out.println(list);
        }

    }
    public static void DFS(ArrayList<Integer> list ,  int n ){
        if (list.size() == 3 && list.get(0)!=0){
            int sum1 = list.get(0)*100 + list.get(1)*10 + list.get(2);
            int sum2  =  list.get(0)*100 + list.get(2)*10 + list.get(2);
            if (sum1+sum2 == n){
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(sum1);
                list1.add(sum2);
                res.add(list1);
                num++;
                return;
            }
        }
        for (int i = 0 ;i < 10 ;i++){
            if (list.contains(i)){
                continue;
            }
            list.add(i);
            DFS(list,n);
            list.remove(list.size()-1);
        }


    }


}
