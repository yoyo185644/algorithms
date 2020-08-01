package mainIdea.datasturcter.linklist;

import java.util.Stack;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/6/6 4:10 下午
 */
//从尾到头打印单链表
public class PrintReversing {
    public static void print(LinkNode head){
        Stack<Integer> stack =  new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
