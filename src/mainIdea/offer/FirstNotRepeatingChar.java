package mainIdea.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 4:05 下午
 */
/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class FirstNotRepeatingChar {
    public static int main(String[] args) {
        String str = "fsdfsasdff";
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (char c :chars){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for (char k: map.keySet()){
            if (map.get(k) == 1){
                return str.indexOf(k);
            }
        }
        return -1;

    }
}
