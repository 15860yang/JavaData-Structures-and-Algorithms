package leetcode;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Q24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;
        temp = head.next;

        while (temp.next != null && temp.next.next != null) {
            ListNode node = temp.next.next;
            temp.next.next = node.next;
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        return head;

    }

}
