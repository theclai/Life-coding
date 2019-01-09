package leetcode;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
        ListNode out=addTwoNumbers(head, head1);
        System.out.println(out.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val;
            if (l1 == null) {
                val = l2.val + carry;
            } else if (l2 == null)
                val = l1.val + carry;
            else
                val = l1.val + l2.val + carry;

            if (val > 10) {
                val = val - 10;
                carry = 1;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return head.next;
    }
}
