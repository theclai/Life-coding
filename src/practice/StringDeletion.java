package practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StringDeletion {
    /***
     *      abc
     *     / | \
     *    ab ac bc
     *   /\  |\  | \
     *  a  b a c b  c
     * */
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        String query = "abc";

        System.out.println("Number of character removal: " + countCharacterRemoval(dict, query));
    }

    private static int countCharacterRemoval(HashSet<String> dict, String query) {
        // we will run a breadth first search
        Queue<String> queue = new LinkedList<>();
        Set<String> queuedElements = new HashSet<>(); // it will help to avoid duplicates
        // Look at the last line of graph above. we need avoid those.
        queue.add(query);
        queuedElements.add(query);
        while (!queue.isEmpty()) {
            String s = queue.remove();
            queuedElements.remove(s);
            if (dict.contains(s)) return query.length()-s.length();

            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(0, i) + s.substring(i + 1, s.length());
                if (!queuedElements.contains(sub) && sub.length() > 0) {
                    queue.add(sub);
                    queuedElements.add(sub);
                }

            }

        }
        return -1;// -1 means word not found.
    }
}
