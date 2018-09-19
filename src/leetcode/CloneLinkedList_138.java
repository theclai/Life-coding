package leetcode;

public class CloneLinkedList_138 {
    /**
     * 1->2->3->4->5
     * random:
     * 1->3, 2->1 , 5->2, 4->3
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public static void main(String[] args) {
        /**
         * Create your list and use the method below
         * */
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;

        // Create new nodes in between the original nodes
        RandomListNode nCurr = head;
        while (nCurr != null) {
            RandomListNode temp = new RandomListNode(nCurr.label);
            //temp.value = nCurr.value;
            temp.next = nCurr.next;
            nCurr.next = temp;
            nCurr = nCurr.next.next;
        }

        // Copy random pointers
        nCurr = head;
        while (nCurr != null) {
            if (nCurr.random != null) {
                nCurr.next.random = nCurr.random.next;
            }
            nCurr = nCurr.next.next;
        }

        // Separate new nodes from old nodes
        RandomListNode copy = head.next;
        nCurr = head;
        while (nCurr.next != null) {
            RandomListNode tmp = nCurr.next;
            nCurr.next = nCurr.next.next;
            nCurr = tmp;
        }
        return copy;
    }
}
