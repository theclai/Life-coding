package practice;

import leetcode.ListNode;

import java.util.List;

public class DeleteNodeGreaterX {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
            this.next=null;
        }
    }

    public static void main(String[] args) {
        //7->3->4->8->5->1
        SinglyLinkedListNode head = new SinglyLinkedListNode(7);
        head.next = new SinglyLinkedListNode(3);
        head.next.next = new SinglyLinkedListNode(4);
        head.next.next.next = new SinglyLinkedListNode(8);
        head.next.next.next.next = new SinglyLinkedListNode(5);
        head.next.next.next.next.next = new SinglyLinkedListNode(1);
        delete(head, 6);

    }

    public static SinglyLinkedListNode delete(SinglyLinkedListNode root, int val) {
        if (root == null) return root;

        if (root.data > val && root.next == null) return null;
        SinglyLinkedListNode cur = root;
        SinglyLinkedListNode prev = null;

        while (cur != null && cur.data > val) {
            prev = cur;
            cur = cur.next;
        }

        if (prev != null) prev.next = null;

        SinglyLinkedListNode temp = cur;

        while (cur.next != null) {
            if (cur.next.data > val)
                cur.next = cur.next.next;
             else
                cur = cur.next;

        }

        return temp;
    }
}
