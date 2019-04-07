package leetcode.contests.contest_131;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumRootToLeaf_1017 {
    SumRootToLeaf_1017 sumRootToLeaf_1017;
    TreeNode root;
    int sum = 0;

    @BeforeEach
    public void init() {
        sumRootToLeaf_1017 = new SumRootToLeaf_1017();
        root = new TreeNode(1);
        construct(root);

    }

    private void construct(TreeNode root) {

        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
    }

    @Test
    public void test() {
        sumRootToLeaf(root);
    }

    public int sumRootToLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        System.out.println(sum);
        return sum;
    }

    private void helper(TreeNode root, StringBuilder tempSum) {
        if (root == null) {
            return;
        }
        tempSum.append(root.val);
        if(root.left==null && root.right==null){
            System.out.println(tempSum.toString());
            int decimalValue = Integer.parseInt(tempSum.toString(), 2);
            //System.out.println(decimalValue);
            sum+=decimalValue;
            sum= (int) (sum%(Math.pow(10,9)+7));
            tempSum.deleteCharAt(tempSum.length()-1);
        }
        else{
            helper(root.left,tempSum);
            helper(root.right,tempSum);
            tempSum.deleteCharAt(tempSum.length()-1);
        }
    }
}
