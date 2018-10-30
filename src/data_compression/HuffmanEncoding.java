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
        printQueue(pq);
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
            if (c != ' ') {
                if (map.containsKey((char) c))
                    map.put((char) c, map.get((char) c) + 1);
                else
                    map.put((char) c, 1);
            }
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
