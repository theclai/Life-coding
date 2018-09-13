package leetcode;

public class FindingMiddleOfLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode findMiddle(ListNode root) {
        if(root==null){
            return null;
        }

        ListNode first=root;
        ListNode second=root;

        while(first!=null && second!=null){
            if(second.next!=null){
                second=second.next.next;
            }else{
                second=null;
            }

            if(second==null){
                return first;
            }
            first=first.next;

        }
        return first;

    }
}
