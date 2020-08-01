package mainIdea.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/1 4:45 下午
 */
/*
你面前有一栋从 1 到 N 共 N 层的楼，然后给你 K 个鸡蛋（K 至少为 1）。
现在确定这栋楼存在楼层 0 <= F <= N，在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于 F 的楼层都会碎，低于 F 的楼层都不会碎）。
现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层 F 呢？

「最坏情况」:鸡蛋破碎一定发生在搜索区间穷尽时，不会说你在第 1 层摔一下鸡蛋就碎了，这是你运气好，不是最坏情况。
 */
public class Unbroken {

    //递归式动态规划
    //表示K个鸡蛋N层楼的最少次数

    //使用备忘录
    private static Map<Map<Integer,Integer>,Integer> map = new HashMap<>();
    public static int dp(int K , int N){
        //K个鸡蛋N层楼
            if (K == 1) return N;  //当只有一个鸡蛋的时候最坏情况下要N次
            if (N == 0) return 0;
            if (N == 1) return 1; //当只有一层楼的时候抛1次
            if (map.containsKey(new HashMap<>(K,N))) return map.get(new HashMap<>(K,N));

            int res = N; //最多不超过层数
            for (int n = 1 ;n<=N ;n++){
                int temp = Math.max(dp(K-1,n-1),dp(K,N-n)) + 1;
                res = Math.min(res , temp);
            }
            map.put(new HashMap<>(K,N),res);
            return res;
    }

    public static void main(String[] args) {
        System.out.println(dp(2,19));
    }
}
