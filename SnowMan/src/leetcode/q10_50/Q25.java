package leetcode.q10_50;

import leetcode.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class Q25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverseKGroup_1(ListNode head, int k) {
        int count = 0;
        ListNode testHead = head;
        ListNode newHead = null;
        ListNode preH = new ListNode(-1);
        ListNode preTail = null;
        preH.next = head;
        while (head != null) {
            if (++count == k) {
                ListNode nodeHead = preH.next;
                ListNode nodeTail = nodeHead;
                ListNode temp;
                while (--count > 0) {
                    temp = nodeTail.next;
                    nodeTail.next = temp.next;
                    temp.next = nodeHead;
                    nodeHead = temp;
                }
                head = nodeTail.next;
                preH.next = preH.next.next;
                if (preTail != null) preTail.next = nodeHead;
                preTail = nodeTail;
                if (newHead == null) {
                    newHead = nodeHead;
                }
            } else {
                head = head.next;
            }
        }
        return newHead == null ? testHead : newHead;
    }


}
