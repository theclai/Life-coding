package linkedlist;

public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(4);
        Node node=linkedList.search(5);
        System.out.println(node.data);

        printData(linkedList);
    }

    private static void printData(MyLinkedList linkedList) {
        Node head = linkedList.head.next;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    Node head=null;
    Node tail=null;

    public MyLinkedList() {
        head = null;
    }

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insert(int data) {
        Node node;
        if (head == null) {
            node = new Node(data, null);
            tail = node;
            head = node;
        }
        node = new Node(data, null);
        tail.next = node;
        tail = node;
    }

    public Node search(int target) {
        Node head = this.head.next;
        while (head != null) {
            if(head.data==target){
                return head;
            }
            head = head.next;
        }
        return null;

    }
}
