package mainIdea.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/29 4:42 下午
 */
public class Choose {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] visit =  new boolean[301];
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<n;i++){
            boolean choose = false;
            for (int j = 0 ;j<n ;j++){
                int a = in.nextInt();
                if (!visit[a] && !choose){
                    list.add(a);
                    visit[a] = true;
                    choose = true;
                }
            }
        }
        for (int i =0;i<list.size();i++){
            System.out.print(list.get(i));
            if (i<list.size()-1){
                System.out.print(" ");
            }
        }


    }
}
