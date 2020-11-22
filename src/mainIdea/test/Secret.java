package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/8 6:24 下午
 */
public class Secret {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        for (String s:strs){
            System.out.println(isValid(s));
        }
    }
    public static int isValid(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len<8 || len > 120) {
            return 1;
        }
        int num = 0,character = 0,upper= 0,lower = 0;
        for (Character c :chars){
            int ascii = (int)c;
            if (ascii >= 65 && ascii<= 90){
                upper++;
            }else if (ascii>=97 && ascii<=122){
                lower++;
            }else if (ascii>=48 && ascii<= 57){
                num++;
            }else {
                character++;
            }
        }
        if (num>0 && character>0 && upper>0 && lower>0){
            return 0;
        }
        return 2;
    }
}
