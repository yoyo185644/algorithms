package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/11 7:03 下午
 */
public class CalLeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder str = new StringBuilder();
        while (str.length()<N){
            str.append(in.next());
        }
        char[] chars = str.toString().toCharArray();
        int i = 0,j=N-1;
        int res =0;
        while (i<=j){
            if (chars[i] != chars[j]){
                res++;
            }
            i++;
            j--;

        }
        System.out.println(res);

    }
}
