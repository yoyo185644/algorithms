/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/6 10:50 上午
 */
/*
28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/
 */
public class implementStrstr28 {
    //双指针解法
    public static int strStr(String haystack, String needle) {
       // if (haystack.length() < needle.length() ) return -1;
        int n = haystack.length(),m = needle.length();
        if (m == 0) return 0;
        int res = -1;
        int p = 0 ,q = 0;
        //设置循环范围在n-m+1内，外部直接不考虑 ****优化的点
        while (p < n-m+1){
            //设置num用于进行定位返回的指针 ****难点
            int num =0;
            while (p < n && q < m && haystack.charAt(p) == needle.charAt(q)){
                p++;
                q++;
                num++;
            }
            if (q == m) return p-q;
            p = p-num+1;
            q=0;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(strStr("m" ,
                        "mm"));
    }
}
