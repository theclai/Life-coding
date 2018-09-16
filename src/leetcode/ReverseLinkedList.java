package leetcode;

public class ReverseLinkedList {
    static ListNode head;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

     static ListNode reverse(ListNode node) {
        ListNode next;
        ListNode prev=null;
        ListNode cur=node;
        while (cur!=null){
            next = cur.next;
            cur.next = prev;
            // make current to previous
            // next to current
            prev = cur;
            cur = next;
        }
        node=prev;
        return node;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
