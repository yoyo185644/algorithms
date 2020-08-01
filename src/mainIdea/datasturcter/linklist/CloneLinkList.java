package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 5:26 下午
 */
//请实现函数ComplexListNode Clone(ComplexListNode head)，复制一个复杂链表。
// 在复杂链表中，每个结点除了有一个Next指针指向下一个结点外，还有一个Sibling指向链表中的任意结点或者NULL。
class ComplexListNode{
    int val;
    ComplexListNode next;
    ComplexListNode sibling;
    ComplexListNode(int val){
        this.val = val;
    }
}
public class CloneLinkList {
    //在原来链表的基础上复制元素 时间复杂度O(n) 空间复杂度O(n)
    public static ComplexListNode Clone(ComplexListNode head){
        if (head == null) return null;
        ComplexListNode p = head ;
        ComplexListNode res = new ComplexListNode(0) ;
        //将克隆的每个元素放在原来元素的后面
        while (p!=null){
            ComplexListNode newNode = new ComplexListNode(head.val);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next;
        }
        //克隆sibling节点
        p = head;
        while (p!=null){
            p.next.sibling = p.sibling;
            p = p.next == null ? null : p.next.next;
        }

        //将clone的节点分离开
        p = head;
        ComplexListNode q = res;
        while (p!=null){
            q.next = p.next;
            //易错
            p = p.next == null ? null : p.next.next;
            q = q.next;

        }
        return res.next;

    }

}
