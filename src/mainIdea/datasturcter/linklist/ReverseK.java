package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/9 3:52 下午
 */
//链表每K位逆序
public class ReverseK {
    public static LinkNode reverse(LinkNode head ,int k){
        if (head==null) return null;
        LinkNode res = new LinkNode(0);
        res.next = head;
        LinkNode p = head,pre = null;
        int beigin = 1,end = beigin+k-1,len=0;
        while (p!=null){
            len++;
            p=p.next;
        }
        p = head;
        while (p!=null && end<=len){
            while (beigin<=end){
                LinkNode q = p.next;
                p.next = pre;
                pre =p;
                p=q;
                beigin++;
            }
            beigin = end+1;
            end = beigin+k-1;
        }
        return res.next;
    }
}
