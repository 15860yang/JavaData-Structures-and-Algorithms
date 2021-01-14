package leetcode;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Q234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode nh = null;
        ListNode mh = head;
        ListNode temp;
        ListNode mDouble = head.next;
        while (mDouble.next != null && mDouble.next.next != null) {
            temp = mh;
            mh = mh.next;
            temp.next = nh;
            nh = temp;
            mDouble = mDouble.next.next;
        }
        temp = mh;
        ListNode middle = mDouble.next == null ? mh.next : mh.next.next;
        temp.next = nh;
        nh = temp;
        while (middle.val == nh.val) {
            middle = middle.next;
            nh = nh.next;
            if (nh == null && middle == null) {
                return true;
            } else if (nh == null || middle == null) {
                return false;
            }
        }
        return false;
    }
}
