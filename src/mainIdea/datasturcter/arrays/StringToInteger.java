package mainIdea.datasturcter.arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/9 2:16 下午
 */
public class StringToInteger {
    public static int StrToInt(String str) {
        if (str == null || str.length() ==0) return 0;
        int i =0;
        char[] arr = str.toCharArray();
        while (arr[i]==' ') i++;
        if (i==arr.length) return 0;
        if (!Character.isDigit(arr[i]) && arr[i]!='+' && arr[i]!='-') return 0;
        boolean flag = (arr[i] == '-')?false:true;
        i =(arr[i] == '+'|| arr[i]=='-')?i+1:i;
        long num = 0;
        while (i<arr.length && Character.isDigit(arr[i])){
            num = num*10 + (arr[i++]-'0');
            if (num > Integer.MAX_VALUE) {
                if (num == Integer.MAX_VALUE + 1 && !flag)
                    return Integer.MIN_VALUE;
                else return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        if (i!=arr.length) return 0;
        return flag?(int) num:(int) num*-1;


    }

    public static void main(String[] args) {
        System.out.println(StrToInt("41"));
    }
}
