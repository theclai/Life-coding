package helper;

public class LinkedListNode {
    int val;
    LinkedListNode prev;
    LinkedListNode next;
    int both;

    public LinkedListNode() {
    }

    public LinkedListNode(int val,
                          LinkedListNode prev,
                          LinkedListNode next,
                          int both) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.both = both;
    }
}
