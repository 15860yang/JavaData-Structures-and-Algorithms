package question;

/**
 * 判断链表是否回文
 */
public class Q3 {

    public static boolean changeList(Node head) {
        if (head == null) {
            return false;
        }
        if(head.next == null){
            return true;
        }
        if(head.next.next == null){
            return head.data == head.next.data;
        }
        Node midQ;
        Node fastQ = head;
        Node slowQ = head;
        while (fastQ.next != null && fastQ.next.next != null) {
            fastQ = fastQ.next.next;
            slowQ = slowQ.next;
        }
        midQ = slowQ;
        //到现在的时候 slowQ 为中间结点，比如总共四个结点，slowQ 就在第二个，比如总共五个节点，slowQ为第三个
        //然后现在开始反转slowQ后面的
        reverseList(midQ);
        boolean result = anagrams(head,midQ.next);
        reverseList(midQ);
        return result;
    }

    //判断是否回文
    private static boolean anagrams(Node head,Node midNest) {
        while (midNest.next != null){
            if(head.data != midNest.data){
                return false;
            }
            midNest = midNest.next;
            head = head.next;
        }
        return true;
    }

    //将midQ之后的结点反转
    private static void reverseList(Node midQ) {
        Node startQ;
        Node endQ;
        startQ = endQ = midQ.next;
        Node temp = null;
        //反转中间往后的链表
        while (endQ.next != null) {
            temp = endQ.next;
            endQ.next = endQ.next.next;
            temp.next = startQ;
            startQ = temp;
        }
        //将反转后的链表重写连到中间的结点上
        midQ.next = startQ;
    }
}
