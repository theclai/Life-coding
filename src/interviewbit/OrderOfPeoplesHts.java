package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Hint 1
 * This problem is slightly tricky.
 *
 * Really inefficient but correct approach :
 *
 * Try out all possible permutation of the give numbers, and verify if the infronts numbers match for the given sequence.
 * This is obviously too inefficient. O(N!).
 * Lets see if we can do something better.
 *
 * Hint towards something better
 *
 * What can you say about the position of the shortest person ? If the position of the shortest person is i, how many people would be in front of the shortest person ?
 *
 * Once you fix the position of the shortest person, what can you say about the position of the second shortest person ?
 *
 * If we take that approach, do we need to sort the heights first ?
 *
 * Hint 2
 * O(N^2) approach
 *
 * Sort people by heights. Then iterate from shortest to tallest. In each step you need an efficient way to put the next person to the correct position. Notice that people we’ve already placed are not taller that the current person. And the people we place after are taller than the current. So we have to find a place such that the number of empty positions in the front is equal to the inFronts value of this person.
 *
 * Lets take an example :
 *
 * For example after sorting,
 *
 * Height - 1, 2, 3, 4, 5, 6
 * Infront - 3, 2, 1, 2, 0, 0.
 * 1st element should go in position 3. Hence final array becomes:
 *
 * ---1--
 * 2nd element shall go in position 2. Hence final array becomes:
 *
 * --21--
 * 3rd element should go in position 1. Hence final array becomes:
 *
 * -321--
 * 4th element shall go in position 2. This is the position among the empty ones. Hence final array becomes:
 *
 * -321-4
 * 5th element shall go in position 0. Hence final array becomes:
 *
 * 5321-4
 * 6th element should go in position 0. Hence final array becomes:
 *
 * 532164
 * Hint towards an even better solution
 *
 * Can we make the process of finding the ith empty position even more efficient ? Think binary tree / segment tree ?
 * Oh, by the way, this would be a nice time to read up on Segment Trees which are incredibly useful ( http://codeforces.com/blog/entry/3327 )
 * What if you knew how many elements are there in first half of the array, and the second half of the array ?
 *
 * Solution Approach
 * Please read the previous hint if you haven’t done so already.
 *
 * Here, we will explore how to efficiently answer the query of finding the ith empty space.
 *
 * The query can be solved using segment / interval tree.
 * The root contains the number of elements in [0, N].
 * Left node contains the number of elements in [0, N/2]
 * Right node contains the number of elements in [N/2 + 1, N]
 *
 * Lets say we need to find the ith empty position.
 * We look at the number of elements X in [0, N/2].
 *
 * If
 *     N / 2 - X >= i, the position lies in the left part of array and we move down to the left node.
 *     N / 2 - X < i, we now look for i - (N / 2 - X) th position in the right part of the array and move to the right node in the tree.
 * This is a fairly standard use of the segment tree.
 * */
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
