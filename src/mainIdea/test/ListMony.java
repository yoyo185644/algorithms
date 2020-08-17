package mainIdea.test;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/13 8:19 下午
 */
/*
1024-N 由1 4 16 64组成 最少的个数
 */
public class ListMony {
    public static void main(String[] args) {
        int N = 2;
        int num = 1024 - N;
        int a = num/16;
        int b = num%16/4;
        int c  = num%16%4;

    }
}
