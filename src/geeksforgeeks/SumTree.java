package geeksforgeeks;

class Node {
    int data;
    Node left, right, nextRight;

    Node(int item) {
        data = item;
        left = right = nextRight = null;
    }
}

public class SumTree {
    static class BinaryTree {
        Node root;
        BinaryTree() {

        }


        public int isSumTree(Node root) {
            if(root.data==Math.addExact(sum(root.left),sum(root.right))){
                return 1;
            }

            return 0;
        }

        private int sum(Node node) {
            if(node==null){
                return 0;
            }
            int l=sum(node.left);
            int r=sum(node.right);
            return node.data+l+r;
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(2);

        if (tree.isSumTree(tree.root) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
