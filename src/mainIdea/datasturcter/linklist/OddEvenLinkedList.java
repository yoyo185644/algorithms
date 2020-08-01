package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/21 4:29 下午
 */
public class OddEvenLinkedList {
    public static LinkNode oddEvenList(LinkNode head) {
        LinkNode odd = new LinkNode(0);
        LinkNode even = new LinkNode(0) ;
        LinkNode p = head ,res = odd;
        while (p!=null){
            if (p.val % 2 == 0){
                odd.next = p;
                p = p.next;
                odd = odd.next;
                odd.next = null;
            }else {
                even.next = p;
                p = p.next;
                even = even.next;
                even.next = null;
            }
        }
        odd.next = even.next;
        return res.next;

    }
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        l1.next = l2;l2.next = l3; l3.next = l4;
        System.out.println(oddEvenList(l1));

    }
}
