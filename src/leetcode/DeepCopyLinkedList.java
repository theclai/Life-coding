package leetcode;

import java.util.HashMap;

public class DeepCopyLinkedList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        if (this.visited.containsKey(head))
            return this.visited.get(head);

        RandomListNode node = new RandomListNode(head.label);
        this.visited.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        return node;
    }

}
