package dailycodings;

import leetcode.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node= reverse(head);
        System.out.println(node.val);
        //1-2-3-4
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev=null;
        ListNode next=null;
        ListNode cur=node;

        while (cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        node=prev;
        return node;
    }
}
