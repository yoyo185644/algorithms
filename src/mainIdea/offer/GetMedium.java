package mainIdea.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/16 3:28 下午
 */
public class GetMedium {
    //大根堆
   public static PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
   //小根堆
    public  static PriorityQueue<Integer> min = new PriorityQueue<>();

    int size = 0;
    public void Insert(Integer num) {
        size++;
        if (size % 2 ==1){
            max.offer(num);
            min.offer(max.poll());
        }else {
            min.offer(num);
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (size%2==1){
            return new Double(min.peek());
        }else {
            return new Double((max.peek()+min.peek()))/2;
        }

    }
}
