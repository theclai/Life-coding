package pramp;

public class MinSalesPath {


    /**
     * iterate all the paths to find consumer
     * add the pathvalue to a list
     * <p>
     * list of 5 consumer
     * <p>
     * take the min of that list
     * <p>
     * // use one minValue and keep updating it
     * <p>
     * <p>
     * TC: O(n)
     * Memory: (E+V)
     */

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }


    static int minVal = Integer.MAX_VALUE;

    static int getCheapestCost(Node rootNode) {
        return minHelper(rootNode, 0);
    }


    public static int minHelper(Node rootNode, int cost) {
        if (rootNode==null ||rootNode.children==null)
            return cost;

        else {
            for (int i = 0; i < rootNode.children.length; i++) {
                Node tNode = rootNode.children[i];
                if (tNode != null) {
                    minVal = Math.min(minVal, minHelper(tNode, cost + tNode.cost));
                }
            }
        }

        return minVal;
    }


    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);
        root.children = new Node[3];

        Node l11 = new Node(5);
        l11.children = new Node[1];

        Node l21 = new Node(4);
        l11.children[0] = l21;


        Node l12 = new Node(3);

        Node l22 = new Node(2);

        Node l31 = new Node(1);
        l22.children = new Node[1];
        l22.children[0] = l31;
        Node l41 = new Node(1);
        l31.children = new Node[1];
        l31.children[0] = l41;

        Node l23 = new Node(0);
        Node l42 = new Node(10);
        l23.children = new Node[1];
        l23.children[0] = l42;

        l12.children = new Node[2];
        l12.children[0] = l22;
        l12.children[1] = l23;


        Node l13 = new Node(6);
        Node l24 = new Node(1);
        Node l25 = new Node(5);

        l13.children = new Node[2];
        l13.children[0] = l24;
        l13.children[1] = l25;


        root.children[0] = l11;
        root.children[1] = l12;
        root.children[2] = l13;

        System.out.println(getCheapestCost(root));
    }
}

