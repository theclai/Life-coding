package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        n1.next.next.next = null;

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        n2.next.next.next = null;
        ListNode node=addTwoNumbers(n1, n2);

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
            opString+=l1.val;
        }

        while (l2 != null) {
            opString+=l2.val;
        }

        ListNode output=new ListNode(Integer
                .parseInt(String.valueOf(opString.charAt(0))));
        ListNode head=output;
        for(int i=1;i<opString.length();i++){
            output.next=new ListNode(Integer
                    .parseInt(String.valueOf(opString.charAt(i))));
            output=output.next;
        }
        System.out.println(opString);
        return head;

    }
}
