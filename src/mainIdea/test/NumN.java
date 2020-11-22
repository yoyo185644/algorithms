package mainIdea.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/27 7:44 下午
 */
public class NumN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder("2"));
        list.add(new StringBuilder("3"));
        list.add(new StringBuilder("5"));
        int num = 3;
        if (n<=3) {
            System.out.println(Integer.parseInt(list.get(n-1).toString()));
            return;
        }
        int k =0;
        while (true){
            for (String s : new String[]{"2","3","5"}){
                list.add(new StringBuilder(list.get(k)).append(s));
                num++;
                if (num == n) {
                    System.out.println(Integer.parseInt(list.get(n-1).toString()));
                    return;
                }
            }
            k++;

        }

    }
}
