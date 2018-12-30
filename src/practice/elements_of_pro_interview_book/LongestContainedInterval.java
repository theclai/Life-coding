package practice.elements_of_pro_interview_book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestContainedInterval {
    public static void main(String[] args) {
        int[] in = new int[]{10, 5, 3, 11, 6, 100, 4};
        System.out.println(longestInterval(in));
    }

    private static int longestInterval(int[] in) {
        Set<Integer> s = new HashSet<>();
        int max_value = 0;
        Arrays.stream(in).forEach(value -> s.add(value));
        while (!s.isEmpty()) {
            int data = s.iterator().next();
            s.remove(data);
            // lower bound

            int lowerBound = data - 1;
            while (s.contains(lowerBound)) {
                s.remove(lowerBound);
                lowerBound--;
            }

            //computing upper bound
            int upperBound = data + 1;
            while (s.contains(upperBound)) {
                s.remove(upperBound);
                upperBound++;
            }

            max_value = Math.max(upperBound - lowerBound - 1, max_value);
        }
        return max_value;
    }
}
