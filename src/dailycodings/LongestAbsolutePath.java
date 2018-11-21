package dailycodings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LongestAbsolutePath {
    /**
     * dir
     *      subdir1
     *      subdir2
     *          file.ext
     */
    public static void main(String[] args) {
        LongestAbsolutePath l = new LongestAbsolutePath();
        System.out.println(l.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;

        String[] in=input.split("\n");
        Arrays.stream(in).forEach(st->System.out.println(st));

        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"

            while (lev + 1 < stack.size())
                stack.pop(); // find parent

            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if (s.contains("."))
                maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }
}
