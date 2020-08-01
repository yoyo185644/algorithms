package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 3:54 下午
 */
//倒数第K个链表元素
public class FindKth {
    public  int finK(LinkNode head ,int k){
        LinkNode p = head ,q = head;
        int i =0;
        while (p!=null && i<k){
            p = p.next;
            i++;
        }
        while (p!=null){
            p = p.next;
            q = q.next;
        }
        return q.val;
    }

}
