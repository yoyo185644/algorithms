/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/5 8:59 下午
 */
/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class swapNodesInPairs24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre=res,p=pre.next,q=p.next;
        while (p!=null && q!=null){
            p.next = q.next;
            q.next = p;
            pre.next = q;
            pre = p ;
            if (pre.next==null){
                break;
            } else {
                p = pre.next;
                q = p.next;
            }

        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(swapPairs(head));

    }

}
