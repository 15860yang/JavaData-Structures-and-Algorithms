package leetcode.q51_100.链表;

import leetcode.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode kHead = head;
        int n = k;
        while (n-- > 0) {
            if (kHead.next == null) {
                kHead = head;
            } else {
                kHead = kHead.next;
            }
        }
        if (kHead == head) {
            return head;
        }
        ListNode mh = head;
        while (kHead.next != null) {
            kHead = kHead.next;
            mh = mh.next;
        }
        ListNode newHead = mh.next;
        mh.next = null;
        kHead.next = head;
        return newHead;
    }
}
