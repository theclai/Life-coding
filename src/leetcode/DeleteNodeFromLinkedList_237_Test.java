package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteNodeFromLinkedList_237_Test {
    DeleteNodeFromLinkedList_237 list;
    @BeforeEach
    public void init(){
        list=new DeleteNodeFromLinkedList_237();

    }
    @Test
    public void deleteTest(){
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node1=new ListNode(1);
        ListNode node9=new ListNode(9);
        node4.next=node5;
        node5.next=node1;
        node1.next=node9;
        node9.next=null;
        list.deleteNode(node1);

        System.out.println(list);

    }
}
