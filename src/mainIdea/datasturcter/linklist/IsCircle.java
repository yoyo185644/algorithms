package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 4:14 下午
 */
//判断一个链表是否有环
public class IsCircle {
    //使用快慢指针
    public static boolean isCircle(LinkNode head){
        LinkNode p = head, q = head;
        //循环结束条件
        while (p!=null && p.next!=null){
            //快指针每次前进2步
            p = p.next.next;
            //慢指针每次走一步
            q = q.next;
            if (p==q) return true;
        }
        return false;
    }

    //如果是个环求环的长度
    public static int lengthOfCircle(LinkNode head){
        LinkNode p = head, q = head ,t = null;
        boolean flag = false;
        //循环结束条件
        while (p!=null && p.next!=null){
            //快指针每次前进2步
            p = p.next.next;
            //慢指针每次走一步
            q = q.next;
            if (p==q) {
                flag = true;
                break;
            }
        }
        if (flag){
            int len = 1;
            p = p.next;
            while (p!=q){
                len++;
                p = p.next;
            }
            return len;
        }
    return 0;

    }
    //求环的入口节点
    public static LinkNode enter(LinkNode head){
        //相当于求倒数第len个节点
        int len = lengthOfCircle(head);
        LinkNode p = head ,q = head;
        int i =0;
        while (p!=null && i<len){
            p = p.next;
            i++;
        }
        while (p!=q){
            p=p.next;
            q=q.next;
        }
        return q;

    }

}
