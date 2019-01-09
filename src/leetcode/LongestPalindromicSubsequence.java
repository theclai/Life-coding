package leetcode;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(find("aaaa"));
    }
    /**
     * b b b a b
     * 0 1 2 3 4
     * b 0 1
     * b 1   1
     * b 2     1
     * a 3       1
     * b 4         1
     */
    public static int find(String seq) {
        if(seq==null || seq.length()==0) return 0;
        if(seq.length()==1) return 1;
        if(seq.length()==2){
            if(seq.charAt(0)==seq.charAt(1))
                return 2;
            else return 1;
        }
        int n = seq.length();
        int i, j, cl;
        // Create a table to store results of subproblems
        int L[][] = new int[n][n];

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower
        // diagonal values of table are
        // useless and not filled in the process.
        // The values are filled in a manner similar
        //  to Matrix Chain Multiplication DP solution (See
        // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).
        // cl is length of substring
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
            }
        }

        return L[0][n-1];
    }
}

