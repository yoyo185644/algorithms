package mainIdea.test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/5 7:17 下午
 */
public class Password {
    public long getPasswordCount (String password) {
        int len = password.length();
        int[] nums = new int[len];
        for (int i = 0;i<len;i++){
            nums[i] = Integer.parseInt(""+password.charAt(i));
        }
        AtomicLong counter = new AtomicLong(0);
        for (int loveNum = 0 ;loveNum <=9 ;loveNum++){
            int[] path = new int[len];
            path[0] = loveNum;
            getPath(nums,1,path,counter);
        }
        return counter.longValue();
    }
    public static void getPath(int[] nums,int idx,int[] path,AtomicLong counter){
        if (idx >= nums.length){
            if (Arrays.toString(nums).toString().equals(Arrays.toString(path))){
                return;
            }
            counter.incrementAndGet();
            return;
        }
        int curr = nums[idx];
        int sum = curr + path[idx-1];
        if (sum % 2 == 0 ){
            path[idx] = sum/2;
            int nextIdx = idx+1;
            getPath(nums, nextIdx,path, counter);
        }else {
            int nextIdx = idx+1;
            path[idx] = (int) Math.ceil(sum/2.0);
            getPath(nums,nextIdx,path,counter);
            path[idx] = (int) Math.floor(sum/2.0);
            getPath(nums,nextIdx,path,counter);
        }
    }
}
