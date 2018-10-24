package linkedlist;

public class ListNode {
    int val;
    ListNode next;
    char c;

    ListNode(int x) {
        val = x;
        next = null;

    }

    ListNode(char x) {
        this.c = x;
        next = null;
    }
}
