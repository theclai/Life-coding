package leetcode;

public class AddTwoNumbers_02 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        n1.next = null;

        /*
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        n1.next.next.next = null;
*/
        ListNode n2 = new ListNode(5);
        n2.next = null;
        /*
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        n2.next.next.next = null;*/
        //ListNode node = addTwoNumbers(n1, n2);
        ListNode node = addTwoNumbersSubmission(n1,n2);

        System.out.println(node);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        String opString = "";
        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val + carry;
            if (result > 9) {
                carry = 1;
                result = result - 10;
            } else {
                carry = 0;
            }
            opString += String.valueOf(result);
            l1 = l1.next;
            l2 = l2.next;
            System.out.println(result);
        }
        while (l1 != null) {
            opString += l1.val + carry;
        }

        while (l2 != null) {
            opString += l2.val + carry;
        }
        if (carry == 1)
            opString += 1;

        ListNode output = new ListNode(Integer
                .parseInt(String.valueOf(opString.charAt(0))));
        ListNode head = output;
        for (int i = 1; i < opString.length(); i++) {
            output.next = new ListNode(Integer
                    .parseInt(String.valueOf(opString.charAt(i))));
            output = output.next;
        }
        System.out.println(opString);
        return head;
    }

    public static ListNode addTwoNumbersSubmission(ListNode l1, ListNode l2) {
        // create a head node with value 0. This will be the permanent head. But its next value is the
        // first value of the linked list
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
