package leetcode;

public class Readchar_157 {
    public int read(char[] buf, int n) {
        int count = 0;
        boolean eof = false;
        char[] buffer = new char[4];
        while (!eof && count < n) {
            int size = read4(buffer);
            if (size < 4) eof = true;

            if (count + size > n) {
                size = n - count;
            }
            System.arraycopy(buffer, 0, buf, count, size);

            count += size;
        }
        return count;

    }

    private int read4(char[] buffer) {
        return 0;
    }
}
