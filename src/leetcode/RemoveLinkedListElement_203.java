package leetcode;

public class RemoveLinkedListElement_203 {
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        //head.next.next=new ListNode(3);
        //head.next.next.next=new ListNode(4);
        ListNode op=removeElements(head,1);
        System.out.println(op.val);

    }
    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode cur=dummyHead;

        if(head==null){
            return head;
        }

        while (cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummyHead.next;

    }
}
