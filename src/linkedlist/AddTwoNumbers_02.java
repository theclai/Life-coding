package linkedlist;

public class AddTwoNumbers_02 {
    static int carry=0;
    static ListNode copy=new ListNode(0);
    public static void main(String[] args){
        ListNode r1=new ListNode(2);
        r1.next=new ListNode(4);
        r1.next.next=new ListNode(3);
        ListNode r2=new ListNode(5);
        r2.next=new ListNode(6);
        r2.next.next=new ListNode(4);

        //ListNode res=reverse(r1);
        //System.out.println("***: "+res.val);

        ListNode op=addTwoNumbers(r1,r2);
        System.out.println(op.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        while (l1!=null && l2!=null){
            int n=l1.val+l2.val+carry;
            if(n>=10){
                n=n-10;
                carry=1;
            }
            System.out.println(n);
            copy.next=new ListNode(n);

            System.out.println("-->");
            l1=l1.next;
            l2=l2.next;

        }

        return copy;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode mCur=head;
        ListNode next=null;

        while (mCur!=null){
            System.out.println(mCur.val);
            //get the next element
            next=mCur.next;

            //set current next to prev
            mCur.next=prev;
            //

            prev=mCur;
            mCur=next;
        }
        head=prev;
        return head;

    }
}
