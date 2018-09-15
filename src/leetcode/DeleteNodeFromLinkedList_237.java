package leetcode;

public class DeleteNodeFromLinkedList_237 {

    public void deleteNode(ListNode node) {
        //get the next data
        if(node==null)
            return;

        int nextData=node.next.val;
        node.val=nextData;

        node.next=node.next.next;


    }
}
