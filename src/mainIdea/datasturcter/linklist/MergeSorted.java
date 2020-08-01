package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 5:02 下午
 */
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
public class MergeSorted {

    public static LinkNode merge(LinkNode head1 , LinkNode head2){
        LinkNode res = new LinkNode(0);
        LinkNode p = res;
        res.next = head1;
        //将head2里面的元素插入head1里面 减少空间复杂度
        while (head1!=null && head2!=null){
            if (head1.val < head2.val){
                p.next = head1;
                head1 = head1.next;
            }else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1!=null) p.next = head1;
        if (head2!=null) p.next = head2;

        return res.next;
    }
}
