package mainIdea.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/12 8:04 下午
 */
public class Remove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        int n = in.nextInt();
        System.out.println(removeKDigits(num,n));
    }
    public static String removeKDigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }

        LinkedList<Character> stack = new LinkedList<>();
        int rmNum = 0;
        int idx= 0;

        for (; idx < num.length(); idx++) {
            char c = num.charAt(idx);
            while (!stack.isEmpty() && stack.peek() > c && rmNum < k) {
                stack.pop();
                rmNum++;
            }
            if (rmNum >= k) {
                break;
            }

            if (c != '0') {
                stack.push(c);
            }
        }

        while (rmNum < k) {
            stack.pop();
            rmNum++;
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        while (result.length()==0 && idx < num.length() && num.charAt(idx) == '0') {
            idx++;
        }

        if (idx < num.length()) {
            result +=num.substring(idx);
        }

        if (result.length() == 0) {
            return "0";
        }
        return result;
    }
}
