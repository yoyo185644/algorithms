/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/31 10:13 上午
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
    public static boolean judgeSquareSum(int c) {
        //平方
        double n  =  Math.sqrt(c);
        for(int i = 0;i*i<=n;i++){
            double b  =  Math.sqrt(n-i*i);
            if (b == (int)b){
                return true;
            }
        }
        return false;
    }
}
