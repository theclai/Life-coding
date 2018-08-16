package geeksforgeeks;

/**
 * ABC
 * /        |      \
 * ABC        BAC        CBA
 * <p>
 * ABC ACB   BAC    BCA   CBA   CAB
 */

public class PermutationOfString {
    public static void main(String[] args) {
        String in = "ABC";
        permute(in, 0, in.length() - 1);
    }

    /**
     * @param l   starting point in the string
     * @param r   End of the string
     * @param str Input string
     */
    private static void permute(String str, int l, int r) {
        System.out.println("Permute: "+str);
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                //Choose first character, permute rest and un choose it
                //chose character
                str = swap(str, l, i);
                //permute rest of the chars
                permute(str, l + 1, r);
                //un choose it
                str = swap(str, l, i);//backtrack. back to the previous configuration
                System.out.println("***" + str);
            }
        }

    }

    private static String swap(String in, int i, int j) {
        char temp;
        char[] charArray = in.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}


/***
 * Example:
 *
 * First A, permute BC--> BC,CB
 * ABC, ACB
 * Un choose it, so you will be at same ABC
 *
 * Now choose B
 * B, permute AC-> AC, CA
 * BAC BCA
 *
 * */