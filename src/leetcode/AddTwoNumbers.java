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
        n2.next.next.next=null;
        addTwoNumbers(n1,n2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while(l1!=null && l2!=null){
            int result=l1.val+l2.val;
            l1=l1.next;
            l2=l2.next;
            System.out.println(result);
        }
        return null;

    }
}
