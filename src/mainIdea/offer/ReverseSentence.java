package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 10:16 上午
 */
/*
“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String str = "  ";
        ReverseSentence(str);
    }
    public static String ReverseSentence(String str) {
        if (str.length()==0||str==null||str.trim().length()==0 ) return str;
        String[] strs = str.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strs.length-1 ;i >=0;i--){
                stringBuilder.append(strs[i]);
                if (i>0){
                    stringBuilder.append(" ");
                }

        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();

    }
}
