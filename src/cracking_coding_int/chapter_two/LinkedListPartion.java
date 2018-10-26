package cracking_coding_int.chapter_two;

/**
 * partition a linkedlist around a value x, such that all nodes less than x come before all nodes greater
 * than or equal to x
 */
public class LinkedListPartion {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        partition(head,5);

    }

    private static ListNode partition(ListNode node, int x) {
        ListNode head=node;
        ListNode tail=node;

        while (node!=null){
            ListNode next=node.next;
            if(next.val<x) {
                node.next = head;
                head=node;
            }else{
                tail.next=node;
                tail=node;
            }
            node=next;
        }
        tail.next=null;
        return head;
    }
}
