package leetcode.q10_50;

import leetcode.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */


public class Q21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {

            return l1;
        }

        ListNode head;
        ListNode tail;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        tail = head;
        while (l2 != null && l1 != null) {
            if (l1.val > l2.val) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
        }
        tail.next = l1 == null ? l2 : l1;
        return head;
    }
}
