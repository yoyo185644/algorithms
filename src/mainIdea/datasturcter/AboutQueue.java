package mainIdea.datasturcter;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/3 5:48 下午
 */
/*
239. 滑动窗口最大值
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。
示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

进阶：

你能在线性时间复杂度内解决此题吗？O(N)使用队列
 */
public class AboutQueue {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        return res;

    }

}
/*
阻塞队列
 */
class Blockingq{
    BlockingQueue queue = new ArrayBlockingQueue(2);
}
/*
用栈表示队列
 */
class stackToQueue{
    //一个用来进
    Stack<Integer> sk1 = new Stack<>();
    //一个用来出
    Stack<Integer> sk2 = new Stack<>();
    public void offer(int data){
        sk1.push(data);
    }
    public int peek(){
        if (sk2.isEmpty()){
            while (!sk1.isEmpty()) sk2.push(sk1.pop());
        }
        return sk2.peek();
    }
    public void pop(){
        //保证sk2非空
        peek();
        sk2.pop();
    }
    public boolean isEmpty(){
        return sk1.isEmpty()&&sk2.isEmpty();
    }

 }
