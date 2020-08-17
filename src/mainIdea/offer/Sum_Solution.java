package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 11:02 上午
 */
/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        if (n == 1) return n;
        return Sum_Solution(n-1)+n;

    }
}
