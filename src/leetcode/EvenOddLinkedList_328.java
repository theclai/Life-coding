package leetcode;

public class EvenOddLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode beforeSlow = head;
        ListNode beforeFast = head.next;

        while (true) {
            //move odd to end of first half and close the gap
            beforeSlow.next = fast;
            beforeFast.next = fast.next;
            fast.next = slow;
            // move pointers
            beforeSlow = beforeSlow.next;
            if (beforeFast.next == null || beforeFast.next.next == null) {
                break;
            }
            fast = beforeFast.next.next;
            beforeFast = beforeFast.next;
        }
        return head;
    }
}
