package leetcode;

public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if ((int) target - 'a' < (int) letters[i] - 'a')
                return letters[i];
        }
        return letters[0];
    }
}
