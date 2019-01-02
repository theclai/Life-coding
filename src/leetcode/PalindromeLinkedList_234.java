package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode root = head;
        List<ListNode> nodes = new ArrayList<>();
        while (root != null) {
            nodes.add(root);
            root = root.next;
        }

        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            if (nodes.get(i).val != nodes.get(j).val) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
