package dailycodings;

import leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Dailycoding_125 {
    Dailycoding_125 dailycoding_125;
    static TreeNode head;
    @BeforeEach
    public void init() {
        buildTree();
        dailycoding_125 = new Dailycoding_125();
    }

    @Test
    public void first_positive() {
        boolean result = dailycoding_125.verify(head, 20);
        System.out.println(result);
        Assertions.assertEquals(true,result);
    }

    private boolean verify(TreeNode head, int K) {
        return helper(head, K, new HashSet<Integer>());
    }

    private boolean helper(TreeNode head, int k, HashSet<Integer> set) {
        if (head == null) return false;
        if (set.contains(k - head.val)) return true;
        else {
            set.add(head.val);
        }
        return helper(head.left, k, set) ||
                helper(head.right, k, set);
    }

    private void buildTree() {
        head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.right = new TreeNode(15);
        head.right.left = new TreeNode(11);
        head.right.right = new TreeNode(15);
    }
}
