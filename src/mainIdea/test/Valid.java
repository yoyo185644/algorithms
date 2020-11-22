package mainIdea.test;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/9 9:19 下午
 */
public class Valid {
    public static void main(String[] args) {
        int i,a,b,c,d;
        for (i =0;i<10000;i++){
        a = i/1000;
        b = (i-a*1000)/100;
        c = (i - a*1000 -b*100)/10;
        d = i- a*1000 - b*100 - c*10;
        if ((i+b*1000+c*100+d*10+a) == 8888 ){
            System.out.printf("%d %d %d %d\n",a,b,c,d);
        }
    }

    }
}
