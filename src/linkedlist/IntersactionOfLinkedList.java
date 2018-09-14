package linkedlist;

public class IntersactionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA,
                                        ListNode headB) {
        int lenA=len(headA);
        System.out.println(lenA);
        int lenB=len(headB);
        if(lenA>lenB){
            headA=findNewHead(Math.abs(lenA-lenB),headA);
        }else {
            headB=findNewHead(Math.abs(lenA-lenB),headB);
        }
        System.out.println("  ");
        while (headA!=null && headB!=null){
            if(headA.val==headB.val){
                return headA;
            }else {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;

    }

    private ListNode findNewHead(int diff,ListNode head) {
        while (diff-->0){
            head=head.next;
        }
        return head;
    }

    private int len(ListNode headA) {
        int i=0;
        while (headA!=null){
            headA=headA.next;
            i++;
        }
        return i;
    }

}
