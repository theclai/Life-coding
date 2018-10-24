package linkedlist;

public class SplitLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode nodea = new ListNode('a');
        head.next = nodea;
        ListNode nodeb = new ListNode('b');
        nodea.next = nodeb;
        ListNode nodec = new ListNode('c');
        nodeb.next = nodec;
        ListNode noded = new ListNode('d');
        nodec.next = noded;
        ListNode nodee = new ListNode('e');
        noded.next = nodee;
        System.out.println(divideHalf(head).c);
    }

    /**
     * It should return the head of second part of the list
     * */
    private static ListNode divideHalf(ListNode list) {
        /*
        ListNode slow = nodea;
        ListNode fast = nodea;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            System.out.println("Slow: "+ slow.c);
            fast=fast.next.next;
            System.out.println("Fast: "+ fast.c);
        }
        System.out.println(slow.c);
        System.out.println(fast.c);
        return false;
        */
        // Find the odd number of nodes
        if (list == null)
            return null;
        ListNode runner = list.next;
        while (runner != null) {
            runner = runner.next;
            if (runner == null) {
                break;
            }
            runner=runner.next;
            list=list.next;
        }

        ListNode toReturn=list.next;

        return toReturn;
    }
}
