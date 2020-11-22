package mainIdea.datasturcter.arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/20 8:37 下午
 */
public class Sqrt {
    public static void main(String[] args) {
        int t = 15;
        if (t < 0) {
            throw new RuntimeException("Negative number cannot have a sqrt root.");
        }

        //先确定当前数所处的最小整数区间
        int i = 0;
        for ( ; i <= t; i++) {
            if (i * i == t) {
                System.out.println(i);
                return;
            }
            if(i * i > t){
                break;
            }
        }

        //再通过二分法来进行判断检测
        Double precise = null;
        double low = i-1, high = i, prec = precise != null ? precise : 1e-7;
        double middle, squre;
        while (high - low > prec) {
            middle = (low + high) / 2;
            squre = middle * middle;
            if (squre > t) {
                high = middle;
            }else{
                low = middle;
            }
        }
        System.out.println((low + high) / 2);
    }
}
