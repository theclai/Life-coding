package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedList {
    public ListNode mergeKLists(ListNode[] arr) {
        if (arr == null || arr.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode node :
                arr) {
            if (node != null)
                pq.offer(node);

        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top != null) {
                head.next = top;
                head = head.next;
                if (top.next != null)
                    pq.offer(top.next);
            }
        }
        return cur.next;
    }
}
