package dailycodings;

import leetcode.ListNode;

public class SumOfLinkedList_127 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(2);

        ListNode result = sum(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode sum(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode t = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int x = 0;
            int y = 0;
            if (head1 != null) x = head1.val;
            if (head2 != null) y = head2.val;
            int temp = (x + y + carry);
            if (temp > 9) {
                carry = 1;
                temp = temp - 10;
            } else
                carry = 0;
            ListNode newNode = new ListNode(temp);
            head.next = newNode;
            head = head.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        if (carry > 0)
            head.next = new ListNode(carry);
        return t.next;
    }
}
