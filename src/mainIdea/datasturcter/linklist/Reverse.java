package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 3:27 下午
 */
/*
反转整个链表
 */
class LinkNode{
    int val;
    LinkNode next;
    LinkNode(int val){
        this.val = val;
    }
}
public class Reverse {
    //递归实现
    public static LinkNode rev(LinkNode head){
        //将「以 head 为起点」的链表反转，并返回反转之后的头结点
        if (head.next == null) return head;
        //返回反转之后的头节点
        LinkNode last = rev(head.next);
        head.next.next = head;
        head.next = null;

        return last;

    }
    //遍历反转更加方便
    public static LinkNode rev01(LinkNode head){
        LinkNode newhead = null,node = null;
        while (head!=null){
            //每次只反转head和前一个元素的前后关系
            node = head;
            head = head.next;
            //反转
            node.next = newhead;
            newhead = node;
        }
        return newhead;
    }
}
