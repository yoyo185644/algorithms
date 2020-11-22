package mainIdea.test;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/8 10:27 上午
 */
public class FinaleProblem {
    public static void main(String[] args) {
        System.out.println(theFinalProblem("0011"));
    }
    public static int theFinalProblem(String target) {
        // Write your code here
        char[] chars = target.toCharArray();
        int len = chars.length;
        int[] nums = new int[len];
        for (int i =0 ;i<len ;i++){
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        int num = 0;
        int i = 0;
        while(i<len){
            if (nums[i]!=0){
                num++;
                int j = i;
                while (j<len){
                   nums[j] = 1-nums[j];
                    j++;
                }
            }
            i++;
        }

        return num;
    }


}
