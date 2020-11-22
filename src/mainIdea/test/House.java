package mainIdea.test;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/5 7:31 下午
 */
public class House {
    public int getHouses (int t, int[] xa) {
        int res = 0;
        int begin = xa[0]+xa[1]/2;
        int end = xa[2] + xa[3]/2;
        if (end>begin){
            res = end-begin+1;
        }

        return 2+res;

    }
}
