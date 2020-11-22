package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/26 7:38 下午
 */
public class Dance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int sum = 0;
        for (int i  = 0 ;i<chars1.length ;i++){
            if (chars1[i] == chars2[i]){
                sum +=20;
            }else {
                sum -=10;
            }
            if (sum < 0){
                sum = 0;
                continue;
            }
        }
        System.out.println(sum);
    }
}
