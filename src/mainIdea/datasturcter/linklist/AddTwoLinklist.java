package mainIdea.datasturcter.linklist;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/7 4:25 下午
 */
//用两个链表来求和
public class AddTwoLinklist {
    public static LinkNode addTwo(LinkNode list1 ,LinkNode list2){
        LinkNode res = new LinkNode(0) , t = res;
        LinkNode p = list1,q = list2;
        //进位
        int arr = 0;
        while (p!=null || q!=null){
            int pval = p!=null ? p.val:0;
            int qval = q!=null ? q.val:0;

            int temp = (p.val + q.val + arr)%10;
            arr = temp/10;

            LinkNode newnode = new LinkNode(temp);
            t.next = newnode;
            t = newnode;
            //当指向p.next时 需要考虑p是否为空
            if (p!=null) p=p.next;
            if (q!=null) q=q.next;

        }
        if (arr>0) t.next = new LinkNode(arr);
        return res.next;


    }
}
