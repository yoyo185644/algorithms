package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/15 1:54 下午
 */
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class EntryNodeOfLoop {
    //快慢指针
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode p1 = pHead,p2=pHead;
        boolean flag = false;
        while (p1!=null && p2!=null && !flag){
            p1 = p1.next;
            if (p2.next!=null) p2= p2.next.next;
            if (p1 ==p2){
                flag=true; //存在环路
            }
        }

        //有环就将P1恢复到其实位置：数学推导
        if (flag){
            p1 = pHead;
            while (p1!=p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;

        }
        return null;

    }

}
