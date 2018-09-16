package leetcode;

public class RemovedulplicateFromSortedList_83 {
    // 1->1->2->4->3->3->5->5
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newMember=head;
        while(newMember!=null){
            ListNode distinct=newMember.next;

            while (distinct!=null && distinct.val==newMember.val){
                distinct=distinct.next;
            }
            newMember.next=distinct;
            newMember=distinct;
        }
        return head;
    }
}
