package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/29 4:13 下午
 */
public class Sub {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        int begin = -1,end = -1;
        for (int i = 0;i<n;i++){
            if (begin!=-1){
                break;
            }
            if (chars[i] == 'M'){
                for (int j = i;j<n;j++){
                    if (chars[j] == 'T'){
                        begin = j;
                        break;
                    }
                }
            }
        }
        for (int i = n-1 ;i>=0;i--){
            if (end!=-1){
                break;
            }
            if (chars[i] == 'T'){
                for (int j = i ;j>=0 ;j--){
                    if (chars[j] == 'M'){
                        end = j;
                        break;
                    }
                }
            }
        }
        if (begin>0 && end > 0 && begin < end){
            System.out.println(str.substring(begin+1,end));
        }



    }
}
