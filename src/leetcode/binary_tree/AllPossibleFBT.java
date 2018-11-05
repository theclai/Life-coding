package leetcode.binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT {
    Map<Integer, List<BinaryTreeTraversal.TreeNode>> memo = new HashMap();

    public List<BinaryTreeTraversal.TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<BinaryTreeTraversal.TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new BinaryTreeTraversal.TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (BinaryTreeTraversal.TreeNode left : allPossibleFBT(x))
                        for (BinaryTreeTraversal.TreeNode right : allPossibleFBT(y)) {
                            BinaryTreeTraversal.TreeNode bns = new BinaryTreeTraversal.TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                             ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
