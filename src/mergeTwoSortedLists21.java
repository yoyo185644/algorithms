/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/5 1:52 下午
 */

/*
21. 合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class mergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        res.next = l1;
        ListNode nl = res;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val) {
                nl.next = l1;
                nl = nl.next;
                l1 = l1.next;
            }else{
                nl.next = l2;
                nl = nl.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) nl.next = l2;
        if (l2 == null) nl.next = l1;
        return res.next;
    }

    public static void main(String[] args) {

    }

}
