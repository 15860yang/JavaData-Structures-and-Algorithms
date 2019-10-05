package leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int end = lists.length;
        for (int i = 0; i < end; ) {
            if (lists[i] == null) {
                lists[i] = lists[end - 1];
                end--;
            } else i++;
        }
        if (end == 0) {
            return null;
        }
        int minIndex = 0;
        for (int i = 0; i < end; i++) {
            if (lists[i].val < lists[minIndex].val) minIndex = i;
        }

        ListNode head = lists[minIndex];
        ListNode tail = head;
        lists[minIndex] = lists[minIndex].next;
        if (lists[minIndex] == null) {
            lists[minIndex] = lists[end - 1];
            end--;
        }
        while (end > 1) {
            minIndex = 0;
            for (int i = 0; i < end; i++) {
                if (lists[i].val < lists[minIndex].val) minIndex = i;
            }
            tail.next = lists[minIndex];
            tail = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            if (lists[minIndex] == null) {
                lists[minIndex] = lists[--end];
            }
        }
        tail.next = lists[0];
        return head;
    }
}
