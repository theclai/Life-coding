package cracking_coding_int.chapter_two;

public class DeletingMiddleNode {
    /**
     * You dont have refrence of the head but just node you will delete
     * */
    public static void main(String[] args) {
        ListNode nodea=new ListNode('a');
        ListNode nodeb=new ListNode('b');
        nodea.next=nodeb;
        ListNode nodec=new ListNode('c');
        nodeb.next=nodec;
        ListNode noded=new ListNode('d');
        nodec.next=noded;

        ListNode nodee=new ListNode('e');
        noded.next=nodee;
        ListNode nodef=new ListNode('f');
        nodee.next=nodef;
        System.out.println(deleteMiddleNode(nodec));
    }

    /**
     * a->b->b->c->d->e->f
     * here c is pointing to d
     * Just update the value of c node by d and point to e
     * */
    private static boolean deleteMiddleNode(ListNode nodeToDelete) {
        if(nodeToDelete==null || nodeToDelete.next==null)
            return false;
        //reference of the d node
        ListNode node = nodeToDelete.next;
        // copy the d node value to c
        nodeToDelete.c=node.c;
        nodeToDelete.next=node.next;
        return true;
    }
}
