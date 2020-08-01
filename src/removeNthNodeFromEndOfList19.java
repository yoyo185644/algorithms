/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/4 2:52 下午
 */
/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class removeNthNodeFromEndOfList19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //head指向第一个数字
        //需要一个指针指向head
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = p;
        int num = 0,index =0 ;
        while (q.next!=null) {
            num++;
            q = q.next;
        }
        num = num - n ;
        q = p;
        while (num>0){
            q = q.next;
            num --;
        }
        q.next = q.next.next;
        return p.next;


    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        System.out.println(removeNthFromEnd(head,1));

    }
}
