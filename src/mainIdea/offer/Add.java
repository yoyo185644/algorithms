package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 1:51 下午
 */
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Add {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            // 负数左移会在低位补1
            //进位与运算
            int c = ((num1 & num2)) << 1;
            num1 ^= num2;
            num2 = c;
        }
        return num1;

    }
}
