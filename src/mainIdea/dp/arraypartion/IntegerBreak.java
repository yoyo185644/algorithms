package mainIdea.dp.arraypartion;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/31 8:49 下午
 */
public class IntegerBreak {

    private static void changeInteger(Integer value) {
        ++value;
    }

    public static void main(String[] args) {
        Integer a = 1;
        changeInteger(a);
        System.out.println("a = " + a);
        Integer.toBinaryString(7).toCharArray();
    }
}
