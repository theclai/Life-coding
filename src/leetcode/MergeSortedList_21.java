package leetcode;

public class MergeSortedList_21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=null;
        ListNode current=dummyHead;

        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                current.next=l1;
                l1=l1.next;
            }else{
                current.next=l2.next;
                l2=l2.next;
            }
            current=current.next;
        }
        //add rest of the node
        current.next=l1!=null?l1:l2;
        return current.next;

    }
}
