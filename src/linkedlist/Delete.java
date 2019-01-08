package linkedlist;

public class Delete {
    public static ListNode removeNodes(ListNode listHead, int x) {
        // Write your code here
        if(listHead==null) return listHead;

        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead;
        ListNode curr=listHead;
        //dummyHead.next=listHead;
        while(curr !=null){
            if(curr.val<=x){
                temp.next=curr;
                curr=curr.next;
                temp=temp.next;
            }else{
                curr=curr.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode head=new ListNode(1);
        head.next=new ListNode(5);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(3);
        ListNode res= removeNodes(head,3);
        System.out.println(res.val);
    }
}
