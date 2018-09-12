package leetcode;

public class LinkedListCycle_142 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode tortoise=head;
        ListNode hare=head;
        while(tortoise!=null && hare!=null && hare.next!=null){
            tortoise=head.next;
            hare=head.next.next;
            if(tortoise==hare){
                return tortoise;
            }

        }
        return null;

    }
}
