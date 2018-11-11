package helper;

public class LinkedListNode {
    public int val;
    public LinkedListNode prev;
    public LinkedListNode next;
    public int both;

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
