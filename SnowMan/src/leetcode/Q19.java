package leetcode;

public class Q19 {
    /**
     * Definition for singly-linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = head;
        int size = 1;
        ListNode node = head;
        while (node.next != null) {
            if (size > n) {
                tempNode = tempNode.next;
            }
            size++;
            node = node.next;
        }
        if (tempNode == head) {
            if (size > n) {
                tempNode.next = tempNode.next.next;
            } else
                head = head.next;
        } else tempNode.next = tempNode.next.next;
        return head;
    }
}
