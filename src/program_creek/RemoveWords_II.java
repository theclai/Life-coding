package program_creek;

public class RemoveWords_II {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int pos = 1;
        int prev = A[0];
        int count = 0;

        boolean flag = false;
        for (int i = 1; i < A.length; i++) {
            int cur = A[i];
            if (prev == cur) {
                if (!flag) {
                    flag = true;
                    A[pos++] = prev;
                    continue;
                } else {
                    count++;
                }

            } else {
                prev = cur;
                A[pos] = prev;
                pos++;
                flag = false;
            }
        }
        return A.length - count;
    }
}
