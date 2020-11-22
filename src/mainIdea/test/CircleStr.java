package mainIdea.test;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/6 4:55 下午
 */
//判断回文字符串
public class CircleStr {
    public static void main(String[] args) {

        System.out.println(isPalindrome("A man,a plan,a canal: panama"));
       // System.out.println(Character.isLetterOrDigit(':'));
    }
    public static boolean isPalindrome (String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<j){
            while (!Character.isLetterOrDigit(chars[i])){
                i++;
            }
            while (!Character.isLetterOrDigit(chars[j])){
                j--;
            }
            if (Character.toLowerCase(chars[i])!=Character.toLowerCase(chars[j])){
                return false;
            }else {
                i++;
                j--;
            }


        }
        return true;
    }
}
