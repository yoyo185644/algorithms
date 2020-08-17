package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 2:22 下午
 */
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
//返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode res = new ListNode(0);
        res.next = pHead;
        ListNode p = res,q = pHead;
        while (q!=null){
            if (q.next!=null && q.val == q.next.val){
                q = q.next;
                while (q.next!=null && q.val == q.next.val){
                    q = q.next;
                }
                q = q.next;
                p.next = q;
            }else{
                p = q;
                q = q.next;
            }

        }
        return res.next;

    }
}
