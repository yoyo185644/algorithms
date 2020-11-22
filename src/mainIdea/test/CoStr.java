package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/7 3:29 下午
 */
public class CoStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        System.out.println(copy(str));
        System.out.println(n-copy(str));

    }
    public static int copy(String str){
        int len = str.length();
        int max = 1;
        char[] chars = str.toCharArray();
        int begin = chars[0];
        for (int i = 1 ;i<=len/2;i++){
            if (chars[i] == begin && str.substring(0,i).equals(str.substring(i,2*i))){
                if (i>max){
                    max = i-1;
                }
            }
        }
        return max;

    }
}
