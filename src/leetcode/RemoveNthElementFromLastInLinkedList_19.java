package leetcode;

public class RemoveNthElementFromLastInLinkedList_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast;
        ListNode start = new ListNode(0);
        slow = start;
        fast = start;
        slow.next = head;
        // As you have to start our slow man from k element ahead
        // when slow man will reach to end, fast man will be n behind which is last n-th elemnt

        for(int i=1; i<=n+1; i++)   {
            slow = slow.next;
        }

        while(slow!=null){
            slow=slow.next;
            fast=fast.next;
        }
        // fast node is at the n th behind
        // fast n+1 th last element
        fast.next = fast.next.next;
        return start.next;

    }
}
