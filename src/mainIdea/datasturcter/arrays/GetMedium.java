package mainIdea.datasturcter.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/9 3:03 下午
 */
//得到一个数据流中的中位数，我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class GetMedium {
    //小顶堆 升序
    static PriorityQueue<Integer> minheap = new PriorityQueue<>();
    //大顶堆 降序
    static PriorityQueue<Integer> maxheap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public static void insert(int[] nums){
        int n=0;
        while (n<nums.length){
            //偶数放在小根堆
            if (n%2==0){
                minheap.offer(nums[n]);
                int min = minheap.poll();
                maxheap.offer(min);
            }else {
                maxheap.offer(nums[n]);
                int max = maxheap.poll();
                minheap.offer(max);
            }
            n++;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        insert(nums);
        if (nums.length % 2 ==0){
            System.out.println(new Double(minheap.peek()+maxheap.peek())/2);
        }
        else {
            System.out.println(maxheap.peek());
        }

    }
}
