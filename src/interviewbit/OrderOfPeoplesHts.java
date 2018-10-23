package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class OrderOfPeoplesHts {
    public class Solution {
        public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

            ArrayList<Integer> order = new ArrayList<>();
            ArrayList<Node> nodes = new ArrayList<>();
            int n;
            if (heights == null || infronts == null) {
                return order;
            }

            n = heights.size();

            Bit bit = new Bit(n);

            for (int i = 1; i <= n; i++) {
                bit.update(i, 1);
            }
            for (int i = 0; i < n; i++) {
                Node node = new Node(heights.get(i), infronts.get(i));
                nodes.add(node);
                order.add(0);
            }

            Collections.sort(nodes);
            for (int i = 0; i < n; i++) {
                Node node = nodes.get(i);
                int index = getIth(bit, node.infronts + 1, n);
                order.set(index, node.height);
            }
            return order;
        }

        public int getIth(Bit bit, int index, int n) {

            int start = 1;
            int end = n;
            int count = end - start + 1;
            int it;
            int res = 0;
            while (count > 0) {
                int mid = (start + end) / 2;
                int val = bit.query(mid);

                if (val < index) {
                    start = mid + 1;
                } else if (val > index) {
                    end = mid - 1;
                } else if (val == index) {
                    res = mid;
                    end = mid - 1;
                }
                count /= 2;
            }

            bit.update(res, -1);
            return res - 1;
        }

        class Node implements Comparable<Node> {
            int height;
            int infronts;

            public Node(int h, int i) {
                height = h;
                infronts = i;
            }

            @Override
            public int compareTo(Node node) {
                return Integer.compare(height, node.height);
            }

        }


        class Bit {
            int bit[];
            int N;

            public Bit(int N) {
                this.bit = new int[N + 10];
                this.N = N;
            }

            public void update(int idx, int value) {

                while (idx > 0 && idx <= N) {
                    bit[idx] += value;
                    idx += (idx & -idx);
                }
            }

            public int query(int idx) {
                int res = 0;
                while (idx > 0) {
                    res += bit[idx];
                    idx -= (idx & -idx);
                }
                return res;

            }
        }
    }
}
