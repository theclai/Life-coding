package linkedlist;

import java.util.LinkedList;

public class ReverseLinkedListInMemory {
    static class LNode{
        int val;
        LNode prev;
        LNode next;

        public LNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args){
        LNode head = new LNode(1);
        head.prev=null;
        LNode bNode = new LNode(2);
        LNode cNode = new LNode(3);
        LNode dNode = new LNode(4);

        bNode.prev=head;
        bNode.next=cNode;
        cNode.prev= bNode;

        cNode.next=dNode;
        dNode.prev=cNode;
        dNode.next=null;

        head.next = bNode;

        LNode output = findLast(head);

        System.out.println("Output: "+output.val);

        LNode newHead = reverse(head,output);

        int a=0;
    }

    private static LNode reverse(LNode head,
                                 LNode last)
    {

        while(last.prev!=null){
            last.next=last.prev;
            last=last.prev;
        }
        return last;

    }

    private static LNode findLast(LNode node) {
        System.out.println(node.val);
        while(node.next!=null){
            node = node.next;
            System.out.println(node.val);
        }
        return node;
    }
}
