package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 4:46 下午
 */
//给定单链表的头指针和一个结点指针，定一个函数在时间复杂度为O(1)删除链表结点
public class DelNode {

    public static LinkNode delNode(LinkNode head , LinkNode delNode){
        LinkNode res = new LinkNode(0);
        res.next = head;
        //如果不是尾节点的话 交换它与后一个节点的位置,时间复杂度O(1)
        if (delNode.next!=null){
            LinkNode node = delNode.next;
            int temp = node.val;
            node.val = delNode.val;
            delNode.val = temp;
            //删除后一个节点
            delNode.next = node.next;
        } else {
            //如果是最后一个节点的话 时间复杂度是O(n)
            //但是均摊复杂度是O(1)
            LinkNode p = head;
            while (p.next != delNode){
                p = p.next;
            }
            p.next = p.next.next;
        }
        return res.next;
    }

}
