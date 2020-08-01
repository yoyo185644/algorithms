package mainIdea.datasturcter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/3 5:30 下午
 */
/*
讲解 Next Greater Number 的原始问题：给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。不好用语言解释清楚，直接上一个例子：
给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
用stack后进先出
 */
public class AboutStack {
    public static int[] nextGreater(int[] nums){
        int len = nums.length;
        int[] res  = new int[len];
        Stack<Integer> sk = new Stack<>();
        for (int i = len-1;i>=0;i--){
            while (!sk.isEmpty() && sk.peek()<=nums[i]){
                sk.pop();
            }
            res[i] = sk.isEmpty()?-1:sk.peek();
            sk.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nextGreater(new int[]{2,1,2,4,3}));
    }

}
/*
用队列实现栈
 */
class quequeToStack{
    Queue<Integer> q = new LinkedList<>();
    //设置栈顶元素
    int top_element = 0;
    public  void push(int data){
        q.offer(data);
        top_element = data;
    }
    public int top(){
        return top_element;
    }

}
