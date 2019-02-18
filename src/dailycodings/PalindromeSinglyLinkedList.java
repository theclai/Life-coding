package dailycodings;

import leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeSinglyLinkedList {
    PalindromeSinglyLinkedList palindromeSinglyLinkedList;
    ListNode head;

    @BeforeEach
    public void init() {
        palindromeSinglyLinkedList = new PalindromeSinglyLinkedList();
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);
    }

    @Test
    public void psll_positive_test() {
        Assertions.assertEquals(true,isPalindromByStack(head));

    }

    public boolean isPalindromByStack(ListNode head) {
        ListNode tempHead=head;
        Deque stack=new ArrayDeque();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty() && tempHead!=null){
            if(tempHead.val!=(int)stack.poll())
                return false;
            tempHead=tempHead.next;
        }
        return true;
    }
}
