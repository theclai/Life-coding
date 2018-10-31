package data_compression;

import java.util.*;

/**
 * 1. HE is a variable length encoding
 * 2. Prefix free Trie, to avoid collision or mess
 * 3. Loss less compression
 */
public class HuffmanEncoding {
    HashMap<Character, Integer> map = new HashMap<>();

    public void HuffmanEncodingBuilder(String data) {
        // create frequency counter
        buildFrequencyCounter(data, map);
        printFrequencyCounter(map);

        // put all the data in a priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.frequency));

        // make all nodes as a leaf
        Iterator it = map.entrySet().iterator();
        for (Map.Entry e : map.entrySet()) {
            pq.add(new Node((Character) e.getKey(), (Integer) e.getValue()));
        }
        //printQueue(pq);

        // This loops will take smallest two elements and create a new internal node
        // keep doing it until it found the root
        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            System.out.println(left.ch);
            System.out.println(right.ch);
            int sum = left.frequency + right.frequency;
            pq.add(new Node('\0', sum, left, right));
        }

        Node root = pq.peek();
        System.out.println("Root: " + root.frequency);

        // traverse the Huffman tree and store the Huffman codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        // print the Huffman codes
        System.out.println("Huffman Codes are :\n");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\nOriginal string was :\n" + data);
// print encoded string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            sb.append(huffmanCode.get(data.charAt(i)));
        }

        System.out.println("\nEncoded string is :\n" + sb);

        // traverse the Huffman Tree again and this time
        // decode the encoded string
        int index = -1;
        System.out.println("\nDecoded string is: \n");
        while (index < sb.length() - 2) {
            index = decode(root, index, sb);
        }

    }

    private void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null)
            return;

        // found a leaf node
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }
        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }

    // traverse the Huffman Tree and decode the encoded string
    public static int decode(Node root, int index, StringBuilder sb) {
        if (root == null)
            return index;

        // found a leaf node
        if (root.left == null && root.right == null) {
            System.out.print(root.ch);
            return index;
        }

        index++;

        if (sb.charAt(index) == '0')
            index = decode(root.left, index, sb);
        else
            index = decode(root.right, index, sb);

        return index;
    }

    private void printQueue(PriorityQueue<Node> pq) {
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            System.out.print(n.ch + "->" + n.frequency);
            System.out.println();
        }
    }

    private void buildFrequencyCounter(String data, HashMap<Character, Integer> map) {
        data.chars().forEach(c -> {
            if (!map.containsKey((char) c))
                map.put((char) c, 0);
            map.put((char) c, map.get((char) c) + 1);

        });
    }

    private void printFrequencyCounter(HashMap<Character, Integer> map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }

    public static void main(String[] args) {
        HuffmanEncoding he = new HuffmanEncoding();
        he.HuffmanEncodingBuilder("Huffman encoding is a data compression algorithm");
    }

    class Node {
        char ch;
        int frequency;
        Node left, right;

        public Node(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

        public Node(char ch, int frequency, Node left, Node right) {
            this.ch = ch;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

}
