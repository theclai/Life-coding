package tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeToFlattenLinkedListTest {
    BinaryTreeToFlattenLinkedList binaryTreeToFlattenLinkedList;
    TreeNode root;

    @BeforeEach
    public void init() {
        root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);

        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(6);

        binaryTreeToFlattenLinkedList = new BinaryTreeToFlattenLinkedList();
    }

    @Test
    public void test() {
        binaryTreeToFlattenLinkedList.flatten(root);

    }
}
