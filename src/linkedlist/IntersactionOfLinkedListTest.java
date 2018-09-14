package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class IntersactionOfLinkedListTest {
    IntersactionOfLinkedList linkedList;

    @Test
    public void test() {
        linkedList=new IntersactionOfLinkedList();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(5);
        headA.next.next.next.next = new ListNode(6);

        ListNode headB = new ListNode(11);
        headB.next = new ListNode(22);
        headB.next.next = new ListNode(13);
        headB.next.next.next = new ListNode(4);
        headB.next.next.next.next = new ListNode(5);
        headB.next.next.next.next.next = new ListNode(6);

        ListNode op= linkedList.getIntersectionNode(headA, headB);
        Assertions.assertEquals(4,op.val);

    }
}
