package leetcode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            ListNode next = head.next;

            if (next == head) {
                return true;
            } else {
                head.next = head;
            }

            head = next;
        }
        return false;
    }

}
