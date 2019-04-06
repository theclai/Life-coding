package leetcode.contests.contest_130;

import leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NextGreaterNodeInLinkedList_1019 {

    NextGreaterNodeInLinkedList_1019 nextGreaterNodeInLinkedList;
    static int size = 0;

    @BeforeEach
    public void init() {
        nextGreaterNodeInLinkedList = new NextGreaterNodeInLinkedList_1019();
    }

    private int[] computeAndPrint(int[] input) {
        ListNode head = construct(input);
        size = input.length;
        int[] res = nextGreaterNodeInLinkedList.nextLargerNodes(head);
        System.out.println(Arrays.deepToString(new int[][]{res}));
        return res;
    }

    @Test
    public void firstPositiveNextLargerNodes() {
        int[] input = new int[]{2, 1, 5};
        int[] res = computeAndPrint(input);
        Assertions.assertTrue(Arrays.equals(res, new int[]{5, 5, 0}));
    }

    @Test
    public void secondPositiveNextLargerNodes() {
        int[] input = new int[]{2, 7, 4, 3, 5};
        int[] res = computeAndPrint(input);
        Assertions.assertTrue(Arrays.equals(res, new int[]{7, 0, 5, 5, 0}));
    }

    @Test
    public void thirdPositiveNextLargerNodes() {
        int[] input = new int[]{1, 7, 5, 1, 9, 2, 5, 1};
        int[] res = computeAndPrint(input);
        Assertions.assertTrue(Arrays.equals(res, new int[]{7, 9, 9, 9, 0, 5, 0, 0}));
    }

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode start = head;
        ListNode forward = head.next;
        while (start != null) {
            if (forward == null) {
                result.add(0);
                forward = start.next;
                start = start.next;

            } else {
                if (forward.val > start.val) {
                    result.add(forward.val);
                    forward = start.next;
                    start = start.next;

                } else {
                    forward = forward.next;
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private ListNode construct(int[] input) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = 0; i < input.length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }
        return temp.next;
    }
}
