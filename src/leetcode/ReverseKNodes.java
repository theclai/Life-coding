package leetcode;

public class ReverseKNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseKGroup(head, 2);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode HEAD = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        if (len < k)
            return HEAD;
        return helper(HEAD, k, len, 0);

    }

    private static ListNode helper(ListNode head, int k, int len, int total) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
            total++;
        }

        if (next != null && len - total >= k)
            head.next = reverseKGroup(next, k);
        else if (next != null)
            head.next = next;
        return prev;
    }
}
