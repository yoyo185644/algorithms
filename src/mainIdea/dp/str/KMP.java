package mainIdea.dp.str;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/3 2:10 下午
 */
/*

 */
public class KMP {
    private String pat;
    private int[][] dp;
    public KMP (String pat){
        this.pat = pat;
        //表示第i个pat遇到文本的字符j是需要状态转移
        dp =  new int[pat.length()][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for (int i =1 ;i<pat.length() ;i++){
            for (int c = 0 ;c< 256 ;c++){
                if (pat.charAt(i) == c) dp[i][c] = i+1;
                else dp[i][c] = dp[X][c];
            }
            //当前状态是X 遇到字符pat[i]需要的状转移
            X = dp[X][pat.charAt(i)];
        }
    }

    //根据状态转移表去匹配字符串
    public  int search(String text) {

        int j = 0;
        for (int i = 0; i<text.length();i++){
            //计算下一个状态 当前状态是j 遇到字符pat[i]需要的状转移
            j = dp[j][text.charAt(i)];
            if (j == pat.length()) return i-j+1;
        }

        return -1;

    }
}
