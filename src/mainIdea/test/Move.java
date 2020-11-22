package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/3 7:52 下午
 */
public class Move {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        for (int i = 0 ;i<chars.length;i++){
            if (chars[i] == 'U' || chars[i] == 'u'){
                x0+=1;
            }
            if (chars[i] == 'D' ||  chars[i] == 'd'){
                x0+=1;
            }
            if (chars[i] == 'L' || chars[i] == 'l'){
                y0-=1;
            }
            if (chars[i] == 'R' || chars[i] == 'r'){
                y0-=1;
            }
        }
        System.out.println(x0 + " " + y0 );
    }
}
