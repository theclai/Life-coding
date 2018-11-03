package pramp;

/**
 * Deletion Distance
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:
 * <p>
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance between them. Explain how your function works, and analyze its time and space complexities.
 * <p>
 * Examples:
 * <p>
 * input:  str1 = "dog", str2 = "frog"
 * output: 3
 * <p>
 * input:  str1 = "some", str2 = "some"
 * output: 0
 * <p>
 * input:  str1 = "some", str2 = "thing"
 * output: 9
 * <p>
 * input:  str1 = "", str2 = ""
 * output: 0
 * Constraints:
 * <p>
 * [input] string str1
 * [input] string str2
 * [output] integer
 */
public class DeletionDistance {
    static int deletionDistance(String str1, String str2) {
        return helperDeletionDistance(str1, str2, 0, 0);
    }

    static int helperDeletionDistance(String str1, String str2, int pos1, int pos2) {
        if (pos1 > str1.length() - 1 && pos2 > str2.length() - 1) {
            return 0;
        } else {
            if (pos1 > str1.length() - 1) {
                return (str2.length() - pos2);
            }
            if (pos2 > str2.length() - 1) {
                return (str1.length() - pos1);
            }
        }
        //case where equal str1[i] == str2[j]
        if (str1.charAt(pos1) == str2.charAt(pos2))
            return helperDeletionDistance(str1, str2, pos1 + 1, pos2 + 1);

            //case where different str1[i] != str2[j]
            //counter is return
        else {
            return Math.min(helperDeletionDistance(str1, str2, pos1 + 1, pos2),
                    helperDeletionDistance(str1, str2, pos1, pos2 + 1)) + 1;
        }

    }

    static int dpBottomApproach(String str1, String str2) {
        int row = str1.length();
        int col = str2.length();
        if (row == 0)
            return col;
        if (col == 0)
            return row;
        int[][] cache = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char charA = str1.charAt(i);
                char charB = str2.charAt(j);
                if (i == 0 && j == 0) {
                    cache[i][j] = charA != charB ? 2 : 0;
                } else if (i == 0 & j != 0) {
                    cache[i][j] = charA != charB ? cache[i][j - 1] + 1 : cache[i][j - 1]-1;
                } else if (i != 0 & j == 0) {
                    cache[i][j] = charA != charB ? cache[i - 1][j] + 1 : cache[i - 1][j]-1;
                } else {
                    cache[i][j] = charA != charB ? Math.min(cache[i - 1][j], cache[i][j - 1])+1 : cache[i - 1][j - 1];
                }

            }

        }
        return cache[row - 1][col - 1];
    }

    public static void main(String[] args) {

        String str1 = "frog";
        String str2 = "dog";
        System.out.println(deletionDistance(str1, str2));
        System.out.println(dpBottomApproach(str1, str2));

        //System.out.println(dpBottomApproach("", ""));
        System.out.println(dpBottomApproach("sea", "ate"));
        System.out.println(dpBottomApproach("sea", "eat"));

    }
}
