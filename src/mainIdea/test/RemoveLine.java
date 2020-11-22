package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/29 7:25 下午
 */
public class RemoveLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<strs.length;i++){
            if (!strs[i].equals("")){
                sb.append(strs[i]).append("_");
            }
        }

//        char[] chars = str.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        while (!Character.isLetterOrDigit(chars[i])){
//            i++;
//        }
//        for (;i<chars.length;){
//            if (Character.isLetterOrDigit(chars[i])){
//                sb.append(chars[i]);
//                i++;
//            }
//            if (i<chars.length && chars[i]=='_'){
//                sb.append(chars[i]);
//                i++;
//                while (i<chars.length && chars[i] == '_'){
//                    i++;
//                }
//            }
//        }
        String res = sb.toString();
        int len = res.length();
        if (res.substring(len-1,len).equals("_")){
            System.out.println(res.substring(0,len-1));
        }else {
            System.out.println(res);
        }

    }
}
