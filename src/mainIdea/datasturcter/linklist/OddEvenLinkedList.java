package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/21 4:29 下午
 */
//链表奇偶重新排列 奇在前 偶在后
public class OddEvenLinkedList {
    public static LinkNode oddEvenList(LinkNode head) {
       LinkNode res = new LinkNode(0);
       LinkNode preeven = res , preodd = res ,cur = head, next = head.next;
       while (cur!=null){
           if (cur.val%2 == 1){
               preeven.next = cur;
               preeven = cur;
               cur.next = null;
           }else {
               cur.next = preodd.next;
               preodd.next =cur;
               preodd = cur;
           }
           cur = next;
           next = cur.next;
       }
       return res.next;

    }
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        l1.next = l2;l2.next = l3; l3.next = l4;
        oddEvenList(l1);

    }
}
