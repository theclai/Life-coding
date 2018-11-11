package dailycodings;

import helper.LinkedListNode;

public class XORLinkedList {
    static LinkedListNode last;

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode();
        head.prev = null;
        last=head;
        add(1);
        add(2);
        add(4);

        System.out.println("");

    }

    public static void add(int val) {
        LinkedListNode curLast = new LinkedListNode();
        curLast.val = val;
        last.next=curLast;
        curLast.prev=last;
        last=curLast;
    }
}
